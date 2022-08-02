package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.StudentDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr.StudentDTOMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.StudentService;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.StudentEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentDTOMapper studentDTOMapper;

    @Override
    public StudentDTO insert(StudentDTO dto) {
        StudentEntity entityToSave = studentDTOMapper.getEntityFromDto(dto);
        StudentEntity entitySaved = studentRepository.save(entityToSave);
        return studentDTOMapper.getDtoFromEntity(entitySaved);
    }

    @Override
    public StudentDTO getById(Integer id) throws EntityNotFoundException {
        StudentEntity entity = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Entity not found in DB"));
        return studentDTOMapper.getDtoFromEntity(entity);
    }

    @Override
    public List<StudentDTO> getAll() {
        List<StudentEntity> entities = studentRepository.findAll();
        List<StudentDTO> dtoList = entities.stream().map(studentDTOMapper::getDtoFromEntity).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public StudentDTO update(StudentDTO dto) throws EntityNotFoundException {
        if(!studentRepository.existsById(dto.getId())){
            throw new EntityNotFoundException("Entity not found in DB");
        }
        StudentEntity entityUpdated = studentRepository.save(studentDTOMapper.getEntityFromDto(dto));
        return studentDTOMapper.getDtoFromEntity(entityUpdated);
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
        if(!studentRepository.existsById(id)){
            throw new EntityNotFoundException("Entity not found in DB");
        }
        studentRepository.deleteById(id);

    }

    @Override
    public List<StudentDTO> getByNameAndLastName(String name, String lastName) throws EntityNotFoundException {
        if(!studentRepository.existsStudentEntityByNameAndLastName(name,lastName))
            throw new EntityNotFoundException("Entity not found in DB");
        return studentDTOMapper.getDtoListFromEntityList(studentRepository.findStudentEntityByNameAndLastName(name, lastName));
    }

//    @Override
//    public List<StudentDTO> getListByAcademyName(Academy name) throws EntityNotFoundException {
//        return null;
//    }
}

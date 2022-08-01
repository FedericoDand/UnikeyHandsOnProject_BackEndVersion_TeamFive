package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.impl;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TeacherDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.impl.TeacherDTOMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.TeacherService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TeacherEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherDTOMapper teacherDTOMapper;

    @Override
    public TeacherDTO insert(TeacherDTO dto) {
        TeacherEntity entityToSave = teacherDTOMapper.getEntityFromDto(dto);
        TeacherEntity entitySaved = teacherRepository.save(entityToSave);
        return teacherDTOMapper.getDtoFromEntity(entitySaved);
    }

    @Override
    public TeacherDTO getById(Integer id) throws EntityNotFoundException {
        TeacherEntity entity = teacherRepository.findById(id).orElseThrow(() -> new NotFoundException("Entity not found in DB"));
        return teacherDTOMapper.getDtoFromEntity(entity);
    }

    @Override
    public List<TeacherDTO> getAll() {
        List<TeacherEntity> entities = teacherRepository.findAll();
        return teacherDTOMapper.fromEntityListToDtoList(entities);
    }

    @Override
    public TeacherDTO update(TeacherDTO dto) throws EntityNotFoundException {
        if(!teacherRepository.existsById(dto.getId())){
            throw new EntityNotFoundException("Entity not found in DB");
        }
        TeacherEntity entityUpdated = teacherRepository.save(teacherDTOMapper.getEntityFromDto(dto));
        return teacherDTOMapper.getDtoFromEntity(entityUpdated);
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
        if(!teacherRepository.existsById(id)){
            throw new EntityNotFoundException("Entity not found in DB");
        }
        teacherRepository.deleteById(id);

    }

    @Override
    public List<TeacherDTO> getByNameAndLastName(String name, String lastName) throws EntityNotFoundException {
        if(!teacherRepository.existsTeacherEntityByNameAndLastName(name,lastName))
            throw new EntityNotFoundException("Entity not found in DB");
        return teacherDTOMapper.fromEntityListToDtoList(teacherRepository.findTeacherEntityByNameAndLastName(name, lastName));
    }
}

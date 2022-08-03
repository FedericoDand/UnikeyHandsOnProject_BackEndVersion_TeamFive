package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AcademyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr.AcademyMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.AcademyService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.AcademyEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {
    private final AcademyRepository repository;
    private final AcademyMapper mapper;

    @Override
    public AcademyDTO insert(AcademyDTO dto) {
        AcademyEntity academyToSave= mapper.getEntityFromDto(dto);
        AcademyEntity academySaved= repository.save(academyToSave);
        return mapper.getDtoFromEntity(academySaved);
    }

    @Override
    public AcademyDTO getById(Integer id) throws EntityNotFoundException {
    AcademyEntity academyEntity= repository.findById(id).orElseThrow(()-> new EntityNotFoundException());

        return mapper.getDtoFromEntity(academyEntity);
    }

    @Override
    public List<AcademyDTO> getAll() {
        List<AcademyEntity> academyEntityList= repository.findAll();
        return mapper.getDtoListFromEntityList(academyEntityList);
    }

    @Override
    public AcademyDTO update(AcademyDTO dto) throws EntityNotFoundException {
        AcademyEntity academyEntity= repository.save(mapper.getEntityFromDto(dto));
        return mapper.getDtoFromEntity(academyEntity);
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
       if(!repository.existsById(id))
           throw new EntityNotFoundException();
       repository.deleteById(id);
    }
}

package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.impl;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.Dto.AcademyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.impl.AcademyMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.AcademyService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entity.AcademyEntity;
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
        AcademyEntity academyToSave= mapper.fromDtoToEntity(dto);
        AcademyEntity academySaved= repository.save(academyToSave);
        return mapper.fromEntityToDto(academySaved);
    }

    @Override
    public AcademyDTO getById(Integer id) throws EntityNotFoundException {
    AcademyEntity academyEntity= repository.findById(id).orElseThrow(()-> new EntityNotFoundException());

        return mapper.fromEntityToDto(academyEntity);
    }

    @Override
    public List<AcademyDTO> getAll() {
        List<AcademyEntity> academyEntityList= repository.findAll();
        return mapper.fromEntityListToDtoList(academyEntityList);
    }

    @Override
    public AcademyDTO update(AcademyDTO dto) throws EntityNotFoundException {
        AcademyEntity academyEntity= repository.save(mapper.fromDtoToEntity(dto));
        return mapper.fromEntityToDto(academyEntity);
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
       if(!repository.existsById(id))
           throw new EntityNotFoundException();
       repository.deleteById(id);
    }
}

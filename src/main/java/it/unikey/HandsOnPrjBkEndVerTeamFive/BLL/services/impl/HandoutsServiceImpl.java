package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.impl;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.Dto.HandoutsDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.impl.HandoutsMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.HandoutsService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entity.HandoutsEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.HandoutsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class HandoutsServiceImpl implements HandoutsService {
    private final HandoutsRepository repository;
    private final HandoutsMapper mapper;

    @Override
    public HandoutsDTO insert(HandoutsDTO dto) {
        HandoutsEntity entityToSave= mapper.fromDtoToEntity(dto);
        HandoutsEntity entitySaved= repository.save(entityToSave);
        return mapper.fromEntityToDto(entitySaved);
    }

    @Override
    public HandoutsDTO getById(Integer id) throws EntityNotFoundException {
        HandoutsEntity handoutsEntity= repository.findById(id).orElseThrow(()->new EntityNotFoundException());
        return mapper.fromEntityToDto(handoutsEntity);
    }

    @Override
    public List<HandoutsDTO> getAll() {
        List<HandoutsEntity> List= repository.findAll();
        return mapper.fromEntityListToDtoList(List);
    }

    @Override
    public HandoutsDTO update(HandoutsDTO dto) throws EntityNotFoundException {
        HandoutsEntity handoutsEntity= repository.save(mapper.fromDtoToEntity(dto));
        return mapper.fromEntityToDto(handoutsEntity);
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
     if(!repository.existsById(id))
         throw new EntityNotFoundException();
     repository.deleteById(id);
    }
}

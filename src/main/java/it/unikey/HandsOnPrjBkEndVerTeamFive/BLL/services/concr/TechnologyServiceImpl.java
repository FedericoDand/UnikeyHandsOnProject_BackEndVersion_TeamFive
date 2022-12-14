package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TechnologyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr.TechnologyMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.TechnologyService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TechnologyEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;
    private final TechnologyMapper technologyMapper;


    @Override
    public TechnologyDTO insert(TechnologyDTO dto) {
        return technologyMapper.getDtoFromEntity(technologyRepository.save(technologyMapper.getEntityFromDto(dto)));
    }

    @Override
    public TechnologyDTO getById(Integer id) throws EntityNotFoundException {
        TechnologyEntity technologyEntity = technologyRepository.
                findById(id).orElseThrow(() -> new NotFoundException("Entity not found in db"));
        return technologyMapper.getDtoFromEntity(technologyEntity);
    }

    @Override
    public List<TechnologyDTO> getAll() {
        return technologyMapper.getDtoListFromEntityList(technologyRepository.findAll());
    }

    @Override
    public TechnologyDTO update(TechnologyDTO dto) throws EntityNotFoundException {
        if(!technologyRepository.existsById(dto.getId()))
            throw new NotFoundException("Entity not found in db");
        return technologyMapper.getDtoFromEntity(technologyRepository.save(technologyMapper.getEntityFromDto(dto)));
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
        if(!technologyRepository.existsById(id))
            throw new NotFoundException("Entity not found in db");
        technologyRepository.deleteById(id);
    }

    @Override
    public List<TechnologyDTO> getByName(String name) throws NotFoundException {
        if(!technologyRepository.existsTechnologyEntitiesByName(name))
            throw new NotFoundException("Entity not found in db");
        return technologyMapper.getDtoListFromEntityList(technologyRepository.findTechnologyEntitiesByName(name));
    }
}

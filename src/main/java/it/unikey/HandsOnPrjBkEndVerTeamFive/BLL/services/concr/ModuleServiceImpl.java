package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.ModuleDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr.ModuleMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.ModuleService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.ModuleEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;

    @Override
    public ModuleDTO insert(ModuleDTO dto) {
        return moduleMapper.getDtoFromEntity(moduleRepository.save(moduleMapper.getEntityFromDto(dto)));
   }

    @Override
    public ModuleDTO getById(Integer id) throws EntityNotFoundException {
        ModuleEntity moduleEntity = moduleRepository.
                findById(id).orElseThrow(() -> new NotFoundException("Entity not found in db"));
        return moduleMapper.getDtoFromEntity(moduleEntity);
    }

    @Override
    public List<ModuleDTO> getAll() {
        return moduleMapper.getDtoListFromEntityList(moduleRepository.findAll());
    }

    @Override
    public ModuleDTO update(ModuleDTO dto) throws EntityNotFoundException {
        if(!moduleRepository.existsById(dto.getId()))
            throw new NotFoundException("Entity not found in db");
        return moduleMapper.getDtoFromEntity(moduleRepository.save(moduleMapper.getEntityFromDto(dto)));
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
        if(!moduleRepository.existsById(id))
            throw new NotFoundException("Entity not found in db");
        moduleRepository.deleteById(id);
    }

    @Override
    public List<ModuleDTO> getByName(String name) throws NotFoundException {
        if(!moduleRepository.existsModuleEntitiesByName(name))
            throw new NotFoundException("Entity not found in db");
        return moduleMapper.getDtoListFromEntityList(moduleRepository.findModuleEntitiesByName(name));
    }
}

package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.StudentDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TopicDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr.TopicMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.TopicService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TopicEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.TechnologyRepository;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;
    private final TechnologyRepository technologyRepository;


    @Override
    public TopicDTO insert(TopicDTO dto) {
        return topicMapper.getDtoFromEntity(topicRepository.save(topicMapper.getEntityFromDto(dto)));
    }

    @Override
    public TopicDTO getById(Integer id) throws EntityNotFoundException {
        TopicEntity topicEntity = topicRepository.
                findById(id).orElseThrow(() -> new NotFoundException("Entity not found in db"));
        return topicMapper.getDtoFromEntity(topicEntity);
    }

    @Override
    public List<TopicDTO> getAll() {
        return topicMapper.getDtoListFromEntityList(topicRepository.findAll());
    }

    @Override
    public TopicDTO update(TopicDTO dto) throws EntityNotFoundException {
        if(!topicRepository.existsById(dto.getId()))
            throw new NotFoundException("Entity not found in db");
        return topicMapper.getDtoFromEntity(topicRepository.save(topicMapper.getEntityFromDto(dto)));
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
        if(!topicRepository.existsById(id))
            throw new NotFoundException("Entity not found in db");
        topicRepository.deleteById(id);
    }

    @Override
    public List<TopicDTO> getByName(String name) throws NotFoundException {
        if(!topicRepository.existsTopicEntitiesByName(name))
            throw new NotFoundException("Entity not found in db");
        return topicMapper.getDtoListFromEntityList(topicRepository.findTopicEntitiesByName(name));



    }

    @Override
    public List<TopicDTO> getListByTechnologyName(String name) throws NotFoundException {
        if(!technologyRepository.existsTechnologyEntitiesByName(name))
            throw new EntityNotFoundException("Entity TECHNOLOGY not found in DB");
        return topicMapper.getDtoListFromEntityList(topicRepository.findTopicEntitiesByTechnologyName(name));
    }
}

package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TopicDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr.QuestionMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.QuestionService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.QuestionEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;
    private final QuestionMapper mapper;

    /**
     * ################
     * #  BASIC CRUD  #
     * ################
     */
    @Override
    public QuestionDTO insert(QuestionDTO dto) {
        QuestionEntity savedEntity = repository.save(mapper.getEntityFromDto(dto));
        return mapper.getDtoFromEntity(savedEntity);
    }

    @Override
    public QuestionDTO getById(Integer id) throws EntityNotFoundException {
        QuestionEntity retrievedEntity = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found on DB"));
        return mapper.getDtoFromEntity(retrievedEntity);
    }

    @Override
    public List<QuestionDTO> getAll() {
        List<QuestionEntity> retrievedList = repository.findAll();
        return retrievedList.stream()
                .map(mapper::getDtoFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDTO update(QuestionDTO dto) throws EntityNotFoundException {
        if(!repository.existsById(dto.getId())) {
            throw new EntityNotFoundException("Not found on DB");
        }
        QuestionEntity savedEntity = repository.save(mapper.getEntityFromDto(dto));
        return mapper.getDtoFromEntity(savedEntity);
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException {
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("Not found on DB");
        }
        repository.deleteById(id);
    }


    /**
     * ############################
     * #  TABLE-SPECIFIC METHODS  #
     * ############################
     */

    @Override
    public List<QuestionDTO> getByDifficulty(Integer difficulty) {
        if(!repository.existsByDifficulty(difficulty)) {
            throw new EntityNotFoundException("Not found on DB");
        }
        List<QuestionEntity> entityList = repository.findByDifficulty(difficulty);
        return entityList
                .stream()
                .map(mapper::getDtoFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuestionDTO> getByTopicId(Integer topicId) {
        if(!repository.existsByTopicId(topicId)) {
            throw new EntityNotFoundException("Not found in DB");
        }
        List<QuestionEntity> entityList = repository.findByTopicId(topicId);
        return mapper.getDtoListFromEntityList(entityList);
    }

    public List<QuestionDTO> getByTopic(TopicDTO topic) {
        return getByTopicId(topic.getId());
    }
}

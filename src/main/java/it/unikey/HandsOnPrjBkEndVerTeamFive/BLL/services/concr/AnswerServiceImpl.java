package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AnswerDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr.AnswerMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.AnswerService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.AnswerEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;
    private final AnswerMapper mapper;


    /**
     * ################
     * #  BASIC CRUD  #
     * ################
     */
    @Override
    public AnswerDTO insert(AnswerDTO dto) {
        AnswerEntity savedEntity = repository.save(mapper.getEntityFromDto(dto));
        return mapper.getDtoFromEntity(savedEntity);
    }

    @Override
    public AnswerDTO getById(Integer id) throws EntityNotFoundException {
        AnswerEntity retrievedEntity = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found on DB"));
        return mapper.getDtoFromEntity(retrievedEntity);
    }

    @Override
    public List<AnswerDTO> getAll() {
        List<AnswerEntity> retrievedList = repository.findAll();
        return retrievedList.stream()
                .map(mapper::getDtoFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDTO update(AnswerDTO dto) throws EntityNotFoundException {
        if(!repository.existsById(dto.getId())) {
            throw new EntityNotFoundException("Not found on DB");
        }
        AnswerEntity savedEntity = repository.save(mapper.getEntityFromDto(dto));
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
     * #########################
     * #  SPECIFIC OPERATIONS  #
     * #########################
     */
    @Override
    public List<AnswerDTO> getByQuestionId(Integer questionId) {
        if(!repository.existsByQuestionId(questionId)) {
            throw new EntityNotFoundException("Not found on DB");
        }
        List<AnswerEntity> entityList = repository.findByQuestionId(questionId);
        return entityList
                .stream()
                .map(mapper::getDtoFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnswerDTO> getByQuestion(QuestionDTO question) {
        return getByQuestionId(question.getId());
    }
}

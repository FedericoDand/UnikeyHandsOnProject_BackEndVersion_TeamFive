package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AnswerDto;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDto;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr.AnswerMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.AnswerService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.AnswerEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.QuestionEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerConcreteService implements AnswerService {

    private final AnswerRepository repository;
    private final AnswerMapper mapper;


    /**
     * ################
     * #  BASIC CRUD  #
     * ################
     */
    @Override
    public AnswerDto insert(AnswerDto dto) {
        AnswerEntity savedEntity = repository.save(mapper.getEntityFromDto(dto));
        return mapper.getDtoFromEntity(savedEntity);
    }

    @Override
    public AnswerDto getById(Integer id) throws EntityNotFoundException {
        AnswerEntity retrievedEntity = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found on DB"));
        return mapper.getDtoFromEntity(retrievedEntity);
    }

    @Override
    public List<AnswerDto> getAll() {
        List<AnswerEntity> retrievedList = repository.findAll();
        return retrievedList.stream()
                .map(mapper::getDtoFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDto update(AnswerDto dto) throws EntityNotFoundException {
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
    public List<AnswerDto> getByQuestionId(Integer questionId) {
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
    public List<AnswerDto> getByQuestion(QuestionDto question) {
        return getByQuestionId(question.getId());
    }
}

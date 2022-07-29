package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDto;
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
public class QuestionConcreteService implements QuestionService {

    private final QuestionRepository repository;
    private final QuestionMapper mapper;

    /**
     * ################
     * #  BASIC CRUD  #
     * ################
     */

    @Override
    public QuestionDto insert(QuestionDto dto) {
        QuestionEntity toBeSaved = mapper.getEntityFromDto(dto);
        QuestionEntity savedEntity = repository.save(toBeSaved);
        return mapper.getDtoFromEntity(savedEntity);
    }

    @Override
    public QuestionDto getById(Integer id) throws EntityNotFoundException {
        QuestionEntity entity = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found on DB"));
        return mapper.getDtoFromEntity(entity);
    }

    @Override
    public List<QuestionDto> getAll() {
        List<QuestionEntity> entityList = repository.findAll();
        List<QuestionDto> dtoList = entityList
                .stream()
                .map(mapper::getDtoFromEntity)
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public QuestionDto update(QuestionDto dto) throws EntityNotFoundException {
        if(!repository.existsById(dto.getId())) {
            throw new EntityNotFoundException("Not found on DB");
        }
        QuestionEntity updatedEntity = repository.save(mapper.getEntityFromDto(dto));
        return mapper.getDtoFromEntity(updatedEntity);
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
    public List<QuestionDto> getByDifficulty(Integer difficulty) {
        if(!repository.existsByDifficulty(difficulty)) {
            throw new EntityNotFoundException("Not found on DB");
        }
        List<QuestionEntity> entityList = repository.findByDifficulty(difficulty);
        List<QuestionDto> dtoList = entityList
                .stream()
                .map(mapper::getDtoFromEntity)
                .collect(Collectors.toList());
        return dtoList;
    }
}

package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AnswerDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.AnswerService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.abstr.GenericController;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr.AnswerRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr.QuestionRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.AnswerRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.QuestionRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answers")
public class AnswerController implements GenericController<AnswerRest> {

    private final AnswerService service;
    private final AnswerRestMapper answerRestMapper;
    private final QuestionRestMapper questionRestMapper;

    /**
     * ################
     * #  BASIC CRUD  #
     * ################
     */

    @Override
    @PostMapping
    public ResponseEntity<AnswerRest> post(@RequestBody AnswerRest rest) {
        AnswerDTO savedDto = service.insert(answerRestMapper.getDtoFromRest(rest));
        return new ResponseEntity<>(answerRestMapper.getRestFromDto(savedDto), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AnswerRest> getById(@PathVariable Integer id) {
        try {
            AnswerDTO retrievedDto = service.getById(id);
            return new ResponseEntity<>(answerRestMapper.getRestFromDto(retrievedDto), HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AnswerRest>> getAll() {
        List<AnswerDTO> retrievedDtoList = service.getAll();
        List<AnswerRest> restList = retrievedDtoList
                .stream()
                .map(answerRestMapper::getRestFromDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(restList, HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<AnswerRest> put(@RequestBody AnswerRest rest) {
        try {
            AnswerDTO savedDto = service.insert(answerRestMapper.getDtoFromRest(rest));
            return new ResponseEntity<>(answerRestMapper.getRestFromDto(savedDto), HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * ############################
     * #  TABLE-SPECIFIC METHODS  #
     * ############################
     */
    @GetMapping("/byQuestion/{questionId}")
    public ResponseEntity<List<AnswerRest>> getByQuestionId(@PathVariable Integer questionId) {
        try {
            List<AnswerDTO> retrievedDtoList = service.getByQuestionId(questionId);
            List<AnswerRest> restList = retrievedDtoList
                    .stream()
                    .map(answerRestMapper::getRestFromDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(restList, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byQuestion")
    public ResponseEntity<List<AnswerRest>> getByQuestion(@RequestBody QuestionRest question) {
        try {
            List<AnswerDTO> retrievedDtoList = service.getByQuestion(questionRestMapper.getDtoFromRest(question));
            List<AnswerRest> restList = retrievedDtoList
                    .stream()
                    .map(answerRestMapper::getRestFromDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(restList, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

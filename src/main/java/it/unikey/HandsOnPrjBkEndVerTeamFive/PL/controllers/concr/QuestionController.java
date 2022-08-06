package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.StudentDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.QuestionService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.abstr.GenericController;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr.QuestionRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.QuestionRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.StudentRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController implements GenericController<QuestionRest> {

    private final QuestionService service;
    private final QuestionRestMapper restMapper;

    /**
     * ################
     * #  BASIC CRUD  #
     * ################
     */

    @Override
    @PostMapping
    public ResponseEntity<QuestionRest> post(@RequestBody QuestionRest rest) {
        QuestionDTO savedDto = service.insert(restMapper.getDtoFromRest(rest));
        return new ResponseEntity<>(restMapper.getRestFromDto(savedDto), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<QuestionRest> getById(@PathVariable Integer id) {
        try {
            QuestionDTO retrievedDto = service.getById(id);
            return new ResponseEntity<>(restMapper.getRestFromDto(retrievedDto), HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<QuestionRest>> getAll() {
        List<QuestionDTO> retrievedDtoList = service.getAll();
        List<QuestionRest> restList = retrievedDtoList
                .stream()
                .map(restMapper::getRestFromDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(restList, HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<QuestionRest> put(@RequestBody QuestionRest rest) {
        try{
            QuestionDTO savedDto = service.update(restMapper.getDtoFromRest(rest));
            return new ResponseEntity<>(restMapper.getRestFromDto(savedDto), HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        try{
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

    @GetMapping("/filter")
    public ResponseEntity<List<QuestionRest>> getByDifficulty(@RequestParam("difficulty") Integer difficulty) {
        try {
            List<QuestionDTO> retrievedDtoList = service.getByDifficulty(difficulty);
            List<QuestionRest> restList = retrievedDtoList
                    .stream()
                    .map(restMapper::getRestFromDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(restList, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/topic_name")
    private ResponseEntity<List<QuestionRest>> getByTopicName(@RequestParam("topic_name") String topic){
        try {
            List<QuestionDTO> dtoList = service.getByTopicName(topic);
            List<QuestionRest> questionRests = restMapper.getRestListFromDtoList(dtoList);
            return new ResponseEntity<>(questionRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/topic_id")
    private ResponseEntity<List<QuestionRest>> getByTopicID(@RequestParam("topic_id") Integer id){
        try {
            List<QuestionDTO> dtoList = service.getByTopicId(id);
            List<QuestionRest> questionRests = restMapper.getRestListFromDtoList(dtoList);
            return new ResponseEntity<>(questionRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/handouts")
    private ResponseEntity<List<QuestionRest>> getByHandoutsId(@RequestParam("handouts") Integer id){
        try {
            List<QuestionDTO> dtoList = service.getByHandoutsId(id);
            List<QuestionRest> questionRests = restMapper.getRestListFromDtoList(dtoList);
            return new ResponseEntity<>(questionRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

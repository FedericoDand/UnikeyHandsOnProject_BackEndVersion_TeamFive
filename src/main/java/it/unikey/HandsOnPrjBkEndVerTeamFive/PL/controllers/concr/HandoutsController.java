package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.HandoutsDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.HandoutsService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr.HandoutsRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.HandoutsRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.abstr.GenericController;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.QuestionRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/handouts")
public class HandoutsController implements GenericController<HandoutsRest> {

    private final HandoutsService service;
    private final HandoutsRestMapper mapper;

    @Override
    @PostMapping
    public ResponseEntity<HandoutsRest> post(@RequestBody HandoutsRest rest) {
        HandoutsDTO handoutsDTO= service.insert(mapper.getDtoFromRest(rest));
        HandoutsRest handoutsRest= mapper.getRestFromDto(handoutsDTO);
        return new ResponseEntity<>(handoutsRest, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<HandoutsRest> getById(@PathVariable Integer id) {
        HandoutsDTO handoutsDTO= service.getById(id);
        HandoutsRest handoutsRest= mapper.getRestFromDto(handoutsDTO);
        return new ResponseEntity<>(handoutsRest,HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<HandoutsRest>> getAll() {
        List<HandoutsDTO> dtoList= service.getAll();
        List<HandoutsRest> restList= mapper.getRestListFromDtoList(dtoList);
        return new ResponseEntity<>(restList,HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<HandoutsRest> put(@RequestBody HandoutsRest rest) {
        HandoutsDTO handoutsDTO= service.update(mapper.getDtoFromRest(rest));
        HandoutsRest handoutsRest= mapper.getRestFromDto(handoutsDTO);
        return new ResponseEntity<>(handoutsRest,HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        try{
            service.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * ############################
     * #  TABLE-SPECIFIC METHODS  #
     * ############################
     */

    @GetMapping(path = "/topic_name")
    private ResponseEntity<List<HandoutsRest>> getByTopicName(@RequestParam("topic_name") String topic){
        try {
            List<HandoutsDTO> dtoList = service.getByTopicName(topic);
            List<HandoutsRest> questionRests = mapper.getRestListFromDtoList(dtoList);
            return new ResponseEntity<>(questionRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/topic_id")
    private ResponseEntity<List<HandoutsRest>> getByTopicID(@RequestParam("topic_id") Integer id){
        try {
            List<HandoutsDTO> dtoList = service.getByTopicId(id);
            List<HandoutsRest> questionRests = mapper.getRestListFromDtoList(dtoList);
            return new ResponseEntity<>(questionRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/question")
    private ResponseEntity<List<HandoutsRest>> getByQuestionId(@RequestParam("question") Integer id){
        try {
            List<HandoutsDTO> dtoList = service.getByQuestionId(id);
            List<HandoutsRest> questionRests = mapper.getRestListFromDtoList(dtoList);
            return new ResponseEntity<>(questionRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
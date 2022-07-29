package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDto;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.QuestionService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.abstr.GenericController;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr.QuestionRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.QuestionRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Questions")
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
        QuestionDto saved = service.insert(restMapper.getDtoFromRest(rest));
        return new ResponseEntity<>(restMapper.getRestFromDto(saved), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<QuestionRest> getById(@PathVariable Integer id) {
        try {
            QuestionDto obtainedDto = service.getById(id);
            QuestionRest rest = restMapper.getRestFromDto(obtainedDto);
            return new ResponseEntity<>(rest, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<QuestionRest>> getAll() {
        List<QuestionDto> obtainedDtoList = service.getAll();
        List<QuestionRest> restList = obtainedDtoList
                .stream()
                .map(restMapper::getRestFromDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(restList, HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<QuestionRest> put(@RequestBody QuestionRest rest) {
        try{
            QuestionDto saved = service.update(restMapper.getDtoFromRest(rest));
            return new ResponseEntity<>(restMapper.getRestFromDto(saved), HttpStatus.OK);
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

    @GetMapping("/subset")
    public ResponseEntity<List<QuestionRest>> getByDifficulty(@RequestParam("difficulty") Integer difficulty) {
        try {
            List<QuestionDto> obtainedDtoList = service.getByDifficulty(difficulty);
            List<QuestionRest> restList = obtainedDtoList
                    .stream()
                    .map(restMapper::getRestFromDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(restList, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

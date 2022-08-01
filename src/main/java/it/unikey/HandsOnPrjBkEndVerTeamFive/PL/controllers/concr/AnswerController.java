package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AnswerDto;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.AnswerService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.abstr.GenericController;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr.AnswerRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.AnswerRest;
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
    private final AnswerRestMapper restMapper;

    /**
     * ################
     * #  BASIC CRUD  #
     * ################
     */

    @Override
    @PostMapping
    public ResponseEntity<AnswerRest> post(@RequestBody AnswerRest rest) {
        AnswerDto savedDto = service.insert(restMapper.getDtoFromRest(rest));
        return new ResponseEntity<>(restMapper.getRestFromDto(savedDto), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AnswerRest> getById(@PathVariable Integer id) {
        try {
            AnswerDto retrievedDto = service.getById(id);
            return new ResponseEntity<>(restMapper.getRestFromDto(retrievedDto), HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AnswerRest>> getAll() {
        List<AnswerDto> retrievedDtoList = service.getAll();
        List<AnswerRest> restList = retrievedDtoList
                .stream()
                .map(restMapper::getRestFromDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(restList, HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<AnswerRest> put(@RequestBody AnswerRest rest) {
        try {
            AnswerDto savedDto = service.insert(restMapper.getDtoFromRest(rest));
            return new ResponseEntity<>(restMapper.getRestFromDto(savedDto), HttpStatus.OK);
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
     * ########################
     * #  ADDITIONAL METHODS  #
     * ########################
     */
}

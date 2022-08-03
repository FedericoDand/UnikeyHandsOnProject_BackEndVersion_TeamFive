package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.imp;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.Dto.HandoutsDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.HandoutsService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.Mappers.impl.HandoutsRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.Rest.HandoutsRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.abstr.GenericController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Handouts")
public class HandoutsController implements GenericController<HandoutsRest> {

    private final HandoutsService service;
    private final HandoutsRestMapper mapper;

    @Override
    @PostMapping
    public ResponseEntity<HandoutsRest> post(@RequestBody HandoutsRest rest) {
        HandoutsDTO handoutsDTO= service.insert(mapper.fromRestToDto(rest));
        HandoutsRest handoutsRest= mapper.fromDtoToRest(handoutsDTO);
        return new ResponseEntity<>(handoutsRest, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<HandoutsRest> getById(@PathVariable Integer id) {
        HandoutsDTO handoutsDTO= service.getById(id);
        HandoutsRest handoutsRest= mapper.fromDtoToRest(handoutsDTO);
        return new ResponseEntity<>(handoutsRest,HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<HandoutsRest>> getAll() {
        List<HandoutsDTO> dtoList= service.getAll();
        List<HandoutsRest> restList= mapper.fromDtoListToRestList(dtoList);
        return new ResponseEntity<>(restList,HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<HandoutsRest> put(@RequestBody HandoutsRest rest) {
        HandoutsDTO handoutsDTO= service.update(mapper.fromRestToDto(rest));
        HandoutsRest handoutsRest= mapper.fromDtoToRest(handoutsDTO);
        return new ResponseEntity<>(handoutsRest,HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Integer id) {
        try{
            service.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
              e.printStackTrace();        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

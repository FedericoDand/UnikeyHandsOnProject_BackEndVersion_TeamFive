package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AcademyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.AcademyService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr.AcademyRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.AcademyRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.abstr.GenericController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/academy")
public class AcademyController implements GenericController<AcademyRest> {

    private final AcademyService service;
    private final AcademyRestMapper mapper;


    @Override
    @PostMapping
    public ResponseEntity<AcademyRest> post(@RequestBody AcademyRest rest) {
        AcademyDTO academyDTO= service.insert(mapper.getDtoFromRest(rest));
        AcademyRest academyRest= mapper.getRestFromDto(academyDTO);
        return new ResponseEntity<>(academyRest, HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<AcademyRest> getById(@PathVariable Integer id) {
        AcademyDTO academyDTO= service.getById(id);
        AcademyRest academyRest= mapper.getRestFromDto(academyDTO);
        return new ResponseEntity<>(academyRest,HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AcademyRest>> getAll() {
        List<AcademyDTO> list= service.getAll();
        List<AcademyRest> restList= mapper.getRestListFromDtoList(list);
        return new ResponseEntity<>(restList,HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<AcademyRest> put(@RequestBody AcademyRest rest) {
        AcademyDTO academyDTO= service.update(mapper.getDtoFromRest(rest));
        AcademyRest academyRest= mapper.getRestFromDto(academyDTO);
        return new ResponseEntity<>(academyRest, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Integer id) {
        try{
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.imp;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.Dto.AcademyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.AcademyService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.Mappers.impl.AcademyRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.Rest.AcademyRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.abstr.GenericController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Academy")
public class AcademyController implements GenericController<AcademyRest> {

    private final AcademyService service;
    private final AcademyRestMapper mapper;


    @Override
    @PostMapping
    public ResponseEntity<AcademyRest> post(@RequestBody AcademyRest rest) {
        AcademyDTO academyDTO= service.insert(mapper.fromRestToDto(rest));
        AcademyRest academyRest= mapper.fromDtoToRest(academyDTO);
        return new ResponseEntity<>(academyRest, HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<AcademyRest> getById(@PathVariable Integer id) {
        AcademyDTO academyDTO= service.getById(id);
        AcademyRest academyRest= mapper.fromDtoToRest(academyDTO);
        return new ResponseEntity<>(academyRest,HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AcademyRest>> getAll() {
        List<AcademyDTO> list= service.getAll();
        List<AcademyRest> restList= mapper.fromDtoListToRestList(list);
        return new ResponseEntity<>(restList,HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<AcademyRest> put(@RequestBody AcademyRest rest) {
        AcademyDTO academyDTO= service.update(mapper.fromRestToDto(rest));
        AcademyRest academyRest= mapper.fromDtoToRest(academyDTO);
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
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.StudentDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TechnologyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.TechnologyService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr.TechnologyRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.ModuleRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.StudentRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.TechnologyRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/technology")
public class TechnologyController {

    private final TechnologyService technologyService;
    private final TechnologyRestMapper technologyRestMapper;

    @GetMapping
    private ResponseEntity<List<TechnologyRest>> getAll(){
        return new ResponseEntity<>(technologyRestMapper.getRestListFromDtoList(technologyService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<TechnologyRest> getById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(technologyRestMapper.
                    getRestFromDto(technologyService.getById(id)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/name")
    private ResponseEntity<List<TechnologyRest>> getByName(@RequestParam("name") String name){
        try {
            return new ResponseEntity<>(technologyRestMapper.
                    getRestListFromDtoList(technologyService.getByName(name)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/module")
    private ResponseEntity<List<TechnologyRest>> getByAcademy(@RequestParam("module") String module){
        try {
            List<TechnologyDTO> dtoList = technologyService.getListByModuleName(module);
            List<TechnologyRest> technologyRests = technologyRestMapper.getRestListFromDtoList(dtoList);
            return new ResponseEntity<>(technologyRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    private ResponseEntity<TechnologyRest> postTechnology(@RequestBody TechnologyRest technology){
        return new ResponseEntity<>(technologyRestMapper
                .getRestFromDto(technologyService.insert(technologyRestMapper.getDtoFromRest(technology))), HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity<TechnologyRest> putTechnology(@RequestBody TechnologyRest technology){
        try {
            return new ResponseEntity<>(technologyRestMapper.
                    getRestFromDto(technologyService.update(technologyRestMapper.getDtoFromRest(technology))), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteTechnology(@PathVariable Integer id){
        try {
            technologyService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

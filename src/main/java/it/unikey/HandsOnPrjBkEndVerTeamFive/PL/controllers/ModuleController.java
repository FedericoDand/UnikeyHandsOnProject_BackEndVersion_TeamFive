package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.ModuleService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr.ModuleRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.ModuleRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/module")
public class ModuleController {

    private final ModuleService moduleService;
    private final ModuleRestMapper moduleRestMapper;

    @GetMapping
    private ResponseEntity<List<ModuleRest>> getAll(){
        return new ResponseEntity<>(moduleRestMapper.getRestListFromDtoList(moduleService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ModuleRest> getById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(moduleRestMapper.
                    getRestFromDto(moduleService.getById(id)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/name")
    private ResponseEntity<List<ModuleRest>> getByName(@RequestParam("name") String name){
        try {
            return new ResponseEntity<>(moduleRestMapper.
                    getRestListFromDtoList(moduleService.getByName(name)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<ModuleRest> postModule(@RequestBody ModuleRest module){
        return new ResponseEntity<>(moduleRestMapper
                .getRestFromDto(moduleService.insert(moduleRestMapper.getDtoFromRest(module))), HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity<ModuleRest> putModule(@RequestBody ModuleRest module){
        try {
            return new ResponseEntity<>(moduleRestMapper.
                    getRestFromDto(moduleService.update(moduleRestMapper.getDtoFromRest(module))), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteModule(@PathVariable Integer id){
        try {
            moduleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

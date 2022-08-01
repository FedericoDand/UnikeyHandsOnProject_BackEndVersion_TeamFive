package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.impl;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TeacherDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.TeacherService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.impl.TeacherRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.TeacherRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {
    
    final private TeacherService teacherService;
    final private TeacherRestMapper teacherRestMapper;
    
    @GetMapping
    private ResponseEntity<List<TeacherRest>> getAllTeachers(){
        List<TeacherDTO> teachers = teacherService.getAll();
        List<TeacherRest> teacherRests = teacherRestMapper.fromDtoListToRestList(teachers);
        return new ResponseEntity<>(teacherRests, HttpStatus.OK);
    }
    
    @GetMapping(path = "/{id}")
    private ResponseEntity<TeacherRest> getTeacherById(@PathVariable Integer id){
        try {
            TeacherDTO teacher = teacherService.getById(id);
            TeacherRest teacherRest = teacherRestMapper.getRestFromDto(teacher);
            return new ResponseEntity<>(teacherRest, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{name}/{lastName}")
    private ResponseEntity<List<TeacherRest>> getByNameAndLastName(@PathVariable("name") String name, @PathVariable("lastName") String lastName){
        try {
            List<TeacherDTO> dtoList = teacherService.getByNameAndLastName(name, lastName);
            List<TeacherRest> teacherRests = teacherRestMapper.fromDtoListToRestList(dtoList);
            return new ResponseEntity<>(teacherRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    private ResponseEntity<TeacherRest> postTeacher(@RequestBody TeacherRest athlete){
        TeacherDTO teacherDto = teacherService.insert(teacherRestMapper.getDtoFromRest(athlete));
        TeacherRest teacherRest = teacherRestMapper.getRestFromDto(teacherDto);
        return new ResponseEntity<>(teacherRest, HttpStatus.CREATED);
    }


    @PutMapping
    private ResponseEntity<TeacherRest> putTeacher(@RequestBody TeacherRest athlete){
        try {
            TeacherDTO teacherDTO = teacherService.update(teacherRestMapper.getDtoFromRest(athlete));
            TeacherRest teacherRest = teacherRestMapper.getRestFromDto(teacherDTO);
            return new ResponseEntity<>(teacherRest, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteTeacher(@PathVariable Integer id){
        try {
            teacherService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
}

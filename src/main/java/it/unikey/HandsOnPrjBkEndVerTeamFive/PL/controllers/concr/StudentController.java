package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.StudentDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.StudentService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr.StudentRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.StudentRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    final private StudentService studentService;
    final private StudentRestMapper studentRestMapper;

    @GetMapping
    private ResponseEntity<List<StudentRest>> getAllStudents(){
        List<StudentDTO> students = studentService.getAll();
        List<StudentRest> studentRests = studentRestMapper.getRestListFromDtoList(students);
        return new ResponseEntity<>(studentRests, HttpStatus.OK);
    }


    @GetMapping(path = "/{id}")
    private ResponseEntity<StudentRest> getStudentById(@PathVariable Integer id){
        try {
            StudentDTO student = studentService.getById(id);
            StudentRest studentRest = studentRestMapper.getRestFromDto(student);
            return new ResponseEntity<>(studentRest, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{name}/{lastName}")
    private ResponseEntity<List<StudentRest>> getByNameAndLastName(@PathVariable("name") String name, @PathVariable("lastName") String lastName){
        try {
            List<StudentDTO> dtoList = studentService.getByNameAndLastName(name, lastName);
            List<StudentRest> studentRests = studentRestMapper.getRestListFromDtoList(dtoList);
            return new ResponseEntity<>(studentRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/academy_name")
    private ResponseEntity<List<StudentRest>> getByAcademy(@RequestParam("academy_name") String academy){
        try {
            List<StudentDTO> dtoList = studentService.getListByAcademyName(academy);
            List<StudentRest> studentRests = studentRestMapper.getRestListFromDtoList(dtoList);
            return new ResponseEntity<>(studentRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/academy_code")
    private ResponseEntity<List<StudentRest>> getByAcademyAccess(@RequestParam("academy_code") String code){
        try {
            List<StudentDTO> dtoList = studentService.getListByAcademyAccesCode(code);
            List<StudentRest> studentRests = studentRestMapper.getRestListFromDtoList(dtoList);
            return new ResponseEntity<>(studentRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    private ResponseEntity<StudentRest> postStudent(@RequestBody StudentRest athlete){
        StudentDTO studentDto = studentService.insert(studentRestMapper.getDtoFromRest(athlete));
        StudentRest studentRest = studentRestMapper.getRestFromDto(studentDto);
        return new ResponseEntity<>(studentRest, HttpStatus.CREATED);
    }


    @PutMapping
    private ResponseEntity<StudentRest> putStudent(@RequestBody StudentRest athlete){
        try {
            StudentDTO studentDTO = studentService.update(studentRestMapper.getDtoFromRest(athlete));
            StudentRest studentRest = studentRestMapper.getRestFromDto(studentDTO);
            return new ResponseEntity<>(studentRest, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
        try {
            studentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

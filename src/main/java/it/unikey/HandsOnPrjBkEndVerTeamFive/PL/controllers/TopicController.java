package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.controllers;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr.TopicService;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr.TopicRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.ModuleRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.TopicRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topic")
public class TopicController {

    private final TopicService topicService;
    private final TopicRestMapper topicRestMapper;

    @GetMapping
    private ResponseEntity<List<TopicRest>> getAll(){
        return new ResponseEntity<>(topicRestMapper.getRestListFromDtoList(topicService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<TopicRest> getById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(topicRestMapper.
                    getRestFromDto(topicService.getById(id)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/name")
    private ResponseEntity<List<TopicRest>> getByName(@RequestParam("name") String name){
        try {
            return new ResponseEntity<>(topicRestMapper.
                    getRestListFromDtoList(topicService.getByName(name)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<TopicRest> postTopic(@RequestBody TopicRest topic){
        return new ResponseEntity<>(topicRestMapper
                .getRestFromDto(topicService.insert(topicRestMapper.getDtoFromRest(topic))), HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity<TopicRest> putTopic(@RequestBody TopicRest topic){
        try {
            return new ResponseEntity<>(topicRestMapper.
                    getRestFromDto(topicService.update(topicRestMapper.getDtoFromRest(topic))), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteTopic(@PathVariable Integer id){
        try {
            topicService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

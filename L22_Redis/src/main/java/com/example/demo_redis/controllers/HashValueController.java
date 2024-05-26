package com.example.demo_redis.controllers;

import com.example.demo_redis.dto.CreatePersonRequest;
import com.example.demo_redis.model.Person;
import com.example.demo_redis.services.HashValueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class HashValueController {

    @Autowired
    HashValueService hashValueService;

    @PostMapping("/hash")
    public Person createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest){
        return this.hashValueService.set(createPersonRequest.to());
    }

    @DeleteMapping("/hash")
    public void deleteField(@RequestParam("id") String id,
                               @RequestParam("field") String field){
        this.hashValueService.deleteField(id, field);
    }

    @GetMapping("/hash/all")
    public Person getPerson(@RequestParam("id") String id){
        return this.hashValueService.getPerson(id);
    }

    @GetMapping("/hash/field")
    public Object getFieldValue(@RequestParam("id") String id,
                                @RequestParam("field") String field){
        return this.hashValueService.getValueForField(id, field);
    }
}

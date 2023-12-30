package com.crud.controller;

import com.crud.entity.Demo;
import com.crud.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud")
public class DemoController {
    @Autowired
    private DemoService demoService;
    @PostMapping
    public ResponseEntity<Demo>  insertDemo(@RequestBody Demo demo){
        Demo saved = demoService.createDemo(demo);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDemo(@PathVariable int id){
        demoService.deleteDemo(id);
        return new ResponseEntity<>("record is deleted",HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Demo>> getAllDemo(){
        List<Demo> allDemos = demoService.getALL();
        return new ResponseEntity<>(allDemos,HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Demo>  updateDemo(@PathVariable int id,@RequestBody Demo demo){
        Demo updatedDemo = demoService.updateDemo(id,demo);
        return new ResponseEntity<>(updatedDemo,HttpStatus.OK);
    }

}

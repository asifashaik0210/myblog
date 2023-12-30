package com.crud.service;

import com.crud.entity.Demo;
import com.crud.repository.DemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoService {
    private DemoRepository demoRepository;

    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public Demo createDemo(Demo demo) {
        Demo savedDemo = demoRepository.save(demo);
      return savedDemo;
    }

    public String deleteDemo(int id) {
        demoRepository.deleteById(id);
        return null;
    }

    public List<Demo> getALL() {
        List<Demo> all = demoRepository.findAll();
        return all;
    }

    public Demo updateDemo(int id,Demo demo) {
        Optional<Demo> idAll = demoRepository.findById(id);
           Demo demo1 = idAll.get();
           demo1.setName(demo.getName());
           demo1.setCourse(demo.getCourse());
           demo1.setEmail(demo.getEmail());
        Demo save = demoRepository.save(demo1);
        return save;
    }
}

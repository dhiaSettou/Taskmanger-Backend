package com.training.training.Controller;

import com.training.training.Entity.DTO.ProjectDeveloperDTO;
import com.training.training.Entity.Filter;
import com.training.training.Entity.Mapper.ProjectDeveloperMapper;
import com.training.training.Entity.Mapper.ProjectMapper;
import com.training.training.Entity.ProjectDeveloper;
import com.training.training.Repository.ProjectDeveloperRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/projectdeveloper")
@AllArgsConstructor
public class ProjectDeveloperController {
    @Autowired
    private ServiceFilter serviceFilter;
     private  final  ProjectDeveloperMapper projectDeveloperMapper ;
     private  final ProjectDeveloperRepository projectDeveloperRepository;

     @GetMapping(path = "/get")
    List<ProjectDeveloperDTO> getdata(){
       return    projectDeveloperMapper.toDtos(projectDeveloperRepository.findAll());
     }

    @PostMapping(path = "/getbyfilter")
    public List<ProjectDeveloperDTO> filtredData(@RequestBody Filter filter) {
        return projectDeveloperMapper.toDtos(serviceFilter.findByFilter(filter));
    }
}


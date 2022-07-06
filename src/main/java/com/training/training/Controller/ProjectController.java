package com.training.training.Controller;

import com.training.training.Entity.DTO.ProjectDto;
import com.training.training.Entity.Mapper.ProjectMapper;
import com.training.training.Entity.Project;
import com.training.training.Entity.Status;
import com.training.training.Repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/project")
@AllArgsConstructor
public class ProjectController {
    private final ProjectRepository repository;
    private  final ProjectMapper projectMapper;
    @PostMapping(path ="/save")
    public Project savedata(@RequestBody Project project){
        //project.getDevelopers().forEach(developer -> developer.setProjects(Collections.singletonList(project)));
        repository.save(project);
        return project;
    }
    @GetMapping(path ="/get")
    public List<ProjectDto> getdata(){
        return projectMapper.toDtos(repository.findAll());
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean delete(@PathVariable int id){
        repository.deleteById(id);
        return !repository.existsById(id);
    }
    @PatchMapping(path = "/update")
    private ProjectDto update(@RequestBody ProjectDto projectDto){
        boolean b = repository.existsById(projectDto.getId());
        if (b) {
            ProjectDto projectDto1 = projectMapper.toDto(repository.save(projectMapper.toEntity(projectDto)));
            return projectDto1;
        } else {
            return null;
        }

    }
}


package com.training.training.Controller;

import com.training.training.Entity.DTO.DeveloperDto;
import com.training.training.Entity.Developer;
import com.training.training.Entity.Mapper.DeveloperMapper;
import com.training.training.Entity.ProjectDeveloperId;
import com.training.training.Repository.DeveloperRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/developer")
@AllArgsConstructor
public class DeveloperController {


    private final DeveloperMapper developerMapper;

    private final DeveloperRepository repository;

    @PostMapping(path = "/save")
    public ResponseEntity<DeveloperDto> saveData(@Valid @RequestBody DeveloperDto developerDto) {// البوست يكون فيه لربع مراحل :1-نجيبو dto من
        Developer entity = developerMapper.toEntity(developerDto);//2-نحولو الي جبناه للentity كيما كان
        //entity.getProjectDevelopers().get(0).setId(ProjectDeveloperId.builder().developerId(entity.getId()).projectId(developerDto.getProjectDevelopers().get(0).getId().getProjectId()).build());
        Developer developer = repository.save(entity);//نحفطوه من الشكل القديم اتاعه لازم
        DeveloperDto dto = developerMapper.toDto(developer);//نرجعوه dto
        return ResponseEntity.ok(dto);
        //الترجيع يكون dto تع الحاجة لي تحفظت مشي الdto الي تبعث
    }

    @GetMapping(path = "/get")
    public List<DeveloperDto> getData() {
        return developerMapper.toDtos(repository.findAll());
    }
    @GetMapping(path = "/getbyname/{name}")
    public List<DeveloperDto> getByName(@PathVariable String name) {
        return developerMapper.toDtos(repository.searchByName(name));
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean delete(@PathVariable int id) {
       if(repository.existsById(id)) {
           repository.deleteById(id);
           return !repository.existsById(id);
       }
       else return true;
    }

    @PatchMapping(path = "/update")
    private DeveloperDto update(@RequestBody DeveloperDto developerDto) {
        if (repository.existsById(developerDto.getId()))//منديروشي تحويل للentity علجاله الid كاين فيه
        {
            Developer save = repository.save(developerMapper.toEntity(developerDto));
            DeveloperDto developerDto1 = developerMapper.toDto(save);
            return developerDto1;
        } else {
            return null;
        }

    }
}

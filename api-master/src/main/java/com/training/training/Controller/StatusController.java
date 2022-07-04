package com.training.training.Controller;

import com.training.training.Entity.DTO.StatusDto;
import com.training.training.Entity.Mapper.StatusMapper;
import com.training.training.Entity.Status;
import com.training.training.Repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/status")
@AllArgsConstructor
public class StatusController {
    private final StatusRepository repository;
    private final StatusMapper statusMapper;

    @PostMapping(path ="/save")
    public StatusDto savedata(@RequestBody StatusDto statusDto){

        Status entity = statusMapper.toEntity(statusDto);
        Status save = repository.save(entity);
        StatusDto statusDto1 = statusMapper.toDto(save);
        return statusDto1;

    }
    @GetMapping(path ="/get")
    public List<StatusDto> getdata(){

        List<Status> all = repository.findAll();
        List<StatusDto> statusDtos = statusMapper.toDtos(all);
        return statusDtos;
    }

    @DeleteMapping(path = "/delete/{id}")
     public boolean delete(@PathVariable int id){
        repository.deleteById(id);
        return !repository.existsById(id);
    }
    @PatchMapping(path = "/update")
    private StatusDto update(@RequestBody StatusDto statusDto){
        if (repository.existsById(statusDto.getId())) {
            Status entity = statusMapper.toEntity(statusDto);
            Status save = repository.save(entity);
            return statusMapper.toDto(save);
        } else {
            return null;
        }

    }
}

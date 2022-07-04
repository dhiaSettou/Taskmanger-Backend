package com.training.training.Entity.Mapper;

import com.training.training.Entity.DTO.ProjectDeveloperDTO;
import com.training.training.Entity.Project;
import com.training.training.Entity.ProjectDeveloper;
import com.training.training.Repository.ProjectRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectDeveloperMapper {
    ProjectDeveloperMapper instance = Mappers.getMapper(ProjectDeveloperMapper.class);

    ProjectDeveloperDTO toDto(ProjectDeveloper projectDeveloper);

    List<ProjectDeveloperDTO> toDtos(List<ProjectDeveloper> projectDevelopers);

    ProjectDeveloper toEntity(ProjectDeveloperDTO projectDeveloperDTO);



}

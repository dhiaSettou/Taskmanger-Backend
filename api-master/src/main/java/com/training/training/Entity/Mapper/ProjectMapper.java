package com.training.training.Entity.Mapper;

import com.training.training.Entity.DTO.ProjectDto;
import com.training.training.Entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ProjectMapper {
    ProjectMapper instance = Mappers.getMapper(ProjectMapper.class);

     ProjectDto toDto(Project project);
     List<ProjectDto> toDtos(List<Project> projects);

     Project toEntity(ProjectDto projectDto) ;


}

package com.training.training.Entity.Mapper;

import com.training.training.Entity.DTO.DeveloperDto;
import com.training.training.Entity.DTO.ProjectDeveloperDTO;
import com.training.training.Entity.DTO.ProjectDto;
import com.training.training.Entity.Developer;
import com.training.training.Entity.Project;
import com.training.training.Entity.ProjectDeveloper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DeveloperMapper {
    DeveloperMapper instance = Mappers.getMapper(DeveloperMapper.class);

    @Mapping(source = "projectDevelopers"/* مركز الداتا */, target = "projectDevelopers"/* الى اين */, qualifiedByName = "toProjectDevelopersDto"/* اخدم بالميطود الي اسمها كذا*/)
    DeveloperDto toDto(Developer developer);

    List<DeveloperDto> toDtos(List<Developer> developers);

    @Mapping(source = "projectDevelopers"/* مركز الداتا */, target = "projectDevelopers"/* الى اين */, qualifiedByName = "toProjectDevelopers"/* اخدم بالميطود الي اسمها كذا*/)
    Developer toEntity(DeveloperDto developerDto);

    @Named("toProjectDevelopers")//بش نعطوها اسم
// من اجل بش نفهمو نعرضو البروجيات تع الديفلوبارة
    static ProjectDeveloper toProject(ProjectDeveloperDTO dto) {
        return ProjectDeveloperMapper.instance.toEntity(dto);
    }
    @Named("toProjectDevelopersDto")
    static ProjectDeveloperDTO toProjectDto(ProjectDeveloper projectDeveloper){
        return ProjectDeveloperMapper.instance.toDto(projectDeveloper);
    }
}

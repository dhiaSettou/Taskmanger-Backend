package com.training.training.Entity.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperDto {
    private  int id ;

    @NotBlank(message = "name must not be null")
    @NotNull
    private String name;
    List<ProjectDeveloperDTO> projectDevelopers;
}

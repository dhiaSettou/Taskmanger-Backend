package com.training.training.Entity.DTO;

import com.training.training.Entity.ProjectDeveloperId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDeveloperDTO {
    private ProjectDeveloperId id ;
    private Date date;
    private Boolean fullDay;
    private Timestamp startedTime;
    private Timestamp finishedTime;
    private DeveloperDto developerDto;
    private ProjectDto projectDto;

}

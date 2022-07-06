package com.training.training.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDeveloperDTO {
    private int id ;
    private Boolean fullDay;
    private Timestamp startedTime;
    private Timestamp finishedTime;
    private String projectName;
    private String developerName;
    private int idProject;
    private int idDeveloper;
    private Boolean isExpended;



}

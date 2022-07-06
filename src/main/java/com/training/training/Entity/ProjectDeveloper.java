package com.training.training.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Named;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project_developer")
public class ProjectDeveloper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String projectName;
    private String developerName;
    private Boolean isExpended;
    private Boolean fullDay;
    private Timestamp startedTime;
    private Timestamp finishedTime;
    @ManyToOne
    private Developer developer;
    @ManyToOne
    private Project project;


}

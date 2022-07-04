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
    @EmbeddedId
    private ProjectDeveloperId id;
    @Column(columnDefinition = "DATE")
    private Date date;
    private Boolean fullDay;
    private Timestamp startedTime;
    private Timestamp finishedTime;
    @ManyToOne
    @MapsId("developerId")
    private Developer developer ;
    @ManyToOne
    @MapsId("projectId")
    private Project project ;



}

package com.training.training.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},
        mappedBy = "developer")
    List<ProjectDeveloper> projectDevelopers;


}

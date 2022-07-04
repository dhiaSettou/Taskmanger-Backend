package com.training.training.Entity.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private  int id ;
    private  String name;
    private  String color;
    private  String note;



    //List<DeveloperDto> developers ;
}
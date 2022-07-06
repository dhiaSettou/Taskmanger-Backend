package com.training.training.Repository;

import com.training.training.Entity.Developer;
import com.training.training.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer,Integer> {

    @Query("SELECT d FROM Developer d WHERE d.name LIKE %?1%")
    List<Developer> searchByName(String name);
}

package com.training.training.Repository;

import com.training.training.Entity.ProjectDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDeveloperRepository extends JpaRepository<ProjectDeveloper, Integer> {
    List<ProjectDeveloper> findProjectDeveloperByDeveloperId (Long developerId);
}

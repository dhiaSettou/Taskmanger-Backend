package com.training.training.Repository;

import com.training.training.Entity.ProjectDeveloper;
import com.training.training.Entity.ProjectDeveloperId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDeveloperRepository extends JpaRepository<ProjectDeveloper, ProjectDeveloperId> {
}

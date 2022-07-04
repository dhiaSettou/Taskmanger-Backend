package com.training.training.Repository;

import com.training.training.Entity.Project;
import com.training.training.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Integer> {
}

package com.vtlamdev.business.business.dao.Job;

import com.vtlamdev.business.business.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {
}

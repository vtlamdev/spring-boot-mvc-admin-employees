package com.vtlamdev.business.business.services.Job;

import com.vtlamdev.business.business.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> findAllJob();
    Job saveJob(Job job);
    Job findJobById(int id);
    void deleteJobById(int id);
    Job findJobAndEmployeesByJoinFetch(int id);
}

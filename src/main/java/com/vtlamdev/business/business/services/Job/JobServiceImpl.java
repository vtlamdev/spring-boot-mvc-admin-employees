package com.vtlamdev.business.business.services.Job;

import com.vtlamdev.business.business.dao.Job.CustomJobRepository;
import com.vtlamdev.business.business.dao.Job.JobRepository;
import com.vtlamdev.business.business.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{
    private JobRepository jobRepository;
    private CustomJobRepository customJobRepository;
    @Autowired
    public JobServiceImpl(JobRepository jobRepository, CustomJobRepository customJobRepository)
    {
        this.jobRepository=jobRepository;
        this.customJobRepository=customJobRepository;
    }

    @Override
    @Transactional
    public List<Job> findAllJob() {
        return jobRepository.findAll();
    }
    @Override
    @Transactional
    public Job saveJob(Job job)
    {
        return jobRepository.save(job);
    }
    @Override
    @Transactional
    public Job findJobById(int id)
    {
        Optional<Job> job= jobRepository.findById(id);
        return job.get();
    }
    @Override
    @Transactional
    public void deleteJobById(int id)
    {
        jobRepository.deleteById(id);
    }
    @Override
    @Transactional
    public Job findJobAndEmployeesByJoinFetch(int id)
    {
        return customJobRepository.findJobAndEmployeesByJoinFetch(id);
    }
}

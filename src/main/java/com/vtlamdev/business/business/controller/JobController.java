package com.vtlamdev.business.business.controller;

import com.vtlamdev.business.business.entity.Job;
import com.vtlamdev.business.business.services.Job.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;
    public JobController(JobService jobService)
    {
        this.jobService=jobService;
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/list")
    public String listJobs(Model theModel)
    {
        theModel.addAttribute("jobs",jobService.findAllJob());
        return "list-job";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        theModel.addAttribute("job", new Job());
        return "add-job";

    }
    @GetMapping("/showFormForUpdate{jobId}")
    public String showFormForUpdate(@RequestParam("jobId") int jobId,Model theModel)
    {
        theModel.addAttribute("job", jobService.findJobById(jobId));
        return "add-job";
    }
    @GetMapping("/delete{jobId}")
    public String deleteJob(@RequestParam("jobId") int jobId)
    {
        jobService.deleteJobById(jobId);
        return "redirect:/jobs/list";
    }
    @PostMapping("/save")
    public String saveJob(@Valid @ModelAttribute("job") Job job, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "add-job";
        }
        else
        {
            jobService.saveJob(job);
            return"redirect:/jobs/list";
        }
    }
    @GetMapping("/showAssociatedEmployees{jobId}")
    public String showAssociatedEmployees(@RequestParam("jobId") int jobId, Model theModel)
    {
        theModel.addAttribute("job",jobService.findJobAndEmployeesByJoinFetch(jobId));
        return "list-AssociatedJob";
    }

}

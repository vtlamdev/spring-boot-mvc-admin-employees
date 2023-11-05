package com.vtlamdev.business.business.dao.Job;

import com.vtlamdev.business.business.entity.Job;

import java.util.List;

public interface CustomJobRepository {
    Job findJobAndEmployeesByJoinFetch(int id);

}

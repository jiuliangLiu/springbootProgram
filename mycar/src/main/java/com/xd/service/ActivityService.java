package com.xd.service;

import com.xd.dto.ActivityDTO;
import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;

public interface ActivityService {

    public int addActivity(ActivityDTO activityDTO);

    public int delActivity(Long id);

    public int updateActivity(ActivityDTO activityDTO);

    public ActivityDTO findById(Long id);

    public DataGridResult findByPage(QueryDTO queryDTO);



}

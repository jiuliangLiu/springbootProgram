package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.CarParams;

public interface CarParamService {

    public int addCarParams(CarParams carParams);
    public void delCarParams(Integer id);
    public int updateCarParams(CarParams carParams);
    public CarParams findById(Integer id);
    public DataGridResult findByPage(QueryDTO queryDTO);



}

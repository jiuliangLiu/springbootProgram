package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.CarParamType;

import java.util.List;

public interface CarParamTypeService {

    public int addCarParamType(CarParamType carParamType);

    public void delCarParm(Integer id);

    public int updateCarParamType(CarParamType carParamType);

    public CarParamType findById(Integer id);

    public List<CarParamType> findAll();

    public DataGridResult findByPage(QueryDTO queryDTO);



}

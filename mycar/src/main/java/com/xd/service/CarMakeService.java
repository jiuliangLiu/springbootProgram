package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.CarMake;

import java.util.List;

public interface CarMakeService {

    public int addCarMake(CarMake carMake);

    public void delCarMake(Integer id);

    public int updateCarMake(CarMake carMake);

    public CarMake findById(Integer id);

    public List<CarMake> findALL();

    public DataGridResult findByPage(QueryDTO queryDTO);

}

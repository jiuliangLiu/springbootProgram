package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.Car;

public interface CarService {

    public int addCar(Car car);
    public int delCar(Integer id);
    public int updateCar(Car car);
    public Car findById(Integer id);
    public DataGridResult findByPage(QueryDTO queryDTO);

}

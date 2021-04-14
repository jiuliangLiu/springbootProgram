package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.CarModel;

public interface CarModelService {

    public int addCarModel(CarModel carModel);

    public int delCarModel(Integer id);

    public int updateCarModel(CarModel carModel);

    public CarModel findById(Integer id);

    public DataGridResult findByPage(QueryDTO queryDTO);

}

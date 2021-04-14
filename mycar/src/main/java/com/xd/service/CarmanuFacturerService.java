package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.CarManufacturer;

public interface CarmanuFacturerService {

    public int addCarmanuFacturer(CarManufacturer carManufacturer);

    public void delCarManu(Integer id);

    public int updateCarmanuFacturer(CarManufacturer carManufacturer);

    public CarManufacturer findById(Integer id);

    public DataGridResult findByPage(QueryDTO queryDTO);

}

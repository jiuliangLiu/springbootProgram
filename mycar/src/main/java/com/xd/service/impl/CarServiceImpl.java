package com.xd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.dao.CarMapper;
import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.Car;
import com.xd.pojo.CarExample;
import com.xd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public int addCar(Car car) {
        return carMapper.insertSelective(car);
    }

    @Override
    public int delCar(Integer id) {
        return carMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCar(Car car) {
        return carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public Car findById(Integer id) {
        return carMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        CarExample example = new CarExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<Car> cars = carMapper.selectByExample(example);
        PageInfo<Car> info = new PageInfo<>(cars);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,cars);
        return result;
    }
}

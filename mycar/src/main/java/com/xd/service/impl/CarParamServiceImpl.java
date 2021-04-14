package com.xd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.dao.CarParamsMapper;
import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.CarParams;
import com.xd.pojo.CarParamsExample;
import com.xd.service.CarParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CarParamServiceImpl implements CarParamService {

    @Autowired
    private CarParamsMapper carParamsMapper;

    @Override
    public int addCarParams(CarParams carParams) {
        return carParamsMapper.insertSelective(carParams);
    }

    @Override
    public void delCarParams(Integer id) {
        carParamsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCarParams(CarParams carParams) {
        return carParamsMapper.updateByPrimaryKeySelective(carParams);
    }

    @Override
    public CarParams findById(Integer id) {
        return carParamsMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        CarParamsExample example = new CarParamsExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<CarParams> carParams = carParamsMapper.selectByExample(example);
        PageInfo<CarParams> info = new PageInfo<>(carParams);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,carParams);
        return result;
    }
}

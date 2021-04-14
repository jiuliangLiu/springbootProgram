package com.xd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.dao.CarParamTypeMapper;
import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.CarParamType;
import com.xd.pojo.CarParamTypeExample;
import com.xd.service.CarParamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarParamTypeServiceImpl implements CarParamTypeService {

    @Autowired
    private CarParamTypeMapper carParamTypeMapper;

    @Override
    public int addCarParamType(CarParamType carParamType) {
        return carParamTypeMapper.insertSelective(carParamType);
    }

    @Override
    public void delCarParm(Integer id) {
        carParamTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCarParamType(CarParamType carParamType) {
        return carParamTypeMapper.updateByPrimaryKeySelective(carParamType);
    }

    @Override
    public CarParamType findById(Integer id) {
        return carParamTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CarParamType> findAll() {
        return carParamTypeMapper.selectByExample(null);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        CarParamTypeExample example = new CarParamTypeExample();
        if(queryDTO.getSort()!=null&&!queryDTO.getSort().equals("")){
            example.setOrderByClause("id");
        }
        List<CarParamType> carParamTypes = carParamTypeMapper.selectByExample(example);
        PageInfo<CarParamType> info = new PageInfo<>(carParamTypes);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,carParamTypes);
        return result;
    }


}

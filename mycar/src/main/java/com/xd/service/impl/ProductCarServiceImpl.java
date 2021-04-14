package com.xd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.dao.ProductMapper;
import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.ProductExample;
import com.xd.pojo.ProductWithBLOBs;
import com.xd.service.ProductCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductCarServiceImpl implements ProductCarService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int addProduct(ProductWithBLOBs productWithBLOBs) {
        return productMapper.insertSelective(productWithBLOBs);
    }

    @Override
    public int delProduct(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateProduct(ProductWithBLOBs productWithBLOBs) {
        return productMapper.updateByPrimaryKeyWithBLOBs(productWithBLOBs);
    }

    @Override
    public ProductWithBLOBs findByID(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        ProductExample example = new ProductExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<ProductWithBLOBs> productWithBLOBs = productMapper.selectByExampleWithBLOBs(example);
        PageInfo<ProductWithBLOBs> info = new PageInfo<>(productWithBLOBs);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,productWithBLOBs);
        return result;
    }
}

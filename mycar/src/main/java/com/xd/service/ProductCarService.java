package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.ProductWithBLOBs;

public interface ProductCarService {

    public int addProduct(ProductWithBLOBs productWithBLOBs);

    public int delProduct(Integer id);

    public int updateProduct(ProductWithBLOBs productWithBLOBs);

    public ProductWithBLOBs findByID(Integer id);

    public DataGridResult findByPage(QueryDTO queryDTO);


}

package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.SysUser;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface SysUserService {
    public List<SysUser> findAll();

    public DataGridResult findUserByPage(QueryDTO queryDTO);

    public Workbook exportUser();

    public SysUser findByUsername(String username);

}

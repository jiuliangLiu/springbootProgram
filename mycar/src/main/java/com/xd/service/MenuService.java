package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.SysMenu;
import com.xd.utils.R;

import java.util.List;

public interface MenuService {

    public DataGridResult findMenu(QueryDTO queryDTO);

    public R deleteMenu(List<Long> ids);

    public R selectMenu();

    public R saveMenu(SysMenu sysMenu);

    public R findMenuById(Long menuId);

    public R updateMenu(SysMenu sysMenu);

    public List<String> findPermsByUserId(Long userId);

    public R findUserMenu(Long userId);

}

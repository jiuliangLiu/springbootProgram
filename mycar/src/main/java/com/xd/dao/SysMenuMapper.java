package com.xd.dao;

import com.xd.dto.QueryDTO;
import com.xd.pojo.SysMenu;
import com.xd.pojo.SysMenuExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysMenuMapper {
    int countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int deleteMenu(List<Long> ids);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> findMenuByPage(QueryDTO query);

    List<SysMenu> findMenu();

    List<String> findPermsByUserId(@Param("userId") Long userId);

    List<Map<String,Object>> findDirMenuByUserId(@Param("userId") Long userId);

    List<Map<String,Object>> findMenuNotButtonByUserId(@Param("userId") Long userId,@Param("parentId") Long parentId);
}
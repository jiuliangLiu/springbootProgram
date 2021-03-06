package com.xd.controller;

import com.xd.pojo.SysUser;
import com.xd.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/findAll")
    @ResponseBody
//    @RequiresRoles("qf")
    public List<SysUser> findAll(){
        int i = 1/0;
        return sysUserService.findAll();
    }

}

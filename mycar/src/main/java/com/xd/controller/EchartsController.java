package com.xd.controller;

import com.xd.service.TagService;
import com.xd.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EchartsController {

    @Autowired
    private TagService tagService;

    @ResponseBody
    @RequestMapping("/sys/echarts/line")
    public R findLine(){
        return tagService.findLineData();
    }

    @ResponseBody
    @RequestMapping("/sys/echarts/bar")
    public R findBar(){
        return tagService.findBarData();
    }

    @ResponseBody
    @RequestMapping("/sys/echarts/pie")
    public R findBie(){
        return tagService.findPieData();
    }


}

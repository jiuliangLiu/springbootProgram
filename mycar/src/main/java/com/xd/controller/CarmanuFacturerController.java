package com.xd.controller;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.CarMake;
import com.xd.pojo.CarManufacturer;
import com.xd.service.CarMakeService;
import com.xd.service.CarmanuFacturerService;
import com.xd.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarmanuFacturerController {

    @Autowired
    private CarmanuFacturerService carmanuFacturerService;
    @Autowired
    private CarMakeService carMakeService;

    @ResponseBody
    @RequestMapping("/sys/manufacturer/list")
    public DataGridResult findCarManu(QueryDTO queryDTO){
        return carmanuFacturerService.findByPage(queryDTO);
    }

    @ResponseBody
    @RequestMapping("/sys/manufacturer/del")
    public R delCarManu(@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            carmanuFacturerService.delCarManu(id);
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/sys/manufacturer/typeall")
    public R carType(){
        List<CarMake> all = carMakeService.findALL();
        return R.ok().put("sites",all);
    }

    @ResponseBody
    @RequestMapping("/sys/manufacturer/info/{id}")
    public R findById(@PathVariable("id") Integer id){
        CarManufacturer byId = carmanuFacturerService.findById(id);
        return R.ok().put("manufacturer",byId);
    }

    @ResponseBody
    @RequestMapping("/sys/manufacturer/save")
    public R addCarManu(@RequestBody CarManufacturer carManufacturer){
        int i = carmanuFacturerService.addCarmanuFacturer(carManufacturer);
        return i>0?R.ok():R.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/sys/manufacturer/update")
    public R updateCarManu(@RequestBody CarManufacturer carManufacturer){
        int i = carmanuFacturerService.updateCarmanuFacturer(carManufacturer);
        return i>0?R.ok():R.error("修改失败");
    }


}

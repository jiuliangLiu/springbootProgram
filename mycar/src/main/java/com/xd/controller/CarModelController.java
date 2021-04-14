package com.xd.controller;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.CarMake;
import com.xd.pojo.CarModel;
import com.xd.service.CarMakeService;
import com.xd.service.CarModelService;
import com.xd.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarModelController {

    @Autowired
    private CarModelService carModelService;
    @Autowired
    private CarMakeService carMakeService;

    @ResponseBody
    @RequestMapping("/sys/model/list")
    public DataGridResult findCarPage(QueryDTO queryDTO){
        return carModelService.findByPage(queryDTO);
    }

    @ResponseBody
    @RequestMapping("/sys/model/del")
    public R deleteCarModel(@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            carModelService.delCarModel(id);
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/sys/model/typeall")
    public R typeAll(){
        List<CarMake> all = carMakeService.findALL();
        return R.ok().put("sites",all);
    }

    @ResponseBody
    @RequestMapping("/sys/model/info/{id}")
    public R findById(@PathVariable("id") Integer id){
        CarModel byId = carModelService.findById(id);
        return R.ok().put("model",byId);
    }

    @ResponseBody
    @RequestMapping("/sys/model/save")
    public R addCarModel(@RequestBody CarModel carModel){
        int i = carModelService.addCarModel(carModel);
        return i>0?R.ok():R.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/sys/model/update")
    public R updateCarModel(@RequestBody CarModel carModel){
        int i = carModelService.updateCarModel(carModel);
        return i>0?R.ok():R.error("修改失败");
    }

}

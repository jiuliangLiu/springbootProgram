package com.xd.controller;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.Tag;
import com.xd.service.TagService;
import com.xd.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping("/sys/tag/list")
    @ResponseBody
    public DataGridResult findTag(QueryDTO queryDTO){
        return tagService.findByPage(queryDTO);
    }

    @RequestMapping("/sys/tag/del")
    @ResponseBody
    public R deleteTag(@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            tagService.delTag(id);
        }
        return R.ok();
    }

    @RequestMapping("/sys/tag/save")
    @ResponseBody
    public R saveTag(@RequestBody Tag tag){
        int i = tagService.addTag(tag);
        return i>0?R.ok():R.error("添加失败");
    }

    @RequestMapping("/sys/tag/info/{id}")
    @ResponseBody
    public R findById(@PathVariable("id") Integer id){
        Tag byId = tagService.findById(id);
        return R.ok().put("tag",byId);
    }

    @RequestMapping("/sys/tag/update")
    @ResponseBody
    public R updateTage(@RequestBody Tag tag){
        int i = tagService.updateTag(tag);
        return i>0?R.ok():R.error("更新失败");
    }




}

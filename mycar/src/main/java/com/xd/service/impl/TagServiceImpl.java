package com.xd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.dao.TagMapper;
import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.Tag;
import com.xd.pojo.TagExample;
import com.xd.service.TagService;
import com.xd.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int addTag(Tag tag) {
        int i = tagMapper.insertSelective(tag);
        return i;
    }

    @Override
    public void delTag(Integer id) {
        tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateTag(Tag tag) {
        int i = tagMapper.updateByPrimaryKeySelective(tag);
        return i;
    }

    @Override
    public Tag findById(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        TagExample example = new TagExample();
        if(queryDTO.getSort()!=null&&!queryDTO.getSort().equals("")){
            example.setOrderByClause("id "+queryDTO.getOrder());
        }
        List<Tag> tags = tagMapper.selectByExample(example);
        PageInfo<Tag> info = new PageInfo<>(tags);
        long total = info.getTotal();
        DataGridResult dataGridResult = new DataGridResult(total,tags);
        return dataGridResult;
    }

    @Override
    public R findLineData() {
        List<String> xAxisData  = new ArrayList<>();
        List seriesData = new ArrayList();
        List<Tag> tags = tagMapper.selectByExample(null);
        for (Tag tag : tags) {
            String name = tag.getName();
            xAxisData.add(name);
            Long clickCount = tag.getClickCount();
            seriesData.add(clickCount);
        }
        return R.ok().put("xAxis",xAxisData).put("seriesData",seriesData);
    }

    @Override
    public R findBarData() {
        List xAxisData = new ArrayList();
        List seriesData = new ArrayList();
        List<Tag> tags = tagMapper.selectByExample(null);
        for (Tag tag : tags) {
            xAxisData.add(tag.getName());
            seriesData.add(tag.getClickCount());
        }
        return R.ok().put("xAxis",xAxisData).put("seriesData",seriesData);
    }

    @Override
    public R findPieData() {
        List<String> legendData = new ArrayList<>();
        List<Map<String,Object>> seriesData = new ArrayList<>();
        List<Tag> tags = tagMapper.selectByExample(null);
        for (Tag tag : tags) {
            String name = tag.getName();
            Long clickCount = tag.getClickCount();
            legendData.add(name);
            Map<String,Object> map = new HashMap<>();
            map.put("name",name);
            map.put("value",clickCount);
            seriesData.add(map);
        }
        return R.ok().put("legendData",legendData).put("seriesData",seriesData);
    }
}

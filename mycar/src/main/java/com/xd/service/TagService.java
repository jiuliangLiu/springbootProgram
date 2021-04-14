package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.Tag;
import com.xd.utils.R;

public interface TagService {

    public int addTag(Tag tag);

    public void delTag(Integer id);

    public int updateTag(Tag tag);

    public Tag findById(Integer id);

    public DataGridResult findByPage(QueryDTO queryDTO);

    public R findLineData();

    public R findBarData();

    public R findPieData();

}

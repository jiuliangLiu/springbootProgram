package com.xd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.dao.MessageMapper;
import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.Message;
import com.xd.pojo.MessageExample;
import com.xd.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int addMessage(Message message) {
        return messageMapper.insertSelective(message);
    }

    @Override
    public int delMessage(Long id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateMessage(Message message) {
        return messageMapper.updateByPrimaryKeyWithBLOBs(message);
    }

    @Override
    public Message findById(Long id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        MessageExample example = new MessageExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<Message> messages = messageMapper.selectByExampleWithBLOBs(example);
        PageInfo<Message> info = new PageInfo<>(messages);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,messages);
        return result;
    }
}

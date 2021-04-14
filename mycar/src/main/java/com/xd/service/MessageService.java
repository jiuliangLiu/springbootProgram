package com.xd.service;

import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.Message;

public interface MessageService {

    public int addMessage(Message message);
    public int delMessage(Long id);
    public int updateMessage(Message message);
    public Message findById(Long id);
    public DataGridResult findByPage(QueryDTO queryDTO);


}

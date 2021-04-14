package com.xd.service;

import com.xd.dto.ArticleDTO;
import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.Article;

public interface ArticleService {

    public int addArticle(ArticleDTO articleDTO);

    public void delArt(Long id);

    public int updateArticle(ArticleDTO articleDTO);

    public Article findByID(Long id);

    public DataGridResult findByPage(QueryDTO queryDTO);


}

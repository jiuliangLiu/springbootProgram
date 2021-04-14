package com.xd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.dao.ArticleMapper;
import com.xd.dto.ArticleDTO;
import com.xd.dto.DataGridResult;
import com.xd.dto.QueryDTO;
import com.xd.pojo.Article;
import com.xd.pojo.ArticleExample;
import com.xd.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int addArticle(ArticleDTO articleDTO) {
        Article record = new Article();
        BeanUtils.copyProperties(articleDTO,record);
        Boolean allowUp = articleDTO.getAllowUp();
        record.setAllowUp((byte) 0);
        if(allowUp!=null) {
            if (allowUp) {
                record.setAllowUp((byte) 1);
            }
        }
        Boolean allowFav = articleDTO.getAllowFav();
        record.setAllowFav((byte) 0);
        if(allowFav!=null) {
            if (allowFav) {
                record.setAllowFav((byte) 1);
            }
        }
        int i = articleMapper.insertSelective(record);
        return i;
    }

    @Override
    public void delArt(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateArticle(ArticleDTO articleDTO) {
        Article record = new Article();
        BeanUtils.copyProperties(articleDTO,record);
        Boolean allowUp = articleDTO.getAllowUp();
        if(allowUp){
            record.setAllowUp((byte)1);
        }else{
            record.setAllowUp((byte)0);
        }
        Boolean allowFav = articleDTO.getAllowFav();
        if(allowFav){
            record.setAllowFav((byte)1);
        }else{
            record.setAllowFav((byte)0);
        }
        int i = articleMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    @Override
    public Article findByID(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        ArticleExample example = new ArticleExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<Article> articles = articleMapper.selectByExample(example);
        PageInfo<Article> info = new PageInfo<>(articles);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,articles);
        return result;
    }
}

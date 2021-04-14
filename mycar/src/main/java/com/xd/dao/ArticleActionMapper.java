package com.xd.dao;

import com.xd.pojo.ArticleAction;
import com.xd.pojo.ArticleActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleActionMapper {
    int countByExample(ArticleActionExample example);

    int deleteByExample(ArticleActionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleAction record);

    int insertSelective(ArticleAction record);

    List<ArticleAction> selectByExample(ArticleActionExample example);

    ArticleAction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleAction record, @Param("example") ArticleActionExample example);

    int updateByExample(@Param("record") ArticleAction record, @Param("example") ArticleActionExample example);

    int updateByPrimaryKeySelective(ArticleAction record);

    int updateByPrimaryKey(ArticleAction record);
}
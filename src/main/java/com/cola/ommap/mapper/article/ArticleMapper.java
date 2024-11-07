package com.cola.ommap.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cola.ommap.repository.entity.article.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
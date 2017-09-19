package cn.java.learn.redis.service;

import java.util.List;

import cn.java.learn.redis.entity.Article;
import cn.java.learn.redis.entity.City;

public interface ArticleESService {



    /**
     * 新增 ES 论文
     *
     * @param city
     * @return
     */
    Long saveArticle(Article article);

    /**
     * AND 语句查询
     *
     * @param title
     * @param abstracts
     * @return
     */
    List<Article> findByTitleAndAbstracts(String title, String abstracts);

}

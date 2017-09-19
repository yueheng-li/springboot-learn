package cn.java.learn.redis.service;

import java.util.List;

import cn.java.learn.redis.entity.Article;

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

    /**
     * 搜索词搜索，分页返回论文信息
     *
     * @param pageNumber 当前页码
     * @param pageSize 每页大小
     * @param searchContent 搜索内容
     * @return
     */
    List<Article> searchArticle(Integer pageNumber, Integer pageSize, String searchContent);

}

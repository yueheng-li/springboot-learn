package cn.java.learn.redis.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cn.java.learn.redis.entity.Article;

public interface ArticleESRepository extends ElasticsearchRepository<Article, Long>{

    /**
     * AND 语句查询
     *
     * @param title
     * @param abstracts
     * @return
     */
    List<Article> findByTitleAndAbstracts(String title, String abstracts);


}

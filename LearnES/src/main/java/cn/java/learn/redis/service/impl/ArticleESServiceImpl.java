package cn.java.learn.redis.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.java.learn.redis.entity.Article;
import cn.java.learn.redis.repository.ArticleESRepository;
import cn.java.learn.redis.service.ArticleESService;

@Service
public class ArticleESServiceImpl implements ArticleESService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleESServiceImpl.class);

    // 分页参数 -> TODO 代码可迁移到具体项目的公共 common 模块
    private static final Integer pageNumber = 0;
    private static final Integer pageSize = 10;
    Pageable pageable = new PageRequest(pageNumber, pageSize);
    
    @Autowired
    ArticleESRepository articeRepository;
	

	@Override
	public Long saveArticle(Article article) {
		Article ar = articeRepository.save(article);
		return ar.getId();
	}

	@Override
	public List<Article> findByTitleAndAbstracts(String title, String abstracts) {
		return articeRepository.findByTitleAndAbstracts(title, abstracts);
	}

}

package com.h3c.learnredis.service;

import com.h3c.learnredis.RedisUtils;
import com.h3c.learnredis.model.Article;
import com.h3c.learnredis.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {
    @Resource
    RedisUtils redisUtils;

    public void addArticle(Article article, User user) {
        long cur = System.currentTimeMillis();
        redisUtils.hSet("article", article.getId(), article);
        redisUtils.zAdd("time", article.getId(), cur);
        redisUtils.zAdd("score", article.getId(), cur);
        redisUtils.sAdd("voted:" + article.getId(), user.getId());
    }

    public void vote(Article article, User user) {
        redisUtils.sAdd("voted:" + article.getId(), user.getId());
        redisUtils.zIncrBy("score", article.getId(), 432);
    }
}

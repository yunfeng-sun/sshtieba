package com.tieba.service.Impl;

import com.tieba.dao.Impl.ReplyDaoImpl;
import com.tieba.dao.Impl.TopicDaoImpl;
import com.tieba.dao.ReplyDao;
import com.tieba.dao.TopicDao;
import com.tieba.domain.Reply;
import com.tieba.domain.Topic;
import com.tieba.service.BusinessService;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    private TopicDao topicDao = new TopicDaoImpl();
    private ReplyDao replyDao = new ReplyDaoImpl();

    public List<Topic> findAllTopic() {
        return topicDao.findAll();
    }

    public void saveTopic(Topic topic) {
        topicDao.save(topic);
    }

    public Topic findTopicById(Integer id) {
        return topicDao.findById(id);
    }

    public void saveReply(Reply reply) {
        replyDao.save(reply);
    }
}

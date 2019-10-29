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
        //添加回复
        replyDao.save(reply);
        //todo 修改主题的  最后回复时间，值为当前回复的创建时间
        Topic topic = topicDao.findById(reply.getTopic().getId()); // 执行查询  数据存放入 一级缓存和快照
        topic.setLastReplyTime(reply.getCreateDate());  // 修改一级缓存的内容
        //至此 已经更新 todo  提交时 进行 一级缓存与 快照的比较 ，触发update更新
    }
}

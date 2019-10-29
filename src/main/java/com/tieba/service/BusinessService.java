package com.tieba.service;

import com.tieba.domain.Reply;
import com.tieba.domain.Topic;

import java.util.List;

public interface BusinessService {
    public List<Topic> findAllTopic();
    public void saveTopic(Topic topic);
    public Topic findTopicById(Integer id);
    public void saveReply(Reply reply);
}

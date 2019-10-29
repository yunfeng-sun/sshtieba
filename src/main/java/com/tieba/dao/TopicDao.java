package com.tieba.dao;

import com.tieba.domain.Topic;

import java.util.List;

public interface TopicDao {
    /**
     * 查询所有topic
     * @return
     */
    public List<Topic> findAll();

    /**
     * 保存topic
     * @param topic
     */
    public void save(Topic topic);

    /**
     * 通过id获得Topic
     * @param id
     * @return
     */
    public Topic findById(Integer id);
}

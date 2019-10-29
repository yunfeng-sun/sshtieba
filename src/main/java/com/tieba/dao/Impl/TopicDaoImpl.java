package com.tieba.dao.Impl;

import com.tieba.dao.TopicDao;
import com.tieba.domain.Topic;
import com.tieba.util.HJUtils;

import java.util.List;
// 转为 泛型 / 反射
public class TopicDaoImpl implements TopicDao {
    public List<Topic> findAll() {
        return HJUtils.getCurrentSession().createQuery("from Topic t order by t.lastReplyTime desc").list();
    }

    public void save(Topic topic) {
        HJUtils.getCurrentSession().save(topic);
    }

    public Topic findById(Integer id) {
        return HJUtils.getCurrentSession().get(Topic.class,id);
    }
}

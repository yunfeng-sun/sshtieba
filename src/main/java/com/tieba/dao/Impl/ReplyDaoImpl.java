package com.tieba.dao.Impl;

import com.tieba.dao.ReplyDao;
import com.tieba.domain.Reply;
import com.tieba.util.HJUtils;

public class ReplyDaoImpl implements ReplyDao {
    public void save(Reply reply) {
        HJUtils.getCurrentSession().save(reply);
    }
}

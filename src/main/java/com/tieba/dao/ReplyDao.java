package com.tieba.dao;

import com.tieba.domain.Reply;

public interface ReplyDao {
    /**
     * 保存回复
     * @param reply
     */
    public void save(Reply reply);
}

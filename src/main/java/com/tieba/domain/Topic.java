package com.tieba.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Topic {
    private Integer id ;
    private String title ;          //主题
    private String ipAddr ;         //作者
    private Date lastReplyTime ; // 最后回复时间
    //配合reply
    private String topicContent ;  // 主题内容
    private Date createTime ; // 创建时间(发帖时间)
    Set<Reply> replySet = new HashSet<Reply>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Date getLastReplyTime() {
        return lastReplyTime;
    }

    public void setLastReplyTime(Date lastReplyTime) {
        this.lastReplyTime = lastReplyTime;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Set<Reply> getReplySet() {
        return replySet;
    }

    public void setReplySet(Set<Reply> replySet) {
        this.replySet = replySet;
    }
}

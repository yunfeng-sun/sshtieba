package com.tieba.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tieba.domain.Topic;
import com.tieba.service.BusinessService;
import com.tieba.service.Impl.BusinessServiceImpl;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

public class TopicAction extends ActionSupport implements ModelDriven<Topic> {

    //1 封装数据
    private Topic topic = new Topic();
    public Topic getModel() {
        return topic;
    }

    //2 使用service  （后面结合spring 注入 service）
    private BusinessService service = new BusinessServiceImpl();

    //查询所有
    public String findAll(){
        List<Topic> allTopic = service.findAllTopic();
        //todo 将查询的结果存放到值栈中 root     在jsp通过key直接获得 遍历即可
//        for (Topic tp : allTopic) {
//            System.out.println(tp.getLastReplyTime()+"==================>"+tp.getId());
//        }
        ActionContext.getContext().getValueStack().set("allTopic",allTopic);
        return "findAll";
    }
    //发表主题
    public String save(){
        //设置服务器端 生成的数据   jsp只传来 title 与 topicContent
        topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
        topic.setCreateTime(new Date());
        //默认使用创建时间，作为第一个回复时间
        topic.setLastReplyTime(topic.getCreateTime());
        service.saveTopic(topic);
        return "save";
    }
    // 通过id查topic
    public String findTopicById(){
        Topic findTopic = service.findTopicById(topic.getId());
        //添加到 MapContext 中 ； jsp必须通过 #key 获得
        ActionContext.getContext().put("findTopic",findTopic);
        return "findTopicById";
    }
}

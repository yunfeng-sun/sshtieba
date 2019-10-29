package com.tieba.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tieba.domain.Reply;
import com.tieba.service.BusinessService;
import com.tieba.service.Impl.BusinessServiceImpl;
import org.apache.struts2.ServletActionContext;

import java.util.Date;

public class ReplyAction extends ActionSupport implements ModelDriven<Reply> {
    private Reply reply = new Reply();
    public Reply getModel() { //3  modelDriven赋值
        return reply;
    }
    //1  可以设置set方法来赋值   2 jsp的ognl赋值
    private BusinessService service = new BusinessServiceImpl();
    public String save(){
        reply.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
        reply.setCreateDate(new Date());
//        System.out.println("=======replyAction==="+reply.getTopic().getId());
        service.saveReply(reply);
        return "save";
    }
}

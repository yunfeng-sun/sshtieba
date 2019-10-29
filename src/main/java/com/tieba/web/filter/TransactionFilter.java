package com.tieba.web.filter;


import com.tieba.util.HJUtils;
import org.hibernate.Session;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    //请求开始获得session，并开启事务，然后放行，执行struts action，struts执行完成之后，及放行结果，最后提交或回滚
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获得session
        Session session = HJUtils.getCurrentSession();
        try {
            //开启事务
            session.beginTransaction();
            //放行
            filterChain.doFilter(servletRequest,servletResponse);

            //提交事务
            session.getTransaction().commit(); // session是 getCurrentSession 得到的，hibernate会自动关闭
        }catch (Exception e){
            //回滚
            if(session !=null){
                session.getTransaction().rollback();
            }
            //出问题的 友好页面
            servletRequest.getRequestDispatcher("/WEB-INF/tieBa/syfBa/message.jsp").forward(servletRequest,servletResponse);
        }
    }

    public void destroy() {

    }
}

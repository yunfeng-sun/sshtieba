package com.tieba.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HJUtils {
    // addClass()  会在 hibernate.cfg.xml 中的 mapping 标签加载
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static Session openSession(){
        return  factory.openSession();
    }

    /**
     * 一个请求一个线程，当请求开始时，调用getCurrentSession获得session，此时本地线程中没有session，于是创建一个新的session与本地线程绑定
     * 当次请求之后的操作，如果再执行getCurrentSession获得的将是已经绑定到本地线程中的session   === 即一次请求中共享一个session
     * @return
     */
    public static Session getCurrentSession(){
        return factory.getCurrentSession();
    }
}

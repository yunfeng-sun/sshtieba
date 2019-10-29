<%--
  Created by IntelliJ IDEA.
  User: sunyunfeng
  Date: 2019/10/12
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--自动转发到 首页 showTopic  前面的路径为 项目名 --%>
<%
    response.sendRedirect(request.getContextPath() + "/topicAction_findAll");
%>

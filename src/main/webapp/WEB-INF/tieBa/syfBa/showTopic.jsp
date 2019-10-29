<%--
  Created by IntelliJ IDEA.
  User: sunyunfeng
  Date: 2019/10/12
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>本地贴吧</title>
</head>
<body>
<!--    简单搜索表单 -->
<div style="margin: 15px auto">
    <!--  搜索表单 -->
    <form action="TopicAction" onsubmit="alert('暂不支持该功能！');return false;">
        <font class="logolabel">syf贴吧</font>
        <input type="text" name="queryString" class="queryString"/>
        <input type="submit" value="搜索">
    </form>
</div>
<!--   菜单      -->
<div class="menu-bar">
    <a href="listTopic.jsp">返回首页</a>
</div>
<!--   当前主题贴数      -->
<div style="padding:10px 30px;font-size:12px;font-family: '宋体'">
    共有<font color="red"><s:property value="#findTopic.replySet.size() + 1"/> </font>聊帖子
</div>
<!--  显示主题   -->
<table class="postList" cellspacing="0">
    <tr class="title">
        <td width="20" class="num">1</td>
        <td><s:property value="#findTopic.title"/> </td>
    </tr>
    <tr class="content">
        <td></td>
        <td><pre><s:property value="#findTopic.topicContent"/></pre></td>
    </tr>
    <tr class="info">
        <td></td>
        <td>
            作者:<font color="blue"><s:property value="#findTopic.ipAddr"/> </font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <font color="#999999">发表时间:<s:date name="#findTopic.createTime"/> </font>
        </td>
    </tr>
</table>
<!--  显示回复列表 start  -->
<s:iterator value="@findTopic.replySet" var="reply"> <!-- 使用var 添加数据到 context map 中；注意 root栈顶也有临时的-->
<table class="postList" cellspacing="0">
    <tr class="title">
        <td width="20" class="num">2</td>
        <td></td>
    </tr>
    <tr class="content">
        <td></td>
        <td><pre><s:property value="#reply.replyContent"/></pre></td>
    </tr>
    <tr class="info">
        <td></td>
        <td>
            作者:<font color="blue"><s:property value="#reply.ipAddr"/> </font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <font color="#999999">回复时间:<s:date name="#reply.createDate"/> </font>
        </td>
    </tr>
</table>
</s:iterator>
<!--  显示回复列表 end  -->
</body>
</html>

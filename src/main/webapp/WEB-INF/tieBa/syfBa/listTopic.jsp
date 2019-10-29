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
    <div class="menu-bar"></div>
    <!--  主题列表   -->
    <table cellspacing="0">
        <tbody class="list topicList">
            <!-- 显示表头 -->
            <tr class="title">
                <td width="25">编号</td>
                <td width="50">回复</td>
                <td width="500">标题</td>
                <td width="110">作者</td>
                <td width="145">最后回复时间</td>
            </tr>
        <!--    显示topic列表  todo start   -->
            <s:iterator value="allTopic" >  <%--  将遍历的每一个topic都压入栈顶，通过javaBean的属性直接获取数据  --%>
            <tr class="data">
                <td class="num"><s:property value="id"/></td>
                <td class="num"><s:property value="replySet.size()"/></td>
                <td>
                    <!-- 通过id查topic start   -->
                    <s:a namespace="/" action="TopicAction_findById">  <!-- 传到的action  -->
                        <s:property value="title"/> <!--  显示的值  -->
                        <s:param name="id" value="id"/>  <!--todo  将id 通过valur传过去 -->
                    </s:a>
                    <!-- 通过id查topic end   -->
                </td>
                <td class="info"><s:property value="ipAddr"/></td>
                <td class="info"><s:date name="lastReplyTime" format="yyyy-MM-dd HH:mm:ss"/></td>  <%-- format 可加可不加  <s:property value="lastReplyTime"/>  使用这个时间格式 19-10-27 22:23:33.000  故改为date--%>
            </tr>
            <!--   显示topic列表 todo end -->
            </s:iterator>
            <tr>
                <td colspan="$" class="num">共有主题数<font color="red"><s:property value="allTopic.size()"/> </font> </td>
            </tr>
        </tbody>
    </table>

    <div style="margin-bottom: 15px"></div>
    <!-- 发表主题表单  -->
    <s:form action="TopicAction_save" namespace="/">
        <table class="publishArticleForm">
            <tr>
                <td>标题</td>
                <td>
                    <s:textfield cssClass="title" name="title"/>
                </td>
            </tr>
            <tr>
                <td>内 容</td>
                <td>
                    <s:textfield cssClass="topicContent" name="topicContent"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <s:submit value="发 表"/>
                </td>
            </tr>
        </table>
    </s:form>
</body>
</html>

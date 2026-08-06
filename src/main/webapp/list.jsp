<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>单词列表</title>
    <style>
        .box {
            width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="box">
    <h2>单词列表</h2>
    <c:if test="${not empty errorMsg}">
        <div style="background:#ffe0e0;color:#c00;padding:10px;border-radius:4px;margin-bottom:10px;">
            ⚠️ ${errorMsg}
        </div>
    </c:if>
    <c:if test="${empty wordList and empty errorMsg}">
        <div style="text-align:center;color:#999;padding:20px;">暂无单词，请先添加单词</div>
    </c:if>
    <table>
        <tr>
            <th>英文</th>
            <th>中文</th>
            <th>状态</th>
        </tr>
        <c:forEach items="${wordList}" var="word">
            <tr>
                <td>${word.english}</td>
                <td>${word.chinese}</td>
                <td>${word.isRemembered == 1 ? "✅已记住" : "❌未记住"}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="index.jsp" target="_top">返回菜单</a>
</div>
</body>
</html>
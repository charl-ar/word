<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>背单词</title>
    <style>
        .box {
            width: 500px;
            margin: 80px auto;
            padding: 40px;
            border: 1px solid #ccc;
            border-radius: 8px;
            text-align: center;
        }
        .word {
            font-size: 30px;
            margin: 20px 0;
            color: #1ab394;
        }
        .mean {
            font-size: 20px;
            margin: 20px 0;
            color: #666;
        }
        .hidden {
            color: transparent;
        }
        a, button {
            display: inline-block;
            padding: 8px 20px;
            background: #1ab394;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            border: none;
            cursor: pointer;
            font-size: 16px;
            margin: 5px;
        }
        .btn-no {
            background: #e74c3c;
        }
    </style>
</head>
<body>
<div class="box">
    <h2>随机单词</h2>
    <c:if test="${empty word}">
        <div class="mean">暂无单词，请先添加一些单词</div>
        <a href="addWord.jsp">去添加单词</a>
    </c:if>
    <c:if test="${not empty word}">
        <div class="word">${word.english}</div>
        <div class="mean">
            <c:choose>
                <c:when test="${showAnswer}">
                    ${word.chinese}
                </c:when>
                <c:otherwise>
                    <span class="hidden">${word.chinese}</span>
                </c:otherwise>
            </c:choose>
        </div>

        <c:if test="${!showAnswer}">
            <form action="randomWord" method="get" style="display:inline;">
                <input type="hidden" name="show" value="1">
                <button type="submit">显示答案</button>
            </form>
        </c:if>

        <c:if test="${showAnswer}">
            <form action="markWord" method="get" style="display:inline;">
                <input type="hidden" name="flag" value="yes">
                <button type="submit">✅我记住了</button>
            </form>
            <form action="markWord" method="get" style="display:inline;">
                <input type="hidden" name="flag" value="no">
                <button type="submit" class="btn-no">❌还没记住</button>
            </form>
        </c:if>

        <a href="randomWord">下一个单词</a>
    </c:if>
</div>
</body>
</html>
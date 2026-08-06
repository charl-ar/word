<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示答案</title>
    <style>
        body {
            text-align: center;
            margin-top: 50px;
            font-size: 24px;
        }
        .word {
            font-size: 36px;
            margin: 30px;
        }
        .mean {
            font-size: 32px;
            color: #2e6db7;
        }
        button {
            font-size: 20px;
            padding: 10px 20px;
            margin: 10px;
        }
    </style>
</head>
<body>

<h1>🦁答案</h1>
<%
    com.word.entity.Word w = (com.word.entity.Word) session.getAttribute("currentWord");
%>
<div class="word">
    <% out.print(w.getEnglish()); %>
</div>

<div class="mean">
    <% out.print(w.getChinese()); %>
</div>

<!-- 新增标记按钮 -->
<form action="markWord" method="get" style="display:inline-block;">
    <input type="hidden" name="flag" value="yes">
    <button type="submit">✅我记住了</button>
</form>
<form action="markWord" method="get" style="display:inline-block;">
    <input type="hidden" name="flag" value="no">
    <button type="submit">❌还没记住</button>
</form>

<br>
<form action="randomWord" method="get">
    <button type="submit">继续背下一个</button>
</form>

<a href="listWord">返回单词列表</a>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加单词</title>
    <style>
        .box {
            width: 500px;
            margin: 50px auto;
            padding: 30px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        div {
            margin: 15px 0;
        }
        label {
            display: inline-block;
            width: 80px;
            font-size: 16px;
        }
        input {
            width: 300px;
            padding: 8px;
            font-size: 15px;
        }
        button {
            padding: 8px 20px;
            background: #1ab394;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="box">
    <h2>添加新单词</h2>
    <c:if test="${not empty errorMsg}">
        <div style="background:#ffe0e0;color:#c00;padding:10px;border-radius:4px;margin-bottom:10px;text-align:left;">
            ⚠️ ${errorMsg}
        </div>
    </c:if>
    <form action="addWord" method="post">
        <div>
            <label>英文：</label>
            <input type="text" name="english" required>
        </div>
        <div>
            <label>中文：</label>
            <input type="text" name="chinese" required>
        </div>
        <div style="text-align: center;">
            <button type="submit">保存单词</button>
        </div>
    </form>
</div>
</body>
</html>
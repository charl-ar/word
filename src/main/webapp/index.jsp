<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>背单词系统</title>
  <style>
    /* 简单布局：左200px，右边占满 */
    body {
      display: flex;
      margin: 0;
      padding: 0;
      height: 100vh;
    }
    .left {
      width: 200px;
      background: #f5f5f5;
      padding: 20px;
      border-right: 1px solid #ccc;
    }
    .right {
      flex: 1;
    }
    iframe {
      width: 100%;
      height: 100%;
      border: none;
    }
    a {
      display: block;
      margin: 10px 0;
      font-size: 16px;
      text-decoration: none;
      color: #333;
    }
  </style>
</head>
<body>

<!-- 左侧菜单 -->
<div class="left">
  <h3>单词菜单</h3>
  <!-- target 指向右边 iframe 的 name -->
  <a href="${pageContext.request.contextPath}/addWord.jsp" target="main">➕ 添加单词</a>
  <a href="${pageContext.request.contextPath}/ListWord" target="main">📖 查看所有单词</a>
  <a href="${pageContext.request.contextPath}/randomWord" target="main">随机背单词</a>
</div>

<!-- 右侧内容区域 -->
<div class="right">
  <iframe name="main" src="about:blank"></iframe>
</div>

</body>
</html>
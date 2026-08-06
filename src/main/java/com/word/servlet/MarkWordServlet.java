package com.word.servlet;

import com.word.dao.WordDao;
import com.word.entity.Word;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/markWord")
public class MarkWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Word currentWord = (Word) session.getAttribute("currentWord");
        if(currentWord == null){
            response.sendRedirect("randomWord");
            return;
        }
        // 获取按钮传过来的标记 1记住 /0没记住
        String flag = request.getParameter("flag");
        WordDao dao = new WordDao();
        if("yes".equals(flag)){
            dao.updateRemember(currentWord.getId(),1);
        }else if("no".equals(flag)){
            dao.updateRemember(currentWord.getId(),0);
        }
        //标记完成，跳下一个单词
        response.sendRedirect("randomWord");
    }
}
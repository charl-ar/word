package com.word.servlet;

import com.word.dao.WordDao;
import com.word.entity.Word;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addWord")
public class AddWordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String english = request.getParameter("english");
        String chinese = request.getParameter("chinese");

        Word word = new Word(english, chinese);
        WordDao dao = new WordDao();
        boolean success = dao.AddWord(word);

        if (success) {
            response.sendRedirect("ListWord");
        } else {
            request.setAttribute("errorMsg", dao.getErrorMsg() != null ? dao.getErrorMsg() : "添加单词失败");
            request.getRequestDispatcher("/addWord.jsp").forward(request, response);
        }
    }
}
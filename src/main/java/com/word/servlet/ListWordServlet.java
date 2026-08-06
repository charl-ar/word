package com.word.servlet;

import com.word.dao.WordDao;
import com.word.entity.Word;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListWord")
public class ListWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WordDao dao = new WordDao();
        List<Word> list = dao.findAll();
        System.out.println("查询到的单词数量：" + list.size());
        if (dao.getErrorMsg() != null) {
            request.setAttribute("errorMsg", dao.getErrorMsg());
        }
        request.setAttribute("wordList", list);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
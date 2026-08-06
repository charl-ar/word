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
import java.util.List;
import java.util.Random;

@WebServlet("/randomWord")
public class RandomWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WordDao dao = new WordDao();
        List<Word> wordList = dao.findAll();

        if (wordList == null || wordList.isEmpty()) {
            response.sendRedirect("addWord.jsp");
            return;
        }

        HttpSession session = request.getSession();
        String showParam = request.getParameter("show");
        Word word;

        if ("1".equals(showParam) && session.getAttribute("currentWord") != null) {
            word = (Word) session.getAttribute("currentWord");
            request.setAttribute("showAnswer", true);
        } else {
            Random random = new Random();
            int idx = random.nextInt(wordList.size());
            word = wordList.get(idx);
            session.setAttribute("currentWord", word);
            request.setAttribute("showAnswer", false);
        }

        request.setAttribute("word", word);
        request.getRequestDispatcher("study.jsp").forward(request, response);
    }
}
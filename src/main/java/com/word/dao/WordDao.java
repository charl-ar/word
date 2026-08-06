package com.word.dao;

import com.word.entity.Word;
import com.word.util.wordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WordDao {

    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    // 添加单词
    public boolean AddWord(Word word) {
        errorMsg = null;
        Connection conn = wordUtil.getConnection();
        if (conn == null) {
            errorMsg = "数据库连接失败！请检查MySQL是否启动，以及数据库配置是否正确。";
            return false;
        }
        String sql = "INSERT INTO word(english, chinese) VALUES (?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, word.getEnglish());
            pstmt.setString(2, word.getChinese());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            errorMsg = "添加单词失败：" + e.getMessage();
            e.printStackTrace();
            return false;
        } finally {
            wordUtil.close(conn);
        }
    }

    // 查询所有单词
    public List<Word> findAll() {
        errorMsg = null;
        List<Word> list = new ArrayList<>();
        Connection conn = wordUtil.getConnection();
        if (conn == null) {
            errorMsg = "数据库连接失败！请检查MySQL是否启动，以及数据库配置是否正确。";
            return list;
        }
        String sql = "SELECT * FROM word";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Word w = new Word();
                w.setId(rs.getInt("id"));
                w.setEnglish(rs.getString("english"));
                w.setChinese(rs.getString("chinese"));
                w.setIsRemembered(rs.getInt("is_remembered"));
                list.add(w);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            errorMsg = "查询单词失败：" + e.getMessage();
            e.printStackTrace();
        } finally {
            wordUtil.close(conn);
        }
        return list;
    }
    // 根据id查询单个单词
    public Word findById(Integer id){
        Connection conn = wordUtil.getConnection();
        Word word = null;
        String sql = "SELECT * FROM word WHERE id = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                word = new Word();
                word.setId(rs.getInt("id"));
                word.setEnglish(rs.getString("english"));
                word.setChinese(rs.getString("chinese"));
                word.setIsRemembered(rs.getInt("is_remembered"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            wordUtil.close(conn);
        }
        return word;
    }

    // 修改记住状态：0未记住，1已记住
    public boolean updateRemember(Integer id,int isRemembered){
        Connection conn = wordUtil.getConnection();
        String sql = "UPDATE word SET is_remembered=? WHERE id=?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,isRemembered);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            wordUtil.close(conn);
        }
    }
}
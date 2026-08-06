package com.word.entity;

public class Word {
    private Integer id;
    private String english;
    private String chinese;
    private Integer isRemembered;

    // 空构造
    public Word() {}

    // 带参构造
    public Word(String english, String chinese) {
        this.english = english;
        this.chinese = chinese;
        this.isRemembered = 0;
    }

    // getter 和 setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEnglish() { return english; }
    public void setEnglish(String english) { this.english = english; }

    public String getChinese() { return chinese; }
    public void setChinese(String chinese) { this.chinese = chinese; }

    public Integer getIsRemembered() { return isRemembered; }
    public void setIsRemembered(Integer isRemembered) { this.isRemembered = isRemembered; }
}
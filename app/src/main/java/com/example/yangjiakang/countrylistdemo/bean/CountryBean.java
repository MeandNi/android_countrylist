package com.example.yangjiakang.countrylistdemo.bean;

/**
 * Created by yangjiakang on 2018/12/2.
 */

public class CountryBean {
    private String abbr;
    private String chinese;
    private String code;
    private String english;
    private String spell;

    public CountryBean() {
    }

    public String getChinese() {
        return this.chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEnglish() {
        return this.english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getSpell() {
        return this.spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }
}

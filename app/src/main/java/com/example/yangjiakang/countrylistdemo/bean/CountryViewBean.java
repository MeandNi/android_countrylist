package com.example.yangjiakang.countrylistdemo.bean;

import com.example.yangjiakang.countrylistdemo.utils.contact.ContactItemInterface;

public class CountryViewBean implements ContactItemInterface {

    private String countryName;
    private String key;
    private String number;
    private String pinyin;

    public CountryViewBean(String key, String countryName, String number, String pinyin) {
        super();
        this.countryName = countryName;
        this.key = key;
        this.number = number;
        this.pinyin = pinyin;
    }

    // index the list by nickname
    @Override
    public String getItemForIndex() {
        return countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}

package com.example.yangjiakang.countrylistdemo.utils;

import android.os.Message;

/**
 * Created by lee on 16/5/12.
 */
public class MessageUtil {

    public static Message getCallFailMessage(int msgWhat){
        Message msg = new Message();
        msg.what = msgWhat;
        return msg;
    }


    public static Message getMessage(int msgWhat, Object msgObj){
        Message msg = new Message();
        msg.what = msgWhat;
        msg.obj = msgObj;
        return msg;
    }

    public static Message getResultMessage(int msgWhat){
        Message msg = new Message();
        msg.what = msgWhat;
        return msg;
    }
}

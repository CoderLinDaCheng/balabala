package com.github.coderlindacheng.balabala;

import org.apache.commons.lang3.text.StrBuilder;

/**
 * Created by lindacheng on 16/8/30.
 */
public class StrBuilderUtil{

    public static StrBuilder newBuilder(){
        return new StrBuilder();
    }

    public static <T> String toString(T... array){
        return appendAll(array).toString();
    }

    public static <T> StrBuilder appendAll(T... array){
        return new StrBuilder().setNullText("NULL").appendAll(array);
    }
}

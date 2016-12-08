package com.github.coderlindacheng.balabala.common;

import com.github.coderlindacheng.balabala.StrBuilderUtil;

/**
 * Created by lindacheng on 16/7/14.
 */
public abstract class AbstractCommon {

    protected String readerbaleCaller(Object caller) {
        return caller == null ? "unkonw caller" : caller.toString();
    }

    protected String errMsg(String msg) {
        return StrBuilderUtil.toString(this, " --- ", msg);
    }
}

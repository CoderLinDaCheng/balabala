package com.github.coderlindacheng.balabala;

import com.github.coderlindacheng.balabala.common.AbstractCommon;

import java.util.List;

/**
 * Created by lindacheng on 16/7/14.
 *
 * a list wrapper.
 *
 * with this wrapper , you can take the element of target list one by one.
 */
public class ListOneByOneTaker<T> extends AbstractCommon {

    private final List<T> list;
    private final int size;
    private int index;

    private ListOneByOneTaker(Object caller, List<T> list) {
        this(list);
        ValidityChecker.checkNotNullWithCallerInfo(readerbaleCaller(caller),
                list, errMsg("null list"));
    }

    private ListOneByOneTaker(List<T> list) {
        this.list = list;
        this.size = list.size();
    }

    public static <T> ListOneByOneTaker<T> checkedGenerate(Object caller,
                                                           List<T> list) {
        return new ListOneByOneTaker<>(caller, list);
    }

    public static <T> ListOneByOneTaker<T> checkedGenerate(List<T> list) {
        return new ListOneByOneTaker<>(null, list);
    }

    public static <T> ListOneByOneTaker<T> uncheckedGenerate(List<T> list) {
        return new ListOneByOneTaker<>(list);
    }

    public T take() {
        return this.index < this.size ? this.list.get(this.index++) : null;
    }

    public boolean hasNext() {
        return this.index < this.size;
    }

    @Override
    public String toString() {
        return "com.github.coderlindacheng.balabala.ListOneByOneTaker";
    }
}

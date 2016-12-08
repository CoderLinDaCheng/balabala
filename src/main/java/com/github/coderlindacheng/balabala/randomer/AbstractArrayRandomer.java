package com.github.coderlindacheng.balabala.randomer;

import com.github.coderlindacheng.balabala.ValidityChecker;
import com.github.coderlindacheng.balabala.common.AbstractCommon;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by lindacheng on 16/8/30.
 */
abstract class AbstractArrayRandomer<T> extends AbstractCommon {
    T[] array;

    protected int size;

    protected AbstractArrayRandomer(Object caller, T[] array){
        this(array);
        ValidityChecker.checkNotEmptyWithCallerInfo(readerbaleCaller(caller),
                array, errMsg("array is empty"));
    }

    protected AbstractArrayRandomer(T[] array){
        this.array = array;
        size = array.length;
    }

    public T next(){
        if (!hasNext()){
            return null;
        }
        int index = ThreadLocalRandom.current().nextInt(size);
        size--;
        T t = array[index];
        array[index] = array[size];
        return t;
    }

    public boolean hasNext(){
        return size > 0;
    }
}

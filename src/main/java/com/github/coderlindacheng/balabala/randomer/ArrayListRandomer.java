package com.github.coderlindacheng.balabala.randomer;

import java.util.ArrayList;

/**
 * Created by lindacheng on 16/8/15.
 *
 * 随机不从复的获取一个列表的内容
 *
 * 为了追求效率,这里只用 ArrayList
 *
 * 这个算法主要靠list内的元素hashcode去产生随机数,所以如果list内元素的hashcode散列度不够的话,会直接影响随机数的散列度,慎用
 */
public class ArrayListRandomer<T> extends AbstractArrayRandomer<T> {

    private ArrayListRandomer(Object caller, ArrayList<T> arrayList) {
        super(caller, (T[]) arrayList.toArray(new Object[]{}));
    }

    private ArrayListRandomer(ArrayList<T> arrayList) {
        super((T[]) arrayList.toArray(new Object[]{}));
    }

    public static <T> ArrayListRandomer<T> checkedGenerate(Object caller,
                                                           ArrayList<T> list) {
        return new ArrayListRandomer<>(caller, list);
    }

    public static <T> ArrayListRandomer<T> checkedGenerate(ArrayList<T> list) {
        return new ArrayListRandomer<>(null, list);
    }

    public static <T> ArrayListRandomer<T> uncheckedGenerate(ArrayList<T> list) {
        return new ArrayListRandomer<>(list);
    }

    @Override
    public String toString() {
        return "app.utils.ldc.ArrayListRandomer";
    }

}

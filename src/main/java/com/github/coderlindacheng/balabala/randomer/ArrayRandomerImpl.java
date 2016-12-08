package com.github.coderlindacheng.balabala.randomer;

/**
 * Created by lindacheng on 16/8/30.
 */
public class ArrayRandomerImpl<T> extends AbstractArrayRandomer<T> {

    private ArrayRandomerImpl(T[] array) {
        super(array);
    }

    private ArrayRandomerImpl(Object caller, T[] array) {
        super(caller, array);
    }

    public static <T> ArrayRandomerImpl<T> checkedGenerate(Object caller,
                                                           T[] array) {
        return new ArrayRandomerImpl<>(caller, array);
    }

    public static <T> ArrayRandomerImpl<T> checkedGenerate(T[] array) {
        return new ArrayRandomerImpl<>(null, array);
    }

    public static <T> ArrayRandomerImpl<T> uncheckedGenerate(T[] array) {
        return new ArrayRandomerImpl<>(array);
    }

    @Override
    public String toString() {
        return "app.utils.ldc.ArrayRandomerImpl";
    }
}

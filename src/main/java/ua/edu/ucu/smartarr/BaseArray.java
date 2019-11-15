package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] arr;

    public BaseArray(Object[] arr) {
        this.arr = arr;
    }

    @Override
    public Object[] toArray() {
        Object[] newarr = new Object[size()];
        int newSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                newarr[newSize] = arr[i];
                newSize += 1;
            }
        }
        arr = Arrays.copyOf(newarr, newSize);
        return arr;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {

        int realSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                realSize += 1;
            }
        }

        return realSize;
    }
}

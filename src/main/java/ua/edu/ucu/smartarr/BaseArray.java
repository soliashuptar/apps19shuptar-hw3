package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] objects;

    public BaseArray(Object[] arr) {
        this.objects = arr;
    }

    @Override
    public Object[] toArray() {
        Object[] newarr = new Object[size()];
        int newSize = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                newarr[newSize] = objects[i];
                newSize += 1;
            }
        }
        objects = Arrays.copyOf(newarr, newSize);
        return objects;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {

        int realSize = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                realSize += 1;
            }
        }

        return realSize;
    }

    public void setValue(int index) {
        objects[index] = 0;

    }
}

package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
        applyfunc();
    }

    private void applyfunc() {
        Object[] newArr = toArray();
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = func.apply(newArr[i]);
        }
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Applies function to every element in array";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}

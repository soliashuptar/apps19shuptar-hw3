package ua.edu.ucu.smartarr;

import ua.edu.ucu.Student;
import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;
import java.util.stream.Stream;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
//        Object[] newArr = toArray();
        Stream<Object> arrayStream = Arrays.stream(smartArray.toArray());
        Object[] array = arrayStream.map(
                obj -> func.apply(obj)
        ).toArray();

        return Arrays.copyOf(array, array.length);
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

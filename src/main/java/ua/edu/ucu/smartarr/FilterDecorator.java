package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;
import java.util.stream.Stream;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate pr;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.pr = pr;
    }

    @Override
    public Object[] toArray() {
        Stream<Object> arrayStream = Arrays.stream(smartArray.toArray());
        Object[] array = arrayStream.filter(obj -> pr.test(obj)).toArray();
        System.out.println(Arrays.toString(array));

        return Arrays.copyOf(array, array.length);
    }

    @Override
    public String operationDescription() {
        return "Filters array with given predicate";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}

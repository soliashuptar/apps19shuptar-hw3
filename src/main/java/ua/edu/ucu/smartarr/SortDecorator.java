package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;
import java.util.stream.Stream;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private MyComparator cmp;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.cmp = cmp;
    }


    @Override
    public Object[] toArray() {

        Stream<Object> arrayStream = Arrays.stream(smartArray.toArray());
        Object[] array = arrayStream.sorted(cmp
        ).toArray();

        return Arrays.copyOf(array, array.length);
    }

    @Override
    public String operationDescription() {
        return "Sorts array by key (cmp)";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}

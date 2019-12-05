package ua.edu.ucu.smartarr;

import ua.edu.ucu.Student;

import java.util.Arrays;
import java.util.stream.Stream;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
//        removeDuplicates();

    }

//    private void removeDuplicates() {
//        Object[] newArr = smartArray.toArray();
//
//        for (int i = 0; i < newArr.length; i++) {
//            for (int j = i + 1; j < newArr.length; j++) {
//                try {
//                    if (newArr[i].equals(newArr[j])) {
//                        newArr[j] = null;
//                    }
//                } catch (NullPointerException ignored) {
//                    System.out.println("NullPointerException caught");
//
//                }
//            }
//        }
//    }


    @Override
    public Object[] toArray() {
        Stream<Object> arrayStream = Arrays.stream(smartArray.toArray());
        Object[] array = arrayStream.distinct().toArray();

        return Arrays.copyOf(array, array.length);

    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator removes duplicates from smart array";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}

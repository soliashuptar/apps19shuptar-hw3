package ua.edu.ucu.smartarr;

import ua.edu.ucu.Student;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    private final double ALPHA = 0.0000001;


    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        removeDuplicates();

    }

    private void removeDuplicates() {
        Object[] newArr = smartArray.toArray();

        for (int i = 0; i < newArr.length; i++) {
            for (int j = i + 1; j < newArr.length; j++) {
                try {
                    if (equals(newArr[i], newArr[j])) {
                        newArr[j] = null;
                    }
                } catch (NullPointerException ignored) {
                    System.out.println("NullPointerException caught");

                }
            }
        }
    }

    private boolean equals(Object ob1, Object ob2) {
        if (ob1 instanceof Student && ob2 instanceof Student) {
            return ((Student) ob1).getName().equals(((Student) ob2).getName())
                    &&
                    ((Student) ob1).getSurname().equals((
                            (Student) ob2).getSurname())
                    &&
                    ((Student) ob1).getGPA() - (((Student) ob2).getGPA())
                            < ALPHA
                    &&
                    ((Student) ob1).getYear() == (((Student) ob2).getYear());
        } else {
            return ob1.equals(ob2);
        }
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
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

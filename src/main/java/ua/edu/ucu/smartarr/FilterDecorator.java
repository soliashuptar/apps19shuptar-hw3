package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate pr;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.pr = pr;
        filter();
    }

    private void filter() {
        Object[] newArr = toArray();
        for (int i = 0; i < newArr.length; i++) {
            if (!pr.test(newArr[i])) {
//                System.out.println(newArr[i]);
                newArr[i] = null;
            }
        }
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
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

package ua.edu.ucu;


public class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }

    @Override
    public boolean equals(Object ob2) {
        double ALPHA = 0.0000001;
        if (ob2 instanceof Student ) {
            return (this).getName().equals(((Student) ob2).getName())
                    &&
                    (this).getSurname().equals((
                            (Student) ob2).getSurname())
                    &&
                    (this).getGPA() - (((Student) ob2).getGPA())
                            < ALPHA
                    &&
                    (this).getYear() == (((Student) ob2).getYear());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) ((this.getYear() + (int) this.getGPA()) * 5.3357);
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname +
                ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

}

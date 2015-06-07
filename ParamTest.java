/**
 * Created by Magy on 2015/6/7.
 * desc: This program demonstrates parameter passing in Java
 */
public class ParamTest {
    private static final String TAG = "ParamTest";

    public static void main(String[] args) {
        /*
         *Test 1£ºMethods can't modify numeric parameters
         */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before : percent = " + percent);
        tripleValue(percent);
        System.out.println("After: percent = " + percent);

        /*
        Test2: Method can change the state of object parameter
         */
        System.out.println("\nTESTING tripleSalary: ");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before: Harry.salary  = " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: Harry.salary = " + harry.getSalary());


        /*
        Test3: Method can't attach new objects to object parameters
         */
        System.out.println("\n Testing swap: ");
        Employee a = new Employee("Alice", 50000);
        Employee b = new Employee("BOb", 40000);
        System.out.println("Before: Alice.salary = " + a.getSalary());
        System.out.println("Before: Bob.salary = " + b.getSalary());
        swap(a, b);
        System.out.println("After: Alice.salary = " + a.getSalary());
        System.out.println("After: Bob.salary = " + b.getSalary());
    }


    //dosn't work
    public static void tripleValue(double x){
        x *= 3;
        System.out.println("End of method: x = " + x);
    }

    public static void tripleSalary(Employee emp){
        emp.raiseSalary(200);
        System.out.println("End of method: salary = " + emp.getSalary());
    }

    public static void swap (Employee emp1, Employee emp2){
        Employee tempEmp = emp1;
        emp1 = emp2;
        emp2 = tempEmp;
        System.out.println("End of method: emp1 = " + emp1.getSalary());
        System.out.println("End of method: emp2 = " + emp2.getSalary());
    }
}

//simplified Employee class
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
package Model;

import java.util.ArrayList;

public class EmployeeContainer {
    private final ArrayList<Employee> employees;
    private static EmployeeContainer instance;

    private EmployeeContainer(){
        employees = new ArrayList<Employee>();
    }

    // singleton
    public static EmployeeContainer getInstance(){
        if(instance ==null)
            instance = new EmployeeContainer();
        return instance;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }


}

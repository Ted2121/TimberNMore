package Controller;

import Model.Employee;
import Model.EmployeeContainer;

import java.util.ArrayList;

public class EmployeeController {
    private EmployeeContainer employeeContainer;

    public EmployeeController() {employeeContainer = EmployeeContainer.getInstance();}

    public void addEmployee(Employee employee){
        employeeContainer.addEmployee(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employeeContainer.getEmployees();
    }

}

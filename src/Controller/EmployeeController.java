package Controller;

import Model.Employee;
import Model.EmployeeContainer;

public class EmployeeController {
    private EmployeeContainer employeeContainer;

    public EmployeeController() {employeeContainer = EmployeeContainer.getInstance();}

    public void addEmployee(Employee employee){
        employeeContainer.addEmployee(employee);
    }

}

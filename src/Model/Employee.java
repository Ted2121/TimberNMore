package Model;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Locale;

public class Employee {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int accessType;

    private BigDecimal turnover;
    private String jobPosition;

    public Employee(String firstName, String lastName, String jobPosition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobPosition = jobPosition;
        this.accessType = switch (jobPosition.toLowerCase()){
            case "manager" -> 1;
            case "accountant" -> 2;
            case "sales assistant" -> 3;
            default -> 4;
        };
        this.username = accessType + firstName + lastName;
        this.password = firstName + lastName + "123";

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccessType() {
        return accessType;
    }

    public void setAccessType(int accessType) {
        this.accessType = accessType;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accessType=" + accessType +
                ", turnover=" + turnover +
                ", jobPosition='" + jobPosition + '\'' +
                '}';
    }
}

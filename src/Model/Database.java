package Model;

import java.math.BigDecimal;

public class Database {


    Item item1 = new Item('T', 11, "Hammer", true, new BigDecimal("50.0"));
    Item item2 = new Item('D', 12, "Nails", false, new BigDecimal("20.0"));
    Item item3 = new Item('T', 13, "Bolts", false, new BigDecimal("15.0"));
    Item item4 = new Item('D', 14, "Chair", true, new BigDecimal("10.0"));
    Item item5 = new Item('T', 15, "Table", true, new BigDecimal("200.0"));

public Item getItem(Item item){
    return item;
}

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public Item getItem2() {
        return item2;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public Item getItem3() {
        return item3;
    }

    public void setItem3(Item item3) {
        this.item3 = item3;
    }

    public Item getItem4() {
        return item4;
    }

    public void setItem4(Item item4) {
        this.item4 = item4;
    }

    public Item getItem5() {
        return item5;
    }

    public void setItem5(Item item5) {
        this.item5 = item5;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }

    public Employee getEmployee3() {
        return employee3;
    }

    public void setEmployee3(Employee employee3) {
        this.employee3 = employee3;
    }

    public Employee getEmployee4() {
        return employee4;
    }

    public void setEmployee4(Employee employee4) {
        this.employee4 = employee4;
    }

    public Employee getEmployee5() {
        return employee5;
    }

    public void setEmployee5(Employee employee5) {
        this.employee5 = employee5;
    }

    Employee employee1 = new Employee("Bob", "Dylan", "sales assistant");
    Employee employee2 = new Employee("Anders", "Olesen", "manager");
    Employee employee3 = new Employee("Casper", "Olesen", "manager");
    Employee employee4 = new Employee("Joey", "Joes", "accountant");
    Employee employee5 = new Employee("Secondbob", "Notdylan", "sales assistant");
}

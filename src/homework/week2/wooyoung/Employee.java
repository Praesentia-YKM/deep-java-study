package homework.week2.wooyoung;

public class Employee {
    protected String id;
    protected String name;
    protected String position;
    protected int salary;
    protected String acnNo;

    public Employee(String id, String name, String position, int salary, String acnNo) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.acnNo = acnNo;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary + ", acnNo="
                + acnNo + "]";
    }
}

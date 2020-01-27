package equals;

import abstractClasses.Person;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee extends Person
{
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary, int year, int month, int day)
    {
        super(name);
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public String getName()
    {
        return super.getName();
    }

    public double getSalary()
    {
        return salary;
    }

    public Date getHireDay()
    {
        return hireDay;
    }

    public String getDescription()
    {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        // a quick test to see if the objects are identical
        if (this == otherObject) return true;

        // must return false if the explicit parameter is null
        if (otherObject == null) return false;

        // if the classes don't match, then can't be equal
        if (getClass() != otherObject.getClass()) return false;

        // now we know otherObjects is a non-null Employee
        Employee other = (Employee) otherObject;

        // test whether the fields have identical values
        return Objects.equals(this.getName(), other.getName()) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
    }

    // 重写hashCode(): 散列码由name，salary，hireDay导出
    public int hashCode()
    {
        return Objects.hash(this.getName(), salary, hireDay);
    }

    public String toString()
    {
        return getClass().getName() + "[name = " + this.getName() + ", salary = " + salary + ", hireDay" + hireDay + "]";
    }

}

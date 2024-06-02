import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee name: "+name+ " id= "+id+ ",salary: "+calculateSalary();
    }

}

class FullTimeEmployee extends Employee{

    private double monthlySalary;

   public FullTimeEmployee(String name,int id,double monthlySalary){
       super(name,id);
       this.monthlySalary=monthlySalary;
   }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked,double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return hoursWorked*hourlyRate;
    }
}

class PayroleSystem{
    private List<Employee> employeelist;

    public PayroleSystem(){
        employeelist = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeelist.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee: employeelist){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeelist.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for (Employee employee:employeelist){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayroleSystem payroleSystem = new PayroleSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("vikas",1,70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Alexander",2, 40,100);

        payroleSystem.addEmployee(emp1);
        payroleSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details");
        payroleSystem.displayEmployee();

        System.out.println("Removing Employees");
        payroleSystem.removeEmployee(2);

        System.out.println("Remaining Employee Details");
        payroleSystem.displayEmployee();

    }
}
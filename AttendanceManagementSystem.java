import java.util.*;

// Class to represent each employee
class Employee 
{
    private String name;
    private int id;
    private boolean presentToday;

    public Employee(String name, int id) 
    {
        this.name = name;
        this.id = id;
        this.presentToday = false; // Assuming no one is present initially
    }

    public String getName() 
    {
        return name;
    }

    public int getId() 
    {
        return id;
    }

    public boolean isPresentToday()
    {
        return presentToday;
    }

    public void markPresent()
    {
        this.presentToday = true;
    }

    public void markAbsent()
    {
        this.presentToday = false;
    }
}

// Main attendance management system class
public class AttendanceManagementSystem 
{
    private List<Employee> employees;

    public AttendanceManagementSystem()
    {
        this.employees = new ArrayList<>();
    }

    // Method to add new employees
    public void addEmployee(String name, int id)
    {
        Employee newEmployee = new Employee(name, id);
        employees.add(newEmployee);
    }

    // Method to mark an employee present based on ID
    public void markEmployeePresent(int id) 
    {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.markPresent();
                System.out.println(emp.getName() + " marked as present.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // Method to mark an employee absent based on ID
    public void markEmployeeAbsent(int id) 
    {
        for (Employee emp : employees) 
        {
            if (emp.getId() == id) 
            {
                emp.markAbsent();
                System.out.println(emp.getName() + " marked as absent.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // Method to print attendance status for all employees
    public void printAttendance() 
    {
        System.out.println("Attendance for Today:");
        for (Employee emp : employees) 
        {
            System.out.println(emp.getName() + ": " + (emp.isPresentToday() ? "Present" : "Absent"));
        }
    }

    // Main method to test the system
    public static void main(String[] args) 
    {
        AttendanceManagementSystem ams = new AttendanceManagementSystem();

        // Adding employees
        ams.addEmployee("Dikshat Goyal", 1001);
        ams.addEmployee("Akash Garg", 1002);
        ams.addEmployee("Binod Yadav", 1003);

        // Marking employees present or absent
        ams.markEmployeePresent(1001);
        ams.markEmployeeAbsent(1002);
        ams.markEmployeeAbsent(1003);

        // Printing final attendance
        ams.printAttendance();
    }
}

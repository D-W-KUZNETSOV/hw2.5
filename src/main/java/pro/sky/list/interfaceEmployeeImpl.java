package pro.sky.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import pro.sky.list.exeption.EmployeeAlreadyAddedException;
import pro.sky.list.exeption.EmployeeNotFoundException;
import pro.sky.list.exeption.EmployeeStorageIsFullException;

@Service
public class interfaceEmployeeImpl implements EmployeeService {

  private static final int MAX_EMPLOYEE = 10;
  private final List<Employee> employees = new ArrayList<>(
        List.of(

            new Employee("Иван", "Иванов", 1, 14000),

            new Employee("Семён", "Фёдоров", 2, 10000),

            new Employee("Василий", "Степанов", 3, 25000),

            new Employee("Николай", "Афанасьев", 4, 11000),

            new Employee("Владислав", "Киселёв", 3, 44000),

            new Employee("Антон", "Сергеев", 2, 3000)
        ));



  public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
    Employee employee = new Employee(firstName, lastName, departmentId, salary);
    if (employees.size() >= MAX_EMPLOYEE) {
      throw new EmployeeStorageIsFullException();
    } else if (employees.contains(employee)) {
      throw new EmployeeAlreadyAddedException();
    }
    employees.add(employee);
    return employee;
  }


  public boolean removeEmployee(String firstName, String lastName) {
     {
      return employees.removeIf(employee -> employee.getFirstName().equals(firstName)&&employee.getLastName().equals(lastName));
    }
  }



  public Employee findEmployee(String firstName, String lastName) {
    return employees.stream()
        .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
        .findFirst()
        .orElseThrow(EmployeeNotFoundException::new);
  }

  public Collection<Employee> findAll() {
    return employees;
  }
}



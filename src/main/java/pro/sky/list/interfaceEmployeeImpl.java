package pro.sky.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import pro.sky.list.exeption.EmployeeAlreadyAddException;
import pro.sky.list.exeption.EmployeeNotFoundException;

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


  @Override
  public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
    Employee employee = new Employee(firstName, lastName, departmentId, salary);
    if (employees.size() >= MAX_EMPLOYEE) {
      throw new EmployeeNotFoundException();
    } else {
      if (employees.contains(employee.getFullName())) {
      } else {
        throw new EmployeeAlreadyAddException();
      }
    }
    employees.add(employee);
    return employee;
  }


  @Override
  public String removeEmployee(String firstName, String lastName) {
    boolean removed = employees.removeIf(
        employee -> employee.getFullName().equals(employee.getFullName()));
    if (removed) {
      return "Сотрудник " + firstName + " " + lastName + " удалён";
    } else {
      throw new EmployeeNotFoundException();
    }
  }

  @Override
  public Employee findeEmployee(String firstName, String lastName) {
    return employees.stream()
        .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
        .findFirst()
        .orElseThrow(() -> new EmployeeNotFoundException());
  }

  @Override
  public Collection<Employee> findAll() {
    return employees;
  }
}


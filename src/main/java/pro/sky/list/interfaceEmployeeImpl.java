package pro.sky.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import pro.sky.list.exeption.EmployeeAlreadyAddException;
import pro.sky.list.exeption.EmployeeNotFoundException;

@Service
public class interfaceEmployeeImpl implements EmployeeService {

  private final List<Employee>employeeList;

  public interfaceEmployeeImpl() {
    this.employeeList = new ArrayList<>();
  }

  @Override
  public Employee add(String firstName, String lastName) {
    Employee employee = new Employee(firstName, lastName);
    if (employeeList.contains(employee)) {
      throw new EmployeeAlreadyAddException();
    }
    employeeList.add(employee);
    return employee;
  }

  @Override
  public Employee remowe(String firstName, String lastName) {
    Employee employee = new Employee(firstName, lastName);
    if (employeeList.contains(employee)) {
      employeeList.remove(employee);
    }
    throw new EmployeeNotFoundException();
  }

  @Override
  public Employee finde(String firstName, String lastName) {
    Employee employee = new Employee(firstName, lastName);
    if (employeeList.contains(employee)) {
      return employee;
    }
    throw new EmployeeNotFoundException();
  }

  @Override
  public Collection<Employee> findAll() {
    return Collections.unmodifiableList(employeeList);
  }
}

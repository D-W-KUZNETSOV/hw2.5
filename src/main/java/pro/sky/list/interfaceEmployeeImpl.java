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
private final Map<String,Employee>employees;



  public interfaceEmployeeImpl(Map<String, Employee> employees) {
    this.employees = new HashMap<>();

  }



  @Override
  public Employee add(String firstName, String lastName) {
    Employee employee = new Employee(firstName, lastName);
    if (employees.containsKey(employee.getFullName())) {
      throw new EmployeeAlreadyAddException();
    }
    employees.put(employee.getFullName(),employee);
    return employee;
  }

  @Override
  public Employee remowe(String firstName, String lastName) {
    Employee employee = new Employee(firstName, lastName);
    if (employees.containsKey(employee.getFullName())) {
      return employees.remove(employee.getFullName());
    }
    throw new EmployeeNotFoundException();
  }

  @Override
  public Employee finde(String firstName, String lastName) {
    Employee employee = new Employee(firstName, lastName);
    if (employees.containsKey(employee.getFullName())) {
      return employees.get(employee.getFullName());
    }
    throw new EmployeeNotFoundException();
  }

  @Override
  public Collection<Employee> findAll() {
    return Collections.unmodifiableCollection(employees.values());
  }
}

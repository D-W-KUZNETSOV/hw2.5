package pro.sky.list;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

  private final interfaceEmployeeImpl interfaceEmployee;


  public DepartmentService(interfaceEmployeeImpl interfaceEmployee) {
    this.interfaceEmployee = interfaceEmployee;
  }


  public Employee getMaxSalary(int departmentId) {
    return interfaceEmployee.findAll()
        .stream()
        .filter(employee -> departmentId == employee.getDepartmentId())
        .max(Comparator.comparingInt(Employee::getSalary))
        .orElse(null);
  }

  public Employee getMinSalary(int departmentId) {
    return interfaceEmployee.findAll()
        .stream()
        .filter(employee -> departmentId == employee.getDepartmentId())
        .min(Comparator.comparingInt(Employee::getSalary))
        .orElse(null);
  }

  public List<Employee> getByDepartment(int departmentId) {
    return interfaceEmployee.findAll()
        .stream()
        .filter(employee -> departmentId == employee.getDepartmentId())
        .toList();
  }

  public Map<Integer, List<Employee>> groupByDepartment() {
    return interfaceEmployee.findAll()
        .stream()
        .collect(Collectors.groupingBy(Employee::getDepartmentId));
  }
}

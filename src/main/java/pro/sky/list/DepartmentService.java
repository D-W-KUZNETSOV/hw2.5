package pro.sky.list;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

  private final EmployeeService service;


  public DepartmentService(EmployeeService service) {
    this.service = service;
  }


  public Employee getMaxSalary(int departmentId) {
    return service.findAll()
        .stream()
        .filter(employee -> departmentId == employee.getDepartmentId())
        .max(Comparator.comparingInt(Employee::getSalary))
        .orElse(null);
  }

  public Employee getMinSalary(int departmentId) {
    return service.findAll()
        .stream()
        .filter(employee -> departmentId == employee.getDepartmentId())
        .min(Comparator.comparingInt(Employee::getSalary))
        .orElse(null);
  }

  public long getSumm(int departmentId) {
    return service.findAll()
        .stream()
        .filter(employee -> departmentId == employee.getDepartmentId())
        .mapToLong(Employee::getSalary)
        .sum();
  }

  public List<Employee> getByDepartment(int departmentId) {
    return service.findAll()
        .stream()
        .filter(employee -> departmentId == employee.getDepartmentId())
        .toList();
  }

  public Map<Integer, List<Employee>> groupByDepartment() {
    return service.findAll()
        .stream()
        .collect(Collectors.groupingBy(Employee::getDepartmentId));
  }
}

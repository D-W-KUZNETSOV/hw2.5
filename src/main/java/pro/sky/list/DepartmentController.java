package pro.sky.list;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

  private final DepartmentService service;

  public DepartmentController(DepartmentService service) {
    this.service = service;
  }

  @GetMapping("/max-salary")
  public Employee max(@RequestParam int departmentId) {
    return service.getMaxSalary(departmentId);
  }
  @GetMapping("/min-salary")
  public Employee min(@RequestParam int departmentId) {
    return service.getMaxSalary(departmentId);
  }

  @GetMapping("/all")
  public List<Employee> all(@RequestParam int departmentId) {
    return service.getByDepartment(departmentId);
  }

  @GetMapping("/all-get-by")
  public Map<Integer,List<Employee>> all() {
    return service.groupByDepartment();
  }
}

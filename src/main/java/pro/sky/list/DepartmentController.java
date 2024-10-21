package pro.sky.list;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/department")
public class DepartmentController {


  private final DepartmentService departmentService;


  @Autowired
  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping("/{id}/salary/max")
  public Employee MaxSalary(@PathVariable Integer departmentId) {
    return departmentService.getMaxSalary(departmentId);
  }

  @GetMapping("/{id}/salary/min")
  public Employee MinSalary(@PathVariable Integer departmentId) {
    return departmentService.getMinSalary(departmentId);
  }

  @GetMapping("/{id}/salary/sum")
  public long Summ(@PathVariable Integer departmentId) {
    return departmentService.getSumm(departmentId);
  }

  @GetMapping("{id}/employees")
  public List<Employee> all(@PathVariable Integer departmentId) {
    return departmentService.getByDepartment(departmentId);
  }

  @GetMapping("/employees")
  public Map<Integer, List<Employee>> employees() {
    return departmentService.groupByDepartment();
  }
}

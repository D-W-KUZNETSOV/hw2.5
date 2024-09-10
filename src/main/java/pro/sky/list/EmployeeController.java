package pro.sky.list;


import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employee")

public class EmployeeController {

  private final EmployeeService service;


  public EmployeeController(EmployeeService service) {
    this.service = service;
  }

  @GetMapping("/add")
  public Employee addEmployee(@RequestParam String firstName,
      @RequestParam String lastName,
      @RequestParam int departmentId,
      @RequestParam int salary) {
    return service.addEmployee(firstName, lastName, departmentId, salary);
  }

  @GetMapping("/remove")
  public String removeEmployee(@RequestParam String firstName,
      @RequestParam String lastName) {
    return service.removeEmployee(firstName, lastName);
  }

  @GetMapping("/find")
  public Employee findEmployee(@RequestParam String firstName,
      @RequestParam String lastName) {
    return service.findeEmployee(firstName, lastName);
  }

  @GetMapping("/find-all")
  public Collection<Employee> findAll() {
    return service.findAll();
  }
}


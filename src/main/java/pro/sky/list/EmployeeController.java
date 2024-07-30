package pro.sky.list;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
  public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
    return service.add(firstName, lastName);
  }
  @GetMapping("/remove")
  public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
    return service.remowe(firstName, lastName);
  }
  @GetMapping("/finde")
  public Employee findeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
    return service.finde(firstName, lastName);
  }

  @GetMapping
  public Collection<Employee> findAll() {
    return service.findAll();
  }
}


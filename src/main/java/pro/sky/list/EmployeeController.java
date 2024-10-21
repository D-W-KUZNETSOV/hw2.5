package pro.sky.list;


import java.util.Collection;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.list.exeption.ValidationException;

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
    validate(firstName, lastName);

    return service.addEmployee(StringUtils.capitalize(firstName),
        StringUtils.capitalize(lastName),
        departmentId,
        salary);
  }

  @GetMapping("/remove")
  public String removeEmployee(@RequestParam("firstname") String firstName,
      @RequestParam("lastname") String lastName) {
    validate(firstName, lastName);
    var removed = service.removeEmployee(StringUtils.capitalize(firstName),
        StringUtils.capitalize(lastName));
    if (removed) {
      return "сотрудник" + firstName + " " + lastName + " удалён";
    }
    return "сотрудник" + firstName + " " + lastName + " не найден";
  }

  @GetMapping("/find")
  public Employee findEmployee(@RequestParam String firstName,
      @RequestParam String lastName) {
    validate(firstName, lastName);
    return service.findEmployee(StringUtils.capitalize(firstName),
        StringUtils.capitalize(lastName));
  }

  @GetMapping("/find-all")
  public Collection<Employee> findAll() {

    return service.findAll();
  }

  public void validate(String... values) {
    for (String value : values) {
      if (!StringUtils.isAlpha(value)) {
        throw new ValidationException();
      }
    }
  }
}


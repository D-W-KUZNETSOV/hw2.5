package pro.sky.list;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

  @Mock
  EmployeeService interfaceEmployee;
  @InjectMocks
  DepartmentService departmentService;

  @BeforeEach
  void setUp() {
    List<Employee> employees = new ArrayList<>(
        List.of(
            new Employee("Иван", "Иванов", 1, 14000),

            new Employee("Семён", "Фёдоров", 2, 10000),

            new Employee("Василий", "Степанов", 3, 25000),

            new Employee("Николай", "Афанасьев", 4, 11000),

            new Employee("Владислав", "Киселёв", 3, 44000),

            new Employee("Антон", "Сергеев", 2, 3000)
        ));
    when(interfaceEmployee.findAll()).thenReturn(employees);
  }

  @Test
  void testMaxSalary() {
    assertEquals(new Employee("Владислав", "Киселёв", 3, 44000), departmentService.getMaxSalary(3));
    assertNull(departmentService.getMaxSalary(-1));
  }

  @Test
  void testMinSalary() {
    assertEquals(new Employee("Василий", "Степанов", 3, 25000), departmentService.getMinSalary(3));
    assertNull(departmentService.getMinSalary(-1));
  }

  @Test
  void testGetByDepartment() {
    assertThat(departmentService.getByDepartment(2)).containsExactly(
        new Employee("Семён", "Фёдоров", 2, 10000),
        new Employee("Антон", "Сергеев", 2, 3000));

    assertThat(departmentService.getByDepartment(1)).containsExactly(
        new Employee("Иван", "Иванов", 1, 14000));
  }

  @Test
  void testGroupByDepartment() {
    Map<Integer, List<Employee>> actual = departmentService.groupByDepartment();
    assertThat(actual).isEqualTo(Map.of(
        1, List.of(new Employee("Иван", "Иванов", 1, 14000)),
        2, List.of(new Employee("Семён", "Фёдоров", 2, 10000),
            new Employee("Антон", "Сергеев", 2, 3000)),
        3, List.of(new Employee("Василий", "Степанов", 3, 25000),
            new Employee("Владислав", "Киселёв", 3, 44000)),
        4, List.of(new Employee("Николай", "Афанасьев", 4, 11000))));

  }

}

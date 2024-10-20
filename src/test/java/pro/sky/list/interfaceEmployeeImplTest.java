package pro.sky.list;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import pro.sky.list.exeption.EmployeeAlreadyAddedException;
import pro.sky.list.exeption.EmployeeNotFoundException;
import pro.sky.list.exeption.EmployeeStorageIsFullException;

final class interfaceEmployeeImplTest {

  interfaceEmployeeImpl interfaceEmployee = new interfaceEmployeeImpl();


  @Test
  void addEmployee() {
    assertThat(interfaceEmployee.findAll()).size().isEqualTo(6);
    var emp = interfaceEmployee.addEmployee("Test", "test test", 1, 10000);
    assertThat(emp.getFirstName()).isEqualTo("Test");
    assertThat(emp.getLastName()).isEqualTo("test test");
    assertThat(emp.getDepartmentId()).isEqualTo(1);
    assertThat(emp.getSalary()).isEqualTo(10000);

    assertThat(interfaceEmployee.findAll()).size().isEqualTo(7);
    assertThat(interfaceEmployee.findAll()).contains(emp);

  }
  @Test
  void testAddEmployeeAlreadyExist(){
    var emp =interfaceEmployee.addEmployee("Test","test test",1,10000);
    assertThat(emp).isNotNull();
    assertThrows(
        EmployeeAlreadyAddedException.class, ()->interfaceEmployee.addEmployee("Test","test test",1,10000));

  }
  @Test
  void testAddMaxEmployee(){
    interfaceEmployee.addEmployee("Test1","test test1",1,10000);
    interfaceEmployee.addEmployee("Test2","test test2",2,15000);
    interfaceEmployee.addEmployee("Test3","test test3",3,11000);
    interfaceEmployee.addEmployee("Test4","test test4",2,11000);
    assertThrows(
        EmployeeStorageIsFullException.class, ()->interfaceEmployee.addEmployee("Test5","test test5",4,17000));

  }

  @Test
  void removeEmployee() {
  }

  @Test
  void findEmployee() {
    interfaceEmployee.addEmployee("Test","test test",3,12000);
    var actual=interfaceEmployee.findEmployee("Test","test test");
    assertThat(actual).isNotNull();
    assertThat(actual.getLastName()).isEqualTo("test test");
    assertThat(actual.getFirstName()).isEqualTo("Test");
    assertThat(actual.getDepartmentId()).isEqualTo(3);
    assertThat(actual.getSalary()).isEqualTo(12000);

  }

  @Test
  void testFindEmployeeNotFound() {
    assertThrows(EmployeeNotFoundException.class,
        () -> interfaceEmployee.findEmployee("Not found", "Not found"));

  }

  @Test
  void testFindAll() {
    var expected= List.of(
        new Employee("Иван", "Иванов", 1, 14000),

        new Employee("Семён", "Фёдоров", 2, 10000),

        new Employee("Василий", "Степанов", 3, 25000),

        new Employee("Николай", "Афанасьев", 4, 11000),

        new Employee("Владислав", "Киселёв", 3, 44000),

        new Employee("Антон", "Сергеев", 2, 3000));

        new Employee("Test","test test",2,12000);

        new Employee("Test1","test test1",1,11000);

        new Employee("Test2","test test2",3,14000);



    interfaceEmployee.addEmployee("Test", "test test", 2, 12000);
    interfaceEmployee.addEmployee("Test1", "test test1", 1, 11000);
    interfaceEmployee.addEmployee("Test2", "test test2", 3, 14000);

    assertThat(interfaceEmployee.findAll()).containsAll(expected);
  }

  @Test
  void testRemoveEmployee() {
    assertThat(interfaceEmployee.removeEmployee("Test", "test test")).isTrue();
    assertThat(interfaceEmployee.removeEmployee("NotFound", "NotFound")).isFalse();
  }


}
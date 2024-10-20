package pro.sky.list;

import java.util.Collection;
import pro.sky.list.exeption.EmployeeAlreadyAddedException;
import pro.sky.list.exeption.EmployeeStorageIsFullException;

interface EmployeeService {



  Employee addEmployee(String firstName, String lastName,int departmentId,int salary)
      throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

  boolean removeEmployee(String firstName,String lastName);

  Employee findEmployee(String firstName, String lastName);

  Collection<Employee> findAll();
}

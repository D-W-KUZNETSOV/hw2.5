package pro.sky.list;

import java.util.Collection;

interface EmployeeService {



  Employee addEmployee(String firstName, String lastName,int departmentId,int salary);

  String removeEmployee(String firstName,String lastName);
  Employee findeEmployee(String firstName,String lastName);

  Collection<Employee> findAll();
}

package pro.sky.list;

import java.util.Collection;

interface EmployeeService {

  Employee add(String firstName,String lastName);
  Employee remowe(String firstName,String lastName);
  Employee finde(String firstName,String lastName);

  Collection<Employee> findAll();
}

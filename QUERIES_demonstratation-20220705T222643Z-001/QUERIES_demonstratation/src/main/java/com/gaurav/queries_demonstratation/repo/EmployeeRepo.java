package com.gaurav.queries_demonstratation.repo;

import com.gaurav.queries_demonstratation.dto.EmployeeDto;
import com.gaurav.queries_demonstratation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    //named param
    @Query("FROM Employee where eId>=:min and eId<=:max")
    public List<Employee> getEmployeeBByIDRange(int min, int max);
    //native query
    @Query(value = "Select * from employee where e_Dpt=:dept ",nativeQuery = true)
    public List<Employee> getEmployeeByDept(String dept);

//    @Query(value = "Select e.eName from employee e where e.e_Dpt=:dept ",nativeQuery = true)
//    public List<EmployeeDto> getEmployeeByDeptTesting(String dept);

    @Query("From Employee where eName in(:name1,:name2,:name3) order by eName desc")
    public List<Employee> getEmployeeByName(String name1,String name2,String name3);
    //specific columns
    @Query("SELECT eId,eSalary,eName from Employee where eSalary>=:Salary and eName in (:name1,:name2)" )
    public List<Object[]> getEmployeeBySalaryandName(Double Salary,String name1,String name2);

    //specific column
    @Query("SELECT eName from Employee where eId<=:max and eId>=:min")
    public List<String> fetchEmpById(int min, int max);
    //Single row
    @Query("select e from Employee e where e.eName=:name")
    public Employee getEmployeeSingleRow(String name);
}

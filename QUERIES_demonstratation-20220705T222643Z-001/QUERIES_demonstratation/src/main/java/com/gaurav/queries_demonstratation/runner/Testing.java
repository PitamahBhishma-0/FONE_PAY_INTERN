package com.gaurav.queries_demonstratation.runner;

import com.gaurav.queries_demonstratation.dto.EmployeeDto;
import com.gaurav.queries_demonstratation.entity.Employee;
import com.gaurav.queries_demonstratation.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Testing implements CommandLineRunner {
    @Autowired
    EmployeeRepo eRepo;
    @Override
    public void run(String... args) throws Exception {
        eRepo.findAll().forEach(System.out::println);
        eRepo.getEmployeeBByIDRange(1,3).forEach(System.out::println);
        eRepo.getEmployeeByDept("JAVA").forEach((System.out::println));
        eRepo.getEmployeeByName("Gaurav","Hari","Ram").forEach(System.out::println);
        eRepo.getEmployeeBySalaryandName(350.0,"Gaurav","Hari").stream()
                .map(ob -> ob[0]+","+ob[1]+","+ob[2]).forEach(System.out::println);
        eRepo.fetchEmpById(2,5).forEach(System.out::println);
        System.out.println(eRepo.getEmployeeSingleRow("Gaurav"));

//        List<EmployeeDto> employeeList = eRepo.getEmployeeByDeptTesting("JAVA");
//        for (EmployeeDto employeeDto : employeeList) {
//            employeeDto.getEName();
//        }


//        eRepo.save(new Employee("Joker","JAVA",400.0));
//        eRepo.save(new Employee("MainJoker","Berojgar",500.0));
//        eRepo.save(new Employee("Hari","Technical",600.0));
//        eRepo.save(new Employee("Ram","Business",700.0));


    }
}

package com.gaurav.queries_demonstratation.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eId;
    private String eName;
    private String eDpt;
    private Double eSalary;

    public Employee(String eName, String eDpt, Double eSalary) {
        this.eName = eName;
        this.eDpt = eDpt;
        this.eSalary = eSalary;
    }
}

package org.pretest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
    @Id
    @Column(name = "EmployeeId", length = 10)
    private String employeeId;

    @Column(name = "EmployeeName", columnDefinition = "varchar(50)")
    private String employeeName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Employee_Company",
            joinColumns = @JoinColumn(name = "employee_Id", referencedColumnName = "EmployeeId"),
            inverseJoinColumns = @JoinColumn(name = "company_Id", referencedColumnName = "CompanyId")
    )
    private Set<Company> companies;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;
}

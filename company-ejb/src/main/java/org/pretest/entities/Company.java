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
@Table(name = "Company")
public class Company implements Serializable {
    @Id
    @Column(name = "CompanyId", columnDefinition = "varchar(10)")
    private String companyId;
    @Column(name = "CompanyName", columnDefinition = "nvarchar(100)")
    private String companyName;
    @ManyToMany(mappedBy = "companies", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Employee> employees;
}

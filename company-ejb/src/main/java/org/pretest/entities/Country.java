package org.pretest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Country")
public class Country implements Serializable {
    @Id
    @Column(name = "CountryId", columnDefinition = "varchar(10)")
    private String countryId;
    @Column(name = "CountryName")
    private String countryName;
    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
//    @JoinColumn(name = "country_id")
    Set<Employee> employees;
}

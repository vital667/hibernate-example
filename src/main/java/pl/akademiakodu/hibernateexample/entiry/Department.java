package pl.akademiakodu.hibernateexample.entiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "DEPT")
@Entity
@Setter
@Getter
@NoArgsConstructor //pusty konstruktor
public class Department {

    @Column(name = "DEPTNO")
    @Id //klucz glowny
    private Integer id;

    @Column(name = "DNAME")
    private String name;

    @Column(name = "LOC")
    private String city;

    //nazwa pola z drugiej klasy z JoinColumn
    //mappedBy okresla klucz obcy po drugiej stronie
    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", employees=" + employees.stream().map(e->e.getName()).collect(Collectors.toList())+
                '}';
    }
}


package pl.akademiakodu.hibernateexample.entiry;

import lombok.*;

import javax.persistence.*;

@Table(name = "EMP")
@Entity
@Setter
@Getter
@NoArgsConstructor //pusty konstruktor
public class Employee {

    @Column(name = "EMPNO")
    @Id //klucz glowny
    private Integer id;

    @Column(name = "ENAME")
    private String name;

    @Column(name = "JOB")
    private String job;

    @ManyToOne
    @JoinColumn(name="DEPTNO")
    private Department department; //laczenie tabel


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", department=" + department.getName() +
                '}';
    }
}

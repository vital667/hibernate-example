package pl.akademiakodu.hibernateexample.repo;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.hibernateexample.entiry.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}

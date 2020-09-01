package pl.akademiakodu.hibernateexample.repo;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.hibernateexample.entiry.Department;

public interface DepartmentRepository extends CrudRepository<Department,Integer> {
}

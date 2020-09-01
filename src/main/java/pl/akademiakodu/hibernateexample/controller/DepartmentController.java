package pl.akademiakodu.hibernateexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiakodu.hibernateexample.entiry.Department;
import pl.akademiakodu.hibernateexample.repo.DepartmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DepartmentController {

    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @GetMapping("/dept")
    public String showAllAndCount(ModelMap map) {
        map.put("employees", departmentRepository.findAll());
        map.put("count", departmentRepository.count());

        departmentRepository.findAll();
        return "list";
    }


    @GetMapping("/dept/30")
    public String show30(ModelMap map) {
        map.put("employees", ((List<Department>)departmentRepository.findAll())
                .stream()
                .filter(d->d.getId()==30)
                .collect(Collectors.toList()));
        return "list";
    }

}

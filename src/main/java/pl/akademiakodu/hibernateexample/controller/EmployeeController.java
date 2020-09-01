package pl.akademiakodu.hibernateexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.hibernateexample.entiry.Employee;
import pl.akademiakodu.hibernateexample.repo.EmployeeRepository;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String showAllAndCount(ModelMap map) {
        map.put("employees", employeeRepository.findAll());
        map.put("count", employeeRepository.count());
        return "list";
    }


    @GetMapping("/show/{number}")
    public String findById(@PathVariable int number,
                           ModelMap map) {
        map.put("employee", employeeRepository.findById(number).get());
        return "findbyid";
    }


    @GetMapping("/save")
    public String save(ModelMap map) {
        Employee employee = new Employee();
        employee.setId(667);
        employee.setJob("Program");
        employee.setName("vit667");

        if (employeeRepository.existsById(employee.getId())) {
            System.out.println(employee);
            System.out.println(employee.getId());
            System.out.println("Exists");
            map.put("employee", "User " + employee.getName() + " with id=" + employee.getId() + " already exists");
        } else {
            System.out.println("Doesn't exists");
            map.put("employee", employee);
            employeeRepository.save(employee);
        }
        return "save";
    }


    @GetMapping("/savefull")
    public String safeFull(@RequestParam int id,
                           @RequestParam String name,
                           @RequestParam String job,
                           ModelMap map) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setJob(job);
        employee.setName(name);

        if (!employeeRepository.existsById(employee.getId())) {
            map.put("employee", employee);
            employeeRepository.save(employee);
        } else {
            map.put("employee", "User " + employee.getName() + " with id=" + employee.getId() + " already exists");

        }
        return "save";
    }


    @GetMapping("/delete/{number}")
    public String deleteById(@PathVariable int number, ModelMap map) {
        System.out.println(employeeRepository.existsById(number));
        if (employeeRepository.existsById(number)) {
            System.out.println("Exists");
            map.put("employee", employeeRepository.findById(number).get());
            employeeRepository.deleteById(number);
        } else {
            System.out.println("Doesn't exist");
            map.put("employee", "User №" + number + " no in DataBase");
        }
        return "delete";
    }


    @GetMapping("/exists/{number}")
    public String existsById(@PathVariable int number, ModelMap map) {
        map.put("employee", employeeRepository.existsById(number));
        return "exists";
    }
}

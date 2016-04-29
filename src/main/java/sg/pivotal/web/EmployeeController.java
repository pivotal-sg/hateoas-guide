package sg.pivotal.web;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.pivotal.domain.Employee;

import java.util.ArrayList;
import java.util.List;

import static sg.pivotal.web.LinkUtility.getLinkToCurrentPage;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    private EmployeeAssembler assembler = new EmployeeAssembler();

    @GetMapping
    public Resources<?> listEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "boaty@pivotal.io", "Boaty McBoatface", 48_000));
        employees.add(new Employee(2, "smcschoolface@pivotal.io", "Schoolie McSchoolface", 124_000));

        return new Resources<>(assembler.toResources(employees), getLinkToCurrentPage());
    }

    @GetMapping(path = "/{id}")
    public ResourceSupport getEmployee(@PathVariable Long id) {
        return assembler.toResource(new Employee(id, "boaty@pivotal.io", "Boaty McBoatface", 48_000));
    }
}

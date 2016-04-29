package sg.pivotal.web;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.pivotal.domain.Employee;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    private EmployeeAssembler assembler = new EmployeeAssembler();

    @GetMapping(path = "/{id}")
    public ResourceSupport getEmployee(@PathVariable Long id) {
        return assembler.toResource(new Employee(id, "boaty@pivotal.io", "Boaty McBoatface", 48_000));
    }
}

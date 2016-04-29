package sg.pivotal.web;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import sg.pivotal.web.EmployeeAssembler.EmployeeResource;
import sg.pivotal.domain.Employee;

public class EmployeeAssembler extends ResourceAssemblerSupport<Employee, EmployeeResource> {
    public EmployeeAssembler() {
        super(EmployeeController.class, EmployeeResource.class);
    }

    @Override
    public EmployeeResource toResource(Employee entity) {
        return createResourceWithId(entity.getId(), entity);
    }

    @Override
    protected EmployeeResource instantiateResource(Employee entity) {
        return new EmployeeResource(entity);
    }

    static class EmployeeResource extends ResourceSupport {
        private String name;
        private String username;

        public EmployeeResource(Employee content) {
            this.name = content.getName();
            this.username = content.getUsername();
        }

        public String getName() {
            return name;
        }

        public String getUsername() {
            return username;
        }
    }
}

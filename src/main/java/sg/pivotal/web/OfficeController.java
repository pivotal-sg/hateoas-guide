package sg.pivotal.web;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.pivotal.domain.Office;

import java.util.ArrayList;
import java.util.List;

import static sg.pivotal.web.LinkUtility.getLinkToCurrentPage;

@RestController
@RequestMapping(path = "/offices")
class OfficeController {
    private OfficeAssembler assembler = new OfficeAssembler();

    @GetMapping
    public Resources<?> listOffices() {
        List<Office> offices = new ArrayList<>();
        offices.add(new Office("Singapore"));
        offices.add(new Office("Boulder"));

        return new Resources<>(assembler.toResources(offices), getLinkToCurrentPage());
    }

    @GetMapping(path = "/{name}")
    public Resource<?> getOffice(@PathVariable String name) {
        return assembler.toResource(new Office(name));
    }
}

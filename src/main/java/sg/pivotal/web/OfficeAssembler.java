package sg.pivotal.web;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import sg.pivotal.domain.Office;
import sg.pivotal.web.OfficeAssembler.OfficeResource;

public class OfficeAssembler extends ResourceAssemblerSupport<Office, OfficeResource> {
    public OfficeAssembler() {
        super(OfficeController.class, OfficeAssembler.OfficeResource.class);
    }

    @Override
    public OfficeResource toResource(Office entity) {
        return createResourceWithId(entity.getName(), entity);
    }

    @Override
    protected OfficeResource instantiateResource(Office entity) {
        return new OfficeResource(entity);
    }

    static class OfficeResource extends Resource<Office> {

        public OfficeResource(Office content) {
            super(content);
        }
    }
}

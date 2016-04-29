package sg.pivotal.web;

import org.springframework.hateoas.Link;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class LinkUtility {
    static public Link getLinkToCurrentPage() {
        return new Link(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .build()
                        .toUriString()
        );
    }
}

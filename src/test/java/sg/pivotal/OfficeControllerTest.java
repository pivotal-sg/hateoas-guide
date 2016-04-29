package sg.pivotal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class OfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOffices() throws Exception {
        mockMvc.perform(get("/offices"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.offices[0].name", is("Singapore")))
                .andExpect(jsonPath("$._embedded.offices[0]._links.self.href", is("http://localhost/offices/Singapore")))
                .andExpect(jsonPath("$._embedded.offices[1].name", is("Boulder")))
                .andExpect(jsonPath("$._links.self.href", is("http://localhost/offices")));
    }

    @Test
    public void getOffice() throws Exception {
        mockMvc.perform(get("/offices/Singapore"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Singapore")))
                .andExpect(jsonPath("$._links.self.href", is("http://localhost/offices/Singapore")));
    }
}

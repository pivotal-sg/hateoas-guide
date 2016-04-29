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
public class EmployeeIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOneEmployee() throws Exception {
        mockMvc.perform(get("/employees/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.username", is("boaty@pivotal.io")))
            .andExpect(jsonPath("$.name", is("Boaty McBoatface")))
            .andExpect(jsonPath("$.id").doesNotExist())
            .andExpect(jsonPath("$.salary").doesNotExist())
            .andExpect(jsonPath("$._links.self.href", is("http://localhost/employees/1")));
    }

    @Test
    public void getEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$._embedded.employees[0].name", is("Boaty McBoatface")))
            .andExpect(jsonPath("$._embedded.employees[0]._links.self.href", is("http://localhost/employees/1")))
            .andExpect(jsonPath("$._embedded.employees[1].name", is("Schoolie McSchoolface")))
            .andExpect(jsonPath("$._links.self.href", is("http://localhost/employees")));
    }
}

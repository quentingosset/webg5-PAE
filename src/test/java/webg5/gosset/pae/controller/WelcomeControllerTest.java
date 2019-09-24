package webg5.gosset.pae.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(WelcomeController.class)

/**
 * WelcomeControllerTest
 */
public class WelcomeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testWelcomePageArgument() throws Exception{
        mockMvc.perform(get("/welcome?name=quentin"))
            .andExpect(status().isOk())
            .andExpect(view().name("welcome"))
            .andExpect(content().string(Matchers.containsString("quentin")));
    }

    @Test
    public void testWelcomePageNoArgument() throws Exception{
        mockMvc.perform(get("/welcome"))
            .andExpect(status().isOk())
            .andExpect(view().name("welcome"))
            .andExpect(content().string(Matchers.containsString("Quentin")));
    }
}
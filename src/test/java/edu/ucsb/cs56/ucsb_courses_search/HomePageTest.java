package edu.ucsb.cs56.ucsb_courses_search;

// import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
public class HomePageTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthControllerAdvice aca;

    @MockBean
    private ClientRegistrationRepository crr;

    @Test
    public void getHomePage_hasCorrectPageOneTitle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/nav/div/ul/li[1]/a").exists())
                .andExpect(xpath("/html/body/div/nav/div/ul/li[1]/a").string("Tutors"));
    }

    @Test
    public void getHomePage_hasCorrectPageTwoTitle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/nav/div/ul/li[2]/a").exists())
                .andExpect(xpath("/html/body/div/nav/div/ul/li[2]/a").string("Course Offerings"));
    }

    @Test
    public void getHomePage_hasCorrectPageThreeTitle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/nav/div/ul/li[3]/a").exists())
                .andExpect(xpath("/html/body/div/nav/div/ul/li[3]/a").string("Time Slots"));
    }

    @Test
    public void getHomePage_hasCorrectPageFourTitle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/nav/div/ul/li[4]/a").exists())
                .andExpect(xpath("/html/body/div/nav/div/ul/li[4]/a").string("Rooms"));
    }
}

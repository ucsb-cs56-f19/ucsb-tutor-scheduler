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
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import edu.ucsb.cs56.ucsb_courses_search.controllers.TutorController;
import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(TutorController.class)
public class TutorsPageTest {

    @Autowired
    private MockMvc mvc;

    // @MockBean
    // private CourseOfferingController aca;

    // private static TutorController tutorController;
    // private static TutorRepository mockedTutorRepository;
    // private static BindingResult mockedBindingResult;
    // private static Model mockedModel;

    // @BeforeClass
    // public static void setUpTutorControllerInstance() {
    //     mockedTutorRepository = mock(TutorRepository.class);
    //     mockedBindingResult = mock(BindingResult.class);
    //     mockedModel = mock(Model.class);
    //     tutorController = new TutorController(mockedTutorRepository);
    // }
   
    @Test
    public void createTutorPagehasSubmitButton() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("tutors/create").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/div[1]/div/div/p/a").exists());
    }

}
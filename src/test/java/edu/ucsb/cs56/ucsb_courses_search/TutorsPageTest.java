package edu.ucsb.cs56.ucsb_courses_search;

// import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.andExpect;



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
import org.junit.Before;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

import edu.ucsb.cs56.ucsb_courses_search.controllers.TutorController;
import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;
import edu.ucsb.cs56.ucsb_courses_search.controllers.CourseOfferingController;
import edu.ucsb.cs56.ucsb_courses_search.repositories.CourseOfferingRepository;
import edu.ucsb.cs56.ucsb_courses_search.controllers.HomeController;
import edu.ucsb.cs56.ucsb_courses_search.controllers.RepositoryControllerAdvice;
import edu.ucsb.cs56.ucsb_courses_search.controllers.RoomsController;
import edu.ucsb.cs56.ucsb_courses_search.controllers.TimeSlotController;
import edu.ucsb.cs56.ucsb_courses_search.controllers.TutorAssignmentController;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;

@RunWith(SpringRunner.class)
@WebMvcTest(TutorController.class)
public class TutorsPageTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthControllerAdvice aca;

    @MockBean
    private ClientRegistrationRepository crr;

    // @MockBean
    // private CourseOfferingController coController;

    // @MockBean
    // private HomeController hc;
    
    // @MockBean
    // private RepositoryControllerAdvice rca;

    // @MockBean
    // private RoomsController rc;

    // @MockBean
    // private TimeSlotController tsc;

    // @MockBean
    // private TutorAssignmentController tac;

    // @MockBean
    // private TutorController tc;

    private OAuth2User principal;

    /**
     * Set up an OAuth mock user so that we can unit test protected endpoints
    */
     
    @Before
    public void setUpUser() {
        principal = OAuthUtils.createOAuth2User("Chris Gaucho", "cgaucho@example.com");
    }
   




    @Test
    @WithMockUser
    public void createTutorPagehasSubmitButton() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/tutors/create/")
            .with(authentication(OAuthUtils.getOauthAuthenticationFor(principal)))
            .accept(MediaType.TEXT_HTML))
            .andExpect(status().isOk())
            .andExpect(xpath("/html/body/div/div[1]/div/div/p/a").exists());



    }

}

package edu.ucsb.cs56.ucsb_courses_search;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import edu.ucsb.cs56.ucsb_courses_search.entities.TutorsToCSV;
import edu.ucsb.cs56.ucsb_courses_search.entities.Tutor;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.CourseOfferingRepository;
import edu.ucsb.cs56.ucsb_courses_search.repositories.TimeSlotRepository;

//package edu.ucsb.cs56.ucsb_courses_search;

// import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.andExpect;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.Before;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

import edu.ucsb.cs56.ucsb_courses_search.controllers.HomeController;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class TutorToCSVUnitTest {

    @MockBean
    private static TutorRepository mockTutorRepository;
    @MockBean
    private static CourseOfferingRepository mockCourseOfferingRepository;
    @MockBean
    private static TimeSlotRepository mockTimeSlotRepository;

    /**
     * This configures the test to ONLY load one controller,
     * which means that there are far fewer beans that have to be
     * mocked and stubbed.   See https://stackoverflow.com/a/45228072
     * plus the comments underneath about Configuration.
     */
   
    @Configuration
    public static class TestConf {
        @Bean
        public HomeController homeController() {
            return new HomeController(mockTutorRepository, mockCourseOfferingRepository, mockTimeSlotRepository);
        }
    }

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthControllerAdvice aca;

    @MockBean
    private ClientRegistrationRepository crr;

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
    public void getTutorPage_hasCSVDownloadButton() throws Exception {
        // CHANGE LATER TO /tutors when it gets moved from hompepage
        mvc.perform(MockMvcRequestBuilders.get("/")
                .with(authentication(OAuthUtils.getOauthAuthenticationFor(principal)))
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/div/div[1]/div/div[2]/div/a[2]").exists())
                .andExpect(xpath("/html/body/div/nav/div[1]/div/div[2]/div/a[2]").string("Download CSV"));
    }
/*
public class TutorsToCSVUnitTest {


    private final TutorRepository tutorRepository;

    tutorRepository.save(tutor);

    @Test
    public void whenCalledWriteTutors_thenCorrect() {
        Tutor tutor = new Tutor("Julie", "Smith", "julie@domain.com", "PAID");

        List<Tutor> tutors =  (List<Tutor>) tutorRepository.findAll();

        HttpServletResponse response;
        TutorsToCSV.writeTutors(response.getWriter(), tutors);

        assertThat(tutor.getFname()).isEqualTo("Julie");
    }
*/
}
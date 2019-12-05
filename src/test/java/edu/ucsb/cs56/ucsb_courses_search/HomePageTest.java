

package edu.ucsb.cs56.ucsb_courses_search;

// import static org.hamcrest.Matchers.equalTo;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.andExpect;

        import edu.ucsb.cs56.ucsb_courses_search.controllers.HomeController;
        import org.junit.Test;
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

        import edu.ucsb.cs56.ucsb_courses_search.controllers.TutorController;
        import edu.ucsb.cs56.ucsb_courses_search.repositories.TutorRepository;
        import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomePageTest {

    /*
    @MockBean
    private static TutorRepository mockTutorRepository;

     */

    /**
     * This configures the test to ONLY load one controller,
     * which means that there are far fewer beans that have to be
     * mocked and stubbed.   See https://stackoverflow.com/a/45228072
     * plus the comments underneath about Configuration.
     */
    /*
    @Configuration
    public static class TestConf {
        @Bean
        public TutorController tutorController() {
            return new TutorController(mockTutorRepository);
        }
    }
    */

    @Autowired
    private MockMvc mvc;

    /*
    @MockBean
    private AuthControllerAdvice aca;

    @MockBean
    private ClientRegistrationRepository crr;

     */

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
    public void getHomePage_ContentType() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
                .with(authentication(OAuthUtils.getOauthAuthenticationFor(principal))).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    @WithMockUser
    public void getHomePage_hasCorrectBrand() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
                .with(authentication(OAuthUtils.getOauthAuthenticationFor(principal))).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/nav/a").exists())
                .andExpect(xpath("/html/body/div/nav/a").string("UCSB Tutor Scheduler"));
    }

    @Test
    @WithMockUser
    public void getHomePage_hasCorrectPageOneTitle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
                .with(authentication(OAuthUtils.getOauthAuthenticationFor(principal))).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/nav/div/ul[1]/li[1]/a").exists())
                .andExpect(xpath("/html/body/div/nav/div/ul[1]/li[1]/a").string("Tutors"));
    }

    @Test
    @WithMockUser
    public void getHomePage_hasCorrectPageTwoTitle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
                .with(authentication(OAuthUtils.getOauthAuthenticationFor(principal))).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/nav/div/ul[1]/li[2]/a").exists())
                .andExpect(xpath("/html/body/div/nav/div/ul[1]/li[2]/a").string("Course Offerings"));
    }

    @Test
    @WithMockUser
    public void getHomePage_hasCorrectPageThreeTitle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
                .with(authentication(OAuthUtils.getOauthAuthenticationFor(principal))).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/nav/div/ul[1]/li[3]/a").exists())
                .andExpect(xpath("/html/body/div/nav/div/ul[1]/li[3]/a").string("Time Slots"));
    }

    @Test
    @WithMockUser
    public void getHomePage_hasCorrectPageFourTitle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
                .with(authentication(OAuthUtils.getOauthAuthenticationFor(principal))).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/div/nav/div/ul[1]/li[4]/a").exists())
                .andExpect(xpath("/html/body/div/nav/div/ul[1]/li[4]/a").string("Rooms"));
    }

}
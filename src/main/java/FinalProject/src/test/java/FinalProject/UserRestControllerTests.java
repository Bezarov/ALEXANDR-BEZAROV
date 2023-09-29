package FinalProject;

import FinalProject.Controllers.UserRestController;
import FinalProject.Models.UserModel;
import FinalProject.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(UserRestController.class)
public class UserRestControllerTests {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserRestController userRestController;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ObjectMapper objectMapper;

    UserModel requestBodyUserTestModelObject = new UserModel(
            UUID.fromString("99999999-e60b-4e1f-8557-863587a8e0ce"),
            "TestUserName2",
            "TestUserSurname2",
            "testpassword2");
    String userId = "11111111-e60b-4e1f-8557-863587a8e0ce";
    String currentPassword = "testpassword2";
    String newPassword = "newpassword";

    @Test
    @BeforeEach
    public void insertTestUserToDatabaseTest() {
        UserModel testUserModelObject = new UserModel(
                UUID.fromString("11111111-e60b-4e1f-8557-863587a8e0ce"),
                "TestUserName",
                "TestUserSurname",
                "testpassword");
        userRepository.save(testUserModelObject);
        assertThat(userRepository.findById(testUserModelObject.getUserId())).isNotNull();
    }

    @Test
    @DisplayName("New User Registration Test")
    public void userRegistrationTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBodyUserTestModelObject)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Getting a list of all User-Profiles Test")
    public void getAllUserProfilesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/user/profiles"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Getting user profile information Test")
    public void getUserProfileTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/user/profile/{userId}", userId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Update user profile information Test")
    public void updateUserProfileTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/user/profile/{userId}/{currentPassword}", userId, currentPassword)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBodyUserTestModelObject)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("User password update Test")
    public void updateUserPasswordTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/user/password/{userId}/{currentPassword}/{newPassword}",
                                userId, currentPassword, newPassword)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Deleting a user account Test")
    public void deleteUserProfileTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/user/profile/{userId}/{currentPassword}", userId, currentPassword)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

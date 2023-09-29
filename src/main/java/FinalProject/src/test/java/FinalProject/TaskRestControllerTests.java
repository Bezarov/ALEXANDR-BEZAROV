package FinalProject;

import FinalProject.Controllers.TaskRestController;
import FinalProject.Models.TaskModel;
import FinalProject.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureWebMvc
@WebMvcTest(TaskRestController.class)
public class TaskRestControllerTests {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRestController taskRestController;
    @MockBean
    private TaskRepository taskRepository;

    String userId = "11111111-e60b-4e1f-8557-863587a8e0ce";
    String taskId = "22222222-e60b-4e1f-8557-863587a8e0ce";

    @Test
    @BeforeEach
    public void insertTestTaskToDatabaseTest() {
        TaskModel testTaskModelObject = new TaskModel(
                UUID.fromString("22222222-e60b-4e1f-8557-863587a8e0ce"),
                "TestTaskName",
                UUID.fromString("11111111-e60b-4e1f-8557-863587a8e0ce"),
                UUID.fromString("33333399-e60b-4e1f-8557-863587a8e0ce"),
                true,
                false);
        taskRepository.save(testTaskModelObject);
        assertThat(taskRepository.findById(testTaskModelObject.getTaskId())).isNotNull();
    }

    @Test
    @DisplayName("Getting a list of tasks assigned to specific user Test")
    public void getListOfTasksAppointedToThisUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/tasks/assigned/{userId}", userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Assigning a task to a user Test")
    public void appointThisTaskToThisUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/tasks/{taskId}/assign/{userId}", taskId, userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Marking a task as completed Test")
    public void appointThisTaskAsCompletedTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/tasks/{taskId}/complete", taskId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

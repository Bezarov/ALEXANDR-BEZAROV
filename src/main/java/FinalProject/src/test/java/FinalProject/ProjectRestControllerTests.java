package FinalProject;

import FinalProject.Controllers.ProjectRestController;
import FinalProject.Models.ProjectModel;
import FinalProject.Models.TaskModel;
import FinalProject.repository.ProjectRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@WebMvcTest(ProjectRestController.class)
public class ProjectRestControllerTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectRepository projectRepository;

    @MockBean
    private ProjectRestController projectRestController;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ObjectMapper objectMapper;

    String projectId = "33333399-e60b-4e1f-8557-863587a8e0ce";
    String taskId = "22222222-e60b-4e1f-8557-863587a8e0ce";

    ProjectModel requestBodyProjectTestModelObject = new ProjectModel(
            UUID.fromString("33333399-e60b-4e1f-8557-863587a8e0ce"),
            "TestProjectName1",
            "TestProjectDescription1",
            UUID.fromString("11111111-e60b-4e1f-8557-863587a8e0ce"),
            UUID.fromString("22222222-e60b-4e1f-8557-863587a8e0ce"));
    TaskModel requestBodyTaskTestModelObject = new TaskModel(
            UUID.fromString("22222222-e60b-4e1f-8557-863587a8e0ce"),
            "TestTaskName",
            UUID.fromString("11111111-e60b-4e1f-8557-863587a8e0ce"),
            UUID.fromString("33333399-e60b-4e1f-8557-863587a8e0ce"),
            true,
            false);

    @Test
    @BeforeEach
    public void insertProjectTaskToDatabaseTest() {
        ProjectModel testProjectModelObject = new ProjectModel(
                UUID.fromString("33333333-e60b-4e1f-8557-863587a8e0ce"),
                "TestProjectName",
                "TestProjectDescription",
                UUID.fromString("11111111-e60b-4e1f-8557-863587a8e0ce"),
                UUID.fromString("22222222-e60b-4e1f-8557-863587a8e0ce"));
        projectRepository.save(testProjectModelObject);
        assertThat(projectRepository.findById(testProjectModelObject.getProjectId())).isNotNull();
    }

    @Test
    @DisplayName("Getting a list of all projects Test")
    public void getAllProjectsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/projects"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Create a new project Test")
    public void createNewProjectTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBodyProjectTestModelObject)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Obtaining information about a specific project Test")
    public void getThisProjectTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/projects/{projectId}", projectId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Updating information about a specific project Test")
    public void updateThisProjectTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/projects/{projectId}", projectId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBodyProjectTestModelObject)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Deleting a specific project Test")
    public void deleteThisProjectTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/projects/{projectId}", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Getting a list of tasks for a specific project Test")
    public void getListOfTasksForThisProjectTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/projects/{projectId}/tasks", projectId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Create a new task within a project Test")
    public void createNewTaskInThisProjectTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/projects/{projectId}/tasks", projectId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBodyTaskTestModelObject)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Obtaining information about a specific task within the project Test")
    public void getInformationThisProjectThisTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/projects/{projectId}/tasks/{taskId}", projectId, taskId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Updating information about a specific task within a project Test")
    public void updateInformationThisProjectThisTaskTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/projects/{projectId}/tasks/{taskId}", projectId, taskId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBodyTaskTestModelObject)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Deleting a specific task within a project Test")
    public void deleteThisTaskInThisProjectTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/projects/{projectId}/tasks/{taskId}", projectId, taskId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}

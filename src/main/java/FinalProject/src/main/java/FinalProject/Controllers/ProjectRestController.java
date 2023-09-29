package FinalProject.Controllers;

import FinalProject.Models.ProjectModel;
import FinalProject.Models.TaskModel;
import FinalProject.Models.UserModel;
import FinalProject.repository.ProjectRepository;
import FinalProject.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class ProjectRestController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    TaskRepository taskRepository;

    @PostMapping("/api/projects")
    public Object createNewProject(@RequestBody @Valid ProjectModel projectModel) {
        if (!(projectModel.getProjectName()).equals(
                projectRepository.projectDuplicateCheck(projectModel.getProjectName()))) {
            projectRepository.save(projectModel);
            return projectRepository.findByProjectName(projectModel.getProjectName());
        }
        return new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/projects")
    public List<ProjectModel> getAllProjects() {
        return (List<ProjectModel>) projectRepository.findAll();
    }

    @GetMapping("/api/projects/{projectId}")
    public Object getThisProject(@PathVariable UUID projectId) {
        return projectRepository.findById(projectId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    @PutMapping("/api/projects/{projectId}")
    public UUID updateThisProject(@RequestBody @Valid ProjectModel projectModel,
                                  @PathVariable UUID projectId) {
        projectRepository.findById(projectId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        projectRepository.deleteById(projectId);
        projectRepository.save(projectModel);
        return projectModel.getProjectId();
    }

    @DeleteMapping("/api/projects/{projectId}")
    public ResponseStatusException deleteThisProject(@PathVariable UUID projectId) {
        projectRepository.findById(projectId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        projectRepository.deleteById(projectId);
        return new ResponseStatusException(HttpStatus.OK);
    }

    @PostMapping("/api/projects/{projectId}/tasks")
    public Object createNewTaskInThisProject(@RequestBody @Valid TaskModel taskModel, @PathVariable UUID projectId) {
        projectRepository.findById(projectId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        if (projectId.equals(taskModel.getProjectId())) {
            List<TaskModel> task = taskRepository.taskDuplicationCheck(taskModel.getProjectId(), taskModel.getTaskName());
            if (task.isEmpty())
                return taskRepository.save(taskModel);
        }
        return new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/projects/{projectId}/tasks")
    public List<TaskModel> getListOfTasksForThisProject(@PathVariable UUID projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    @GetMapping("/api/projects/{projectId}/tasks/{taskId}")
    public List<TaskModel> getInformationThisProjectThisTask(@PathVariable UUID projectId, @PathVariable UUID taskId) {
        return taskRepository.findByProjectAndTask(projectId, taskId);
    }

    @PutMapping("/api/projects/{projectId}/tasks/{taskId}")
    public Object updateInformationThisProjectThisTask(@RequestBody @Valid TaskModel taskModel,
                                                       @PathVariable UUID projectId,
                                                       @PathVariable UUID taskId) {
        taskRepository.findByProjectAndTask(projectId, taskId).stream()
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        if (!taskModel.getDone()) {
            taskRepository.deleteById(taskId);
            return taskRepository.save(taskModel);
        }
        return new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/api/projects/{projectId}/tasks/{taskId}")
    public ResponseStatusException deleteThisTaskInThisProject(@PathVariable UUID projectId,
                                                               @PathVariable UUID taskId) {
        taskRepository.findByProjectAndTask(projectId, taskId).stream()
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        taskRepository.deleteById(taskId);
        return new ResponseStatusException(HttpStatus.OK);
    }
}

package FinalProject.Controllers;

import FinalProject.Models.TaskModel;
import FinalProject.repository.TaskRepository;
import FinalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskRestController {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/tasks/assigned/{userId}")
    public List<TaskModel> getListOfTasksAppointedToThisUser(@PathVariable UUID userId) {
        userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        return taskRepository.findAllAssignmentsToUser(userId);
    }

    @PutMapping("/api/tasks/{taskId}/assign/{userId}")
    public ResponseStatusException appointThisTaskToThisUser(@PathVariable UUID taskId, @PathVariable UUID userId) {
        taskRepository.findById(taskId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        taskRepository.assignThisTaskToThisProjectById(userId, taskId);
        return new ResponseStatusException(HttpStatus.OK);
    }

    @PutMapping("/api/tasks/{taskId}/complete")
    public ResponseStatusException appointThisTaskAsCompleted(@PathVariable UUID taskId) {
        taskRepository.findById(taskId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        taskRepository.setDoneTrueInProgressFalse(taskId);
        return new ResponseStatusException(HttpStatus.OK);
    }
}

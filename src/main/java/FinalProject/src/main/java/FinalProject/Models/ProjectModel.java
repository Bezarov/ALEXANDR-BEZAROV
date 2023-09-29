package FinalProject.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

@Entity
@Table(name = "PROJECTS")
public class ProjectModel {
    @Id
    @Column
    @GeneratedValue
    private UUID projectId;
    @Column
    @NotEmpty
    private String projectName;
    @Column
    private String description;
    @Column
    private UUID userId;
    @Column
    private UUID taskId;

    public ProjectModel() {
    }

    public ProjectModel(UUID projectId, String projectName, String description, UUID userId, UUID taskId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
        this.userId = userId;
        this.taskId = taskId;
    }

    public UUID projectsId() {
        return projectId;
    }

    public String getDescription() {
        return description;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void projectsId(UUID projectsId) {
        this.projectId = projectsId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}

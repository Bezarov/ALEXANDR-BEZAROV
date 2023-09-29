package FinalProject.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TASKS")
public class TaskModel {
    @Id
    @Column
    @GeneratedValue
    private UUID taskId;
    @Column
    @NotNull
    private String taskName;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @Column(nullable = false, updatable = true)
    @UpdateTimestamp
    private Date updatedAt;
    @Column
    private UUID assignedTo;
    @Column
    @NotNull
    private UUID projectId;
    @Column
    @NotNull
    private Boolean inProgress;
    @Column
    @NotNull
    private Boolean done;

    public TaskModel() {
    }

    public TaskModel(UUID taskId, String taskName, UUID assignedTo, UUID projectId, Boolean inProgress, Boolean done) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.assignedTo = assignedTo;
        this.projectId = projectId;
        this.inProgress = inProgress;
        this.done = done;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public UUID getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UUID assignedTo) {
        this.assignedTo = assignedTo;
    }
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}

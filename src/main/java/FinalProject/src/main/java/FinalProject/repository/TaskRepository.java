package FinalProject.repository;

import FinalProject.Models.TaskModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends CrudRepository<TaskModel, UUID> {

    @Query(value = "SELECT * FROM TASKS WHERE PROJECT_ID = :projectId AND TASK_ID = :taskId", nativeQuery = true)
    List<TaskModel> findByProjectAndTask(@Param("projectId") UUID projectId, @Param("taskId") UUID taskId);

    @Query(value = "SELECT * FROM TASKS WHERE PROJECT_ID = :projectId", nativeQuery = true)
    List<TaskModel> findByProjectId(@Param("projectId") UUID projectId);

    @Query(value = "SELECT * FROM TASKS WHERE ASSIGNED_TO = :userId", nativeQuery = true)
    List<TaskModel> findAllAssignmentsToUser(@Param("userId") UUID userId);

    @Query(value = "SELECT * FROM TASKS WHERE PROJECT_ID = :projectId AND TASK_NAME = :taskName", nativeQuery = true)
    List<TaskModel> taskDuplicationCheck(@Param("projectId") UUID projectId, @Param("taskName") String taskName);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE TASKS SET IN_PROGRESS = FALSE, DONE = TRUE WHERE TASK_ID = :taskId", nativeQuery = true)
    void setDoneTrueInProgressFalse(@Param("taskId") UUID taskId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE TASKS SET ASSIGNED_TO = :userId WHERE TASK_ID = :taskId", nativeQuery = true)
    void assignThisTaskToThisProjectById(@Param("userId") UUID userId, @Param("taskId") UUID taskID);


}

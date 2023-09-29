package FinalProject.repository;


import FinalProject.Models.ProjectModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectModel, UUID> {
    @Query(value = "SELECT * FROM PROJECTS WHERE PROJECT_NAME = :projectName", nativeQuery = true)
    List<ProjectModel> findByProjectName(@Param("projectName") String projectName);

    @Query(value = "SELECT PROJECT_NAME FROM PROJECTS WHERE PROJECT_NAME = :projectName", nativeQuery = true)
    String projectDuplicateCheck(@Param("projectName") String projectName);

}

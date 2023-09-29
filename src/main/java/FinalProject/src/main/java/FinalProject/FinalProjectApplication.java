package FinalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);

		String documentation = "\t\t\t\t\t\tThe Final Project \n" +
				"\t\t\t\t\tHTTP Request Methods & URI \n\n" +
				"\t\t\t\t\t\t\t  USERS: \n" +
		"POST /api/register -> New User Registration \n" +
		"GET /api/user/profile/{userId}	-> Getting user profile information \n" +
		"GET /api/user/profiles	-> Getting a list of all User-Profiles \n" +
		"PUT /api/user/profile/{userId}/{currentPassword} -> Update user profile information \n" +
		"PATCH /api/user/password/{userId}/{currentPassword}/{newPassword} -> User password update \n" +
		"DELETE /api/user/profile/{userId}/{currentPassword} -> Deleting a user account \n\n" +
				"\t\t\t\t\t\t\tPROJECTS: \n" +
		"GET /api/projects -> Getting a list of all projects \n" +
		"POST /api/projects -> Create a new project \n" +
		"GET /api/projects/{projectId} -> Obtaining information about a specific project \n" +
		"PUT /api/projects/{projectId} -> Updating information about a specific project \n" +
		"DELETE /api/projects/{projectId} -> Deleting a specific project \n" +
		"GET /api/projects/{projectId}/tasks -> Getting a list of tasks for a specific project \n" +
		"POST /api/projects/{projectId}/tasks -> Create a new task within a project \n" +
		"GET /api/projects/{projectId}/tasks/{taskId} -> Obtaining information about a specific task within the project \n" +
		"PUT /api/projects/{projectId}/tasks/{taskId} -> Updating information about a specific task within a project \n" +
		"DELETE /api/projects/{projectId}/tasks/{taskId} -> Deleting a specific task within a project\n\n" +
				"\t\t\t\t\t\t\tTASKS: \n" +
		"GET /api/tasks/assigned/{userId} -> Getting a list of tasks assigned to specific user \n" +
		"PUT /api/tasks/{taskId}/assign/{userId} -> Assigning a task to a user \n" +
		"PUT /api/tasks/{taskId}/complete -> Marking a task as completed \n\n" +
				"\t\t\t\t\t\tDatabase H2 Settings: \n" +
		"URL Web Gui -> http://localhost:8080/h2-console\n"+
		"JDBC URL -> jdbc:h2:file:\\src\\main\\resources\\db\\db_save\n"+
		"Login -> admin\n"+
		"Password -> admin\n"+
				"\t\t\t\t\t\tLogging for Project: \n" +
		"Logging level for this project -> error\n"+
		"Logging turned on to a file along this path-references -> src/main/java/FinalProject/Logs/finalProjectLogs.txt\n\n" +
				"\t\t\t\t\t\tLogging for tests & Tests: \n" +
		"Tests for this project you can find here -> src/test/java/FinalProject\n"+
		"Logging for Tests level for this project -> error\n"+
		"Logging for Tests turned on to a file along this path-references -> src/main/java/FinalProject/Logs/finalProjectLogs.txt\n\n" +
		"Project Created at: 14.06.2023                    Last Updated at 16.06.2023";
		System.out.println(documentation);
	}

}

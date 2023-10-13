CREATE TABLE IF NOT EXISTS USERS(
    USER_ID UUID PRIMARY KEY,
    NAME VARCHAR(20),
    SURNAME VARCHAR(25),
    PASSWORD VARCHAR(130)
);
CREATE TABLE IF NOT EXISTS PROJECTS(
    PROJECT_ID UUID PRIMARY KEY,
    USER_ID UUID,
    PROJECT_NAME VARCHAR(25),
    DESCRIPTION VARCHAR(25),
    FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);
CREATE TABLE IF NOT EXISTS TASKS(
    TASKID UUID PRIMARY KEY,
    TASK_NAME VARCHAR(25),
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP,
    ASSIGNED_TO UUID,
    PROJECT_ID UUID,
    IN_PROGRESS BOOLEAN,
    DONE BOOLEAN,
    FOREIGN KEY (PROJECT_ID) REFERENCES PROJECTS(PROJECT_ID),
    FOREIGN KEY (ASSIGNED_TO) REFERENCES USERS(USER_ID)
);
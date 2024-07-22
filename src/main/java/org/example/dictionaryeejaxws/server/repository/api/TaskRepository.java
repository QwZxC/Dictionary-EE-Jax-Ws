package org.example.dictionaryeejaxws.server.repository.api;

import org.example.dictionaryeejaxws.server.entity.Task;
import org.example.dictionaryeejaxws.server.entity.TaskStatus;

import java.util.List;

public interface TaskRepository {
    void createTask(Task task);

    void updateTask(Task task);

    List<Task> findAllTasksByStatus(TaskStatus status);
}

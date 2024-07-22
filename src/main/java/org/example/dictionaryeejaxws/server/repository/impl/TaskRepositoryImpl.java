package org.example.dictionaryeejaxws.server.repository.impl;

import org.example.dictionaryeejaxws.server.entity.Task;
import org.example.dictionaryeejaxws.server.entity.TaskStatus;
import org.example.dictionaryeejaxws.server.repository.api.TaskRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TaskRepositoryImpl implements TaskRepository {

    @PersistenceContext(unitName = "PostgresDS")
    private EntityManager em;


    @Override
    public void createTask(Task task) {
        em.persist(task);
    }

    @Override
    public void updateTask(Task task) {
        em.merge(task);
    }

    @Override
    public List<Task> findAllTasksByStatus(TaskStatus status) {
        return em.createQuery("SELECT t FROM Task t WHERE t.status = :status", Task.class)
                .setParameter("status", status)
                .getResultList();
    }
}

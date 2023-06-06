package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.internal.mapper.TaskMapper;
import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.internal.repository.TaskRepository;
import com.javarush.jira.bugtracking.to.TagTo;
import com.javarush.jira.bugtracking.to.TaskTo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService extends BugtrackingService<Task, TaskTo, TaskRepository> {
    public TaskService(TaskRepository repository, TaskMapper mapper) {
        super(repository, mapper);
    }

    public List<TaskTo> getAll() {
        return mapper.toToList(repository.getAll());
    }

    public TaskTo findById(Long id){
        return Optional.of(getById(id)).map(mapper::toTo).get();
    }

    @Transactional
    public TaskTo save(TaskTo task){
        return mapper.toTo(repository.save(mapper.toEntity(task)));
    }

    @Transactional
    public Task addToTags(Long id, TagTo tags){
        Task task = getById(id);
        task.setTags(tags.getTags());
        return repository.save(task);
    }

    private Task getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Task with id: " + id + " not found"));
    }
}

package com.javarush.jira.bugtracking.internal.controller;


import com.javarush.jira.bugtracking.TaskService;
import com.javarush.jira.bugtracking.internal.mapper.TaskMapper;
import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.to.TagTo;
import com.javarush.jira.bugtracking.to.TaskTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(TaskController.TASK_URL)
public class TaskController {
    public static final String TASK_URL = "/task";
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping("/{id}/tags")
    public TaskTo updateTask(@PathVariable Long id, @RequestBody TagTo tags) {
        return taskMapper.toTo(taskService.addToTags(id, tags));
    }

}

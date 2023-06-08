package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.internal.mapper.ActivityMapper;
import com.javarush.jira.bugtracking.internal.model.Activity;
import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.internal.repository.ActivityRepository;
import com.javarush.jira.bugtracking.internal.repository.TaskRepository;
import com.javarush.jira.bugtracking.to.ActivityTo;
import com.javarush.jira.login.User;
import com.javarush.jira.login.internal.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    public final ActivityRepository activityRepository;
    public final ActivityMapper activityMapper;
    public final UserRepository userRepository;
    public final TaskRepository taskRepository;

    public ActivityTo createLinkToTask(Long userId, Long taskId, ActivityTo activityTo){
        Task task = getTaskById(taskId);
        User user = getUserById(userId);
        Activity activity = activityMapper.toEntity(activityTo);
        activity.setTask(task);
        activity.setAuthor(user);

        activity = activityRepository.save(activity);

        return activityMapper.toTo(activity);
    }

    private Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Task with id: " + id + " not found"));
    }

    private User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "User with id: " + id + " not found"));
    }

}

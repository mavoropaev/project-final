package com.javarush.jira.bugtracking.internal.controller;

import com.javarush.jira.bugtracking.ActivityService;
import com.javarush.jira.bugtracking.internal.mapper.ActivityMapper;
import com.javarush.jira.bugtracking.internal.mapper.TaskMapper;
import com.javarush.jira.bugtracking.internal.model.Activity;
import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.to.ActivityTo;
import com.javarush.jira.bugtracking.to.TaskTo;
import com.javarush.jira.login.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ActivityController.ACTIVITY_URL)
public class ActivityController {
    public static final String ACTIVITY_URL = "/activity";
    public final ActivityService activityService;
    public final ActivityMapper activityMapper;
    public final TaskMapper taskMapper;

    @PostMapping("/{userId}/sign/{taskId}")
    public ActivityTo createLinkToTask(@PathVariable Long userId,
                             @PathVariable Long taskId,
                             @RequestBody ActivityTo activityTo){

        ActivityTo activityToOut = activityService.createLinkToTask(userId, taskId, activityTo);

        return activityToOut;
    }

}

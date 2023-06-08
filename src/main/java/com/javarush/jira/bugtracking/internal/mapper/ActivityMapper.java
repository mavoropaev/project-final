package com.javarush.jira.bugtracking.internal.mapper;

import com.javarush.jira.bugtracking.internal.model.Activity;
import com.javarush.jira.bugtracking.to.ActivityTo;
import com.javarush.jira.common.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ActivityMapper extends BaseMapper<Activity, ActivityTo> {

    //@Mapping(target = "enabled", expression = "java(activity.isEnabled())")
    @Override
    ActivityTo toTo(Activity entity);

    @Override
    Activity toEntity(ActivityTo to);

    @Override
    List<ActivityTo> toToList(Collection<Activity> entities);
}

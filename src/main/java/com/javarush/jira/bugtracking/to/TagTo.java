package com.javarush.jira.bugtracking.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagTo {
    private Set<String> tags;
    //private List<String> tags;

}

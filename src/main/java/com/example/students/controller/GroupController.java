package com.example.students.controller;


import com.example.students.model.Group;
import com.example.students.model.dto.request.GroupRequest;
import com.example.students.model.dto.response.GroupResponse;
import com.example.students.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/addWithRequest")
    public Group addGroupWithRequest(@RequestBody GroupRequest groupRequest) {
        Group group = groupService.addGroupWithRequest(groupRequest);
        return group;
    }

    @GetMapping("/getAll")
    public List<GroupResponse> getAll( ){
         return groupService.getAllByGroup();
    }

}

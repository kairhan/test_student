package com.example.students.service;

import com.example.students.model.Group;
import com.example.students.model.dto.request.GroupRequest;
import com.example.students.model.dto.response.GroupResponse;

import java.util.List;


public interface GroupService {

    Group addGroupWithRequest(GroupRequest groupRequest);
     List<GroupResponse> getAllByGroup();


}

package com.example.students.service.impl;
import com.example.students.model.Group;
import com.example.students.model.dto.request.GroupRequest;
import com.example.students.model.dto.response.GroupResponse;
import com.example.students.repository.GroupRepository;
import com.example.students.service.GroupService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImp implements GroupService {
    private final GroupRepository groupRepository;


    public GroupServiceImp(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    @Override
    public Group addGroupWithRequest(GroupRequest groupRequest) {
        Group group = new Group();
        group.setName(groupRequest.getName());
        groupRepository.save(group);
        return group;
    }

    @Override
    public List<GroupResponse> getAllByGroup(){
        return convertGroupListToResponse(groupRepository.findAll());
    }


    private List<GroupResponse> convertGroupListToResponse(List<Group> groupList){
        List<GroupResponse> groupResponseList = new ArrayList<>();
        for(Group group : groupList){
            GroupResponse groupResponse = convertGroupToResponse(group);
            groupResponseList.add(groupResponse);
        }
        return groupResponseList;
    }

    private GroupResponse convertGroupToResponse(Group group){
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setId(group.getId());
        groupResponse.setName(group.getName());
        return groupResponse;
    }

}

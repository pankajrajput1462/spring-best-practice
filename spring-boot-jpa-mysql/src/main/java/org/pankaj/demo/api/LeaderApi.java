package org.pankaj.demo.api;

import org.pankaj.demo.model.leader.Leader;
import org.pankaj.demo.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LeaderApi {

    @Autowired
    private LeaderService leaderService;

    @GetMapping("/leaders")
    List<Leader> leaders() {
        final List<Leader> leaders = leaderService.getAllLeaderList();
        final boolean empty = CollectionUtils.isEmpty(leaders);
        if (empty) {
            return new ArrayList<>();
        }
        return leaders;
    }

    @GetMapping("/aleaders")
    Leader addLeaders() {
        return leaderService.saveLeader();
    }
}

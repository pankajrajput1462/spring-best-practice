package com.pankaj.topic;

import com.google.common.collect.Lists;
import com.pankaj.core.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    Collection<Topic> getAllTopics() {
        return Lists.newArrayList(topicRepository.findAll());
    }

    @GetMapping("topicName/{topicName}")
    Collection<Topic> getTopicByTopicName(@PathVariable String topicName) {
        return topicRepository.findByTopicName(topicName);
    }

    @GetMapping( "topicId/{topicId}")
    Topic getTopicById(@PathVariable Long topicId) {
        return Util.findOneById(topicRepository, topicId);
    }

    @PostMapping
    ResponseEntity<?> addTopic(@RequestBody Topic topic) {
        if (Util.save(topicRepository, new Topic(topic.getTopicName(), topic.getQuestionCount())) != null) {
            return Util.createResponseEntity("Successful creation of a resource", HttpStatus.CREATED);
        }
        return Util.createResponseEntity("Error creating resource", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("topicId/{topicId}")
    ResponseEntity<?> updateTopic(@RequestBody Topic topic, @PathVariable long topicId) {
        Topic newTopic = Util.findOneById(topicRepository, topicId);
        if (newTopic != null) {
            newTopic.setTopicName(topic.getTopicName());
            newTopic.setQuestionCount(topic.getQuestionCount());
            if (Util.save(topicRepository, newTopic).getId().equals(topicId)) {
                return Util.createResponseEntity("Data updated successfully", HttpStatus.OK);
            }
        }
        return Util.createResponseEntity("Error updating data", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("topicId/{topicId}")
    ResponseEntity<?> deleteTopic(@PathVariable long topicId) {
        try {
            topicRepository.delete(topicId);
            return Util.createResponseEntity("Data deleted successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return Util.createResponseEntity("Resource not found", HttpStatus.NOT_FOUND);
        }
    }

}

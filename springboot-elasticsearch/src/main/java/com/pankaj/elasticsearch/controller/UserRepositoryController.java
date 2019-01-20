package com.pankaj.elasticsearch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.elasticsearch.dao.UserRepository;
import com.pankaj.elasticsearch.model.User;

/**
 * This class is to demo how ElasticsearchRepository can be used to Save/Retrieve/Delete
 */
@RestController
@RequestMapping("/repo")
public class UserRepositoryController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/all")
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
//        userRepository.findAll().forEach(users::add);
        return users;
    }

    @RequestMapping("/id/{userId}")
    public User getUser(@PathVariable String userId) {
        LOG.info("Getting user with ID: {}", userId);
        Optional<User> user = userRepository.findById(userId);
        LOG.info("User with ID: {} is {}", userId, user);
        return user.get();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public User addNewUsers(@RequestBody User user) {
        LOG.info("Adding user : {}", user);
        userRepository.save(user);
        LOG.info("Added user : {}", user);
        return user;
    }

    @RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
    public Object getAllUserSettings(@PathVariable String userId) {

        Optional<User> user = userRepository.findById(userId);
        if (user != null) {
            return user.get().getUserSettings();
        } else {
            return "User not found.";
        }
    }

    @RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
    public String getUserSetting(
            @PathVariable String userId, @PathVariable String key) {
        Optional<User> user = userRepository.findById(userId);
        if (user != null) {
            return user.get().getUserSettings().get(key);
        } else {
            return "User not found.";
        }
    }

    @RequestMapping(value = "/settings/{userId}/{key}/{value}", method = RequestMethod.GET)
    public String addUserSetting(
            @PathVariable String userId,
            @PathVariable String key,
            @PathVariable String value) {
        Optional<User> user = userRepository.findById(userId);
        if (user != null) {
            user.get().getUserSettings().put(key, value);
            userRepository.save(user.get());
            return "Key added";
        } else {
            return "User not found.";
        }
    }
}

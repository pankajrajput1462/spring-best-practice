package com.pankaj.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.pankaj.elasticsearch.model.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {
}

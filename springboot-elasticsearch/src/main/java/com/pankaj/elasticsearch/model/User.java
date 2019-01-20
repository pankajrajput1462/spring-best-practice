package com.pankaj.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "my_index", type = "user")
public class User {

    @Id
    private String userId;
    private String name;
    private Date creationDate = new Date();
    private Map<String, String> userSettings = new HashMap<>();

   
}

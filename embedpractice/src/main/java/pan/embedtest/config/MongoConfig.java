package pan.embedtest.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@Configuration
public class MongoConfig {
    private static final String MONGO_DB_URL = "localhost";
    private static final String MONGO_DB_NAME = "embeded_db";
    @Bean
    public MongoTemplate mongoTemplate() throws IOException {

        MongoTemplate mongoTemplate = new MongoTemplate("");
        return mongoTemplate;
    }
}

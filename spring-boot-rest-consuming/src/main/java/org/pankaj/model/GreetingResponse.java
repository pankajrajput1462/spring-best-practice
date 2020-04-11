package org.pankaj.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GreetingResponse {
    private final long id;
    private final String content;
}

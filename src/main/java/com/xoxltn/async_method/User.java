package com.xoxltn.async_method;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String name;
    private String blog;
    private String id;
    private String location;

    @Override
    public String toString() {
        return "{" +
            "\"name\": \"" + name + '\"' +
            ", \"blog\": \"" + blog + '\"' +
            ", \"id\": \"" + id + '\"' +
            ", \"location\": \"" + location + '\"' +
            '}';
    }
}

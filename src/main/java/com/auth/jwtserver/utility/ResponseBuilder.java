package com.auth.jwtserver.utility;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {
    
    public static ResponseEntity<Object> build(HttpStatus httpStatus, String error, String message, Object data) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("timestamp", Instant.now());
        response.put("status", httpStatus.value());
        response.put("error", error);
        response.put("message", message);
        response.put("data", data);

        return new ResponseEntity<>(response, httpStatus);
    }
}

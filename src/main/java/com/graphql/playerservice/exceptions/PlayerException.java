package com.graphql.playerservice.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;
import java.util.Map;

public class PlayerException extends RuntimeException implements GraphQLError {

    private String message;
    public PlayerException(String message) {
        super(message);
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }
    @Override
    public Map<String, Object> getExtensions() {
        return null;
    }
    @Override
    public ErrorType getErrorType() {
        return null;
    }
}

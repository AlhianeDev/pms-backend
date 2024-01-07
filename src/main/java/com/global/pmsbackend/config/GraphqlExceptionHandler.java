package com.global.pmsbackend.config;

import com.global.pmsbackend.exceptions.ResourceNotFoundException;

import graphql.GraphQLError;

import graphql.GraphqlErrorBuilder;

import graphql.schema.DataFetchingEnvironment;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;

import org.springframework.graphql.execution.ErrorType;

import org.springframework.stereotype.Component;

@Component
public class GraphqlExceptionHandler

    extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(

        Throwable ex, DataFetchingEnvironment env

    ) {

        if (ex instanceof ResourceNotFoundException) {

            ErrorType errorType;

            if(((ResourceNotFoundException) ex).getStatusCode()==400){

                errorType = ErrorType.BAD_REQUEST;

                return graphQLError(errorType, (ResourceNotFoundException) ex, env);

            }

            if(((ResourceNotFoundException) ex).getStatusCode()==404){

                errorType = ErrorType.NOT_FOUND;

                return graphQLError(errorType, (ResourceNotFoundException) ex, env);

            }

            else {

                return GraphqlErrorBuilder.newError().build();

            }

        } else {

            return GraphqlErrorBuilder.newError().build();

        }

    }

    private GraphQLError graphQLError(

        ErrorType errorType,

        ResourceNotFoundException ex,

        DataFetchingEnvironment env)

    {

        return GraphqlErrorBuilder.newError()

                .errorType(errorType)

                .message(ex.getMessage())

                .path(env.getExecutionStepInfo().getPath())

                .location(env.getField().getSourceLocation())

        .build();

    }

}

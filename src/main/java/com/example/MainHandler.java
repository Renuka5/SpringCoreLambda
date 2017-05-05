package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.example.model.Request;
import com.example.model.Response;
import com.example.Wrapper.SpringRequestHandler;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * This is the main entry point for your Lambda function. If you were to
 * run this on AWS, your handler path would be the fully qualified class
 * name, com.example.MainHandler.
 * <p>
 * Note that this class doesn't contain any logic itself and exists solely
 * to provide the application context. That's because the method
 * {@link SpringRequestHandler#handleRequest(Object, Context)} actually
 * uses the provided application context to find a bean of type
 * {@link com.amazonaws.services.lambda.runtime.RequestHandler},
 * and calls it's "handleRequest" method given the input object.
 * <p>
 * Of course, you are free to override the "handleRequest" method if you
 * want to, however this default pattern should work for most use cases.
 * <p>
 * The generic type parameters for this class represent the input and
 * output types of your
 * {@link com.amazonaws.services.lambda.runtime.RequestHandler} bean.
 * These MUST match otherwise you will run into a runtime error.
 * <p>
 * If you prefer more to deal with the raw input/output streams themselves,
 * rather than using Lambda to convert them to POJOs, take a look at
 * {@link com.spring.aws.lambda.SpringRequestStreamHandler}.
 *
 * @author Chris Campo
 */
public class MainHandler extends SpringRequestHandler<Map<String,String>, Response> {

    /**
     * Here we create the Spring {@link ApplicationContext} that will
     * be used throughout our application.
     */
    private static final ApplicationContext context =
            new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

    @Override
    public ApplicationContext getApplicationContext() {
    	System.out.println("This is main handler");
        return context;
    }
}

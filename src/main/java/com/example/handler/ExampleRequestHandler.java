package com.example.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.example.model.Request;
import com.example.model.Response;
import com.example.service.ExampleServiceA;
import com.example.service.ExampleServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * Our Lambda function's main logic takes place here, while we
 * leverage Spring's dependency injection features to inject the
 * services we need at construction time.
 *
 * This class is declared as a bean using the {@link Component}
 * annotation. You could also just as easily register it in the
 * {@link com.example.ApplicationConfiguration} class, or
 * in a Spring application configuration XML file.
 *
 * @author Chris Campo
 */
@Component
public class ExampleRequestHandler implements RequestHandler<Map<String,String>, Response> {

    private final ExampleServiceA exampleServiceA;
    private final ExampleServiceB exampleServiceB;

    /**
     * Dependency injection is handled via autowiring!
     */
    @Autowired
    public ExampleRequestHandler(final ExampleServiceA exampleServiceA, final ExampleServiceB exampleServiceB) {
    	System.out.println("This is constructor call for ex handler");
        this.exampleServiceA = Objects.requireNonNull(exampleServiceA, "exampleServiceA");
        this.exampleServiceB = Objects.requireNonNull(exampleServiceB, "exampleServiceB");
    }

    @Override
    public Response handleRequest(final Map<String,String> input, final Context context) {
    	System.out.println("This is handle req call for ex handler");
        final String responseMessage = "Request message: " + input.get("msg")
                + ", Service A message: " + exampleServiceA.getMessage()
                + ", Service B message: " + exampleServiceB.getMessage();
        final Response response = new Response();
        response.setMessage(responseMessage);
        response.setStatus(Response.Status.OK);
        System.out.println(response.getMessage()+"  "+response.getStatus());
        return response;
    }
}

package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import com.example.handler.ExampleRequestHandler;
import com.example.model.Request;
import com.example.model.Response;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoFrameGitApplicationTests {
	Map<String,String> input;
	
	    @Test
	    public void testHandle() {
	    	final MainHandler handler= new MainHandler();
	       // final Request request = new Request();
	       // request.setMessage("Hello world!");
	    	input = new HashMap<String,String>();
	    	input.put("msg", "Hi There!! This is a hello msg");
	        final Response response = handler.handleRequest(input, null);
	        assertThat(response).isNotNull();
	    }	

}

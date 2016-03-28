package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

 //   @CrossOrigin(origins = "http://localhost:9000", maxAge = 3600)
 //   @CrossOrigin(origins = "http://localhost:9000")
 /*   @CrossOrigin(
    		origins = "http://localhost:9000",
    		allowCredentials="true", 
    		maxAge = 3600,
    		methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.DELETE},
    	    allowedHeaders={"x-requested-with", "accept", "authorization", "content-type"}, 
    	    exposedHeaders={"access-control-allow-headers", "access-control-allow-methods", "access-control-allow-origin", "access-control-max-age", "X-Frame-Options"})
*/    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}

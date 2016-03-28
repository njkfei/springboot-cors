package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting")
               //.allowedOrigins("http://127.0.0.1:9000")
                .allowedOrigins("http://127.0.0.1")
               // .allowedOrigins("*")
    			.allowedMethods("PUT", "DELETE","GET","POST")
    			.allowedHeaders("x-requested-with",
    					"accept", 
    					"authorization",
    					"content-type")
    			.exposedHeaders("access-control-allow-headers", 
    					"access-control-allow-methods", 
    					"access-control-allow-origin", 
    					"access-control-max-age", 
    					"X-Frame-Options")
    			.allowCredentials(false).maxAge(3600);
            }
        };
    }
}

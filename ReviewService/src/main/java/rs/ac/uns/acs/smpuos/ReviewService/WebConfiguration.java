package rs.ac.uns.acs.smpuos.ReviewService;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200") // Replace with your Angular app's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
                //.allowCredentials(true);
    }
}

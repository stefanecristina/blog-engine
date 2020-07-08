package stefane;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class Application
    implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
  public static void main(String[] args) {
    org.springframework.boot.SpringApplication.run(Application.class, args); }
  public void addResourceHandlers(
      org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
  }
}

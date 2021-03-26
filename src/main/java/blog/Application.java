package blog;

import org.springframework.beans.factory.annotation.Value;

@org.springframework.data.jpa.repository.config.EnableJpaRepositories
@org.springframework.boot.autoconfigure.SpringBootApplication
public class Application
    implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
  public static void main(String[] args) {
    org.springframework.boot.SpringApplication.run(Application.class, args); }
  public void addResourceHandlers(
      org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
  }

  private final static org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Application.class);

  @Value("${spring.application.name}") private String appName;
  @Value("${server.port}") private String serverPort;
  @Value("${server.servlet.context-path}") private String webContextPath;

  @javax.annotation.PostConstruct
  public void init() {
    LOGGER.info("Starting '{}' on port {} (Web Context: {}), please wait...",
      this.appName, this.serverPort, this.webContextPath);
  }

}

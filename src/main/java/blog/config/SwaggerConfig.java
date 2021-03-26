package blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import blog.controller.PostController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Profile("!prod")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${info.app.name}")
  private String name;

  @Value("${info.app.description}")
  private String description;

  @Value("${info.app.version}")
  private String version;

  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select().apis(RequestHandlerSelectors.basePackage(
        PostController.class.getPackage().getName()))
      .paths(PathSelectors.any()).build().apiInfo(
         new ApiInfoBuilder()
           .title(this.name)
           .version(this.version)
           .description(this.description.trim())
             .build());
  }

}

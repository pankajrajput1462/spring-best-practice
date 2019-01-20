package pl.piomin.microservices.advanced.account.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
public class AppConfig {
/*
    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
*/

   /* @Bean
    public Docket api() throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.piomin.microservices.advanced.account.api"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfo("Account Service Api Documentation", "Documentation automatically generated", model.getParent().getVersion(), null, new Contact("Piotr Mińkowski", "piotrminkowski.wordpress.com", "piotr.minkowski@gmail.com"), null, null));
    }*/
}

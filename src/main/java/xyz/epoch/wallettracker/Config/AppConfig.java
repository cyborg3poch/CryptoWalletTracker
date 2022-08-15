package xyz.epoch.wallettracker.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import xyz.epoch.wallettracker.Model.APIListResponseModel;
import xyz.epoch.wallettracker.Model.APIStringResponseModel;

import javax.sql.DataSource;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "xyz.epoch.wallettracker")
@EnableScheduling
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver VewResolver ()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public RestTemplate getRestTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        return restTemplate ;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate()
    {
        return  new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource()
    {
        String url ="jdbc:mysql://localhost:3306/epochwallettracker";
        String Username = "root";
        String password = "Shivjee2011@";

        DataSource dataSource = null;



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dataSource = new DriverManagerDataSource(url,Username , password);
        } catch (Exception ex )
        {
            System.out.println(ex.getMessage());
        }


        return  dataSource  ;
    }

    @Bean
    APIListResponseModel getEthScanAPIListResponseModel()
    {
        return new APIListResponseModel();
    }

    @Bean
    APIStringResponseModel getEthScanAPIStringResponseModel()
    {
        return new APIStringResponseModel();
    }

    @Bean
    public PasswordEncoder getpasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:");
    }

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

//        javaMailSender.setProtocol("SMTP");
//        javaMailSender.setHost("127.0.0.1");
//        javaMailSender.setPort(25);

        return javaMailSender;
    }

}

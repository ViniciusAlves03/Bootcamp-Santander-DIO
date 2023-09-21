import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("{noop}user123")
            .roles("USERS")
            .and()
            .withUser("admin")
            .password("{noop}user123")
            .roles("MANAGERS");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .requestMatchers("/admin/**").hasRole("MANAGERS")
            .requestMatchers("/user/**").hasRole("USERS")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
    }
}

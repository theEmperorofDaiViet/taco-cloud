package tacos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
				.withUser("holo")
				.password(encoder.encode("thewisewolf"))
				.authorities("ROLE_USER")
			.and()
				.withUser("mai")
				.password(encoder.encode("bunnygirlsenpai"))
				.authorities("ROLE_USER");
		System.out.println(org.springframework.security.core.SpringSecurityCoreVersion.getVersion());
	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/design", "/orders").hasRole("USER")
				.antMatchers("/", "/**").permitAll()
			.and()
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/design", true)
			.and()
				.logout().logoutSuccessUrl("/");
	}
	
}

package tacos.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.ldapAuthentication()
			.userSearchBase("ou=people")
			.userSearchFilter("(uid={0})")
			.groupSearchBase("ou=roles")
			.groupSearchFilter("member={0}")
			.passwordCompare()
			.passwordEncoder(encoder)
			.passwordAttribute("userPassword")
			.and()
			.contextSource()
				.root("dc=tacocloud2,dc=com")
				.ldif("classpath:users.ldif");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/design", "/orders").permitAll()
				.antMatchers("/", "/**").permitAll()
			.and()
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/design", true)
			.and()
				.logout().logoutSuccessUrl("/");
	}
	
}

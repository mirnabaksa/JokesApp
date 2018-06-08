package app; 
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()		
				.antMatchers("/new").hasRole("USER")			
				.and()
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.defaultSuccessUrl("/")
				.and()
			.logout()
				.logoutSuccessUrl("/");
		
				
			
	}

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("pperic").password("{noop}pero").roles("USER").build());
		manager.createUser(User.withUsername("iivic").password("{noop}ivan").roles("USER").build());
		return manager;
	}
	
}
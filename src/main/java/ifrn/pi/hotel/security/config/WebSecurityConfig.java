package ifrn.pi.hotel.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/user/formUsuario").permitAll()
				.antMatchers("/user/us").permitAll()
				.antMatchers("/quarto/room").hasAnyRole("FUNCIONARIO", "USUARIO")
				.antMatchers("/quarto/formQuarto").hasRole("FUNCIONARIO")
				.antMatchers("/quarto/{id}").hasRole("FUNCIONARIO")
				.antMatchers("/user/us").hasRole("FUNCIONARIO")
				.antMatchers("/hotel/listaReserva").hasRole("FUNCIONARIO")
				.antMatchers("/user/{id}").hasRole("FUNCIONARIO")
				.antMatchers("/user/{id}").hasRole("USUARIO")
				.antMatchers("/quarto/room").hasRole("USUARIO")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll();
	}

}

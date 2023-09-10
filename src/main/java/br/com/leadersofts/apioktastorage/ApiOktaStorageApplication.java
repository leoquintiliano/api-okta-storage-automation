package br.com.leadersofts.apioktastorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiOktaStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiOktaStorageApplication.class, args);
	}
		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")
							.allowedOrigins("*")
//							.allowedOrigins("http://localhost:3000")
//							.allowedOrigins("http://localhost:4200")
//							.allowedOrigins("https://app-okta-storage-automation-50c87ba42d16.herokuapp.com")
							.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");

					registry.addMapping("/veiculo/**")
							.allowedOrigins("*")
//							.allowedOrigins("http://localhost:3000")
//							.allowedOrigins("http://localhost:4200")
//							.allowedOrigins("https://app-okta-storage-automation-50c87ba42d16.herokuapp.com/")
							.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");

					registry.addMapping("/observacao/**")
							.allowedOrigins("*")
							.allowedMethods("GET","POST","PUT","DELETE");

					registry.addMapping("/estoque/**")
							.allowedOrigins("*")
							.allowedMethods("GET","POST", "PUT", "OPTIONS", "HEAD", "TRACE", "CONNECT");
//							.allowedHeaders("");

			}

		};
	}

}

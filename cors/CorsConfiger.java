import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfiger {
	private CorsConfiguration buildCorsConfiger() {
		CorsConfiguration corsc = new CorsConfiguration();
		corsc.addAllowedOrigin("*");
		corsc.addAllowedMethod("*");
		corsc.addAllowedHeader("*");
		return corsc;
	}
	
	//配置
	@Bean
	public CorsFilter getCorsFilter() {
		UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
		configSource.registerCorsConfiguration("/**", buildCorsConfiger());
		CorsFilter corsf = new CorsFilter(configSource );
		return corsf;
	}
}

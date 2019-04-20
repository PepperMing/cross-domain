import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/*
	cors 是spring从4.0以后才提供这样的支持的。
	使用的方式很简单
	第一种情况，如果想要对某一接口配置 CORS，可以在方法上添加 CrossOrigin 注解：
	@CrossOrigin(origins = {"http://localhost:9000", "null"})

	第二种情况，如果想对一系列接口添加 CORS 配置，可以在类上添加注解，对该类声明所有接口都有效：
	@CrossOrigin(origins = {"http://localhost:9000", "null"})

	以下是第三种方式，即添加全局配置，这个时候需要添加一个配置类。
	虽然官方说明有两种方式，
	1. 直接实现WebMvcConfigurer接口
	2. 继承WebMvcConfigurationSupport
	但是其本质上都是操控 CorsConfiguration 类
 */
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

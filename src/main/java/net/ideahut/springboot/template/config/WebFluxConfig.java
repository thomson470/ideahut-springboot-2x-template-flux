package net.ideahut.springboot.template.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.resource.VersionResourceResolver;

import net.ideahut.springboot.admin.AdminHandler;
import net.ideahut.springboot.config.WebFluxBasicConfig;
import net.ideahut.springboot.mapper.DataMapper;

@Configuration
@EnableWebFlux
class WebFluxConfig extends WebFluxBasicConfig {
	
	private final DataMapper dataMapper;
	private final AdminHandler adminHandler;
	
	@Autowired
	WebFluxConfig(
		DataMapper dataMapper,
		AdminHandler adminHandler
	) {
		this.dataMapper = dataMapper;
		this.adminHandler = adminHandler;
	}
	
	@Override
	protected DataMapper dataMapper() {
		return dataMapper;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (adminHandler.isWebEnabled()) {
			registry
			.addResourceHandler(adminHandler.getWebPath() + "/**")
			.addResourceLocations(adminHandler.getWebLocation())
			.setCacheControl(CacheControl.maxAge(60, TimeUnit.DAYS))
	        .resourceChain(false)
	        .addResolver(new VersionResourceResolver().addContentVersionStrategy(adminHandler.getWebPath() + "/**"));
		}
		super.addResourceHandlers(registry);
	}
	
}

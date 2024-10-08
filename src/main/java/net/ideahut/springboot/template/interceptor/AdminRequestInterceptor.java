package net.ideahut.springboot.template.interceptor;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.server.ServerWebExchange;

import net.ideahut.springboot.admin.AdminHandler;
import net.ideahut.springboot.admin.AdminProperties;
import net.ideahut.springboot.admin.WebFluxAdminSecurity;
import net.ideahut.springboot.audit.AuditInfo;
import net.ideahut.springboot.interceptor.WebFluxHandlerInterceptor;
import net.ideahut.springboot.object.MapStringObject;
import net.ideahut.springboot.security.SecurityCredential;
import net.ideahut.springboot.security.SecurityUser;
import net.ideahut.springboot.security.WebFluxSecurityAuthorization;
import net.ideahut.springboot.template.AppConstants;
import net.ideahut.springboot.util.WebFluxUtil;
import reactor.core.publisher.Mono;

@Component
public class AdminRequestInterceptor implements WebFluxHandlerInterceptor, InitializingBean {

	private Set<String> allowPaths;
	private Set<String> skipPaths;

	private final AdminHandler adminHandler;
	private final WebFluxSecurityAuthorization adminSecurity;
	private final SecurityCredential adminCredential;
	
	@Autowired
	AdminRequestInterceptor(
		AdminHandler adminHandler,
		@Qualifier(AppConstants.Bean.Security.ADMIN) WebFluxSecurityAuthorization adminSecurity,
		@Qualifier(AppConstants.Bean.Credential.ADMIN) SecurityCredential adminCredential
	) {
		this.adminHandler = adminHandler;
		this.adminSecurity = adminSecurity;
		this.adminCredential = adminCredential;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		AdminProperties props = adminHandler.getProperties();
		allowPaths = new LinkedHashSet<>(Arrays.asList(
			props.getApi().getRequestPath() + "/**",
			props.getResource().getRequestPath() + "/**"		
		));
		skipPaths = new LinkedHashSet<>();
	}
	
	@Override
	public Set<String> allowPaths() {
		return allowPaths;
	}

	@Override
	public Set<String> skipPaths() {
		return skipPaths;
	}

	@Override
	public Mono<Void> preHandle(ServerWebExchange exchange, Object handler) {
		Mono<Void> mono = adminSecurity.isRequestAuthorized(exchange);
		if (mono != null) {
			return mono;
		}
		if (handler == null) {
			ServerHttpRequest request = exchange.getRequest();
			String path = request.getPath().pathWithinApplication().value();
			Map<String, List<String>> parameters = WebFluxUtil.getRequestParameters(request);
			String redirect = adminHandler.getRedirect(adminCredential, path, parameters, null);
			if (redirect != null) {
				ServerHttpResponse response = exchange.getResponse();
				response.getHeaders().set(HttpHeaders.LOCATION, redirect);
				response.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
				return Mono.empty();
			}
		} else if (handler instanceof HandlerMethod) {
			String key = adminSecurity instanceof WebFluxAdminSecurity ? ((WebFluxAdminSecurity) adminSecurity).getHeaderKey() : HttpHeaders.AUTHORIZATION;
			SecurityUser user = adminCredential.getSecurityUser(
				new MapStringObject().setValue(
					SecurityUser.Parameter.AUTHORIZATION, 
					exchange.getRequest().getHeaders().getFirst(key)
				)
			);
			if (user != null) {
				AuditInfo.context().setAuditor("ADMIN::" + user.getUsername());
			}
		}
		return null;
	}

}

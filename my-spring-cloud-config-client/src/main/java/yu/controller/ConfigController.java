package yu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段.
public class ConfigController {
	
	@Value(value="${user.username}")
	private String username;
	
	@RequestMapping("/show")
	public String showConfig() {
		return "this username is get from romote server!username=" + username;
	}

}

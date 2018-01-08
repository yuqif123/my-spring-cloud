package yu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${app.name}")
	private String appName;
	
	@RequestMapping("/hello")
	public String show(@RequestParam String name) {
		return "this is " + appName + ",name is " + name;
	}

}

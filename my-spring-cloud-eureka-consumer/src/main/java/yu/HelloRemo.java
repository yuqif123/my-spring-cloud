package yu;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="eureka-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemo {
	
	@RequestMapping("/hello")
	public String hello(@RequestParam(value="name") String name);
}

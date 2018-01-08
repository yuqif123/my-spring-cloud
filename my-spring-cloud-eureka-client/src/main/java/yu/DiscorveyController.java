package yu;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscorveyController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/show")
	public String showService() {
		List<String> serviceIds = discoveryClient.getServices();
		StringBuilder builder = new StringBuilder();
		if(serviceIds.size() > 0) {
			for(String id : serviceIds) {
				List<ServiceInstance> instances = discoveryClient.getInstances(id);
				if(!CollectionUtils.isEmpty(instances)) {
					for(ServiceInstance instance : instances) {
						builder.append(instance.getServiceId() + ",host=" + instance.getHost()
						+ ",port=" + instance.getPort() + ",uri=" + instance.getUri());
					}
				}
			}
		}
		return builder.toString();
	}

}

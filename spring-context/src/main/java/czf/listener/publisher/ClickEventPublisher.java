package czf.listener.publisher;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.stereotype.Component;

/**
 * @author czf
 * @Date 2020/4/30 5:28 下午
 */
@Component("clickEventPublisher")
public class ClickEventPublisher implements EventPublisher<ApplicationEvent>, ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public void publishEvent(ApplicationEvent event) {
		applicationContext.publishEvent(event);
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}

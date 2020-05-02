package czf.listener;

import czf.listener.config.Config;
import czf.listener.event.ClickEvent;
import czf.listener.publisher.ClickEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author czf
 * @Date 2020/4/30 5:37 下午
 */
public class ClickTest {
	public static void main(String[] args) {
		// 搞到一个时间发布器
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		ClickEventPublisher clickEventPublisher = (ClickEventPublisher) context.getBean("clickEventPublisher");
		clickEventPublisher.publishEvent(new ClickEvent(ClickTest.class,"double-click","czf"));
	}
}

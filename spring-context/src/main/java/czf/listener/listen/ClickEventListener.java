package czf.listener.listen;

import czf.listener.event.ClickEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author czf
 * @Date 2020/4/30 5:34 下午
 */
@Component
public class ClickEventListener implements SmartApplicationListener {
	/**
	 * 支持的事件类型
	 * @param eventType the event type (never {@code null})
	 * @return
	 */
	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return eventType == ClickEvent.class;
	}


	/**
	 * 支持的事件源类型
	 * @param sourceType the source type, or {@code null} if no source
	 * @return
	 */
	@Override
	public boolean supportsSourceType(Class<?> sourceType) {
		return true;
	}

	/**
	 * 事件触发过程逻辑
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// 业务逻辑
		ClickEvent clickEvent = (ClickEvent) event;
		System.out.println("用户"+clickEvent.getClickerName()+"触发了事件:"+clickEvent.getEventType());
	}

	/**
	 * 多个事件同时触发时，该事件的优先级
	 * @return
	 */
	@Override
	public int getOrder() {
		return 0;
	}
}

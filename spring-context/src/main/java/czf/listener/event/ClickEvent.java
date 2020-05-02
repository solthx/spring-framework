package czf.listener.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author czf
 * @Date 2020/4/30 5:21 下午
 */
public class ClickEvent extends ApplicationEvent {
	// 事件发生的参数
	private String eventType;
	private String clickerName;
	private static final long serialVersionUID = 7099057708183571937L;

	/**
	 * @param source 消息源
	 * @param eventType click类型
	 * @param clickerName 触发click的用户的名字
	 */
	public ClickEvent(Object source, String eventType, String clickerName) {
		super(source);
		this.eventType = eventType;
		this.clickerName = clickerName;
	}

	public String getClickerName() {
		return clickerName;
	}

	public void setClickerName(String clickerName) {
		this.clickerName = clickerName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
}

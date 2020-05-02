package czf.listener.publisher;

/**
 * @author czf
 * @Date 2020/4/30 5:32 下午
 */
public interface EventPublisher<T> {
	void publishEvent(T event);
}

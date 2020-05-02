package czf.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author czf
 * @Date 2020/4/27 8:52 下午
 */
@Component
public class TryAware implements ApplicationContextAware, EmbeddedValueResolverAware, BeanNameAware {
	private ApplicationContext applicationContext;
	private StringValueResolver stringValueResolver;

	@Override
	public void setBeanName(String name) {
		System.out.println("注入了"+name);
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// 进行set
		this.applicationContext = applicationContext;
		System.out.println("设置完毕applicationContext");
	}


	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// 进行set
		this.stringValueResolver = resolver;
		// 对其使用
		System.out.println("解析:"+resolver.resolveStringValue("用户名字:${os.masterName}, 年龄:#{20+2}, 系统名称:${os.name}"));
	}
}

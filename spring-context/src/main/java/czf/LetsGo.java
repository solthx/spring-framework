package czf;

import czf.bean.Calculator;
import czf.bean.TryAware;
import czf.bean.testPostProcessor.User;
import czf.config.ConfigImport;
import czf.config.ConfigOfAOP;
import czf.config.ConfigOfAware;
import czf.config.CustomizeBeanDefinitionRegistryPostProcessor;
import czf.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author czf
 * @Date 2020/4/25 11:32 上午
 */

public class LetsGo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
		ApplicationContext annotationContext = new AnnotationConfigApplicationContext(CustomizeBeanDefinitionRegistryPostProcessor.class);
		//		System.out.println("context 启动~");
		//MessageService messageService = context.getBean(MessageService.class);
		//System.out.println(messageService.getMessage());

//		Calculator calculator = (Calculator) annotationContext.getBean("calculator");
//		System.out.println(calculator.cal(1,1));
		User user = (User) annotationContext.getBean("user");
		System.out.println(user);
//		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigImport.class);
//		for(String name:context.getBeanDefinitionNames())
//			System.out.println(name);

	}
}

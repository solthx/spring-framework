package czf.condition;

import czf.bean.testimport.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author czf
 * @Date 2020/4/28 10:23 上午
 */
public class MyImportBeanDefinitionRegistary implements ImportBeanDefinitionRegistrar {
	/**
	 * Register bean definitions as necessary based on the given annotation metadata of
	 * the importing {@code @Configuration} class.
	 *
	 * @param importingClassMetadata 当前标注Import注解的类的所有注解信息
	 * @param registry               current bean definition registry
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean redcondition = registry.containsBeanDefinition("czf.bean.testimport.Red");
		boolean bluecondition = registry.containsBeanDefinition("czf.bean.testimport.Blue");
		if (redcondition && bluecondition){
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			registry.registerBeanDefinition("rainbow",rootBeanDefinition);
		}
	}
}

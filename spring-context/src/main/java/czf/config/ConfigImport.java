package czf.config;

import czf.bean.testimport.Blue;
import czf.bean.testimport.RainBow;
import czf.bean.testimport.Red;
import czf.condition.MyImportBeanDefinitionRegistary;
import czf.condition.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author czf
 * @Date 2020/4/28 10:22 上午
 */
@Configuration
@Import({Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistary.class})
public class ConfigImport {
}

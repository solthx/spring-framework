package czf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author czf
 * @Date 2020/4/27 8:59 下午
 */
@Configuration
@ComponentScan("czf.bean")
@PropertySource("classpath:/config.properties")
public class ConfigOfAware {
}

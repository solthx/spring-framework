package czf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author czf
 * @Date 2020/4/27 11:46 下午
 */
@EnableAspectJAutoProxy
@ComponentScan("czf.bean")
@ComponentScan("czf.aspect")
@Configuration
public class ConfigOfAOP {
}

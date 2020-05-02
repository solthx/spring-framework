package czf.bean;

import org.springframework.stereotype.Component;

/**
 * @author czf
 * @Date 2020/4/27 11:36 下午
 */
@Component("calculator")
public class Calculator {
	public int cal(int x, int y){
		return x/y;
	}
}

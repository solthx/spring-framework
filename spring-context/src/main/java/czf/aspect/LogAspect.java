package czf.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author czf
 * @Date 2020/4/27 11:35 下午
 */
@Aspect
@Component
public class LogAspect {
	@Pointcut("execution(public int czf.bean.Calculator.*(..))")

	public void calculator() {
	}

	@Before("calculator()")
	public void BeforeLog(JoinPoint joinPoint) {
		Object [] args = joinPoint.getArgs();
		System.out.println("开始执行" + joinPoint.getSignature().getName() + "...");
		System.out.println("输入参数为: " + Arrays.asList(args));
	}

	@After("calculator()")
	public void AfterLog(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getDeclaringTypeName() + "执行完毕");
	}

	@AfterReturning(value = "calculator()", returning = "object")
	public void AfterReturningLog(JoinPoint joinPoint, Object object) {
		System.out.println("返回值为：" + object);
	}

	@AfterThrowing(value = "calculator()", throwing = "ex")
	public void ExceptionLog(JoinPoint joinPoint, Exception ex) {
		System.out.println(joinPoint.getSignature().getName() + "出现异常，异常信息：" + ex);
	}

	/**
	 * 环绕通知
	 * 问题：
	 *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
	 * 分析：
	 *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
	 * 解决：
	 *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
	 *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
	 *
	 * spring中的环绕通知：
	 *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
	 */
	@Around("calculator()")
	public Object aroundPringLog(ProceedingJoinPoint pjp){
		Object rtValue = null;
		try{
			Object[] args = pjp.getArgs();//得到方法执行所需的参数

			System.out.println("前置");

			rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

			System.out.println("后置");

			return rtValue;
		}catch (Throwable t){ // 这里必须要用Throwable来捕获！！！Exception捕获不到！！
			System.out.println("异常");
			throw new RuntimeException(t);
		}finally {
			System.out.println("最终");
		}
	}
}
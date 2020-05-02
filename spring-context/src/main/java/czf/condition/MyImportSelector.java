package czf.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author czf
 * @Date 2020/4/28 11:05 上午
 */
public class MyImportSelector implements ImportSelector {
	// 返回值为一个字符串数组，每一个字符串都是一个类的全类名。
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// 因为之后会使用到 xx.length(), 因此不能返回null，否则会出空指针异常
		return new String[]{"czf.bean.testimport.Blue"};
	}
}

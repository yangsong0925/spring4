package example02;

import base.bean.CDPlayer;
import base.bean.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * SpringJUnit4ClassRunner 测试自动创建Spring应用上下文
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * @ContextConfiguration 加载指定配置文件
 *     String[] value() default {};
 *     String[] locations() default {};             XmlConfig  path
 *     Class<?>[] classes() default {};             JavaConfig path
 *     Class<? extends ApplicationContextInitializer<? extends ConfigurableApplicationContext>>[] initializers() default {};
 *     boolean inheritLocations() default true;
 *     boolean inheritInitializers() default true;
 *     Class<? extends ContextLoader> loader() default ContextLoader.class;
 *     String name() default "";
 *
 *  tip: locations classes 不能同时使用。每个@ContextConfiguration注释只允许一个资源声明。
 *
 *     @ContextConfiguration(classes = {example01.config.JavaConfig.class})
 */
@ContextConfiguration(classes = {example02.config.JavaConfig.class})
public class TestJavaConfig {

    @Autowired
    private CompactDisc sgtPeppers;
    @Resource(name = "blankDisc2")
    private CompactDisc sgtPeppers1;
    @Resource(name = "cDPlayer")
    private CDPlayer    cDPlayer;

    @Test
    public  void play(){
        int i = 1/0;
        sgtPeppers.play();
        sgtPeppers1.play();
        System.out.println(cDPlayer);
    }

}

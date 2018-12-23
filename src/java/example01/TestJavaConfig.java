package example01;

import example01.bean.CompactDisc;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringJUnit4ClassRunner 测试自动创建Spring应用上下文
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * @ContextConfiguration 加载指定配置文件
 */
@ContextConfiguration(classes = example01.config.JavaConfig.class,locations = "classpath:example01/resource/XmlConfig.xml")
public class TestJavaConfig {

    @Autowired
    private CompactDisc sgtPeppers;

    @Test
    public  void play(){
        sgtPeppers.play();
    }

}

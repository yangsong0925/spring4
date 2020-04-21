package example03.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author ：yangsong
 * @date ：Created in 2020年4月21日 0021 23:48
 * @description：自定义标签解析器注册
 * @modified By：
 * @version: $
 */
public class MyNameNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
    }
}

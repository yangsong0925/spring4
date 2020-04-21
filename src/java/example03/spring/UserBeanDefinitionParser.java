package example03.spring;

import example03.bean.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author ：yangsong
 * @date ：Created in 2020年4月21日 0021 23:27
 * @description：
 * @modified By：
 * @version: $
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    /**
     * 标签对应的类
     * @param element
     * @return
     */
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");
        // 将提取的数据存放到 BeanDefinitionBuilder 中，待到完成所有bean的解析后统一注册到 beanFactory 中
        if(StringUtils.hasText(userName)){
            builder.addPropertyValue("userName",userName);
        }
        if(StringUtils.hasText(email)){
            builder.addPropertyValue("email",email);
        }


    }
}

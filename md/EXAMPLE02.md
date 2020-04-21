#### bean profile
    bean profile：将所有不同的 bean 定义整理到一个或多个 profile 中，在将应用部署到每个环境时，
        对应的 profile 处于激活（active）的状态。（bean的具体创建 放在运行时决定）。
    
    指定 profile：
        @Profile 注解指定某一个 bean 属于哪一个 profile。
            作用在配置类上：该配置类所创建的 bean 都属于该 profile。
            作用在方法上 @Bean 配合使用：该 bean 属于该 profile。
            
        XmlConfig: xml配置 可以使用 beans标签，beans 标签可以嵌套。  <beans><beans profile="dev"></beans><beans profile="pro"></beans></beans>
            <beans profile="" />           
    
    激活 profile:
        spring.profiles.active： Spring 初始化指定 profile。(优先级高于 profile)
        spring.profiles.default： Spring 默认初始化 profile。
        tip：当以上两个参数均为设置，Spring 只会创建未定义在 profile 中的 bean。
             profile 使用复数形式，同时激活多个 profile，参数间使用逗号隔开。
        
        参数设置方式：
            1. DispatcherServlet 的初始化参数。
            2. Web 应用的上下文参数。
            3. 测试类， @ActiveProfiles 注解设置。
            4. JNDI 条目。
            5. 环境变量。
            6. JVM 的系统参数。
         
         1. 上下文设置默认 profile:
               <context-param>
                   <param-name>spring.profiles.default</param-name>
                   <param-value>dev</param-value>
               </context-param>
               <listener>
                   <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
               </listener>
               
        2. Servlet 设置默认 profil：
            <servlet>
                <servlet-name>serlet-name</servlet-name>
                <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
                <init-param>
                    <param-name>spring.profiles.default</param-name>
                    <param-value>dev</param-value>
                </init-param>
                <load-on-startup>1</load-on-startup>
            </servlet>
               
               
#### bean 创建条件化
    
    @Conditional 根据设置 实现 Condition 的类，matches  的条件计算结果为 true，创建该bean，否则 忽略。
    
        package org.springframework.context.annotation;
        import org.springframework.core.type.AnnotatedTypeMetadata;
        public interface Condition {
            boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);
        }
        
    
        public interface ConditionContext {
            // 返回 BeanDefinitionRegistry 检查 bean 的定义。
            BeanDefinitionRegistry getRegistry();
            
            // ConfigurableListableBeanFactory 检查 bean 是否存在，甚至探查 bean 的属性。
            ConfigurableListableBeanFactory getBeanFactory();
            
            // Environment 检查环境变量是否存在以及值。
            Environment getEnvironment();
            
            // ResourceLoader 所加载的资源。
            ResourceLoader getResourceLoader();
            
            // ClassLoader 加载并检查类是否存在。
            ClassLoader getClassLoader();
        }
        
        public interface AnnotatedTypeMetadata {
            // 判断带有 @Bean 注解的方法是否存在其他特定的注解。
            boolean isAnnotated(String var1);
        
            Map<String, Object> getAnnotationAttributes(String var1);
        
            Map<String, Object> getAnnotationAttributes(String var1, boolean var2);
        
            MultiValueMap<String, Object> getAllAnnotationAttributes(String var1);
        
            MultiValueMap<String, Object> getAllAnnotationAttributes(String var1, boolean var2);
        }


    @Profile 通过 @Conditional + ProfileCondition(Condition 的实现类)
    
        @Retention(RetentionPolicy.RUNTIME)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @Documented
        @Conditional({ProfileCondition.class})
        public @interface Profile {
         String[] value();
        }
        
        ProfileCondition 通过 AnnotatedTypeMetadata 得到 @Profile 注解的所有属性，检查 value 的属性。
        通过 ConditionContext 得到 Environment 来检查 [acceptsProfiles 方法] 该 profile 是否处于激活状态。
        
        class ProfileCondition implements Condition {
            public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
                if (context.getEnvironment() != null) {
                    MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(Profile.class.getName());
                    if (attrs != null) {
                        Iterator var4 = ((List)attrs.get("value")).iterator();
        
                        Object value;
                        do {
                            if (!var4.hasNext()) {
                                return false;
                            }
        
                            value = var4.next();
                        } while(!context.getEnvironment().acceptsProfiles((String[])((String[])value)));
        
                        return true;
                    }
                }
        
                return true;
            }
        }

        
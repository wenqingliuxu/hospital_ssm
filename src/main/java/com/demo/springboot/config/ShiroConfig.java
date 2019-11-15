package com.demo.springboot.config;

import com.demo.springboot.shiro.MyShiroRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 刘旭
 * Date: 2019/11/8 0:49
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("webSecurityManager") DefaultWebSecurityManager webSecurityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(webSecurityManager);
        Map<String, String> map = new HashMap();
       /* map.put("/htindex","authc");
        map.put("/xinneike","perms[heartInfo]");
        map.put("/ganranneike","perms[ganRanInfo]");
        map.put("/erke","perms[childrenInfo]");
        map.put("/shenjingke","perms[shenJingInfo]");
        map.put("/linchuangyingyangke","perms[yingYangInfo]");
        map.put("/myself","perms[singleInfo]");*/
        filterFactoryBean.setFilterChainDefinitionMap(map);
        filterFactoryBean.setLoginUrl("/doctorLogin");//设置登录页
        filterFactoryBean.setUnauthorizedUrl("/unauth");//权限不足的提示页
        return filterFactoryBean;
    }
    //    创建安全管理器
    @Bean("webSecurityManager")
    public DefaultWebSecurityManager defaultSecurityManager(@Qualifier("myRealm") AuthorizingRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        给安全管理器配置权限策略
        securityManager.setRealm(myRealm);
        return securityManager;
    }
    //    自定义认证授权的安全策略
    @Bean("myRealm")
    public MyShiroRealm getMyShiroRealm() {
        return new MyShiroRealm();
    }
    /**
     * 开启Shiro注解(如@RequiresRoles,@RequiresPermissions),
     * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
    /**
     * 开启aop注解支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }


}

package com.example.demo.config;

import com.example.demo.realm.ShiroRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wxl
 */
@Configuration
@Slf4j
public class ShiroConfig {

    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        //修改凭证校验匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法为md5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数
        credentialsMatcher.setHashIterations(2048);
        return credentialsMatcher;
    }


    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(this.credentialsMatcher());
        return shiroRealm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(this.shiroRealm());
        //webSecurityManager.setCacheManager(this.redisCacheManager());
        // webSecurityManager.setSessionManager(this.sessionManager());
        return webSecurityManager;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(this.securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();

        definition.addPathDefinition("/swagger-ui/**", "anon");
        definition.addPathDefinition("/swagger-resources/**", "anon");
        definition.addPathDefinition("/v3/**", "anon");

        definition.addPathDefinition("/images/**", "anon");
        definition.addPathDefinition("/js/**", "anon");
        definition.addPathDefinition("/style/**", "anon");
        definition.addPathDefinition("/unauthorized", "anon");
        definition.addPathDefinition("/auth/login", "anon");
        definition.addPathDefinition("/auth/logout", "anon");
        definition.addPathDefinition("/**", "authc");
        return definition;
    }
}

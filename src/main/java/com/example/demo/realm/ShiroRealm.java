package com.example.demo.realm;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.salt.MyByteSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wxl
 */
@Slf4j

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        log.info("调用认证: " + username);
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));

        // ShiroUser shiroUser = new ShiroUser();
        //BeanUtil.copyProperties(DefaultFilter.user, shiroUser);
        //     log.info("对象为{}", JSON.toJSON(shiroUser));
        if (user != null) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    user,
                    user.getPassword(),
                    new MyByteSource(user.getSalt()),
                    this.getName()
            );
            return simpleAuthenticationInfo;
        }
        return null;
    }
}

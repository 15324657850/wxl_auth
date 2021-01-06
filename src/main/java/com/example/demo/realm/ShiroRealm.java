package com.example.demo.realm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author wxl
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        log.info("调用认证: " + username);
        SysUser user = userDao.selectByName(username);
        ShiroUser shiroUser = new ShiroUser();
        BeanUtil.copyProperties(user, shiroUser);
        log.info("对象为{}", JSON.toJSON(shiroUser));
        if (user != null) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    shiroUser,
                    user.getPassword(),
                    new MyByteSource(user.getSalt()),
                    this.getName()
            );
            return simpleAuthenticationInfo;
        }
        return null;
    }
}

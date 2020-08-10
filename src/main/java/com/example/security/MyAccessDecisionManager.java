package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
@Service
public class MyAccessDecisionManager implements AccessDecisionManager{
    // decide 方法是判定是否拥有权限的决策方法，
    //authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
    //object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
    //configAttributes 为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，
    public void decide(Authentication authentication, Object object,Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,InsufficientAuthenticationException {
        if (configAttributes == null ) throw new AccessDeniedException("对不起，您没有此权限");
        for(ConfigAttribute ca:configAttributes){
            String needRole = ca.getAttribute();
            for(GrantedAuthority userGA:authentication.getAuthorities()) {
                if(needRole.equals(userGA.getAuthority())) {   // ga is user's role.
                    return ;
                }
            }
        }
        throw new AccessDeniedException("no role!!!!");
    }

    public boolean supports(ConfigAttribute arg0) {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean supports(Class<?> arg0) {
        // TODO Auto-generated method stub
        return true;
    }

}

package com.example.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.*;

@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    private AntPathMatcher urlMatcher = new AntPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;


    /**
     * 加载URL权限配置  todo
     */
    private void loadResourceDefine() {
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        atts.add(new SecurityConfig("ROLE_ADMIN"));
        resourceMap.put("/user/test", atts);
        Collection<ConfigAttribute> atts2 = new ArrayList<ConfigAttribute>();
        atts2.add(new SecurityConfig("ROLE_TEST"));
        resourceMap.put("/user/testRole", atts2);
    }

    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        if (resourceMap == null) {
            loadResourceDefine();
        }
        // TODO Auto-generated method stub
        String url = ((FilterInvocation) object).getRequestUrl();
        if (resourceMap != null) {
            Set<String> urlPatternSet = resourceMap.keySet();
            for (String urlPattern : urlPatternSet) {
                if (urlMatcher.match(urlPattern, url)) {
                    return resourceMap.get(urlPattern);
                }
            }
        }
        return null;
    }

    public boolean supports(Class<?> arg0) {
        // TODO Auto-generated method stub
        return true;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // TODO Auto-generated method stub
        return null;
    }


}

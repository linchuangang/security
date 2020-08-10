package com.example.security;

//import com.example.security.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

//https://www.jianshu.com/p/c3b79a625d84
//https://www.cnblogs.com/softidea/p/7068149.html
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//  启用方法级别的权限认证
class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationProvider provider;  //注入我们自己的AuthenticationProvide
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;


//    该类需要继承WebSecurityConfigurerAdapter，重写configure方法，注解
//    @Configuration：为配置文件，自动加载；
//    @EnableWebSecurity：表示开启security权限控制
//    configure(HttpSecurity http)
//http.csrf().disable()      禁用了csrf,支持jsp时需要加此条件
//http.authorizeRequests().xxxxx    开始添加相关条件
//    antMatchers.....为需要过滤的url，即这些地址url都不需要进行权校验
//            .formLogin().loginPage("/login")   定义了默认的登陆地址
//.successHandler.....定义了登陆成功后的处理方法，主要将用户信息放入session等
//            .failureUrl.....定义了失败的url
//            .withObjectPostProcessor......则定义了访问决策器、资源池查询 两个方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
//                .and()
//                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
//                .anyRequest()               // 任何请求,登录后可以访问
//                .authenticated();


//        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
//                .loginPage("/login")           // 设置登录页面
//                .loginProcessingUrl("/login/login")  // 自定义的登录接口
//                .and()
//                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
//                .antMatchers("/login").permitAll()     // 设置所有人都可以访问登录页面
//                .anyRequest()               // 任何请求,登录后可以访问
//                .authenticated()
//                .and()
//                .csrf().disable();          // 关闭csrf防护

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .failureUrl("/login-error").permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
                .and().authorizeRequests()
                .antMatchers("/user/testNo").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("********************************************");
        //1 用户名密码配在代码里
//        auth.inMemoryAuthentication()
//                .withUser("lin").password("123").roles("USER")
//                .and().withUser("admin").password("admin").roles("ADMIN");
        //2 用户名密码校验在另外的逻辑
        auth.authenticationProvider(provider);
    }


}

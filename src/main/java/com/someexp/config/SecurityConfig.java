package com.someexp.config;

import com.someexp.model.SysPermission;
import com.someexp.service.SysPermissionService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    PasswordEncoder passwordEncoder;

    @Resource
    UserDetailsService userDetailsService;

    @Resource
    SysPermissionService sysPermissionService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http.authorizeRequests();
        List<SysPermission> permissionList = sysPermissionService.findAllPermission();
        if (permissionList != null && permissionList.size() > 0) {
            permissionList.stream().forEach(permission ->
                authorizeRequests.antMatchers(permission.getUrl()).hasAnyAuthority(permission.getPermtag())
            );
        }
        authorizeRequests.antMatchers("/login.html").permitAll()
                .antMatchers("/register.html").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/**").fullyAuthenticated()
                .and().formLogin().loginPage("/login.html")
                .and().logout()
                .and().csrf().disable();

    }

}

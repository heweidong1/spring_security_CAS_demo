package com.kgc.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("经过认证类："+s);
        /*封装角色*/
        List<GrantedAuthority> authorities =new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        //在与CAS整合中，该认证类主要得作用就是封装角色，用户验证在cas中先执行，进行验证了

        // 在普通得spring security项目中该类，主要封装了用户得用户名，密码，角色，用于用户验证
        return new User(s,"",authorities);
    }












}

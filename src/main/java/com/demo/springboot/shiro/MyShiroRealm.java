package com.demo.springboot.shiro;

import com.demo.springboot.pojo.Doctor;
import com.demo.springboot.pojo.Permission;
import com.demo.springboot.service.DoctorService;
import com.demo.springboot.service.PermissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 刘旭
 * Date: 2019/11/8 0:28
 * @Version 1.0
 */
public class MyShiroRealm extends AuthorizingRealm {
    private final Logger logger= LogManager.getLogger(MyShiroRealm.class);
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String principal = (String) principalCollection.getPrimaryPrincipal();
        List<Permission> permissions = permissionService.findPermByLoginName(principal);
        if(permissions!=null){
            Set<String> perms=new HashSet<>();
            for (Permission perm:permissions) {
                perms.add(perm.getPerName());
            }
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.setStringPermissions(perms);
            return authorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        Doctor doctor = doctorService.findDoctorByLoginName(principal);
        if(doctor!=null){
            String doctorPwd = doctor.getPwd();
            SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(principal,doctorPwd,this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}

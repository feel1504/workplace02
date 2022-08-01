package com.cy.pj.sys.service.realm;

import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroUserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserDao sysUserDao;
    //获取授权信息并封装返回
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    //设置加密算法（对传过来的密码加密后和数据库密码比对）
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher){
        //构建匹配对象
        HashedCredentialsMatcher cMather = new HashedCredentialsMatcher();
        //设置加密算法
        cMather.setHashAlgorithmName("MD5");
        //设置加密次数
        cMather.setHashIterations(1);
        super.setCredentialsMatcher(cMather);

    }

    //获取用户认证信息并封装返回
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户信息
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        //基于用户信息查询数据库信息
        SysUser user = sysUserDao.findUserByUserName(username);
        //判定用户是否存在
        if(user == null){
            throw new UnknownAccountException();
        }
        //判断用户是否禁用
        if(user.getValid() == 0){
            throw new LockedAccountException();
        }
        //封装用户信息并返回
        //四个参数分别是：用户对象，加密密码，处理过的盐值，realm名字
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),credentialsSalt,getName());
        return info;
    }
}

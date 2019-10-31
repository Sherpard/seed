package org.seedstack.seed.security.fixtures;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.seedstack.seed.security.AuthenticationException;
import org.seedstack.seed.security.AuthenticationInfo;
import org.seedstack.seed.security.AuthenticationToken;
import org.seedstack.seed.security.IncorrectCredentialsException;
import org.seedstack.seed.security.Realm;
import org.seedstack.seed.security.RoleMapping;
import org.seedstack.seed.security.RolePermissionResolver;
import org.seedstack.seed.security.UnknownAccountException;
import org.seedstack.seed.security.UnsupportedTokenException;
import org.seedstack.seed.security.UsernamePasswordToken;
import org.seedstack.seed.security.principals.PrincipalProvider;

public class SchrodingerRealm implements Realm {

    @Override
    public Set<String> getRealmRoles(PrincipalProvider<?> identityPrincipal,
            Collection<PrincipalProvider<?>> otherPrincipals) {
        return Collections.emptySet();
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        if (!(token instanceof UsernamePasswordToken)) {
            throw new UnsupportedTokenException("SchrodingerRealm only supports UsernamePasswordToken");
        }
        UsernamePasswordToken userNamePasswordToken = (UsernamePasswordToken) token;
        
        if (!"cat".equals(userNamePasswordToken.getUsername())) {
            throw new UnknownAccountException("SchrodingerRealm only accepts a cat as username");
        }
        String pw = new String(userNamePasswordToken.getPassword());
        if (!("dead".equals(pw) || "alive".equals(pw))) {
            throw new IncorrectCredentialsException();
        }
        return new AuthenticationInfo(userNamePasswordToken.getUsername(), userNamePasswordToken.getPassword());
    }

    @Override
    public RoleMapping getRoleMapping() {
        return null;
    }

    @Override
    public RolePermissionResolver getRolePermissionResolver() {
        return null;
    }

    @Override
    public Class<? extends AuthenticationToken> supportedToken() {
        return UsernamePasswordToken.class;
    }

}

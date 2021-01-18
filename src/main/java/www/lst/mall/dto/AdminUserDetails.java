package www.lst.mall.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import www.lst.mall.mbg.model.UmsAdmin;
import www.lst.mall.mbg.model.UmsPermission;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * springSecurity 需要的用户详情
 * by：lst
 */
public class AdminUserDetails implements UserDetails {

    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissions;
    public AdminUserDetails(UmsAdmin umsadmin, List<UmsPermission> permissions) {
        this.umsAdmin = umsadmin;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.stream()
                .filter(permission -> permission.getValue()!=null)
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}

package www.lst.mall.service;

import www.lst.mall.mbg.model.UmsAdmin;
import www.lst.mall.mbg.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登入功能
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}

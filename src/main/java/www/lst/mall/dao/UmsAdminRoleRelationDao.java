package www.lst.mall.dao;

import org.springframework.web.bind.annotation.RequestParam;
import www.lst.mall.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台用户与角色管理自定义dao
 * by：lst 2021/1/11
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限（包括+-权限）
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(@RequestParam Long adminId);
}

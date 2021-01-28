package www.lst.mall.service;

import www.lst.mall.dto.PmsProductCategoryParam;
import www.lst.mall.dto.PmsProductCategoryWithChildrenItem;
import www.lst.mall.mbg.model.PmsProductCategory;

import java.util.List;

/**
 *商品分类的service
 * by：lst 2021/1/27
 */

public interface PmsProductCategoryService {

    /**
     * 创建商品分类
     * @param pmsProductCategoryParam
     * @return
     */
    int create(PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * 修改商品分类
     * @param id
     * @param pmsProductCategoryParam
     * @return
     */
    int update(Long id, PmsProductCategoryParam pmsProductCategoryParam);

    /**
     *分页获取商品分类
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 根据id获取商品分类
     * @param id
     * @return
     */
    PmsProductCategory getItem(Long id);

    /**
     * 根据id删除商品分类
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 批量修改商品导航状态
     * @param ids
     * @param navStatus
     * @return
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     *批量修改商品显示状态
     * @param ids
     * @param showStatus
     * @return
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     *以层级形式获取商品分类
     * @return
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}

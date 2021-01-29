package www.lst.mall.service;

import www.lst.mall.dto.PmsProductAttributeCategoryItem;
import www.lst.mall.mbg.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * 商品属性分类service
 * by：lst 2021/1/29
 */
public interface PmsProductAttributeCategoryService {

    /**
     * 创建商品属性分类
     * @param name
     * @return
     */
    int create(String name);

    /**
     * 更新商品属性分类
     * @param id
     * @param name
     * @return
     */
    int update(Long id, String name);

    /**
     * 删除商品属性分类
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 根据id获取商品属性分类详情
     * @param id
     * @return
     */
    PmsProductAttributeCategory getItem(Long id);

    /**
     *获取包含属性的属性分类
     * @return
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();

    /**
     * 分页查询商品属性分类
     * @param pageSize
     * @param pageSum
     * @return
     */
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageSum);
}

package www.lst.mall.dao;

import www.lst.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 自定义商品属性分类Dao
 * by：lst 2021/1/29
 */
public interface PmsProductAttributeCategoryDao {

    /**
     * 获取包含属性的商品属性分类
     * @return
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}

package www.lst.mall.dao;

import org.apache.ibatis.annotations.Param;
import www.lst.mall.dto.ProductAttrInfo;

import java.util.List;

/**
 * 自定义商品属性Dao
 * by：lst 2021/1/29
 */
public interface PmsProductAttributeDao {
    /**
     *获取商品属性信息
     * @param productCategoryId
     * @return
     */
    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);
}

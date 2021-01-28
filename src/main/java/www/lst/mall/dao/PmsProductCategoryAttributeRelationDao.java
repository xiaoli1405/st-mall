package www.lst.mall.dao;

import org.apache.ibatis.annotations.Param;
import www.lst.mall.mbg.model.PmsProductCategoryAttributeRelation;

import java.util.List;

/**
 * 自定义商品分类和属性关系Dao
 * by：lst 2021/1/28
 */
public interface PmsProductCategoryAttributeRelationDao {
    /**
     * 批量创建
     * @param relationList
     */
    void insertList(@Param("list") List<PmsProductCategoryAttributeRelation> relationList);
}

package www.lst.mall.service;

import www.lst.mall.dto.PmsProductCategoryParam;
import www.lst.mall.dto.ProductAttrInfo;
import www.lst.mall.mbg.model.PmsProductAttribute;

import java.util.List;

/**
 * 商品属性管理Service
 * by：lst 2021/1/29
 */
public interface PmsProductAttributeService {

    /**
     * 根据type分页查询商品属性列表信息
     * @param cid
     * @param type
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 创建商品属性
     * @param productCategoryParam
     * @return
     */
    int create(PmsProductCategoryParam productCategoryParam);

    /**
     * 更新商品属性
     * @param id
     * @param productCategoryParam
     * @return
     */
    int update(Long id, PmsProductCategoryParam productCategoryParam);

    /**
     * 批量删除商品属性
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 根据id查询商品信息
     * @param id
     * @return
     */
    PmsProductAttribute getItem(Long id);

    /**
     * 根据商品分类的id获取商品属性及分类
     * @param productCategoryId
     * @return
     */
    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}

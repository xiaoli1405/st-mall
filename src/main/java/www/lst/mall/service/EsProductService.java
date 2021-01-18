package www.lst.mall.service;

import org.springframework.data.domain.Page;
import www.lst.mall.nosql.elasticsearch.document.EsProduct;

import java.util.List;

/**
 * 商品搜索管理service
 * by：lst 2021/1/13
 */
public interface EsProductService {
    /**
     * 从数据库中导入所有商品到ES
     * @return
     */
    int importAll();

    /**
     * 根据id删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字收索名称或者副标题
     * @param keywords
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsProduct> search(String keywords, Integer pageNum, Integer pageSize);
}

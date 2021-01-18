package www.lst.mall.nosql.elasticsearch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import www.lst.mall.nosql.elasticsearch.document.EsProduct;

/**
 * 商品ES操作类
 * by：lst 2021/1/13
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {

    /**
     * 搜索查询
     * @param name      商品名称
     * @param subTile   商品标题
     * @param keywords  商品关键字
     * @param page      分页信息
     * @return
     */

    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTile, String keywords, Pageable page);
}

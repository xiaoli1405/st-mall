package www.lst.mall.dao;

import io.lettuce.core.dynamic.annotation.Param;
import www.lst.mall.nosql.elasticsearch.document.EsProduct;

import java.util.List;

public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id")Long o);
}

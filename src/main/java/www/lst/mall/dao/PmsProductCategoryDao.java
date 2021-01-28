package www.lst.mall.dao;

import www.lst.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

public interface PmsProductCategoryDao {

    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}

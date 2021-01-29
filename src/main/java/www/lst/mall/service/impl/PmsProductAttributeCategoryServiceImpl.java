package www.lst.mall.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.lst.mall.common.api.CommonPage;
import www.lst.mall.common.api.CommonResult;
import www.lst.mall.dao.PmsProductAttributeCategoryDao;
import www.lst.mall.dto.PmsProductAttributeCategoryItem;
import www.lst.mall.mbg.mapper.PmsProductAttributeCategoryMapper;
import www.lst.mall.mbg.model.PmsProductAttributeCategory;
import www.lst.mall.mbg.model.PmsProductAttributeCategoryExample;
import www.lst.mall.service.PmsProductAttributeCategoryService;

import java.util.List;

/**
 * PmsProductAttributeCategoryService的实现类
 * by：lst 2021/1/29
 */
@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {
    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Autowired
    private PmsProductAttributeCategoryDao productAttributeCategoryDao;

    @Override
    public int create(String name) {
        PmsProductAttributeCategory productAttributeCategory = new PmsProductAttributeCategory();
        productAttributeCategory.setName(name);
        return productAttributeCategoryMapper.insertSelective(productAttributeCategory);
    }

    @Override
    public int update(Long id, String name) {
        PmsProductAttributeCategory productAttributeCategory = new PmsProductAttributeCategory();
        productAttributeCategory.setId(id);
        productAttributeCategory.setName(name);
        return productAttributeCategoryMapper.updateByPrimaryKeySelective(productAttributeCategory);
    }

    @Override
    public int delete(Long id) {
        return productAttributeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PmsProductAttributeCategory getItem(Long id) {
        return productAttributeCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PmsProductAttributeCategoryItem> getListWithAttr() {
        return productAttributeCategoryDao.getListWithAttr();
    }

    @Override
    public List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageSum) {
        PageHelper.startPage(pageSum, pageSize);
        return productAttributeCategoryMapper.selectByExample(new PmsProductAttributeCategoryExample());
    }
}

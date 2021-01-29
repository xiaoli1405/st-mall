package www.lst.mall.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.lst.mall.dao.PmsProductAttributeDao;
import www.lst.mall.dto.PmsProductCategoryParam;
import www.lst.mall.dto.ProductAttrInfo;
import www.lst.mall.mbg.mapper.PmsProductAttributeCategoryMapper;
import www.lst.mall.mbg.mapper.PmsProductAttributeMapper;
import www.lst.mall.mbg.model.PmsProductAttribute;
import www.lst.mall.mbg.model.PmsProductAttributeCategory;
import www.lst.mall.mbg.model.PmsProductAttributeExample;
import www.lst.mall.service.PmsProductAttributeService;

import java.util.List;

/**
 * 商品属性
 * PmsProductAttributeService实现类
 * by：lst 2021/1/29
 */
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Autowired
    private PmsProductAttributeDao productAttributeDao;

    @Override
    public List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andProductAttributeCategoryIdEqualTo(cid).andTypeEqualTo(type);
        return productAttributeMapper.selectByExample(example);
    }

    @Override
    public int create(PmsProductCategoryParam productCategoryParam) {
        PmsProductAttribute productAttribute = new PmsProductAttribute();
        BeanUtils.copyProperties(productCategoryParam, productAttribute);
        int count = productAttributeMapper.insertSelective(productAttribute);
        //新增商品属性以后需要更新商品属性分类数量
        PmsProductAttributeCategory productAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(productAttribute.getProductAttributeCategoryId());
        if (productAttribute.getType() == 0) {
            productAttributeCategory.setAttributeCount(productAttributeCategory.getAttributeCount() + 1);
        }else if (productAttribute.getType() == 1) {
            productAttributeCategory.setParamCount(productAttributeCategory.getParamCount() + 1);
        }
        productAttributeCategoryMapper.updateByPrimaryKey(productAttributeCategory);
        return count;
    }

    @Override
    public int update(Long id, PmsProductCategoryParam productCategoryParam) {
        PmsProductAttribute productAttribute = new PmsProductAttribute();
        productAttribute.setId(id);
        BeanUtils.copyProperties(productCategoryParam, productAttribute);
        return productAttributeMapper.updateByPrimaryKeySelective(productAttribute);
    }

    @Override
    public int delete(List<Long> ids) {
        //获取分类
        PmsProductAttribute productAttribute = productAttributeMapper.selectByPrimaryKey(ids.get(0));
        Integer type = productAttribute.getType();
        PmsProductAttributeCategory productAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(productAttribute.getProductAttributeCategoryId());
        PmsProductAttributeExample productAttributeExample = new PmsProductAttributeExample();
        productAttributeExample.createCriteria().andIdIn(ids);
        int count = productAttributeMapper.deleteByExample(productAttributeExample);
        //删除完成后修改数量
        if (type == 0) {
            if (productAttributeCategory.getAttributeCount() >= count) {
                productAttributeCategory.setAttributeCount(productAttributeCategory.getAttributeCount() - count);
            }else {
                productAttributeCategory.setAttributeCount(0);
            }
        }else if (type == 1) {
            if (productAttributeCategory.getParamCount() >= count) {
                productAttributeCategory.setParamCount(productAttributeCategory.getParamCount() - count);
            }else {
                productAttributeCategory.setParamCount(0);
            }
        }
        productAttributeCategoryMapper.updateByPrimaryKey(productAttributeCategory);
        return count;
    }

    @Override
    public PmsProductAttribute getItem(Long id) {
        return productAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId) {
        return productAttributeDao.getProductAttrInfo(productCategoryId);
    }
}

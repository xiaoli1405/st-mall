package www.lst.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import www.lst.mall.mbg.model.PmsProductAttribute;
import www.lst.mall.mbg.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * 包含有属性分类的dto
 * by：lst 2021/1/29
 */
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {

    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;

}

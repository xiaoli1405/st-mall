package www.lst.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import www.lst.mall.mbg.model.PmsProductCategory;

import java.util.List;

/**
 * by：lst 2021/1/27
 */
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory{
    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<PmsProductCategory> children;
}

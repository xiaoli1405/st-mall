package www.lst.mall.service;

import www.lst.mall.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int updateBrand(Long id, PmsBrand brand);

    int createBrand(PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}

package www.lst.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import www.lst.mall.mbg.model.PmsProductVertifyRecord;
import www.lst.mall.mbg.model.PmsProductVertifyRecordExample;

public interface PmsProductVertifyRecordMapper {
    long countByExample(PmsProductVertifyRecordExample example);

    int deleteByExample(PmsProductVertifyRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductVertifyRecord record);

    int insertSelective(PmsProductVertifyRecord record);

    List<PmsProductVertifyRecord> selectByExample(PmsProductVertifyRecordExample example);

    PmsProductVertifyRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductVertifyRecord record, @Param("example") PmsProductVertifyRecordExample example);

    int updateByExample(@Param("record") PmsProductVertifyRecord record, @Param("example") PmsProductVertifyRecordExample example);

    int updateByPrimaryKeySelective(PmsProductVertifyRecord record);

    int updateByPrimaryKey(PmsProductVertifyRecord record);
}
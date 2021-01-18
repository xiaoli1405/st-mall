package www.lst.mall.service;

import www.lst.mall.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * 会员浏览记录管理Service
 * by：lst 2021/1/13
 *
 */
public interface MemberReadHistoryService {

    /**
     * 生成浏览记录
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 获取浏览历史记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> list(Long memberId);
}

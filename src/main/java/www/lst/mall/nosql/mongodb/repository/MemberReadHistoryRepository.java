package www.lst.mall.nosql.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import www.lst.mall.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * 会员商品浏览历史
 * by：lst 2021/1/13
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {

    /**
     * 根据会员id时间倒序获取浏览纪录
     * @param memberId  会员id
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}

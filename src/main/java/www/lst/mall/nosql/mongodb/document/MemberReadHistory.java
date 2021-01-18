package www.lst.mall.nosql.mongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 用户商品浏览历史记录
 * by：lst 2021/1/13
 */
@Data
@Document
public class MemberReadHistory {

    @Id
    private String id;
    @Indexed
    private Long memberId;
    private String memberNickname;
    private String memberIcon;
    @Indexed
    private Long productId;
    private String productPic;
    private String productName;
    private String productSubTitle;
    private String productPrice;
    private Date createTime;
}

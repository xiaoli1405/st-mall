package www.lst.mall.service;

/**
 * redis操作service
 * 对象和数组都以json格式存储
 * by：lst
 */
public interface RedisService {

    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超时时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     */
    Long increment(String key, long delta);
}

package top.pi1grim.mall.core.constant;

public class RedisConstant {
    private RedisConstant() {

    }
    //全部以秒为单位

    /**
    * Token存活时间
    */
    public static final int TOKEN_EXPIRE_TIME = 30 * 60;

    /**
    * 注册时尝试上锁时间
    */
    public static final int TRY_LOCK_TIME = 20;

    /**
     * 注册时锁持续时间
     */
    public static final int LOCK_TIME = 10;
}

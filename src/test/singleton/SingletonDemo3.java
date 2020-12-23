package singleton;

/**
 * @Author xiongtian
 * @Date 2020/12/23 15:14
 * @Version 1.0
 * <p>
 * 双重检索机制
 */

public class SingletonDemo3 {

    private volatile static SingletonDemo3 instance = null;

    private SingletonDemo3(){}

    public static SingletonDemo3 getInstance(){
        if (null == instance) {
            synchronized (SingletonDemo3.class) {
                if (null == instance) {
                    instance = new SingletonDemo3();
                }
            }
        }
        return instance;
    }
}

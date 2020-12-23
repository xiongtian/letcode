package singleton;

/**
 * @Author xiongtian
 * @Date 2020/12/23 15:01
 * @Version 1.0
 *
 * 懒汉式单例模式
 */

public class SingletonDemo1 {

    private static SingletonDemo1 instance;

    private SingletonDemo1(){}

    public static synchronized SingletonDemo1 getInstance(){
        if (null == instance) {
            instance = new SingletonDemo1();
        }
        return instance;
    }
}

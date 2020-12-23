package singleton;

/**
 * @Author xiongtian
 * @Date 2020/12/23 15:08
 * @Version 1.0
 *
 * 饿汉式
 */

public class SingletonDemo2 {

    private static SingletonDemo2 instance = new SingletonDemo2();

    private SingletonDemo2(){}

    public static SingletonDemo2 getInstance(){
        return instance;
    }
}

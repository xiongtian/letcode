package singleton;

/**
 * @Author xiongtian
 * @Date 2020/12/23 15:16
 * @Version 1.0
 *
 * 静态内部类
 */

public class SingletonDemo4 {

    private SingletonDemo4(){}

    public static class SingletonClassInstance{
        public static final SingletonDemo4 instance = new SingletonDemo4();
    }

    public static SingletonDemo4 getInstance(){
        return SingletonClassInstance.instance;
    }
}

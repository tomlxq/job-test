/**
 * Created by tom on 2016/5/15.
 */

/**
 * 接口中所有的方法隐含的都是抽象的。
 * 而抽象类则可以同时包含抽象和非抽象的方法。
 * 类可以实现很多个接口，但是只能继承一个抽象类类
 * 如果要实现一个接口，它必须要实现接口声明的所有方法。
 * 但是，类可以不实现抽象类声明的所有方法，当然，在这种情况下，类也必须得声明成是抽象的。
 * 抽象类可以在不提供接口方法实现的情况下实现接口。Java接口中声明的变量默认都是final的。
 * 抽象类可以包含非final的变量。
 * Java接口中的成员函数默认是public的。
 * 抽象类的成员函数可以是private，protected或者是public。
 * 接口是绝对抽象的，不可以被实例化。
 * 抽象类也不可以被实例化，但是，如果它包含main方法的话是可以被调用的。
 */
interface Impl1{
    String name="tom";
    void eat();
    void play();
}
interface Impl2{

    void listen();
}
abstract class Abs1{
    protected String name="tomLuo";
     void print(){
        System.out.println(name);
    }
    abstract void study(String name);
}
abstract class Abs2{
    protected String name="tomLuo brother";
     void print(){
        System.out.println(name);
    }
     abstract void listenMusic(String name);
}
public class Abstract_implement extends Abs1 implements Impl1,Impl2{

    public void eat() {
        System.out.println("eat method");
    }

    public void play() {
        System.out.println("play method");
    }

    public void listen() {
        System.out.println("listen");
    }

    void study(String name) {
        System.out.println("study");
    }
}

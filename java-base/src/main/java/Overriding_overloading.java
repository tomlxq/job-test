/**
 * Created by tom on 2016/5/15.
 */
abstract class Sub_class{
    void eat(){
        System.out.println("tom like fish!");
    }
    void eat(String name){
        System.out.println(name+" like fish!");
    }
}
public class Overriding_overloading extends Sub_class{
    //方法覆盖是说子类重新定义了父类的方法。方法覆盖必须有相同的方法名，参数列表和返回类型。覆盖者可能不会限制它所覆盖的方法的访问。
    @Override
    void eat() {
        super.eat();
        System.out.println("tom like cat!");
    }
    @Override
    void eat(String name) {
        super.eat(name+" Father");
        System.out.println(name+" like cat!");
    }
    void play() {
        System.out.println("tom play football!");
    }
    //Java中的方法重载发生在同一个类里面两个或者是多个方法的方法名相同但是参数不同的情况。
    void play(String name) {
        System.out.println(name+" play football!");
    }
    public static void main(String[] args){
        Overriding_overloading oo=new Overriding_overloading();
        oo.eat();
        oo.eat("ZhangShan");
        oo.play();
        oo.play("ZhangShan");
    }
}

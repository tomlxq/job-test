/**
 * Created by tom on 2016/5/15.
 */
public class Constructor {
    String name;
    //作用就是用来初始化方法
    //在面向对象的功能里，我们声明一个类后，为这个类声明一个方法，这个方法名和类名是一样的
    Constructor(){
        this.name="dong ge";
    }
    Constructor(String name){
        this.name=name;
    }
    public void print(){
        System.out.println(this.name);
    }
    public static void main(String[] args){
        new Constructor().print();
        new Constructor("tomLuo").print();
    }
}

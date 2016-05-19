/**
 * Created by tom on 2016/5/15.
 */
class TempTest {
    int a;

    public void test1(int a) {
        //对象被值传递，意味着传递了对象的一个副本。因此，就算是改变了对象副本，也不会影响源对象的值。
        a = 9;
    }

    public void test1(TempTest tempTest) {
        //对象被引用传递，意味着传递的并不是实际的对象，而是对象的引用。因此，外部对引用对象所做的改变会反映到所有的对象上。
        tempTest.a = 9;
    }
}

public class 值传递_引用传递 {
    public static void main(String[] args) {
        int a = 3;
        System.out.println(a);
        new TempTest().test1(a);//值传递
        System.out.println(a);

//指的是在方法调用时，传递的参数是按引用进行传递，其实传递的引用的地址，也就是变量所对应的内存空间的地址。
        TempTest t = new TempTest();
        t.a = 3;
        System.out.println(t.a);
        t.test1(t);//引用传递
        System.out.println(t.a);
    }


}

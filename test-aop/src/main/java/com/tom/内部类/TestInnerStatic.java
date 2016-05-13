package com.tom.内部类;

/**
 * Created by tom on 2016/5/5.
 */
public class TestInnerStatic {
    public static void main(String[] args) {
        S.B a_b = new S().new B(); // ok
        S a = new S();
        S.B ab = a.new B();
        Outer.Inner oi = new Outer.Inner();
//Outer.Inner oi2 = Outer.new Inner(); //!!!error
//Outer.Inner oi3 = new Outer().new Inner(); //!!! error
    }
}

class S {
    private int x;

    void m() {
        new B();
    }

    static void sm() {
//new B(); // error!!!!
    }

    class B {
        B() {
            x = 5;
        }
    }
}

class Outer {
    static class Inner {
    }
}

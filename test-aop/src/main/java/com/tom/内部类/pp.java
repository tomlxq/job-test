package com.tom.内部类;

/**
 * Created by tom on 2016/5/5.
 */
class TestInnerInMethod
{
    public static void main(String[] args)
    {
        Object obj = new Outer1().makeTheInner(47);
        System.out.println("Hello World!" + obj.toString() );
    }
}
class Outer1
{
    private int size = 5;e
            public String toString() {
                return ( " InnerSize: " + size +
// " localVar: " + localVar + // Error!
                        " finalLocalVar: " + finalLocalVar
                );
            }
        }
        return new Inner();
    }
}

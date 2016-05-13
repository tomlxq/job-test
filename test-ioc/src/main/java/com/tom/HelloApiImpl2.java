package com.tom;

/**
 * Created by tom on 2016/5/4.
 */
public class HelloApiImpl2 implements HelloApi{
    private String words;



    public  HelloApiImpl2(){
        this.words="hello world!";
    }
    public  HelloApiImpl2(String words){
        this.words=words;
    }
    public void sayHello() {
        System.out.println(this.words);
    }
}

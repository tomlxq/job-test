package com.tom.lock;

/**
 * Created by tom on 2016/5/4.
 */
public class MaxScore {
    int score;
     public MaxScore(){
        this.score=0;
    }

    /**
     * 两个线程不能同时调用 currentScore() 方法；
     * 当一个线程工作时，另一个线程必须阻塞。
     * 但是，可以有任意数量的线程同时通过 max() 方法访问最大值，
     * 因为 max() 不是同步方法，因此它与锁定无关
     * @param s
     */
    public synchronized void currentScore(int s){
        if(s>this.score){
            this.score=s;
        }
    }
    public int getMaxScore(){
        return this.score;
    }
}

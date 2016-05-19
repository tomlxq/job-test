import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by tom on 2016/5/15.
 */
class A extends Thread {
    @Override
    public void run() {
        System.out.println("A run method");
    }
}

class B implements Runnable {

    public void run() {
        System.out.println("B run method");
    }
}

class C {
    private int coreCpuNum;
    private ExecutorService executor;
    private List<FutureTask<Long>> tasks = new ArrayList<FutureTask<Long>>();

    public C() {
        coreCpuNum = Runtime.getRuntime().availableProcessors();
        executor = Executors.newFixedThreadPool(coreCpuNum);
    }

    class SumCalculator implements Callable<Long> {
        int nums[];
        int start;
        int end;

        public SumCalculator(final int nums[], int start, int end) {
            this.nums = nums;
            this.start = start;
            this.end = end;
        }

        //@Override
        public Long call() throws Exception {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

    public long sum(int[] nums) {
        int start, end, increment;
        // 根据CPU核心个数拆分任务，创建FutureTask并提交到Executor
        for (int i = 0; i < coreCpuNum; i++) {
            increment = nums.length / coreCpuNum + 1;
            start = i * increment;
            end = start + increment;
            if (end > nums.length) {
                end = nums.length;
            }
            SumCalculator calculator = new SumCalculator(nums, start, end);
            FutureTask<Long> task = new FutureTask<Long>(calculator);
            tasks.add(task);
            if (!executor.isShutdown()) {
                executor.submit(task);
            }
        }
        return getPartSum();
    }

    public long getPartSum() {
        long sum = 0;
        for (int i = 0; i < tasks.size(); i++) {
            try {
                sum += tasks.get(i).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return sum;
    }

    public void close() {
        executor.shutdown();
    }
}

/**
 * 有三种方式可以用来创建线程：
 * <p>
 * 继承Thread类
 * 实现Runnable接口应用程序
 * 可以使用Executor框架来创建线程池
 * <p>
 * 实现Runnable接口这种方式更受欢迎，因为这不需要继承Thread类。
 * 在应用设计中已经继承了别的对象的情况下，这需要多继承（而Java不支持多继承），只能实现接口。
 * 同时，线程池也是非常高效的，很容易实现和使用。
 */
public class 创建线程 {
    public static void main(String[] args) {
        A a = new A();
        a.start();

        B b = new B();
        b.run();

        int arr[] = new int[]{1, 22, 33, 4, 52, 61, 7, 48, 10, 11 };
        long sum = new C().sum(arr);
        System.out.println("sum: " + sum);

        /**
         *
         线程在执行过程中，可以处于下面几种状态：
         就绪(Runnable):线程准备运行，不一定立马就能开始执行。
         运行中(Running)：进程正在执行线程的代码。
         等待中(Waiting):线程处于阻塞的状态，等待外部的处理结束。
         睡眠中(Sleeping)：线程被强制睡眠。
         I/O阻塞(Blocked on I/O)：等待I/O操作完成。
         同步阻塞(Blocked on Synchronization)：等待获取锁。
         死亡(Dead)：线程完成了执行。
         */
    }
}

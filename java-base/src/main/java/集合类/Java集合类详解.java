package 集合类;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tom on 2016/5/15.
 */
public class Java集合类详解 {
    static Logger logger= LoggerFactory.getLogger(Java集合类详解.class);
    public static void main(String[] args){
        //HashSet是Set接口的一个子类，主要的特点是：里面不能存放重复元素，而且采用散列的存储方法，所以没有顺序。
        // 这里所说的没有顺序是指：元素插入的顺序与输出的顺序不一致。
        Set<String> set=new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("c");
        set.add(null);
        logger.debug("{}",set);
        /**
         * ArrayList是List的子类，它和HashSet想法，
         * 允许存放重复元素，因此有序。集合中元素被访问的顺序取决于集合的类型。
         * 如果对ArrayList进行访问，迭代器将从索引0开始，每迭代一次，索引值加1。
         * 然而，如果访问HashSet中的元素，每个元素将会按照某种随机的次序出现。
         * 虽然可以确定在迭代过程中能够遍历到集合中的所有元素，但却无法预知元素被访问的次序。
         */
        List<String> arrList=new ArrayList<String>();
        arrList.add("a");
        arrList.add("b");
        arrList.add("c");
        arrList.add("c");
        arrList.add("d");

    }
}

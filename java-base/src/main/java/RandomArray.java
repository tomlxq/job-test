/**
 * User: TOM
 * Date: 2016/5/14
 * email: beauty9235@gmail.com
 * Time: 10:12
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public abstract class RandomArray {
     static Logger logger= LoggerFactory.getLogger(RandomArray.class);
    public static int[] random(int length){
        if (length <= 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<Integer>(length);
        for (int i = 0; i < length; i++) {
            list.add(i);
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = list.remove(new Random().nextInt(length - i));
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = RandomArray.random(10);
        //logger.debug("{}",  StringUtils.join(Arrays.asList(array),","));
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ",");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print("]");
     /*   int len=100;
        Random r= new Random();
        Set set=new HashSet();
        for (int i = 0; i < len; i++) {
            set.add(r.nextInt(i));
        }
        logger.debug("{}",set);*/

    }

}

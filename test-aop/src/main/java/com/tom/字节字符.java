package com.tom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import static com.oracle.jrockit.jfr.ContentType.Bytes;

/**
 * Created by tom on 2016/5/3.
 */
public class 字节字符 {
    final static Logger logger=LoggerFactory.getLogger(字节字符.class);
    static void test字节流写文件() throws IOException {
        File f = new File("d:" + File.separator + "test1.txt");
        OutputStream out = new FileOutputStream(f);//如果文件不存在会自动创建
        String str = "Hello World";
        byte[] b = str.getBytes();
        out.write(b);//因为是字节流，所以要转化成字节数组进行输出
        out.close();

        out = new FileOutputStream(f, true);//追加
        str = "\n\rtom luo";
        b = str.getBytes();
        out.write(b);
        out.close();
        //读文件
        InputStream in = new FileInputStream(f);
        b = new byte[1024];
        int len = in.read(b);
        in.close();
        System.out.println(new String(b, 0, len));
    }

    static void test字节流读文件() throws IOException {
        File f = new File("d:" + File.separator + "test2.txt");
        OutputStream out = new FileOutputStream(f);//如果文件不存在会自动创建
        String str = "Hello World";
        byte[] b = str.getBytes();
        for (int i = 0; i < b.length; i++) {
            out.write(b[i]);
        }
        out.close();
        out = new FileOutputStream(f, true);//追加
        str = "\r\ntom luo";
        b = str.getBytes();
        for (int i = 0; i < b.length; i++) {
            out.write(b[i]);
        }
        out.close();
        //开避需要的长度
        InputStream in = new FileInputStream(f);
        //b = new byte[1024];//不用开辟这么大的一个字节数组，明显是浪费嘛，我们可以根据文件的大小来定义字节数组的大小
        b = new byte[(int) f.length()];
        in.read(b);
        logger.debug("读到指定的字节数组{}",new String(b));
        //in.reset();
        //这儿也可以一个字节一个字节读取
        in = new FileInputStream(f);
        b = new byte[(int) f.length()];
        for(int i=0;i<b.length;i++){
            b[i]=(byte)in.read();
        }
        logger.debug("用字节读到指定的字节数组{}",new String(b));
        in.close();
        System.out.println(new String(b));
        in=new FileInputStream(f);
        int temp;int i=0;
        byte[] b2=new byte[1024];
        while((temp=in.read())!=-1){
            b2[i]=(byte)temp;
            i++;
        }
        in.close();
        logger.debug("不知道长度，用字节读到指定的字节数组{}",new String(b2));
        System.out.println(new String(b2));
    }

    public static void main(String[] args) throws IOException {
        test字节流写文件();
        test字节流读文件();
        test以字符数组写数据();
        test以字符数组读数据();
        test以循环方式判断是否读到底();
        //http://blog.csdn.net/zxman660/article/details/7875799
        //http://blog.csdn.net/zj8692286/article/details/12650731
    }

    private static void test以循环方式判断是否读到底() throws IOException {
        File f=new File("d:"+File.separator+"test.txt");
        Reader r=new FileReader(f);
        int temp,len=0;
        char[] c=new char[1024];
        while((temp=r.read())!=-1){
            c[len]=(char)temp;
            len++;
        }
        r.close();
        logger.debug("以循环方式判断是否读到底　{}",new String(c,0,len));
    }

    private static void test以字符数组读数据() throws IOException {
        File f=new File("d:"+File.separator+"test.txt");
        Reader r=new FileReader(f);
        char[] c=new char[1024];
        int len=r.read(c);
        r.close();
        logger.debug("以字符数组读数据{}",new String(c,0,len));
    }

    private static void test以字符数组写数据() throws IOException {
        File f=new File("d:"+File.separator+"test.txt");
        Writer w=new FileWriter(f);
        String hello="Hello world";
        w.write(hello);
        w.close();
        w=new FileWriter(f,true);//append
        hello="\r\ntom luo";
        w.write(hello);
        w.close();
    }

}

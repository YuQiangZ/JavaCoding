package com.yuqiangz.io;

import org.junit.Test;

import java.io.*;

/**
 *
 * @author yuqiangzhao
 * @create 2020-01-28 13:52
 */
public class BufferTest {

    @Test
    public  void bufferedStreamTest()  {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("E:\\intellJ_IDEA\\JavaCode\\01.jpg");
            File desFile = new File("02.jpg");

            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取，写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭，先关闭外层(自动关闭内层)，在关闭内层
            if(bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//        fos.close();;
//        fis.close();

        }
    }
}

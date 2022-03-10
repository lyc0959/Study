package io_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutPutStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\73490\\Desktop\\1.jpg");
            fileOutPutStream = new FileOutputStream("E:/2.jpg");
            //定义byte数组读取图片数据，提高效率
            byte[] bytes = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(bytes)) != -1) {
                //一定要用该方法，readLen表示实际读取的字节数，读取了多少字节就写入多少字节然后再读取再写入
                fileOutPutStream.write(bytes,0,readLen);
            }
            System.out.println("拷贝完毕");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭 后开先闭
                if (fileOutPutStream != null) {
                    fileOutPutStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

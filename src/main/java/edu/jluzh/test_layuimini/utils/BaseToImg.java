package edu.jluzh.test_layuimini.utils;

import edu.jluzh.test_layuimini.pojo.Base64Req;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/28 9:44
 * @version:
 * @modified By:
 */
public class BaseToImg  extends Base64Req {
    @SuppressWarnings("finally")
    public static boolean GenerateImage(String imgData, String imgFilePath) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
        if (imgData == null) // 图像数据为空
            return false;
        Decoder decoder = Base64.getDecoder();
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            // Base64解码
            byte[] b = decoder.decode(imgData);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return true;
        }
    }
}

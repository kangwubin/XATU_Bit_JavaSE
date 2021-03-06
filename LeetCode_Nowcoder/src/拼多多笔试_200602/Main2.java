package 拼多多笔试_200602;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/6/2
 * @Time: 20:04
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        String str = "hello world";
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {

        }

        byte[] bytes = str.getBytes();
        System.out.println("压缩前长度：" + bytes.length);
        byte[] gzipBytes = gzip(bytes);
        System.out.println("压缩后长度：" + gzipBytes.length);
        System.out.println("压缩后：" + byteToHexString(gzipBytes));
        byte[] unGzipBytes = unGzip(gzipBytes);
        System.out.println("解压后：" + byteToHexString(unGzipBytes));
    }

    public static byte[] gzip(byte[] content) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gos = new GZIPOutputStream(baos);

        ByteArrayInputStream bais = new ByteArrayInputStream(content);
        byte[] buffer = new byte[1024];
        int n;
        while ((n = bais.read(buffer)) != -1) {
            gos.write(buffer, 0, n);
        }
        gos.flush();
        gos.close();
        return baos.toByteArray();
    }

    public static byte[] unGzip(byte[] content) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(content));
        byte[] buffer = new byte[1024];
        int n;
        while ((n = gis.read(buffer)) != -1) {
            baos.write(buffer, 0, n);
        }

        return baos.toByteArray();
    }

    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length);
        String sTemp;
        for (int i = 0; i < bytes.length; i++) {
            sTemp = Integer.toHexString(0xFF & bytes[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
}

package com.jxzj.external.data.utils;

import java.util.Arrays;

// import io.netty.buffer.ByteBuf;

/**
 * byte[]与16进制字符串相互转换
 * 
 */
public class HexStrUtils {

    private static final char[] HEX_CHAR =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 将byte[] 转换为16进制字符串
     * 
     * @param bytes
     * @return
     */
    public static String toHexStr(byte[] bytes) {
        char[] buf = new char[bytes.length * 2];
        int index = 0;
        for (byte b : bytes) {
            buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
            buf[index++] = HEX_CHAR[b & 0xf];
        }

        return new String(buf);
    }

    /**
     * 将netty ByteBuf对象转换为16进制字符串，以可读性较强的方式输出<br>
     * 输出完成后会重置传入buteBuf的readerIndex指针
     * <p>
     * 输出样例：
     * 
     * <pre>
     * 0x0000:  4514 0056 597b 0000 7311 5d48 7584 c5bb  E..VY{..s.]Hu...
     * 0x0010:  ac12 a96d e638 2da8 0042 02df fe04 3545  ...m.8-..B....5E
     * 0x0020:  4a4a 5832 3032 3030 3432 3038 3838 3180  JJX202004208881.
     * 0x0030:  0044 9400 0000 0000 0040 00e0 5b45 2fd2  .D.......@..[E/.
     * 0x0040:  8d46 2f12 6f3b 0300 0000 0000 0041 8030  .F/.o;.......A.0
     * 0x0050:  1907 5f00 0c15                           .._...
     * </pre>
     * 
     * @param bytes
     * @return
     */
    // public static String prettyPrint(final ByteBuf byteBuf) {
    //
    // char[] buf = new char[2];
    // StringBuilder sb = new StringBuilder("\n");
    // StringBuilder hexBuilder = new StringBuilder();
    // StringBuilder textBuilder = new StringBuilder();
    //
    // int i = 0;
    //
    // while (byteBuf.isReadable()) {
    // byte b = byteBuf.readByte();
    //
    // buf[0] = HEX_CHAR[b >>> 4 & 0xf];
    // buf[1] = HEX_CHAR[b & 0xf];
    //
    // hexBuilder.append(buf);
    // if (b >= 0x21 && b <= 0x7e) {
    // textBuilder.append((char)b);
    // } else {
    // textBuilder.append(".");
    // }
    //
    // if (i % 0x10 == 0x0f) {
    // sb.append("0x").append(String.format("%04x", i / 0x10 * 0x10)).append(": ");
    // sb.append(hexBuilder).append(" ");
    // sb.append(textBuilder).append("\n");
    //
    // hexBuilder.setLength(0);
    // textBuilder.setLength(0);
    // } else if (i % 2 == 1) {
    // hexBuilder.append(" ");
    // }
    // i++;
    // }
    //
    // if (0 != hexBuilder.length()) {
    // sb.append("0x").append(String.format("%04x", i / 0x10 * 0x10)).append(": ");
    // for (int j = hexBuilder.length(); j < 39; j++) {
    // hexBuilder.append(" ");
    // }
    // sb.append(hexBuilder).append(" ");
    // sb.append(textBuilder).append("\n");
    // }
    //
    // byteBuf.resetReaderIndex();
    // return sb.toString();
    // }

    /**
     * 将byte[] 转换为16进制字符串，以可读性较强的方式输出
     * <p>
     * 输出样例：
     * 
     * <pre>
     * 0x0000:  4514 0056 597b 0000 7311 5d48 7584 c5bb  E..VY{..s.]Hu...
     * 0x0010:  ac12 a96d e638 2da8 0042 02df fe04 3545  ...m.8-..B....5E
     * 0x0020:  4a4a 5832 3032 3030 3432 3038 3838 3180  JJX202004208881.
     * 0x0030:  0044 9400 0000 0000 0040 00e0 5b45 2fd2  .D.......@..[E/.
     * 0x0040:  8d46 2f12 6f3b 0300 0000 0000 0041 8030  .F/.o;.......A.0
     * 0x0050:  1907 5f00 0c15                           .._...
     * </pre>
     * 
     * @param bytes
     * @return
     */
    public static String prettyPrint(byte[] bytes) {

        char[] buf = new char[2];
        StringBuilder sb = new StringBuilder("\n");
        StringBuilder hexBuilder = new StringBuilder();
        StringBuilder textBuilder = new StringBuilder();

        int i = 0;
        for (; i < bytes.length; i++) {
            buf[0] = HEX_CHAR[bytes[i] >>> 4 & 0xf];
            buf[1] = HEX_CHAR[bytes[i] & 0xf];

            hexBuilder.append(buf);
            if (bytes[i] >= 0x21 && bytes[i] <= 0x7e) {
                textBuilder.append((char)bytes[i]);
            } else {
                textBuilder.append(".");
            }

            if (i % 0x10 == 0x0f) {
                sb.append("0x").append(String.format("%04x", i / 0x10 * 0x10)).append(":  ");
                sb.append(hexBuilder).append("  ");
                sb.append(textBuilder).append("\n");

                hexBuilder.setLength(0);
                textBuilder.setLength(0);
            } else if (i % 2 == 1) {
                hexBuilder.append(" ");
            }
        }

        if (0 != hexBuilder.length()) {
            sb.append("0x").append(String.format("%04x", i / 0x10 * 0x10)).append(":  ");
            for (int j = hexBuilder.length(); j < 39; j++) {
                hexBuilder.append(" ");
            }
            sb.append(hexBuilder).append("  ");
            sb.append(textBuilder).append("\n");
        }

        return sb.toString();
    }

    /**
     * 将16进制字符串转换为byte[]
     * 
     * @param str
     * @return
     */
    public static byte[] toBytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte)Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    public static void main(String[] args) throws Exception {
        // byte[] bytes = "abcd".getBytes("utf-8");
        // for (byte b : bytes) {
        // char c = (char)b;
        // System.out.println(c);
        // }

        byte[] bytes = "测试A B C".getBytes("utf-8");

        System.out.println("字节数组为：" + Arrays.toString(bytes));
        System.out.println(toHexStr(bytes));
        System.out.println(prettyPrint(bytes));
        //
        // System.out.println("==================================");
        // a b c d
        // 61 62 63 64

        // String str = "e6b58be8af95";
        // System.out.println("转换后的字节数组：" + Arrays.toString(toBytes(str)));
        // System.out.println(new String(toBytes(str), "utf-8"));
    }

}

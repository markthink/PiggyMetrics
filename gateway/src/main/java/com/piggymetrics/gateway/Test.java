package com.piggymetrics.gateway;

import java.io.*;

/**
 * @PACKAGE_NAME：com.piggymetrics.gateway
 * @DATE: 2018/11/23
 * @AURH: shilei
 * @DESC:
 */
public class Test {

    public static void main(String[] args){

        System.out.println("--hello--");
        changeContent("","");

    }

    private static void changeContent(String filePath, String savePath) {
        // filePath 要读取的文件 savePath 要写入的文件
        BufferedReader br = null;
        BufferedWriter bw = null;
        String content = "";
        try {
            // 以下读取和写入都转成UTF-8 防止乱码
            br = new BufferedReader(new InputStreamReader(new FileInputStream(
                    "/Users/shilei/Downloads/eclipse-space/PiggyMetrics/gateway/src/main/java/com/piggymetrics/gateway/1.txt"), "UTF-8"));
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("/Users/shilei/Downloads/eclipse-space/PiggyMetrics/gateway/src/main/java/com/piggymetrics/gateway/2.txt"), "UTF-8"));
            StringBuffer str = new StringBuffer(" ");
            String line;
            while ((line = br.readLine()) != null && (line != "")) {
                content = line + br.readLine();
                bw.write(content.replaceAll("\\s\\d{1,2}:\\d{1,2}:\\d{1,2}", str.toString()).replace(
                        "null", ""));
                System.out.println("ssss");
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (bw != null)
                    bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }

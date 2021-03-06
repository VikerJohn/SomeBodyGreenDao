package com.zwei.materialdesigndemo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */

public class FileChangeName {


    public static void main(String[] args) {
        //    在此目录中找文件
        String baseDIR = "D:\\Documents\\Desktop\\掌上星火\\pic";

        //    找扩展名为txt的文件
        String fileName = "you.png";
        String newFileName = "you_checked.png";
     /*   startReName(baseDIR, "Close.png", "close.png");
        startReName(baseDIR, "jinji.png", "jinji_normal.png");
        startReName(baseDIR, "jinji1.png", "jinji_checked.png");

       startReName(baseDIR, "yiban.png", "yiban_normal.png");
        startReName(baseDIR, "yiban1.png", "yiban_checked.png");


       startReName(baseDIR, "zhongyaojinji.png", "zhongyaojinji_normal.png");
        startReName(baseDIR, "zhongyaojinji1.png", "zhongyaojinji_checked.png");
*/


       startReName(baseDIR, "icon.png", "icon_normal.png");
        startReName(baseDIR, "icon1.png", "icon_pressed.png");






    }

    private static void startReName(String baseDIR, String fileName, String newFileName) {
        showFilePath(baseDIR, fileName);
        replaceFileName(baseDIR,fileName,newFileName);
    }

    /**
     * 递归复制到相同文件夹中
     *
     * @param baseDirName    查找的文件夹路径
     * @param targetFileName 需要查找的文件名
     * @param newFileName    修改的文件名
     */
    private static void replaceFileName(String baseDirName, String targetFileName, String newFileName) {

        File baseDir = new File(baseDirName);        // 创建一个File对象
        if (!baseDir.exists() || !baseDir.isDirectory()) {    // 判断目录是否存在
            System.out.println("文件查找失败：" + baseDirName + "不是一个目录！");
        }
        String tempName = null;
        //判断目录是否存在
        File tempFile;
        File[] files = baseDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            tempFile = files[i];
            if (tempFile.isDirectory()) {
                replaceFileName(tempFile.getAbsolutePath(), targetFileName, newFileName);
            } else if (tempFile.isFile()) {
                tempName = tempFile.getName();
                if (wildcardMatch(targetFileName, tempName)) {
                    // 匹配成功，复制并修改文件名
//                    fileList.add(tempFile.getAbsoluteFile());
                    coppyAndReName(tempFile,newFileName);
                }
            }
        }
    }

    /**
     * 复制并修改文件名
     * @param tarFile
     * @param newFileName
     */
    private static void coppyAndReName(File tarFile, String newFileName) {
        String newFilePath = tarFile.getAbsolutePath().replace(tarFile.getName(),newFileName);
        FileUtil.copyFile(tarFile.getAbsolutePath(),newFilePath);
    }

    private static void showFilePath(String baseDIR, String fileName) {
        List resultList = new ArrayList();
        findFiles(baseDIR, fileName, resultList);
        if (resultList.size() == 0) {
            System.out.println("No File Fount.");
        } else {
            for (int i = 0; i < resultList.size(); i++) {
                System.out.println(resultList.get(i));//显示查找结果。
            }
        }
    }





    /**
     * 递归查找文件
     *
     * @param baseDirName    查找的文件夹路径
     * @param targetFileName 需要查找的文件名
     * @param fileList       查找到的文件集合
     */
    public static void findFiles(String baseDirName, String targetFileName, List fileList) {

        File baseDir = new File(baseDirName);        // 创建一个File对象
        if (!baseDir.exists() || !baseDir.isDirectory()) {    // 判断目录是否存在
            System.out.println("文件查找失败：" + baseDirName + "不是一个目录！");
        }
        String tempName = null;
        //判断目录是否存在
        File tempFile;
        File[] files = baseDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            tempFile = files[i];
            if (tempFile.isDirectory()) {
                findFiles(tempFile.getAbsolutePath(), targetFileName, fileList);
            } else if (tempFile.isFile()) {
                tempName = tempFile.getName();
                if (wildcardMatch(targetFileName, tempName)) {
                    // 匹配成功，将文件名添加到结果集
                    fileList.add(tempFile.getAbsoluteFile());
                }
            }
        }
    }

    /**
     * 通配符匹配
     *
     * @param pattern 通配符模式
     * @param str     待匹配的字符串
     * @return 匹配成功则返回true，否则返回false
     */
    private static boolean wildcardMatch(String pattern, String str) {
        int patternLength = pattern.length();
        int strLength = str.length();
        int strIndex = 0;
        char ch;
        for (int patternIndex = 0; patternIndex < patternLength; patternIndex++) {
            ch = pattern.charAt(patternIndex);
            if (ch == '*') {
                //通配符星号*表示可以匹配任意多个字符
                while (strIndex < strLength) {
                    if (wildcardMatch(pattern.substring(patternIndex + 1),
                            str.substring(strIndex))) {
                        return true;
                    }
                    strIndex++;
                }
            } else if (ch == '?') {
                //通配符问号?表示匹配任意一个字符
                strIndex++;
                if (strIndex > strLength) {
                    //表示str中已经没有字符匹配?了。
                    return false;
                }
            } else {
                if ((strIndex >= strLength) || (ch != str.charAt(strIndex))) {
                    return false;
                }
                strIndex++;
            }
        }
        return (strIndex == strLength);
    }


}

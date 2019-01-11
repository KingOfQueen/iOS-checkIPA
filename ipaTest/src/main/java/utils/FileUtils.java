package utils;

import vo.ipaInfo;

import java.io.*;

/**
 * Created by Benjamin on 2019/1/9.
 */
public class FileUtils {

    // 回收资源,删除文件
    public static void fileDelet(File filename){
        // 如果有必要，应该删除解压的结果文件
        boolean result = filename.delete();

        int tryCount = 0;
        while(!result && tryCount++ < 3 )
        {
            System.gc();
            result = filename.delete();
        }

//        if ( !result ) {
//            System.gc();    // 强制解除对文件的占用,回收资源
//            filename.delete();
//        }

        filename.getParentFile().delete();

    }

    // 读文件并以字符串形式返回
    public static String fileRead(File filename) throws IOException {
        /* 读入文件 */
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言

        String filedata = "";
        String line = "";
        line = br.readLine();
        while (line != null) {
            line = br.readLine(); // 一次读入一行数据
            filedata += line;
        }
        br.close(); // 关闭文件流

        return filedata;
    }

    // 判断文件后缀名并存储到实体类中
    public static void fileName(String dirpath,String filename){

        if ( filename.substring(filename.length() - 3).equals("ipa") ){ //文件后缀名是否包含 ipa
            ipaInfo.setFilePath( dirpath + filename );
        }else if (dirpath == null || filename == null){   //判断路径和文件是否为空
            ipaInfo.setFilePath( null );
        }
        else{
            ipaInfo.setFilePath( null );
        }

    }



}

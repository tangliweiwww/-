package com.tangliwei.check_duplicate.utils;

import java.io.*;

public class FileUtils {

    public static void WriteToFile(String data,String filename)  {
        try (FileWriter fileWriter = new FileWriter(filename,true )){
            fileWriter.write("\n"+data);
            System.out.println(filename+"写入成功!");
        }catch (FileNotFoundException e){
            System.err.println("文件路径不存在"+e);
        }
        catch (IOException e) {
            System.err.println("写入文件出错"+e);
        }
    }

    public static String ReadFile(String filename){
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader fileReader = new FileReader(filename)){
           String line;
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           while((line=bufferedReader.readLine())!=null){
               stringBuilder.append(line);
           }
        } catch (FileNotFoundException e) {
            System.err.println("文件路径不存在"+e);
        } catch (IOException e) {
            System.err.println("读取文件出错"+e);
        }
        return stringBuilder.toString();
    }
}

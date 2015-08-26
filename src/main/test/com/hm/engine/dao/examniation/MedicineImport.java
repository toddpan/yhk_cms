package com.hm.engine.dao.examniation;

import com.hm.engine.dao.examniation.domain.YmtMedication;
import sun.applet.Main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by ant_shake_tree on 15/8/13.
 */
public class MedicineImport {
    public  static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(Paths.get("qrjd.txt"),
                Charset.defaultCharset());
        StringBuilder stringBuilder=new StringBuilder();
        for (String l:list){
            if(l.contains("药典")){
                stringBuilder.append("#").append(l);
            }else{
                stringBuilder.append(l);
            }
        }
        String[] strs =stringBuilder.toString().split("#");
        for (String s:strs){
            System.out.println(s);
        }

    }


    public static class MedicinePojo{

    }

}

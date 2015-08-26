package com.hm.engine.web.controller.facade;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import sun.applet.Main;

/**
 * Created by ant_shake_tree on 15/7/30.
 */
public class JpinyinTest {


    public static void  main(String[] args){
        String str = "你好世界";
        System.out.println(PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_MARK)); // nǐ,hǎo,shì,jiè);
        System.out.println(PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_NUMBER));// ni3,hao3,shi4,jie4
        System.out.println(PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITHOUT_TONE)); // ni,hao,shi,jie
        System.out.println(PinyinHelper.getShortPinyin(str));
    }
}

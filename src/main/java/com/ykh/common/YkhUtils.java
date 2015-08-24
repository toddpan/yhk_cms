package com.ykh.common;

import com.google.common.collect.Lists;

import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YkhUtils {

    public static List<String> getAllServicetypelist(){
        List<String> seriveTypeLists= Lists.newLinkedList();
        seriveTypeLists.add(Constants.SERVICE_AUDIO);
        seriveTypeLists.add(Constants.SERVICE_BMS);
        seriveTypeLists.add(Constants.SERVICE_CHAT);
        seriveTypeLists.add(Constants.SERVICE_DESKTOP);
        seriveTypeLists.add(Constants.SERVICE_DOCSHARE);
        seriveTypeLists.add(Constants.SERVICE_QA);
        seriveTypeLists.add(Constants.SERVICE_SURVEY);
        seriveTypeLists.add(Constants.SERVICE_WHITEBOARD);
        seriveTypeLists.add(Constants.SERVICE_VEDIO);
        return seriveTypeLists;
    }
}

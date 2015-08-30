package com.ykh.exception;

import com.maxc.rest.common.exception.RestException;

/**
 * Created by ant_shake_tree on 15/8/30.
 */
public class UserInfoException extends RuntimeException {
    public static int ERROR_CODE=0x5fffff01;
    public static String message="cp userInfo exception.";
}

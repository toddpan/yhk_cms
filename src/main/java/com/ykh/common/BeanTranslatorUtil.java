package com.ykh.common;

import com.ykh.dao.conference.domain.Conference;

import com.ykh.pojo.User;
import com.ykh.tang.agent.vo.BMSUserInfo;
import com.ykh.tang.agent.vo.ConferenceInfoBMS;
import com.ykh.tang.agent.vo.RoleInfo;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by ant_shake_tree on 15/8/30.
 */
public class BeanTranslatorUtil {

        /**
         * logger:log4j变量，用于本地日志的输出
         */
        private static final Logger LOGGER = Logger.getLogger(BeanTranslatorUtil.class);

        /**
         *
         * 转换user信息到业务管理需要的userinfo
         *
         * <P>
         * <b>Detail:</b>
         * <P>
         * 适用条件：userinfo对象是业务管理通过dbus生成的对象，user对象是自定义对象，二者结构高度相似，主要转换Integer和UInt
         * <P>
         * 执行流程：拷贝user对象的每个属性，循环复制到userinfo对象
         * <P>
         * 使用方法：本方法为静态方法，直接通过类名.copyUser2UserInfo调用
         * <P>
         * 注意事项：调用过程中需传递IConferenceRole接口
         * <P>
         *
         * @param user
         *            用户对象
         *            IConferenceRole接口
         * @return UserInfo dbus生成的userinfo对象
         * @throws Exception
         *             抛出异常
         * @code {这里可以添加函数调用示例代码}
         * @endcode
         * @since JDK1.6
         * @see
         */
        public static BMSUserInfo copyUser2UserInfo(User user) throws Exception {

            if (user == null) {
                LOGGER.error("copyUser2UserInfo方法调用，参数为NULL，调用中断，直接返回NULL");
                return null;
            }
            // 转换获得的角色ID信息
            Set<Integer> roleidSet = user.getRolemap().keySet();
            List<String> roleIdList = new ArrayList<String>();
            for(Integer roleID : roleidSet) {
                roleIdList.add(roleID+"");
            }

            LOGGER.info("userJoin user ip=" + user.getIpaddr());

            // 转换获得的用户信息
            String username = user.getUsername();
            if (username == null) {
                return null;
            }
            // 获得用户外网IP，支持ipv6
            List<String> ipList = new ArrayList<String>();
            if(user.getIpaddr() != null) {
                String[] iplist = user.getIpaddr().split("\\.",-1);
                for(String ip : iplist) {
                    ipList.add(ip);
                    LOGGER.info("userJoin ip=" + ip);
                }
            }

            BMSUserInfo userInfo = new BMSUserInfo();
            userInfo.setUserID(user.getTempuserid());
            userInfo.setUserName(username);
            userInfo.setClientType(user.getClientType());
            if(user.getPinCode() != null)
                userInfo.setPinCode(user.getPinCode());
            else
                userInfo.setPinCode(0);

            userInfo.setDomain(user.getDomain());
            userInfo.setIPArr(ipList);
            userInfo.setRoleTypeArr(roleIdList);

            if(user.getUserStatus() != null)
                userInfo.setStatus(user.getUserStatus());
            return userInfo;

        }





    }

package com.ykh.services.conference.impl;//package com.ykh.conference.service.impl;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.log4j.Logger;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ykh.conference.service.ConfJoinTempConf;
//import DtServiceAddr;
//import IPTranslatorUtil;
//import com.ykh.dao.conference.domain.Conference;
//import com.ykh.dao.user.domain.User;
//import com.ykh.tang.agent.ICMSAgentInterface;
//import com.ykh.tang.agent.excep.CMSException;
//import com.ykh.tang.agent.excep.CMSException2JNIException;
//import com.ykh.tang.agent.vo.BMSUserInfo;
//import com.ykh.tang.agent.vo.UserChannel;
//import com.ykh.tang.agent.vo.UserConferenceStatus;
//import com.ykh.tang.agent.vo.UserServiceAddr;
//import UserService;
//
//
///**
// * ConferenceBusinessImpl：会议召开业务实现类
// * 
// * @version 0.0.1
// * @author Dongyu Zhang
// * 
// *         Revision History
// * @if CR/PR ID Author Date Major Change
// * @endif
// * @bug CR0001 Dongyu Zhang Sept. 20 2008 create version 0.0.1\n
// * 
// * @see
// */
//
//@Transactional
//public class ConferenceBusinessImpl
//{
//	private final static int TYPE_CTS = 1;
//	private final static int TYPE_DTS = 2;
//	private final static int TYPE_HOT = 3;
//	private static final Logger LOGGER = Logger.getLogger(ConferenceBusinessImpl.class);
//	private ICMSAgentInterface agent;
//
//	/**
//	 * 
//	 * 单独的创建会议方法，创建会议后没有获得接入和传输信息（此时没有用户加入），创建后会议处于挂起状态。 提供给会议监控调用，暂未实现。
//	 * 
//	 * <P>
//	 * 适用条件：会议已经预约，没有创建，没有用户加入（创建一场没有用户的会议）
//	 * <P>
//	 * 执行流程：Tang应用传入要已经预约的会议ID；会议管理创建临时会议ID（32位编码，包含主子会议逻辑）；
//	 * 会议管理保存预约ID和临时会议ID关系到cdrconferenceinfo表，同时保留在内存，动态更新。
//	 * 会议管理通过从数据库获得会议具体服务值信息，构建32位二进制编码，转换成整型；
//	 * 会议管理调用内总线接口，传递临时会议ID和转换后的整形编码（会议服务编码）给业务管理。
//	 * <P>
//	 * 使用方法：服务暴露外部接口，调用者需要通过消息传入预约会议ID，服务返回创建成功与否。
//	 * <P>
//	 * 注意事项：会议的具体服务值信息通过32为二进制码表示，具体编码值和业务管理协议。
//	 * 临时会议ID（32位二进制）的生成遵从一定的业务规则——前24位代表主会ID，后八位代表子会ID。 该方法创建会议后，会议没有启动。
//	 * 
//	 * @param conferenceID
//	 *            会议标识
//	 * @return boolean 返回是否创建成功
//	 * @throws Exception
//	 *             抛出异常
//	 * @code {这里可以添加函数调用示例代码}
//	 * @endcode
//	 * @since JDK1.6
//	 * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
//	 * @see
//	 */
//	// @Override
//	@Deprecated
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	public Boolean createConference(String applicationID,
//			Integer tempConferenceID, Conference conference) throws Exception
//	{
////		Cdrconferenceinfo cdrConferenceInfo = new Cdrconferenceinfo();
////		if (tempConferenceID == null)
////		{
////			// tempConferenceID = this.getConfeID();
////			tempConferenceID = this.getConfID();
////		}
////
////		// 调用业务管理接口，不带用户创建，如果调用业务管理成功，修改tempconference状态信息为1（已创建，未启动）---------
////		// 不带用户创建，传递的user信息是null
////		List<Integer> valuelist = new ArrayList<Integer>();
////		Set<Conferenceuservalue> uservalueset = conference
////				.getConferenceuservalues();
////		for (Conferenceuservalue uservalue : uservalueset)
////		{
////			valuelist.add(uservalue.getValue());
////		}
////		List<Integer> servicetypelistByInteger = new ArrayList<Integer>(16);
////		servicetypelistByInteger = CodeTranslatorUtil
////				.translateUserCodeValue2ServiceTypeByInteger(valuelist);
////
////		List<String> servicetypelist = new ArrayList<String>();
////		for (Integer i : servicetypelistByInteger)
////		{
////			servicetypelist.add(i + "");
////		}
////
////		ConferenceInfoBMS confInfo = BeanTranslatorUtil
////				.copyConference2ConferenceInfo(conference, tempConferenceID,
////						null, productRoleManager);
////
////		try
////		{
////			int site = conferenceBusinessManager.initSite(applicationID, tempConferenceID);
////			long startTime = System.currentTimeMillis();
////			agent.createConferenceWithoutUser(site, confInfo, servicetypelist);
////			LOGGER
////					.info("[Tang CMS call jni with create conference without user: time: "
////							+ (System.currentTimeMillis() - startTime) + "]");
////
////			// 操作数据库添加cdrconfernceinfo记录
////			cdrConferenceInfo.setConferenceid(conference.getConferenceid());
////			cdrConferenceInfo.setCreatetime(new Date());
////			cdrConferenceInfo.setTempconferenceid(tempConferenceID);
////			cdrConferenceInfo.setBillingcode(conference.getBillingcode());
////			cdrConferenceInfo.setReservtime(conference.getReservtime());
////			cdrConferenceInfo.setConferencename(conference.getConferencename());
////			cdrConferenceInfo.setConferencedesc(conference.getConferencedesc());
////			cdrConferenceInfo.setDuration(conference.getConferenceminutes());
////			cdrConferenceInfo.setParties(conference.getConfscale());
////			cdrConferenceInfoManager.create(cdrConferenceInfo);
////		}
////		catch (CMSException e)
////		{
////			LOGGER.info("exception create conference confID["
////					+ tempConferenceID + "]");
////			// 抓异常
////			LOGGER.error("调用业务管理不带用户创建发生异常，异常信息：" + e.getMessage() + "---异常类型："
////					+ e.getClass().toString());
////			// confJoinTempConfManager.deleteConfJoinTempConfByTempConfID(tempConferenceID);
////			throw CMSException2JNIException.getJNIException(e);
////		}
//		return true;
//	}
//
//	/**
//	 * 停止会议，没有释放会议资源
//	 * 
//	 * @param applicationID
//	 *            应用ID
//	 * @param tempConferenceID
//	 *            临时会议ID
//	 * @return
//	 * @throws Exception
//	 */
//	public Boolean stopConference(String applicationID, Integer tempConferenceID)
//			throws Exception
//	{
//		// 参数为空判断
////		if (tempConferenceID == null || tempConferenceID.intValue() == 0)
////		{
////			LOGGER.error("停止会议方法传递参数：ConferenceID 为空，调用中断，直接返回NULL");
////			return false;
////		}
////		// 调用业务管理关闭会议方法
////		try
////		{
////			int site = conferenceBusinessManager.getSite(applicationID, tempConferenceID);
////			agent.stopConferenceWithoutUser(site, tempConferenceID);
////		}
////		catch (CMSException e)
////		{
////			// add by tanyunhua
////			if ("404".equals(e.getCodeID()))
////			{
////				ConfJoinTempConf tempConf = confJoinTempConfManager
////						.getConfJoinTempConfByTempConfID(tempConferenceID);
////				if (tempConf != null)
////				{
////					confJoinTempConfManager
////							.deleteConfJoinTempConfByTempConfID(tempConferenceID); // delete
////					// by
////					// tanyunhua
////					// 2011-10-31
////					Cdrconferenceinfo cdrConferenceInfo = cdrConferenceInfoManager
////							.queryCdrConfByConfIDAndTempID(tempConferenceID);
////					if (cdrConferenceInfo != null
////							&& cdrConferenceInfo.getEndtime() == null)
////					{
////						cdrConferenceInfo.setEndtime(new Date());
////						cdrConferenceInfoManager.update(cdrConferenceInfo);
////					}
////					return true;
////				}
////			}
////			// add end
////			LOGGER.error("停止会议发生异常，调用中断，直接返回NULL！异常信息：" + e.getMessage()
////					+ "---异常类型：" + e.getClass().toString());
////			throw CMSException2JNIException.getJNIException(e);
////		}
//		return true;
//	}
//
//	/**
//	 * 会议删除，提供给会议监控使用，释放所有会议资源
//	 * 
//	 * @param conferenceID
//	 *            临时会议ID
//	 * @return 返回是否成功关闭会议
//	 * @throws Exception
//	 *             抛出异常
//	 * @code {这里可以添加函数调用示例代码}
//	 * @endcode
//	 * @since JDK1.6
//	 * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
//	 * @see
//	 */
//	// @Override
//	public Boolean deleteConference(String applicationID, Integer conferenceID)
//			throws Exception
//	{
//		// 参数为空判断
//		if (conferenceID == null)
//		{
//			LOGGER.error("删除会议方法传递参数：ConferenceID 为空，调用中断，直接返回NULL");
//			return false;
//		}
//		// 调用业务管理删除会议方法
////		try
////		{
////			int site = conferenceBusinessManager.getSite(applicationID, conferenceID);
////			agent.deleteConferenceWithoutUser(site, conferenceID);
////		}
////		catch (CMSException e)
////		{
////			LOGGER.error("exception  delete conference = " + conferenceID);
////			// add by tanyunhua
////			if ("404".equals(e.getCodeID()))
////			{
////				ConfJoinTempConf tempConf = confJoinTempConfManager
////						.getConfJoinTempConfByTempConfID(conferenceID);
////				if (tempConf != null)
////				{
////					confJoinTempConfManager
////							.deleteConfJoinTempConfByTempConfID(conferenceID); // delete
////					// by
////					// tanyunhua
////					// 2011-10-31
////					Cdrconferenceinfo cdrConferenceInfo = cdrConferenceInfoManager
////							.queryCdrConfByConfIDAndTempID(conferenceID);
////					if (cdrConferenceInfo != null
////							&& cdrConferenceInfo.getEndtime() == null)
////					{
////						cdrConferenceInfo.setEndtime(new Date());
////						cdrConferenceInfoManager.update(cdrConferenceInfo);
////					}
////					return true;
////				}
////			}
////			// add end
////
////			// LOGGER.error("删除会议发生异常，调用中断，直接返回NULL！异常信息：" + e.getMessage() +
////			// "---异常类型：" + e.getClass().toString());
////			throw CMSException2JNIException.getJNIException(e);
////		}
//		return true;
//	}
//
//	/**
//	 * 查询指定会议的在会用户数，动态
//	 * 
//	 * @param tempConfID
//	 *            临时会议ID
//	 * @return
//	 * @throws JNIException
//	 */
//	public Integer queryUserNum(String applicationID, Integer tempConfID)
//			throws Exception
//	{
//		if (tempConfID == null)
//		{
//			LOGGER.error("调用查询会议当前用户方法传递参数为空，调用中断，直接返回NULL");
//			return null;
//		}
////		// 用户数
////		try
////		{
////			int site = conferenceBusinessManager.getSite(applicationID, tempConfID);
////
////			List<BMSUserInfo> userList = agent.getUserList(site, tempConfID);
////
////			return userList.size();
////		}
////		catch (CMSException e)
////		{
////			e.printStackTrace();
////			throw CMSException2JNIException.getJNIException(e);
////		}
//		return 0;
//	}
//
//
//
//	/**
//	 * 直接启动一个会议
//	 * 
//	 * @param applicationID
//	 *            应用ID
//	 * @param tempConferenceID
//	 *            临时会议ID
//	 * @return
//	 * @throws Exception
//	 */
//	public Boolean startConference(String applicationID,
//			Integer tempConferenceID) throws Exception
//	{
//		if (tempConferenceID == null)
//		{
//			LOGGER.error("会议还未创建，请先创建会议再启动，调用中断，直接返回fasle");
//			return false;
//		}
//
////		int site = conferenceBusinessManager.getSite(applicationID, tempConferenceID);
////
////		try
////		{
////			long startTime = System.currentTimeMillis();
////			agent.startConferenceWithoutUser(site, tempConferenceID);
////			LOGGER.info("[Tang CMS call jni with start conference: time: "
////					+ (System.currentTimeMillis() - startTime) + "]");
////			ConfJoinTempConf confJoinTempConf = confJoinTempConfManager
////					.getConfJoinTempConfByTempIDAndStatus(tempConferenceID,
////							new Integer(1));
////			if (confJoinTempConf != null)
////			{
////				confJoinTempConf.setBmsStatus(Consts.CONF_STATUS_BMS_START);
////				confJoinTempConfManager.update(confJoinTempConf);
////			}
////			LOGGER.info("调用业务管理不带用户启动方法成功返回！tempconfID[" + tempConferenceID
////					+ "]");
////		}
////		catch (CMSException e)
////		{
////			LOGGER.error("调用业务管理不带用户启动方法发生异常。异常信息：" + e.getMessage());
////			e.printStackTrace();
////			throw CMSException2JNIException.getJNIException(e);
////		}
//		return true;
//	}
//
//	/**
//	 * 用户加入 ---仅为继续支持原有的userJoin接口
//	 * 
//	 * @param applicationID
//	 * @param tempConferenceID
//	 * @param user
//	 * @return
//	 * @throws Exception
//	 */
//	@Deprecated
//	private UserChannel joinConferenceOld(String applicationID,
//			Integer tempConferenceID, User user, Conference conf)
//			throws Exception
//	{
////		user.setTempuserid(this.getTempUserID());
////		// user.setTempuserid(tempUserManager.getTempuseridByTempconfid(tempConferenceID));
////
////		BMSUserInfo userInfo = BeanTranslatorUtil.copyUser2UserInfo(user);
////
////		if (tempConferenceID == null) return null;
////		// change user domain
////		Integer userDomain = ipdomainManager.getDomainByIp(userInfo.getIPArr());
////		// Integer userDomain = null;
////		if (userDomain != null) userInfo.setDomain(userDomain);
////		else LOGGER.error("Not find responding domain for UserIP="
////				+ user.getIpaddr() + ", domain=" + user.getDomain());
////		// chang end
////
////		int site = conferenceBusinessManager.getSite(applicationID, tempConferenceID);
////		try
////		{
////			long startTime = System.currentTimeMillis();
////			// modify by tanyunhua 2011-10-31
////			UserChannel userChannel;
////			if (user.getIsowner() != null && user.getIsowner()) userChannel = agent
////					.startConferenceWithUser(site, tempConferenceID, userInfo);
////			else userChannel = agent.userJoinConference(site, tempConferenceID,
////					userInfo);
////			// modify end
////
////			LOGGER.info("[Tang CMS call jni with user join conference: time: "
////					+ (System.currentTimeMillis() - startTime) + "]");
////
////			// 判断返回值状态,如果发生异常，写日志，返回null
////			if (userChannel == null)
////			{
////				LOGGER.error("调用业务管理带用户启动发返回为NULL");
////				pinrefManager.deletePin(conf.getBillingcode(), user
////						.getPinCode().toString());
////				return null;
////			}
////
////			return userChannel;
////		}
////		catch (CMSException e)
////		{
////
////			if (conf.getPin() == null || !conf.getPin())
////			{
////				if (user.getIsowner() == null || !user.getIsowner()
////						|| !"412".equals(e.getCodeID())) pinrefManager
////						.deletePin(conf.getBillingcode(), user.getPinCode()
////								.toString());
////			}
////
////			LOGGER.error("exception join conference = " + tempConferenceID);
////			LOGGER.info("[Tang CMS agent error code id: ]" + e.getCodeID());
////
////			if ("404".equals(e.getCodeID()))
////			{
////				try
////				{
////					ConferenceInfoBMS conferenceInfoBMS = agent.getConfInfo(
////							site, tempConferenceID);
////					if ((conferenceInfoBMS.getStatus() & 0x7) == Consts.CONF_STATUS_END)
////					{
////						LOGGER
////								.info("deleteConfJoinTempConf---joinConferenceOld---[Tang CMS agent error code id:404 status=3]"
////										+ tempConferenceID);
////						confJoinTempConfManager
////								.deleteConfJoinTempConfByTempConfID(tempConferenceID); // delete
////						// by
////						// tanyunhua
////						// 2011-10-31
////						Cdrconferenceinfo cdrConferenceInfo = cdrConferenceInfoManager
////								.queryCdrConfByConfIDAndTempID(tempConferenceID);
////						if (cdrConferenceInfo != null
////								&& cdrConferenceInfo.getEndtime() == null)
////						{
////							cdrConferenceInfo.setEndtime(new Date());
////							cdrConferenceInfoManager.update(cdrConferenceInfo);
////						}
////					}
////				}
////				catch (CMSException cmse)
////				{
////					if ("404".equals(cmse.getCodeID()))
////					{
////						LOGGER
////								.info("deleteConfJoinTempConf---joinConferenceOld---getConfInfo--[Tang CMS agent error code id:404 ]"
////										+ tempConferenceID);
////						confJoinTempConfManager
////								.deleteConfJoinTempConfByTempConfID(tempConferenceID); // delete
////						// by
////						// tanyunhua
////						// 2011-10-31
////						Cdrconferenceinfo cdrConferenceInfo = cdrConferenceInfoManager
////								.queryCdrConfByConfIDAndTempID(tempConferenceID);
////						if (cdrConferenceInfo != null
////								&& cdrConferenceInfo.getEndtime() == null)
////						{
////							cdrConferenceInfo.setEndtime(new Date());
////							cdrConferenceInfoManager.update(cdrConferenceInfo);
////						}
////					}
////					else
////					{
////						throw CMSException2JNIException.getJNIException(cmse);
////					}
////				}
////			}
////			else
////			{
////				throw CMSException2JNIException.getJNIException(e);
////			}
//	//		LOGGER.info("调用业务管理用户加入发生异常,异常信息：" + e.getMessage());
//		//	e.printStackTrace();
//			return null;
//		//}
//	}
//
//	/**
//	 * 用户加入--用户使用
//	 * 
//	 * @param applicationID
//	 * @param tempConferenceID
//	 * @param user
//	 * @return
//	 * @throws Exception
//	 */
//	public UserChannel joinConference(String applicationID,
//			Integer tempConferenceID, User user) throws Exception
//	{
//		Integer conferenceID = null;
////		// //设置角色
////		// List<Integer> rolelist = new ArrayList<Integer>();
////		// rolelist.addAll(user.getRolemap().keySet());
////		// //是否禁止外呼
////		// if(this.isProhibit(user.getIpaddr())) {
////		// rolelist.add(1);
////		// }
////		// 设置用户权限
//		ConfJoinTempConf confJoinTempConf = new ConfJoinTempConf();
////				.getConfJoinTempConfByTempIDAndStatus(tempConferenceID, 1);
////		if (confJoinTempConf == null)
////		{
////			LOGGER.error("not exist data record for tempconferenceID["
////					+ conferenceID + "]");
////			return null;
////		}
////		else conferenceID = confJoinTempConf.getConfID();
////
//		Conference conf = new Conference();
//
//		return joinConf(applicationID, confJoinTempConf, conf, user);
//	
//	
//	}
//
//	/**
//	 * 用户加入
//	 * 
//	 * @param applicationID
//	 * @param conferenceID
//	 * @param tempConferenceid
//	 * @param user
//	 * @return
//	 * @throws Exception
//	 */
//	@Deprecated
//	public UserService userJoin(String applicationID, Integer conferenceID,
//			Integer tempConferenceid, User user) throws Exception
//	{
//		LOGGER.info("======================>userJoin:applicationID="
//				+ applicationID + ";conferenceID=" + conferenceID
//				+ ";tempConferenceid=" + tempConferenceid);
//		long startTime = System.currentTimeMillis();
//		// add by tanyunhua for check pin 2011-10-31
////		Conference conf = conferenceManager.query(conferenceID);
////		if (conf == null)
////		{
////			LOGGER.error("not exist data record for [" + conferenceID + "]");
////			return null;
////		}
//
//
//		// end add
//
//		UserService userService = null;
////		if (tempConferenceid != null && tempConferenceid.intValue() > 0)
////		{
////			UserChannel userChannel = this.joinConferenceOld(applicationID,
////					tempConferenceid, user, conf);
////			userService = composeUserService(userChannel, user,
////					tempConferenceid);
////		}
////		else
////		{
////			userService = this
////					.userJoin(applicationID, conferenceID, user, conf);
////		}
////		long endTime = System.currentTimeMillis();
////		LOGGER.info("======================>userJoin Conf time: ["
////				+ (endTime - startTime) + "] confid: " + tempConferenceid
////				+ " userId: " + user.getTempuserid());
//		return userService;
//	}
//
//	/**
//	 * 用户加入 此方法在创建会议的分支里要特别考虑并发问题。
//	 * 
//	 * @param applicationID
//	 * @param conferenceID
//	 * @param user
//	 * @return
//	 * @throws Exception
//	 */
//	@Deprecated
//	private UserService userJoin(String applicationID, Integer conferenceID,
//			User user, Conference conf) throws Exception
//	{
//
//		// 设置角色
////		List<Integer> rolelist = new ArrayList<Integer>();
////		rolelist.addAll(user.getRolemap().keySet());
////		// 是否禁止外呼
////		if (this.isProhibit(user.getIpaddr()))
////		{
////			rolelist.add(1);
////		}
////		// 设置用户权限
////		Map<Integer, List<Integer>> roleprivilegemap = this.productRoleManager
////				.queryAllRolePrivileges(conf.getProduct().getProductid(),
////						rolelist);
////		user.setRolemap(roleprivilegemap);
////
////		Integer tempConferenceID = null;
////
////		ConfJoinTempConf confJoinTempConf = confJoinTempConfManager
////				.getConfJoinTempConfByStart(conferenceID);
////		if (confJoinTempConf == null)
////		{
////			tempConferenceID = this.getConfID();
////			confJoinTempConf = conferenceBusinessManager.createTempConfInDb(
////					conferenceID, tempConferenceID);
////			if (confJoinTempConf == null)
////			{
////				LOGGER.error("create cms temp Conf error: " + conferenceID
////						+ "  " + tempConferenceID);
////				return null;
////			}
////		}
////
////		tempConferenceID = confJoinTempConf.getTempConfID();
////		if (confJoinTempConf.isNeedCreate()) // 需要创建会议
////		{
////			try
////			{
////				if (!createConference(applicationID, tempConferenceID, conf))
////				{
////					// 创建会议失败，需要删除已提交的JoinTempConf数据。
////					conferenceBusinessManager
////							.deleteConfJoinTempConfByTempConfID(tempConferenceID);
////					LOGGER.error("create conference not success confID: "
////							+ tempConferenceID);
////					return null;
////				}
////
////				confJoinTempConf.setBmsStatus(Consts.CONF_STATUS_BMS_NEW);
////				conferenceBusinessManager
////						.updateConfJoinTempConf(confJoinTempConf);
////			}
////			catch (Exception e)
////			{
////				// 创建会议失败，需要删除已提交的JoinTempConf数据。
////				conferenceBusinessManager
////						.deleteConfJoinTempConfByTempConfID(tempConferenceID);
////				LOGGER.error(e.getMessage());
////				throw e;
////			}
////
////			try
////			{
////				// 设置路由
////				routerManager.createRouter(applicationID, tempConferenceID);
////			}
////			catch (Exception e)
////			{
////				LOGGER.error(e.getMessage());
////			}
////		}
////		confJoinTempConf = null;
////
////		// 加入会议
////		UserChannel userChannel = this.joinConferenceOld(applicationID,
////				tempConferenceID, user, conf);
////		if (userChannel == null)
////		{
////			LOGGER.error("user join conference old return null");
////			return null;
////		}
////		// 主动释放引用，以利于回收
////		conf = null;
//	//	return composeUserService(userChannel, user, tempConferenceID);
//		return null;
//	}
//
//	
//	/**
//	 * 实时会议创建后，用户发起轮询请求，根据临时会议ID查询会议状态信息
//	 * 
//	 * @param applicationID
//	 *            应用ID
//	 * @param tempConfID
//	 *            临时会议ID
//	 * @return
//	 * @throws Exception
//	 */
//	public Integer getBMSConferenceInfo(String applicationID, Integer tempConfID)
//			throws Exception
//	{
//
////		if (tempConfID == null || tempConfID.intValue() == 0)
////		{
////			LOGGER.info("tempConfID is null or is 0");
////			return Consts.CONF_STATUS_NOT_FOUND;
////		}
////
////		ConfJoinTempConf confJoinTempConf = confJoinTempConfManager
////				.getConfJoinTempConfByTempConfID(tempConfID);
////		Cdrconferenceinfo cdrConferenceInfo = cdrConferenceInfoManager
////				.queryCdrConfByConfIDAndTempID(tempConfID);
////		if (confJoinTempConf == null)
////		{
////			if (cdrConferenceInfo == null)
////			{
////				LOGGER.info("not exist conferenceID：" + tempConfID
////						+ " for cdrConferenceInfo");
////				return Consts.CONF_STATUS_NOT_FOUND;
////			}
////			// confJoinTempConf == null和cdrConferenceInfo.getEndtime() !=
////			// null应该同时存在，否则，是其他地方错误
////			if (cdrConferenceInfo.getEndtime() == null)
////			{
////				LOGGER
////						.error("cdr conference info is error, no endtime, teomConfID is: "
////								+ tempConfID);
////			}
////
////			return Consts.CONF_STATUS_END;
////		}
////
////		if (confJoinTempConf.getBmsStatus() == null) // 迁就老数据，老数据bmsStatus初始值为null
////		return Consts.CONF_STATUS_DB_NEW;
////
////		int bmsStatus = confJoinTempConf.getBmsStatus();
////		int site = conferenceBusinessManager.getSite(applicationID, tempConfID);
////		// bms给cms消息可能有延迟，所以会议状态为CONF_STATUS_BMS_START时，需要查询bms状态
////		if (bmsStatus != Consts.CONF_STATUS_BMS_START)
////		{
////			if (cdrConferenceInfo == null) return Consts.CONF_STATUS_DB_NEW;
////			Conference conf = conferenceManager.query(cdrConferenceInfo
////					.getConferenceid());
////			int time1 = 0;
////			if (conf.getTime1() != null) time1 = conf.getTime1();
////
////			Calendar cal = Calendar.getInstance();
////			cal.add(Calendar.MINUTE, -1 * time1);
////
////			// if (cdrConferenceInfo.getCreatetime().before(cal.getTime())) //
////			// 防止create后长时间不入会，导致入会时发生404错误。
////			// {
////			// cdrConferenceInfo.setEndtime(new Date());
////			// cdrConferenceInfo.setModifytime(new Date());
////			// LOGGER.info("After " + time1 + " minutes host isn't join");
////			// LOGGER.info("tempConferenceId is " + tempConfID);
////			// try
////			// {
////			// agent.startConferenceWithoutUser(site, tempConfID);
////			// }
////			// catch (Throwable ex)
////			// {
////			// LOGGER.error("exception occurs when start conference "
////			// + tempConfID);
////			// LOGGER.error(ex.getMessage());
////			// }
////			// try
////			// {
////			// agent.stopConferenceWithoutUser(site, tempConfID);
////			// }
////			// catch (Throwable ex)
////			// {
////			// LOGGER.error("exception occurs when stop conference "
////			// + tempConfID);
////			// LOGGER.error(ex.getMessage());
////			// }
////			//
////			// cdrConferenceInfoManager.update(cdrConferenceInfo);
////			// confJoinTempConfManager.delete(confJoinTempConf);
////			// return Consts.CONF_STATUS_END;
////			// }
////			return bmsStatus;
////		}
////
////		try
////		{
////			ConferenceInfoBMS confStatus = agent.getConfInfo(site, tempConfID);
////			if (confStatus == null)
////			{
////				LOGGER.error("BMS not exist conferenceID：" + tempConfID);
////				return Consts.CONF_STATUS_NOT_FOUND;
////			}
////			bmsStatus = confStatus.getStatus();
////			if ((bmsStatus & 0x7) == Consts.CONF_STATUS_END) // bms会议已结束
////			{
////				// 修改cdr结束时间
////				// Cdrconferenceinfo cdrConferenceInfo =
////				// cdrConferenceInfoManager.queryCdrConfByConfIDAndTempID(tempConfID);
////				cdrConferenceInfo.setEndtime(new Date()); // new Date可能会引起计费错误
////				cdrConferenceInfo.setModifytime(new Date());
////				cdrConferenceInfoManager.update(cdrConferenceInfo);
////
////				// 删除confID和tempConfID关联，下次以confID再入会，会重新创建一场会议。
////				LOGGER
////						.info("deleteConfJoinTempConf---getBMSConferenceInfo--[Tang CMS agent error code id:404 status=3]"
////								+ tempConfID);
////				confJoinTempConfManager.delete(confJoinTempConf);
////			}
////			LOGGER.error("BMS status：" + bmsStatus);
////			return bmsStatus;
////		}
////		catch (CMSException e)
////		{
////			// for yanfa test, tms 内存文件丢失
////			if (e.getCodeID().equals("404"))
////			{
////				LOGGER.info("[Tang CMS confernce status BMS-404] id: "
////						+ tempConfID);
////				// Cdrconferenceinfo cdrConferenceInfo =
////				// cdrConferenceInfoManager.queryCdrConfByConfIDAndTempID(tempConfID);
////				if (cdrConferenceInfo != null
////						&& cdrConferenceInfo.getEndtime() == null)
////				{
////					cdrConferenceInfo.setEndtime(new Date()); // new
////					// Date可能会引起计费错误
////					cdrConferenceInfo.setModifytime(new Date());
////					cdrConferenceInfoManager.update(cdrConferenceInfo);
////				}
////				LOGGER
////						.info("deleteConfJoinTempConf---getBMSConferenceInfo--[Tang CMS agent error code id:404 ]"
////								+ tempConfID);
////				if (confJoinTempConf != null) confJoinTempConfManager
////						.delete(confJoinTempConf);
////			}
////			LOGGER.error("getBMSConferenceInfo tempConfID : " + tempConfID);
////			throw CMSException2JNIException.getJNIException(e);
////		}
//		return 0;
//	}
//
//	/**
//	 * 根据临时会议ID和临时用户ID查询该用户在该会议中的状态
//	 * 
//	 * @param applicationID
//	 *            应用ID
//	 * @param tempConfID
//	 *            临时会议ID
//	 * @param tempUserID
//	 *            临时用户ID
//	 * @return
//	 * @throws JNIException
//	 */
//	public UserConferenceStatus getUserConferenceStatus(String applicationID,
//			Integer tempConfID, Integer tempUserID) throws Exception
//	{
//		if (tempConfID == null || tempUserID == null)
//		{
//			LOGGER
//					.error("getUserConferenceStatus method:transfer parameter tempConfID/tempUserID is null ，return null！");
//			return null;
//		}
//
//		try
//		{
//			//int site = conferenceBusinessManager.getSite(applicationID, tempConfID);
//			return agent.getUserConferenceStatus(1, tempConfID, tempUserID);
//		}
//		catch (CMSException e)
//		{
//			e.printStackTrace();
//			throw CMSException2JNIException.getJNIException(e);
//		}
//	}
//
////	/**
////	 * 是否强制禁止外呼
////	 * 
////	 * @param ipaddr
////	 * @return
////	 */
////	private Boolean isProhibit(String ipaddr)
////	{
////		Boolean flag = false;
////		Long ipValue = IPTranslatorUtil.ipToLong(ipaddr);
////		List<WhiteIPList> whiteIPList = whiteIPListManager
////				.getWhiteIPList(ipValue);
////		List<BlackIPList> blackIPList = blackIPListManager
////				.getBlackIPList(ipValue);
////		if (whiteIPList.size() < 0)
////		{
////			if (blackIPList.size() > 0)
////			{
////				flag = true;
////			}
////		}
////		return flag;
////	}
//
//	/**
//	 * 组装UserService
//	 * 
//	 * @param userChannel
//	 * @param user
//	 * @param tempConferenceID
//	 * @return
//	 */
//	private UserService composeUserService(UserChannel userChannel, User user,
//			Integer tempConferenceID)
//	{
//		List<DtServiceAddr> dtsip = new ArrayList<DtServiceAddr>();
//		if (userChannel.ctsAddr == null || userChannel.ctsAddr.isEmpty())
//		{
//			LOGGER.error("业务管理返回的ctsAddr地址列表为空！调用中断，直接返回NULL！");
//			throw new NullPointerException(
//					"业务管理返回的ctsAddr地址列表为空！调用中断，直接返回NULL！");
//		}
//		if (userChannel.dtsAddr == null || userChannel.dtsAddr.isEmpty())
//		{
//			LOGGER.error("业务管理返回的dtsAddr地址列表为空！");
//			dtsip = null;
//		}
//		else
//		{
//			// dtsip =
//			// BeanTranslatorUtil.copyUserServiceAddr2DtServiceAddr(userChannel.dtsAddr);
//			dtsip = new ArrayList<DtServiceAddr>();
//			for (UserServiceAddr usaddr : userChannel.dtsAddr)
//			{
////				dtsip.add(new DtServiceAddr(queryServerDomain(usaddr
////						.getServerIP0(), TYPE_DTS), usaddr.channel,
////						usaddr.serviceType, usaddr.groupID));
//			}
//		}
//		// List<CtServiceAddr> ctsip =
//		// BeanTranslatorUtil.copyUserServiceAddr2CtServiceAddr(userChannel.ctsAddr);
////		List<CtServiceAddr> ctsip = new ArrayList<CtServiceAddr>();
////		for (UserServiceAddr usaddr : userChannel.ctsAddr)
////		{
////			ctsip.add(new CtServiceAddr(queryServerDomain(
////					usaddr.getServerIP0(), TYPE_CTS), queryServerDomain(usaddr
////					.getHotServerIP0(), TYPE_HOT), usaddr.channel,
////					usaddr.serviceType, usaddr.groupID));
////		}
////		UserService userservice = new UserService(ctsip, dtsip, user,
////				tempConferenceID);// 业务管理返回的数据
//		// 返回调用
//	//	return userservice;
//		return null;
//	}
//
//
//
//
//
//
//
//	/**
//	 * tempConfIdManager
//	 * 
//	 * @param itempConfIdManager
//	 *            the tempConfIdManager to set
//	 */
//
//
//
//	public void setAgent(ICMSAgentInterface agent)
//	{
//		this.agent = agent;
//	}
//
//
//
//
//	/**
//	 * 创建临时会议，生成一个临时会议ID，向BMS发送create with out user命令，记录一个会议cdr 创建会议时需要考虑并发
//	 * 
//	 * @param applicationID
//	 *            应用ID
//	 * @param billingCode
//	 *            计费代码
//	 * @return 临时会议ID（会议对象）
//	 * @throws Exception
//	 */
//	public Integer createConference(String applicationID, String billingCode)
//			throws Exception
//	{
////		Conference conference = conferenceManager
////				.getFixedConference(billingCode);
////		if (conference == null)
////		{
////			LOGGER.error("billingcode error: " + billingCode + " not exist");
////			throw new Exception("billingcode error, not open");
////		}
////
////		return initConf(applicationID, conference);
//		return 0;
//	}
//
//	/**
//	 * 创建临时会议，生成一个临时会议ID，向BMS发送create with out user命令，记录一个会议cdr 创建会议时需要考虑并发
//	 * 
//	 * @param applicationID
//	 *            应用ID
//	 * @param billingCode
//	 *            计费代码
//	 * @return 临时会议ID（会议对象）
//	 * @throws Exception
//	 */
//	public Integer createConferenceWithBillInfo(String applicationID,
//			String billingCode, String billInfo) throws Exception
//	{
////		Conference conference = conferenceManager
////				.getFixedConference(billingCode);
////		if (conference == null)
////		{
////			LOGGER.error("billingcode error: " + billingCode + " not exist");
////			throw new Exception("billingcode error, not open");
////		}
////
////		return initConfWithBillInfo(applicationID, conference, billInfo);
//		return 0;
//	}
//
//	/**
//	 * 初始化一场预约会议。
//	 * 将会创建一场BMS会议，往ConfJoinTempConf、Cdrconferenceinfo、Router表中各插入一条数据。
//	 * 
//	 * @param applicationID
//	 *            应用ID
//	 * @param conferenceID
//	 *            预约会议ID，需要是预约出来的会议ID，而不是开通出来的ID
//	 * @return 临时会议ID（会议对象）
//	 * @throws Exception
//	 */
//	public Integer initConference(String applicationID, Integer conferenceID)
//			throws Exception
//	{
////		Conference conference = conferenceManager
////				.getReservedConference(conferenceID);
////		if (conference == null)
////		{
////			LOGGER.error("给定的预约会议ID错误：" + conferenceID + " 不存在");
////			throw new Exception("给定的会议对象错误");
////		}
//
//	//	return initConf(applicationID, conference);
//		return 0;
//	}
//
//	/**
//	 * 初始化一场会议
//	 * 
//	 * @param applicationID
//	 *            应用ID
//	 * @param tempConferenceID
//	 *            临时会议ID
//	 * @param conference
//	 *            会议对象
//	 * @throws Exception
//	 */
//	private Integer initConf(String applicationID, Conference conference)
//			throws Exception
//	{
////		if (conference.getValid().equals(1))
////		{
////			LOGGER.error("this conference[" + conference.getBillingcode()
////					+ "] is delete, can't create now meeting");
////			throw new Exception(
////					"billingcode error, this conference is delete, can't create now meeting");
////		}
////
////		ConfJoinTempConf tempConf = confJoinTempConfManager
////				.getConfJoinTempConfByStart(conference.getConferenceid());
////		if (tempConf != null)
////		{
////			LOGGER.info("find the old conference init");
////			if (Consts.CONF_STATUS_DB_NEW.equals(tempConf.getBmsStatus()))
////			{
////				Thread.sleep(300);
////			}
////
////			return tempConf.getTempConfID();
////		}
////
////		Integer tempConferenceID = getConfID();
////		ConfJoinTempConf confJoinTempConf = conferenceBusinessManager
////				.createTempConfInDb(conference.getConferenceid(),
////						tempConferenceID);
////		if (confJoinTempConf == null)
////		{
////			LOGGER.error("create cms temp Conf error: "
////					+ conference.getConferenceid() + "  " + tempConferenceID);
////			return null;
////		}
////
////		try
////		{
////			// 创建一场BMS会议
////			if (confJoinTempConf.isNeedCreate()) createBMSConference(
////					applicationID, tempConferenceID, conference);
////
////		}
////		catch (Exception e)
////		{
////			LOGGER.error("create bms conference error", e);
////			conferenceBusinessManager.delete(confJoinTempConf);
////			throw e;
////		}
////		confJoinTempConf.setBmsStatus(Consts.CONF_STATUS_BMS_NEW);
////		conferenceBusinessManager.updateConfJoinTempConf(confJoinTempConf);
////
////		Cdrconferenceinfo cdrConferenceInfo = new Cdrconferenceinfo();
////		// 操作数据库添加cdrconfernceinfo记录
////		cdrConferenceInfo.setConferenceid(conference.getConferenceid());
////		cdrConferenceInfo.setCreatetime(new Date());
////		cdrConferenceInfo.setTempconferenceid(tempConferenceID);
////		cdrConferenceInfo.setBillingcode(conference.getBillingcode());
////		cdrConferenceInfo.setReservtime(conference.getReservtime());
////		cdrConferenceInfo.setConferencename(conference.getConferencename());
////		cdrConferenceInfo.setConferencedesc(conference.getConferencedesc());
////		cdrConferenceInfo.setDuration(conference.getConferenceminutes());
////		cdrConferenceInfo.setParties(conference.getConfscale());
////		cdrConferenceInfoManager.create(cdrConferenceInfo);
////
////		// 设置路由
////		try
////		{
////			routerManager.createRouter(applicationID, tempConferenceID);
////		}
////		catch (Exception e)
////		{
////			// TODO Auto-generated catch block
////			LOGGER.error("initConference保存路由表是出现错误");
////		}
////		return tempConferenceID;
//		return 0;
//	}
//
//	/**
//	 * 初始化一场会议
//	 * 
//	 * @param applicationID
//	 *            应用ID
//	 * @param tempConferenceID
//	 *            临时会议ID
//	 * @param conference
//	 *            会议对象
//	 * @throws Exception
//	 */
//	private Integer initConfWithBillInfo(String applicationID,
//			Conference conference, String billInfo) throws Exception
//	{
////		if (conference.getValid().equals(1))
////		{
////			LOGGER.error("this conference[" + conference.getBillingcode()
////					+ "] is delete, can't create now meeting");
////			throw new Exception(
////					"billingcode error, this conference is delete, can't create now meeting");
////		}
////
////		ConfJoinTempConf tempConf = confJoinTempConfManager
////				.getConfJoinTempConfByStart(conference.getConferenceid());
////		if (tempConf != null)
////		{
////			LOGGER.info("find the old conference init");
////			if (Consts.CONF_STATUS_DB_NEW.equals(tempConf.getBmsStatus()))
////			{
////				Thread.sleep(300);
////			}
////
////			return tempConf.getTempConfID();
////		}
////
////		Integer tempConferenceID = getConfID();
////		ConfJoinTempConf confJoinTempConf = conferenceBusinessManager
////				.createTempConfInDb(conference.getConferenceid(),
////						tempConferenceID);
////		if (confJoinTempConf == null)
////		{
////			LOGGER.error("create cms temp Conf error: "
////					+ conference.getConferenceid() + "  " + tempConferenceID);
////			return null;
////		}
////
////		try
////		{
////			// 创建一场BMS会议
////			if (confJoinTempConf.isNeedCreate()) createBMSConferenceWithBillInfo(
////					applicationID, tempConferenceID, conference, billInfo);
////
////		}
////		catch (Exception e)
////		{
////			LOGGER.error("create bms conference error", e);
////			conferenceBusinessManager.delete(confJoinTempConf);
////			throw e;
////		}
////		confJoinTempConf.setBmsStatus(Consts.CONF_STATUS_BMS_NEW);
////		conferenceBusinessManager.updateConfJoinTempConf(confJoinTempConf);
////
////		Cdrconferenceinfo cdrConferenceInfo = new Cdrconferenceinfo();
////		// 操作数据库添加cdrconfernceinfo记录
////		cdrConferenceInfo.setConferenceid(conference.getConferenceid());
////		cdrConferenceInfo.setCreatetime(new Date());
////		cdrConferenceInfo.setTempconferenceid(tempConferenceID);
////		cdrConferenceInfo.setBillingcode(conference.getBillingcode());
////		cdrConferenceInfo.setReservtime(conference.getReservtime());
////		cdrConferenceInfo.setConferencename(conference.getConferencename());
////		cdrConferenceInfo.setConferencedesc(conference.getConferencedesc());
////		cdrConferenceInfo.setDuration(conference.getConferenceminutes());
////		cdrConferenceInfo.setParties(conference.getConfscale());
////		cdrConferenceInfoManager.create(cdrConferenceInfo);
////
////		// 设置路由
////		try
////		{
////			routerManager.createRouter(applicationID, tempConferenceID);
////		}
////		catch (Exception e)
////		{
////			// TODO Auto-generated catch block
////			LOGGER.error("initConference保存路由表是出现错误");
////		}
////		return tempConferenceID;
//		return 0;
//	}
//
//	/**
//	 * 创建一场BMS会议
//	 * 
//	 * @param conference
//	 * @param tempConferenceID
//	 * @param applicationID
//	 * @throws Exception
//	 */
//	private void createBMSConference(String applicationID,
//			Integer tempConferenceID, Conference conference) throws Exception
//	{
//		// 向BMS create一场会议
//		// 调用业务管理接口，不带用户创建，如果调用业务管理成功，修改tempconference状态信息为1（已创建，未启动）---------
//		// 不带用户创建，传递的user信息是null
//		List<Integer> valuelist = new ArrayList<Integer>();
////		Set<Conferenceuservalue> uservalueset = conference
////				.getConferenceuservalues();
////		for (Conferenceuservalue uservalue : uservalueset)
////		{
////			valuelist.add(uservalue.getValue());
////		}
////		List<Integer> servicetypelistByInteger = CodeTranslatorUtil
////				.translateUserCodeValue2ServiceTypeByInteger(valuelist);
////
////		List<String> servicetypelist = new ArrayList<String>();
////		for (Integer i : servicetypelistByInteger)
////		{
////			servicetypelist.add(i + "");
////		}
////
////		ConferenceInfoBMS confInfo = BeanTranslatorUtil
////				.copyConference2ConferenceInfo(conference, tempConferenceID,
////						null, productRoleManager);
////		int site = conferenceBusinessManager.initSite(applicationID, tempConferenceID);
////		long startTime = System.currentTimeMillis();
////		try
////		{
////			agent.createConferenceWithoutUser(site, confInfo, servicetypelist);
////			LOGGER
////					.info("[Tang CMS call jni with create conference without user: time: "
////							+ (System.currentTimeMillis() - startTime) + "]");
////			LOGGER.info("调用业务管理不带用户创建成功返回！confID[" + tempConferenceID + "]");
////		}
////		catch (CMSException e)
////		{
////			LOGGER.info("调用业务管理不带用户发生异常！confID[" + tempConferenceID + "]");
////			throw CMSException2JNIException.getJNIException(e);
////		}
//	}
//
//	/**
//	 * 创建一场BMS会议
//	 * 
//	 * @param conference
//	 * @param tempConferenceID
//	 * @param applicationID
//	 * @throws Exception
//	 */
//	private void createBMSConferenceWithBillInfo(String applicationID,
//			Integer tempConferenceID, Conference conference, String billInfo)
//			throws Exception
//	{
//		// 向BMS create一场会议
//		// 调用业务管理接口，不带用户创建，如果调用业务管理成功，修改tempconference状态信息为1（已创建，未启动）---------
//		// 不带用户创建，传递的user信息是null
//		List<Integer> valuelist = new ArrayList<Integer>();
////		Set<Conferenceuservalue> uservalueset = conference
////				.getConferenceuservalues();
////		for (Conferenceuservalue uservalue : uservalueset)
////		{
////			valuelist.add(uservalue.getValue());
////		}
////		List<Integer> servicetypelistByInteger = CodeTranslatorUtil
////				.translateUserCodeValue2ServiceTypeByInteger(valuelist);
////
////		List<String> servicetypelist = new ArrayList<String>();
////		for (Integer i : servicetypelistByInteger)
////		{
////			servicetypelist.add(i + "");
////		}
////
////		ConferenceInfoBMS confInfo = BeanTranslatorUtil
////				.copyConference2ConferenceInfo(conference, tempConferenceID,
////						null, productRoleManager);
////		int site = conferenceBusinessManager.initSite(applicationID, tempConferenceID);
////		long startTime = System.currentTimeMillis();
////		try
////		{
////			ConferenceBillInfoBMS confBillInfo = new ConferenceBillInfoBMS();
////			BeanTranslatorUtil.copyConferenceBillInfo(confBillInfo, confInfo);
////			confBillInfo.setBillInfo(billInfo);
////			agent.createConferenceBillInfoWithoutUser(site, confBillInfo,
////					servicetypelist);
////			LOGGER
////					.info("[Tang CMS call jni with create conference without user: time: "
////							+ (System.currentTimeMillis() - startTime) + "]");
////			LOGGER.info("调用业务管理不带用户创建成功返回！confID[" + tempConferenceID + "]");
////		}
////		catch (CMSException e)
////		{
////			LOGGER.info("调用业务管理不带用户发生异常！confID[" + tempConferenceID + "]");
////			throw CMSException2JNIException.getJNIException(e);
////		}
//	}
//
//	private UserChannel joinConf(String applicationID,
//			ConfJoinTempConf confJoinTempConf, Conference conf, User user)
//			throws Exception
//	{
////		if (conf == null || confJoinTempConf == null) return null;
////		if (conf.getConferenceid().intValue() != confJoinTempConf.getConfID()
////				.intValue()) return null;
////		if (IPTranslatorUtil.ipToLong(user.getIpaddr()) == null) throw new ParameterException(
////				CMSErrorCode.IP_ERROR.getDescription());
////
////		Integer tempConferenceID = confJoinTempConf.getTempConfID();
////		// 设置角色
////		List<Integer> rolelist = new ArrayList<Integer>();
////		rolelist.addAll(user.getRolemap().keySet());
////		// 是否禁止外呼
////		if (this.isProhibit(user.getIpaddr()))
////		{
////			rolelist.add(1);
////		}
////		// 设置用户权限
////		Map<Integer, List<Integer>> roleprivilegemap = this.productRoleManager
////				.queryAllRolePrivileges(conf.getProduct().getProductid(),
////						rolelist);
////		user.setRolemap(roleprivilegemap);
////
////		if (!checkConfPin(conf, user.getPinCode()))
////		{
////			pinrefManager.deletePin(conf.getBillingcode(), user.getPinCode()
////					.toString());
////			return null;
////		}
////
////		// translation userdto to tang user
////		// user.setTempuserid(tempUserManager.getTempuseridByTempconfid(tempConferenceID));
////		user.setTempuserid(this.getTempUserID());
////		LOGGER
////				.info("===========user Tempuserid [" + user.getTempuserid()
////						+ "]");
////		BMSUserInfo userInfo = BeanTranslatorUtil.copyUser2UserInfo(user);
////		LOGGER.info("===========BMSUserInfo Tempuserid ["
////				+ userInfo.getUserID() + "]");
////
////		// change user domain
////		Integer userDomain = ipdomainManager.getDomainByIp(userInfo.getIPArr());
////		if (userDomain != null) userInfo.setDomain(userDomain);
////		else LOGGER.error("Not find responding domain for UserIP="
////				+ user.getIpaddr() + ", domain=" + user.getDomain());
////
////		int site = conferenceBusinessManager.getSite(applicationID, tempConferenceID);
////		try
////		{
////			long startTime = System.currentTimeMillis();
////
////			UserChannel userChannel;
////			if (user.getIsowner() != null && user.getIsowner())
////			{
////				userChannel = agent.startConferenceWithUser(site,
////						tempConferenceID, userInfo);
////				addConferenceUserInfo(tempConferenceID, userInfo.getUserID());
////			}
////			else
////			{
////				userChannel = agent.userJoinConference(site, tempConferenceID,
////						userInfo);
////			}
////			LOGGER.info("[Tang CMS call jni with user join conference: time: "
////					+ (System.currentTimeMillis() - startTime) + "]");
////
////			// 判断返回值状态,如果发生异常，写日志，返回null
////			if (userChannel == null)
////			{
////				LOGGER.error("bms join conference with user return NULL");
////				if (conf.getPin() == null || !conf.getPin()) pinrefManager
////						.deletePin(conf.getBillingcode(), user.getPinCode()
////								.toString());
////				return null;
////			}
////			userChannel.setTempConferenceID(tempConferenceID);
////			return userChannel;
////		}
////		catch (CMSException e)
////		{
////			if (conf.getPin() == null || !conf.getPin())
////			{
////				if (user.getIsowner() == null || !user.getIsowner()
////						|| !"412".equals(e.getCodeID())) pinrefManager
////						.deletePin(conf.getBillingcode(), user.getPinCode()
////								.toString());
////			}
////			LOGGER.info("[Tang CMS agent error code id: ]" + e.getCodeID());
////			if (e.getCodeID().equals("404"))
////			{
////				try
////				{
////					ConferenceInfoBMS conferenceInfoBMS = agent.getConfInfo(
////							site, tempConferenceID);
////					if ((conferenceInfoBMS.getStatus() & 0x7) == Consts.CONF_STATUS_END)
////					{
////						LOGGER
////								.info("deleteConfJoinTempConf---joinConference---[Tang CMS agent error code id:404 status=3]"
////										+ tempConferenceID);
////						confJoinTempConfManager
////								.deleteConfJoinTempConfByTempConfID(tempConferenceID); // delete
////						// by
////						// tanyunhua
////						// 2011-10-31
////						Cdrconferenceinfo cdrConferenceInfo = cdrConferenceInfoManager
////								.queryCdrConfByConfIDAndTempID(tempConferenceID);
////						if (cdrConferenceInfo != null
////								&& cdrConferenceInfo.getEndtime() == null)
////						{
////							cdrConferenceInfo.setEndtime(new Date());
////							cdrConferenceInfoManager.update(cdrConferenceInfo);
////						}
////					}
////				}
////				catch (CMSException cmse)
////				{
////					if ("404".equals(cmse.getCodeID()))
////					{
////						LOGGER
////								.info("deleteConfJoinTempConf---joinConferenceOld---getConfInfo--[Tang CMS agent error code id:404 ]"
////										+ tempConferenceID);
////						confJoinTempConfManager
////								.deleteConfJoinTempConfByTempConfID(tempConferenceID); // delete
////						// by
////						// tanyunhua
////						// 2011-10-31
////						Cdrconferenceinfo cdrConferenceInfo = cdrConferenceInfoManager
////								.queryCdrConfByConfIDAndTempID(tempConferenceID);
////						if (cdrConferenceInfo != null
////								&& cdrConferenceInfo.getEndtime() == null)
////						{
////							cdrConferenceInfo.setEndtime(new Date());
////							cdrConferenceInfoManager.update(cdrConferenceInfo);
////						}
////					}
////					else
////					{
////						throw CMSException2JNIException.getJNIException(cmse);
////					}
////				}
////			}
////			else
////			{
////				throw CMSException2JNIException.getJNIException(e);
////			}
////			LOGGER.info("join conf exception ：", e);
////			return null;
////		}
//		return null;
//	}
//
//	private UserChannel joinConfWithBillInfo(String applicationID,
//			ConfJoinTempConf confJoinTempConf, Conference conf, User user,
//			String billInfo) throws Exception
//	{
////		if (conf == null || confJoinTempConf == null) return null;
////		if (conf.getConferenceid().intValue() != confJoinTempConf.getConfID()
////				.intValue()) 
//		return null;
////		if (IPTranslatorUtil.ipToLong(user.getIpaddr()) == null) throw new ParameterException(
////				CMSErrorCode.IP_ERROR.getDescription());
//
////		Integer tempConferenceID = confJoinTempConf.getTempConfID();
////		// 设置角色
////		List<Integer> rolelist = new ArrayList<Integer>();
////		rolelist.addAll(user.getRolemap().keySet());
////		// 是否禁止外呼
////		if (this.isProhibit(user.getIpaddr()))
////		{
////			rolelist.add(1);
////		}
////		// 设置用户权限
////		Map<Integer, List<Integer>> roleprivilegemap = this.productRoleManager
////				.queryAllRolePrivileges(conf.getProduct().getProductid(),
////						rolelist);
////		user.setRolemap(roleprivilegemap);
////
////		if (!checkConfPin(conf, user.getPinCode()))
////		{
////			pinrefManager.deletePin(conf.getBillingcode(), user.getPinCode()
////					.toString());
////			return null;
////		}
////
////		// translation userdto to tang user
////		// user.setTempuserid(tempUserManager.getTempuseridByTempconfid(tempConferenceID));
////		user.setTempuserid(this.getTempUserID());
////		LOGGER
////				.info("===========user Tempuserid [" + user.getTempuserid()
////						+ "]");
////		BMSUserInfo userInfo = BeanTranslatorUtil.copyUser2UserInfo(user);
////		LOGGER.info("===========BMSUserInfo Tempuserid ["
////				+ userInfo.getUserID() + "]");
////
////		// change user domain
////		Integer userDomain = ipdomainManager.getDomainByIp(userInfo.getIPArr());
////		if (userDomain != null) userInfo.setDomain(userDomain);
////		else LOGGER.error("Not find responding domain for UserIP="
////				+ user.getIpaddr() + ", domain=" + user.getDomain());
////
////		int site = conferenceBusinessManager.getSite(applicationID, tempConferenceID);
////		try
////		{
////			long startTime = System.currentTimeMillis();
////
////			UserChannel userChannel;
////			BMSUserBillInfo userBillInfo = new BMSUserBillInfo();
////			BeanTranslatorUtil.copyUserBillInfo(userBillInfo, userInfo);
////			userBillInfo.setBillInfo(billInfo);
////			if (user.getIsowner() != null && user.getIsowner())
////			{
////				userChannel = agent.startConferenceBillInfoWithUser(site,
////						tempConferenceID, userBillInfo);
////				addConferenceUserInfo(tempConferenceID, userInfo.getUserID());
////			}
////			else
////			{
////				userChannel = agent.userJoinConferenceWithBillInfo(site,
////						tempConferenceID, userBillInfo);
////			}
////			LOGGER.info("[Tang CMS call jni with user join conference: time: "
////					+ (System.currentTimeMillis() - startTime) + "]");
////
////			// 判断返回值状态,如果发生异常，写日志，返回null
////			if (userChannel == null)
////			{
////				LOGGER.error("bms join conference with user return NULL");
////				if (conf.getPin() == null || !conf.getPin()) pinrefManager
////						.deletePin(conf.getBillingcode(), user.getPinCode()
////								.toString());
////				return null;
////			}
////			userChannel.setTempConferenceID(tempConferenceID);
////			return userChannel;
////		}
////		catch (CMSException e)
////		{
////			if (conf.getPin() == null || !conf.getPin())
////			{
////				if (user.getIsowner() == null || !user.getIsowner()
////						|| !"412".equals(e.getCodeID())) pinrefManager
////						.deletePin(conf.getBillingcode(), user.getPinCode()
////								.toString());
////			}
////			LOGGER.info("[Tang CMS agent error code id: ]" + e.getCodeID());
////			if (e.getCodeID().equals("404"))
////			{
////				try
////				{
////					ConferenceInfoBMS conferenceInfoBMS = agent.getConfInfo(
////							site, tempConferenceID);
////					if ((conferenceInfoBMS.getStatus() & 0x7) == Consts.CONF_STATUS_END)
////					{
////						LOGGER
////								.info("deleteConfJoinTempConf---joinConference---[Tang CMS agent error code id:404 status=3]"
////										+ tempConferenceID);
////						confJoinTempConfManager
////								.deleteConfJoinTempConfByTempConfID(tempConferenceID); // delete
////						// by
////						// tanyunhua
////						// 2011-10-31
////						Cdrconferenceinfo cdrConferenceInfo = cdrConferenceInfoManager
////								.queryCdrConfByConfIDAndTempID(tempConferenceID);
////						if (cdrConferenceInfo != null
////								&& cdrConferenceInfo.getEndtime() == null)
////						{
////							cdrConferenceInfo.setEndtime(new Date());
////							cdrConferenceInfoManager.update(cdrConferenceInfo);
////						}
////					}
////				}
////				catch (CMSException cmse)
////				{
////					if ("404".equals(cmse.getCodeID()))
////					{
////						LOGGER
////								.info("deleteConfJoinTempConf---joinConferenceOld---getConfInfo--[Tang CMS agent error code id:404 ]"
////										+ tempConferenceID);
////						confJoinTempConfManager
////								.deleteConfJoinTempConfByTempConfID(tempConferenceID); // delete
////						// by
////						// tanyunhua
////						// 2011-10-31
////						Cdrconferenceinfo cdrConferenceInfo = cdrConferenceInfoManager
////								.queryCdrConfByConfIDAndTempID(tempConferenceID);
////						if (cdrConferenceInfo != null
////								&& cdrConferenceInfo.getEndtime() == null)
////						{
////							cdrConferenceInfo.setEndtime(new Date());
////							cdrConferenceInfoManager.update(cdrConferenceInfo);
////						}
////					}
////					else
////					{
////						throw CMSException2JNIException.getJNIException(cmse);
////					}
////				}
////			}
////			else
////			{
////				throw CMSException2JNIException.getJNIException(e);
////			}
////			LOGGER.info("join conf exception ：", e);
//
//		//}
//	}
//
////	private void addConferenceUserInfo(Integer tempconferenceid, int tempuserid)
////	{
////		try
////		{
////			LOGGER.info("add conferenceuserinfo");
////			LOGGER.info("tempconferenceid:" + tempconferenceid);
////			LOGGER.info("tempuserid:" + tempuserid);
////			conferenceUserInfoManager
////					.deleteByTempConferenceId(tempconferenceid);
////			LOGGER.info("delete finish");
////			Conferenceuserinfo info = new Conferenceuserinfo();
////			info.setTempconferenceid(tempconferenceid);
////			info.setTempuserid(tempuserid);
////			info.setStatus(Consts.USER_NORMAL_OFFLINE);
////			info.setTimestamp(new Date());
////			// 主持人
////			info.setRole("" + 4);
////			conferenceUserInfoManager.create(info);
////			LOGGER.info("add host finish");
////			info.setId(null);
////			// 主讲人
////			info.setRole("" + 5);
////			conferenceUserInfoManager.create(info);
////			LOGGER.info("add speaker finish");
////		}
////		catch (Exception ex)
////		{
////			LOGGER.warn(ex.getMessage());
////		}
////
////	}
//
//
//
//
//	/**
//	 * 获取临时会议ID
//	 * 
//	 * @return
//	 */
//	private Integer getConfID()
//	{
//		int confId = 0;
//
//		return confId;
//	}
//
//	/**
//	 * 获取临时用户ID
//	 * 
//	 * @return
//	 */
//	private Integer getTempUserID()
//	{
//		int tempuserid = 0;
//
//		return tempuserid;
//	}
//
//	public void init()
//	{
//		try
//		{
//	
//		}
//		catch (Exception e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//
//	/**
//	 * 用户加入--用户使用
//	 * 
//	 * @param applicationID
//	 * @param tempConferenceID
//	 * @param user
//	 * @return
//	 * @throws Exception
//	 */
//	public UserChannel joinConferenceWithBillInfo(String applicationID,
//			Integer tempConferenceID, User user, String billInfo)
//			throws Exception
//	{
//		return null;
//	
//	}
//
//	/**
//	 * 初始化一场预约会议。
//	 * 将会创建一场BMS会议，往ConfJoinTempConf、Cdrconferenceinfo、Router表中各插入一条数据。
//	 * 
//	 * @param applicationID
//	 *            应用ID
//	 * @param conferenceID
//	 *            预约会议ID，需要是预约出来的会议ID，而不是开通出来的ID
//	 * @return 临时会议ID（会议对象）
//	 * @throws Exception
//	 */
//	public Integer initConferenceWithBillInfo(String applicationID,
//			Integer conferenceID, String billInfo) throws Exception
//	{
//		
//
//		return 0;
//	}
//}

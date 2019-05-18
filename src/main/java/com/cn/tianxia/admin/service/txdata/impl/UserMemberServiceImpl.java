package com.cn.tianxia.admin.service.txdata.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.CagentMapper;
import com.cn.tianxia.admin.domain.txdata.CagentStoredvalueLogMapper;
import com.cn.tianxia.admin.domain.txdata.CagentStoredvalueMapper;
import com.cn.tianxia.admin.domain.txdata.CardTypeMapper;
import com.cn.tianxia.admin.domain.txdata.DicDataMapper;
import com.cn.tianxia.admin.domain.txdata.FundmanageMapper;
import com.cn.tianxia.admin.domain.txdata.PlatWithdrawalMapper;
import com.cn.tianxia.admin.domain.txdata.ReserveAccountMapper;
import com.cn.tianxia.admin.domain.txdata.SysUserMapper;
import com.cn.tianxia.admin.domain.txdata.UserCardMapper;
import com.cn.tianxia.admin.domain.txdata.UserDissociateMapper;
import com.cn.tianxia.admin.domain.txdata.UserMemberMapper;
import com.cn.tianxia.admin.domain.txdata.UserPlatformReportMapper;
import com.cn.tianxia.admin.domain.txdata.UserQuantityMapper;
import com.cn.tianxia.admin.domain.txdata.UserTreasureMapper;
import com.cn.tianxia.admin.domain.txdata.UserTypeMapper;
import com.cn.tianxia.admin.domain.txdata.UserWalletMapper;
import com.cn.tianxia.admin.error.BusinessException;
import com.cn.tianxia.admin.error.CommonErrorEnum;
import com.cn.tianxia.admin.project.txdata.Cagent;
import com.cn.tianxia.admin.project.txdata.CagentStoredvalue;
import com.cn.tianxia.admin.project.txdata.CagentStoredvalueLog;
import com.cn.tianxia.admin.project.txdata.CardType;
import com.cn.tianxia.admin.project.txdata.DicData;
import com.cn.tianxia.admin.project.txdata.Fundmanage;
import com.cn.tianxia.admin.project.txdata.PlatWithdrawal;
import com.cn.tianxia.admin.project.txdata.SysUser;
import com.cn.tianxia.admin.project.txdata.UserCard;
import com.cn.tianxia.admin.project.txdata.UserMember;
import com.cn.tianxia.admin.project.txdata.UserMemberTs;
import com.cn.tianxia.admin.project.txdata.UserPlatformReport;
import com.cn.tianxia.admin.project.txdata.UserQuantity;
import com.cn.tianxia.admin.project.txdata.UserTreasure;
import com.cn.tianxia.admin.project.txdata.UserType;
import com.cn.tianxia.admin.project.txdata.UserWallet;
import com.cn.tianxia.admin.project.txdata.WinDetails;
import com.cn.tianxia.admin.service.txdata.UserMemberService;
import com.cn.tianxia.admin.utils.DESEncrypt;
import com.cn.tianxia.admin.utils.UserGameReportUrils;
import com.cn.tianxia.admin.vo.ftpdata.WinDetailsVO;
import com.cn.tianxia.admin.vo.txdata.AddUserMemberVO;
import com.cn.tianxia.admin.vo.txdata.DisabledEntityVO;
import com.cn.tianxia.admin.vo.txdata.EditTopUidVO;
import com.cn.tianxia.admin.vo.txdata.EditUserMemberVO;
import com.cn.tianxia.admin.vo.txdata.EditUserTypeVO;
import com.cn.tianxia.admin.vo.txdata.UserMemberTsVO;
import com.cn.tianxia.admin.vo.txdata.UserMemberVO;
import com.cn.tianxia.admin.vo.txdata.UserMoneyVO;

@Service
public class UserMemberServiceImpl implements UserMemberService {

	// 日志
	private static final Logger logger = LoggerFactory.getLogger(UserMemberServiceImpl.class);

	/**
	 * 平台会员
	 */
	@Autowired
	private UserMemberMapper userMemberMapper;

	/**
	 * 数据字典
	 */
	@Autowired
	private DicDataMapper dicDataMapper;

	/**
	 * 会员总输赢额
	 */
	@Autowired
	private UserPlatformReportMapper userPlatformReportMapper;

	/**
	 * 要求打码量
	 */
	@Autowired
	private UserQuantityMapper userQuantityMapper;
	/**
	 * 会员分层
	 */
	@Autowired
	private UserTypeMapper userTypeMapper;

	/**
	 * 会员积分
	 */
	@Autowired
	private UserWalletMapper userWalletMapper;

	/**
	 * 资金流水
	 */
	@Autowired
	private UserTreasureMapper UserTreasureMapper;

	/**
	 * 会员注单汇总工具类
	 */
	@Autowired
	private UserGameReportUrils userGameReportUrils;

	/**
	 * 系统保留账户
	 */
	@Autowired
	private ReserveAccountMapper reserveAccountMapper;

	/**
	 * 根据代理商id 用户姓名
	 */
	@Autowired
	private SysUserMapper sysUserMapper;

	/**
	 * 会员银行卡
	 */
	@Autowired
	private UserCardMapper userCardMapper;

	/**
	 * 历史用户
	 */
	@Autowired
	private UserDissociateMapper userDissociateMapper;

	/**
	 * 银行列表
	 */
	@Autowired
	private CardTypeMapper cardTypeMapper;

	/**
	 * 存取款配置
	 */
	@Autowired
	private PlatWithdrawalMapper platWithdrawalMapper;

	/**
	 * 平台商
	 */
	@Autowired
	private CagentMapper cagentMapper;

	/**
	 * 平台商额度
	 */
	@Autowired
	private CagentStoredvalueMapper cagentStoredvalueMapper;

	/**
	 * 手动加扣款彩金
	 */
	@Autowired
	private FundmanageMapper fundmanageMapper;

	/**
	 * 额度记录
	 */
	@Autowired
	private CagentStoredvalueLogMapper cagentStoredvalueLogMapper;

	@Override
	public int deleteByPrimaryKey(Integer uid) {
		return userMemberMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public UserMember selectByPrimaryKey(Integer uid) {
		return userMemberMapper.selectByPrimaryKey(uid);
	}

	@Override
	public int insertSelective(UserMember record) {
		return userMemberMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(AddUserMemberVO record) {
		return userMemberMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 平台会员查询
	 */
	// @DataSource(Database.TXDATA_DB_SLAVE)
	@Override
	public Pager<UserMember> memberInquiry(Map<String, String> params) throws Exception {

		logger.info("查询用会员列表请求参数:{}", params.toString());
		Pager<UserMemberVO> pager = new Pager<UserMemberVO>();
		pager.setParams(params);
		// 根据条件查询会员列表
		List<UserMember> userMember = userMemberMapper.memberInquiry(pager);

		// 根据条件查询会员总条数
		int userMemberCount = userMemberMapper.memberInquiryCount(pager);

		userMember.parallelStream().forEach(userMemberid -> {

			/**
			 * 拼接会员打码量，以及输赢额
			 */
			List<UserPlatformReport> userPlatformReport = userPlatformReportMapper.selectByUid(userMemberid.getUid());
			if (null == userPlatformReport || userPlatformReport.size() == 0) {
				userMemberid.setUserQuantity(0d);
				userMemberid.setUserWinAmount(0d);
			} else {
				/**
				 * 统计会员打码量，输赢额
				 */
				DoubleSummaryStatistics userQuantity = userPlatformReport.parallelStream()
						.mapToDouble(value -> value.getValidBetAmount()).summaryStatistics();
				DoubleSummaryStatistics userWinAmount = userPlatformReport.parallelStream()
						.mapToDouble(value -> value.getNetAmount()).summaryStatistics();

				userMemberid.setUserQuantity(userQuantity.getSum());
				userMemberid.setUserWinAmount(userWinAmount.getSum());
			}
			/**
			 * 拼接会员分层
			 */
			UserType usertype = userTypeMapper.selectByPrimaryKey(userMemberid.getTypeId());
			if (null != usertype) {
				userMemberid.setTypeName(usertype.getTypename());
			} else {
				userMemberid.setTypeName("");
			}
			/**
			 * 拼接代理商
			 */
			SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.parseLong(userMemberid.getTopUid() + ""));
			if (null != sysUser) {
				userMemberid.setTopUidName(sysUser.getLoginName());
			} else {
				userMemberid.setTopUidName("");
			}
			/**
			 * 拼接会员积分
			 */
			UserWallet userWallet = userWalletMapper.selectByUid(userMemberid.getUid());
			if (null != userWallet) {
				userMemberid.setIntegral(userWallet.getBalance());
			} else {
				userMemberid.setIntegral(0d);
			}

		});
		// 总条数
		Pager<UserMember> result = new Pager<>(userMemberCount, pager.getPage(), pager.getLimit());
		result.setList(userMember);
		return result;
	}

	/**
	 * 输赢详情查询
	 */
	// @DataSource(Database.TXDATA_DB_SLAVE)
	@Override
	public Pager<WinDetails> selectWinDetails(Map<String, String> params) throws Exception {

		/**
		 * 获取数据字段游戏列表
		 */
		List<DicData> dicData = dicDataMapper.selectDicData();

		List<WinDetails> WinDetailsList = new ArrayList<WinDetails>();
		/**
		 * 这几个参数放外面方便查询资金记录传参
		 */
		WinDetailsVO winDeta = new WinDetailsVO();

		winDeta.setStartTime(params.get("startTime"));
		winDeta.setEndTime(params.get("endTime"));
		winDeta.setUid(Integer.parseInt(params.get("uid")));
		/**
		 * 查询所有游戏注单汇总
		 */
		userGameReportUrils.userGameSummary(dicData, WinDetailsList, winDeta);

		/**
		 * 加款记录。
		 */
		List<WinDetails> addMoneyList = UserTreasureMapper.userTreasureaddMoney(winDeta);
		if (addMoneyList != null && addMoneyList.size() != 0) {

			addMoneyList.parallelStream().forEach(addMoney -> {
				userGameReportUrils.formatData(addMoney);
			});
			WinDetailsList.addAll(addMoneyList);
		}
		/**
		 * 存款记录
		 */
		List<WinDetails> depositList = UserTreasureMapper.userTreasureDeposit(winDeta);
		if (depositList != null && depositList.size() != 0) {
			depositList.parallelStream().forEach(deposit -> {
				userGameReportUrils.formatData(deposit);
			});
			WinDetailsList.addAll(depositList);
		}
		/**
		 * 提款记录
		 */
		List<WinDetails> withdRawalList = UserTreasureMapper.userTreasureWithdRawal(winDeta);
		if (withdRawalList != null && withdRawalList.size() != 0) {
			withdRawalList.parallelStream().forEach(withdRawal -> {
				userGameReportUrils.formatData(withdRawal);
			});
			WinDetailsList.addAll(withdRawalList);
		}
		/**
		 * 返水记录
		 */
		List<WinDetails> returnWaterList = UserTreasureMapper.userTreasureReturnWater(winDeta);
		if (returnWaterList != null && returnWaterList.size() != 0) {
			returnWaterList.parallelStream().forEach(returnWater -> {
				userGameReportUrils.formatData(returnWater);
			});
			WinDetailsList.addAll(returnWaterList);
		}
		/**
		 * 扣款记录
		 */
		List<WinDetails> deductMoneyList = UserTreasureMapper.userTreasureDeductMoney(winDeta);
		if (deductMoneyList != null && deductMoneyList.size() != 0) {
			deductMoneyList.parallelStream().forEach(deductMoney -> {
				userGameReportUrils.formatData(deductMoney);
			});
			WinDetailsList.addAll(deductMoneyList);
		}

		/**
		 * 按照时间分组
		 */
		Function<WinDetails, String> function = e -> e.getBetTime();
		Map<String, List<WinDetails>> winDetailsMap = WinDetailsList.parallelStream()
				.collect(Collectors.groupingBy(function));
		/**
		 * 拼接返回结果集
		 */
		List<WinDetails> winDetaResult = new ArrayList<WinDetails>();
		/**
		 * 按照时间分组
		 */
		winDetailsMap.forEach((k, slist) -> {

			WinDetails winObject = new WinDetails();

			/**
			 * 有效投注额
			 */
			DoubleSummaryStatistics validBetAmount = slist.parallelStream()
					.mapToDouble(value -> null == value.getValidBetAmount() ? 0 : value.getValidBetAmount())
					.summaryStatistics();

			/**
			 * 投注额
			 */
			DoubleSummaryStatistics betAmount = slist.parallelStream()
					.mapToDouble(value -> null == value.getBetAmount() ? 0 : value.getBetAmount()).summaryStatistics();
			/**
			 * 输赢金额
			 */
			DoubleSummaryStatistics netAmount = slist.parallelStream()
					.mapToDouble(value -> null == value.getNetAmount() ? 0 : value.getNetAmount()).summaryStatistics();
			/**
			 * 加款金额
			 */
			DoubleSummaryStatistics addMoney = slist.parallelStream()
					.mapToDouble(value -> null == value.getAddMoney() ? 0 : value.getAddMoney()).summaryStatistics();
			/**
			 * 存款金额
			 */
			DoubleSummaryStatistics deposit = slist.parallelStream()
					.mapToDouble(value -> null == value.getDeposit() ? 0 : value.getDeposit()).summaryStatistics();
			/**
			 * 提款金额
			 */
			DoubleSummaryStatistics withdRawal = slist.parallelStream()
					.mapToDouble(value -> null == value.getWithdRawal() ? 0 : value.getWithdRawal())
					.summaryStatistics();
			/**
			 * 返水金额
			 */
			DoubleSummaryStatistics returnWater = slist.parallelStream()
					.mapToDouble(value -> null == value.getReturnWater() ? 0 : value.getReturnWater())
					.summaryStatistics();
			/**
			 * 扣款金额
			 */
			DoubleSummaryStatistics deductMoney = slist.parallelStream()
					.mapToDouble(value -> null == value.getDeductMoney() ? 0 : value.getDeductMoney())
					.summaryStatistics();
			/**
			 * 注单数
			 */
			IntSummaryStatistics noteNum = slist.parallelStream()
					.mapToInt(value -> null == value.getNoteNum() ? 0 : value.getNoteNum()).summaryStatistics();

			winObject.setValidBetAmount(validBetAmount.getSum());
			winObject.setNoteNum(Integer.parseInt(noteNum.getSum() + ""));
			winObject.setBetAmount(betAmount.getSum());
			winObject.setNetAmount(netAmount.getSum());
			winObject.setAddMoney(addMoney.getSum());
			winObject.setDeposit(deposit.getSum());
			winObject.setWithdRawal(withdRawal.getSum());
			winObject.setReturnWater(returnWater.getSum());
			winObject.setDeductMoney(deductMoney.getSum());
			winObject.setBetTime(k);
			winDetaResult.add(winObject);
		});

		/**
		 * 降序排序
		 */
		List<WinDetails> collect = winDetaResult.parallelStream()
				.sorted(Comparator.comparing(WinDetails::getBetTime).reversed()).collect(Collectors.toList());

		/**
		 * 汇总所有数据
		 */

		/**
		 * 有效投注额
		 */
		DoubleSummaryStatistics validBetAmountSummary = winDetaResult.parallelStream()
				.mapToDouble(value -> null == value.getValidBetAmount() ? 0 : value.getValidBetAmount())
				.summaryStatistics();
		/**
		 * 投注额
		 */
		DoubleSummaryStatistics betAmountSummary = winDetaResult.parallelStream()
				.mapToDouble(value -> null == value.getBetAmount() ? 0 : value.getBetAmount()).summaryStatistics();
		/**
		 * 输赢金额
		 */
		DoubleSummaryStatistics netAmountSummary = winDetaResult.parallelStream()
				.mapToDouble(value -> null == value.getNetAmount() ? 0 : value.getNetAmount()).summaryStatistics();
		/**
		 * 加款金额
		 */
		DoubleSummaryStatistics addMoneySummary = winDetaResult.parallelStream()
				.mapToDouble(value -> null == value.getAddMoney() ? 0 : value.getAddMoney()).summaryStatistics();
		/**
		 * 存款金额
		 */
		DoubleSummaryStatistics depositSummary = winDetaResult.parallelStream()
				.mapToDouble(value -> null == value.getDeposit() ? 0 : value.getDeposit()).summaryStatistics();
		/**
		 * 提款金额
		 */
		DoubleSummaryStatistics withdRawalSummary = winDetaResult.parallelStream()
				.mapToDouble(value -> null == value.getWithdRawal() ? 0 : value.getWithdRawal()).summaryStatistics();
		/**
		 * 返水金额
		 */
		DoubleSummaryStatistics returnWaterSummary = winDetaResult.parallelStream()
				.mapToDouble(value -> null == value.getReturnWater() ? 0 : value.getReturnWater()).summaryStatistics();
		/**
		 * 扣款金额
		 */
		DoubleSummaryStatistics deductMoneySummary = winDetaResult.parallelStream()
				.mapToDouble(value -> null == value.getDeductMoney() ? 0 : value.getDeductMoney()).summaryStatistics();
		/**
		 * 注单数
		 */
		IntSummaryStatistics noteNumSummary = winDetaResult.parallelStream()
				.mapToInt(value -> null == value.getNoteNum() ? 0 : value.getNoteNum()).summaryStatistics();

		long winDetaCount = winDetaResult.parallelStream().count();

		WinDetails winDetaSummary = new WinDetails();
		winDetaSummary.setBetTime("总计");
		winDetaSummary.setValidBetAmount(validBetAmountSummary.getSum());
		winDetaSummary.setBetAmount(betAmountSummary.getSum());
		winDetaSummary.setNetAmount(netAmountSummary.getSum());
		winDetaSummary.setAddMoney(addMoneySummary.getSum());
		winDetaSummary.setDeposit(depositSummary.getSum());
		winDetaSummary.setWithdRawal(withdRawalSummary.getSum());
		winDetaSummary.setReturnWater(returnWaterSummary.getSum());
		winDetaSummary.setDeductMoney(deductMoneySummary.getSum());
		winDetaSummary.setNoteNum(Integer.parseInt(noteNumSummary.getSum() + ""));

		Pager<Map<String, String>> pager = new Pager<Map<String, String>>();
		if (params.containsKey("page") && params.get("page") != null) {
			pager.setPage(Integer.parseInt(params.get("page")));
		}
		if (params.containsKey("limit") && params.get("limit") != null) {
			pager.setLimit(Integer.parseInt(params.get("limit")));
		}
		// 总条数
		Pager<WinDetails> result = new Pager<>(Integer.parseInt(winDetaCount + ""), pager.getPage(), pager.getLimit());

		/**
		 * 分页数据
		 */
		List<WinDetails> pageWinDetaList = collect.parallelStream().skip((pager.getPage() - 1) * pager.getLimit())
				.limit(pager.getLimit()).collect(Collectors.toList());

		WinDetails winDetaPage = new WinDetails();
		/**
		 * 有效投注额
		 */
		DoubleSummaryStatistics validBetAmountPage = pageWinDetaList.parallelStream()
				.mapToDouble(value -> null == value.getValidBetAmount() ? 0 : value.getValidBetAmount())
				.summaryStatistics();
		/**
		 * 投注额
		 */
		DoubleSummaryStatistics betAmountPage = pageWinDetaList.parallelStream()
				.mapToDouble(value -> null == value.getBetAmount() ? 0 : value.getBetAmount()).summaryStatistics();
		/**
		 * 输赢金额
		 */
		DoubleSummaryStatistics netAmountPage = pageWinDetaList.parallelStream()
				.mapToDouble(value -> null == value.getNetAmount() ? 0 : value.getNetAmount()).summaryStatistics();
		/**
		 * 加款金额
		 */
		DoubleSummaryStatistics addMoneyPage = pageWinDetaList.parallelStream()
				.mapToDouble(value -> null == value.getAddMoney() ? 0 : value.getAddMoney()).summaryStatistics();
		/**
		 * 存款金额
		 */
		DoubleSummaryStatistics depositPage = pageWinDetaList.parallelStream()
				.mapToDouble(value -> null == value.getDeposit() ? 0 : value.getDeposit()).summaryStatistics();
		/**
		 * 提款金额
		 */
		DoubleSummaryStatistics withdRawalPage = pageWinDetaList.parallelStream()
				.mapToDouble(value -> null == value.getWithdRawal() ? 0 : value.getWithdRawal()).summaryStatistics();
		/**
		 * 返水金额
		 */
		DoubleSummaryStatistics returnWaterPage = pageWinDetaList.parallelStream()
				.mapToDouble(value -> null == value.getReturnWater() ? 0 : value.getReturnWater()).summaryStatistics();
		/**
		 * 扣款金额
		 */
		DoubleSummaryStatistics deductMoneyPage = pageWinDetaList.parallelStream()
				.mapToDouble(value -> null == value.getDeductMoney() ? 0 : value.getDeductMoney()).summaryStatistics();
		IntSummaryStatistics noteNumPage = pageWinDetaList.parallelStream()
				.mapToInt(value -> null == value.getNoteNum() ? 0 : value.getNoteNum()).summaryStatistics();

		winDetaPage.setBetTime("小计");
		winDetaPage.setValidBetAmount(validBetAmountPage.getSum());
		winDetaPage.setBetAmount(betAmountPage.getSum());
		winDetaPage.setNetAmount(netAmountPage.getSum());
		winDetaPage.setAddMoney(addMoneyPage.getSum());
		winDetaPage.setDeposit(depositPage.getSum());
		winDetaPage.setWithdRawal(withdRawalPage.getSum());
		winDetaPage.setReturnWater(returnWaterPage.getSum());
		winDetaPage.setDeductMoney(deductMoneyPage.getSum());
		winDetaPage.setNoteNum(Integer.parseInt(noteNumPage.getSum() + ""));

		/**
		 * 拼接小计
		 */
		pageWinDetaList.add(winDetaPage);
		/**
		 * 拼接总计
		 */
		pageWinDetaList.add(winDetaSummary);
		result.setList(pageWinDetaList);

		return result;
	}

	/**
	 * 输赢详情明细
	 */
	// @DataSource(Database.TXDATA_DB_SLAVE)
	@Override
	public Pager<WinDetails> selectWinDetailsPage(Map<String, String> params) {

		/**
		 * 获取数据字段游戏列表
		 */
		List<DicData> dicData = dicDataMapper.selectDicData();

		List<WinDetails> WinDetailsList = new ArrayList<WinDetails>();
		/**
		 * 这几个参数放外面方便查询资金记录传参
		 */
		WinDetailsVO winDeta = new WinDetailsVO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			winDeta.setBetTime(sdf.format(sdf.parse(params.get("betTime"))));
		} catch (ParseException e) {
			logger.error("时间转换异常：{}", e.getMessage());
			e.printStackTrace();
		}
		winDeta.setUid(Integer.parseInt(params.get("uid")));
		/**
		 * 查询所有游戏注单汇总
		 */
		userGameReportUrils.userGameSummary(dicData, WinDetailsList, winDeta);

		/**
		 * 按照游戏平台分组
		 */
		Function<WinDetails, String> function = e -> e.getPlatformName();
		Map<String, List<WinDetails>> winDetailsMap = WinDetailsList.parallelStream()
				.collect(Collectors.groupingBy(function));
		/**
		 * 按平台分组 求和
		 */

		/**
		 * 拼接返回结果集
		 */
		List<WinDetails> winDetaResult = new ArrayList<WinDetails>();
		winDetailsMap.forEach((k, slist) -> {
			WinDetails winObject = new WinDetails();
			/**
			 * 注单数
			 */
			IntSummaryStatistics noteNum = slist.parallelStream().mapToInt(value -> value.getNoteNum())
					.summaryStatistics();
			/**
			 * 投注额
			 */
			DoubleSummaryStatistics betAmount = slist.parallelStream().mapToDouble(value -> value.getBetAmount())
					.summaryStatistics();
			/**
			 * 有效投注额
			 */
			DoubleSummaryStatistics validBetAmount = slist.parallelStream()
					.mapToDouble(value -> value.getValidBetAmount()).summaryStatistics();
			/**
			 * 输赢额
			 */
			DoubleSummaryStatistics netAmount = slist.parallelStream().mapToDouble(value -> value.getNetAmount())
					.summaryStatistics();

			winObject.setPlatformName(k);
			winObject.setNoteNum(Integer.parseInt(noteNum.getSum() + ""));
			winObject.setBetAmount(betAmount.getSum());
			winObject.setValidBetAmount(validBetAmount.getSum());
			winObject.setNetAmount(netAmount.getSum());
			winDetaResult.add(winObject);
		});

		// 总条数
		Pager<WinDetails> result = new Pager<>();
		result.setList(winDetaResult);
		return result;
	}

	/**
	 * 添加会员
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public int addUserMember(Map<String, String> params) throws Exception {

		/**
		 * 添加会员VO
		 */
		AddUserMemberVO addUserMemberVO = new AddUserMemberVO();
		/**
		 * 平台商
		 */
		addUserMemberVO.setCagent(params.get("cagent"));
		/**
		 * 上级代理
		 */
		if (!params.containsKey("topUid") || "".equals(params.get("topUid"))) {
			addUserMemberVO.setTopUid(0);
		} else {
			addUserMemberVO.setTopUid(Integer.parseInt(params.get("topUid") + ""));
		}
		/**
		 * 默认分层
		 */
		if (params.containsKey("typeid") && !"".equals(params.get("typeid"))) {
			addUserMemberVO.setTypeId(Integer.parseInt(params.get("typeid") + ""));
		}
		/**
		 * DES加密
		 */
		DESEncrypt d = new DESEncrypt("tianxia88");
		/**
		 * 加密 会员密码
		 */
		addUserMemberVO.setPassword(d.encrypt(params.get("password")));
		/**
		 * 加密 第三方密码
		 */
		addUserMemberVO.setAgPassword(d.encrypt(params.get("agpassword")));
		/**
		 * 加密 取款密码
		 */
		addUserMemberVO.setQkPwd(d.encrypt(params.get("qkpwd")));
		/**
		 * 用户账号
		 */
		addUserMemberVO.setUsername(params.get("cagent") + params.get("username"));
		/**
		 * 登录IP
		 */
		addUserMemberVO.setLoginIp(params.get("loginIp"));
		/**
		 * 注册IP
		 */
		addUserMemberVO.setRegIp(params.get("regIp"));
		/**
		 * 用户姓名
		 */
		addUserMemberVO.setRealname(params.get("realname"));
		/**
		 * 第三方游戏账号
		 */
		addUserMemberVO.setAgUsername(addUserMemberVO.getUsername());

		/**
		 * 判断是否为系统预留账户
		 */
		if (reserveAccountMapper.isReserveAccount(addUserMemberVO) != 0) {
			return -1;
		}
		/**
		 * 判断用户是否存在
		 */
		if (userMemberMapper.ismemberAccount(addUserMemberVO) != 0) {
			return -2;
		}
		/**
		 * 判断历史用户是否存在
		 */
		if (userDissociateMapper.isUserDissociateAccount(addUserMemberVO) != 0) {
			return -3;
		}
		/**
		 * 新增会员
		 */
		int insertUserMemberCount = userMemberMapper.addUserMember(addUserMemberVO);
		// HG
		String hgname = addUserMemberVO.getCagent().toLowerCase();
		hgname += "00000000";
		if (hgname.length() > 10) {
			hgname = hgname.substring(0, 10);
		}

		Integer strnum = hgname.length() - addUserMemberVO.getUid().toString().length();
		addUserMemberVO.setHgUsername(hgname.substring(0, strnum) + addUserMemberVO.getUid());
		// update的时候没有转换ip，需清空
		addUserMemberVO.setRegIp(null);
		addUserMemberVO.setLoginIp(null);

		userMemberMapper.updateByPrimaryKeySelective(addUserMemberVO);

		return insertUserMemberCount;

	}

	/**
	 * 根据uid查询会员数据
	 */
	// @DataSource(Database.TXDATA_DB_SLAVE)
	@Override
	public UserMember editPage(Map<String, String> params) throws Exception {

		/**
		 * 查询会员数据
		 */
		UserMember userMember = userMemberMapper.editPage(params);
		/**
		 * 要求打码量
		 */
		UserQuantity userQuantity = userQuantityMapper.selectByUid(userMember.getUid());
		if (null != userQuantity) {
			userMember.setMarkingQuantity(userQuantity.getMarkingQuantity());
		} else {
			userMember.setMarkingQuantity(0d);
		}
		/**
		 * 会员银行卡
		 */
		UserCard userCard = userCardMapper.selectByUid(userMember.getUid());

		if (null != userCard) {
			userMember.setCradUsername(userCard.getCardUsername());
			userMember.setCardNum(userCard.getCardNum());
			userMember.setCardAddress(userCard.getCardAddress());
			CardType cardtype = cardTypeMapper.selectByPrimaryKey(userCard.getBankId());
			if (null != cardtype) {
				userMember.setBankName(cardtype.getBankName());
				userMember.setBankId(cardtype.getBankId());
			}
		}
		return userMember;
	}

	/**
	 * 编辑会员
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public int editUserMember(Map<String, String> params) throws Exception {

		/**
		 * 添加会员VO
		 */
		EditUserMemberVO editUserMemberVO = new EditUserMemberVO();
		editUserMemberVO.setUid(Integer.parseInt(params.get("uid")));
		editUserMemberVO.setMobile(params.containsKey("mobile") ? params.get("mobile") : "");
		editUserMemberVO.setPassword(params.containsKey("password") ? params.get("password") : "");
		editUserMemberVO.setQkPwd(params.containsKey("qkPwd") ? params.get("qkPwd") : "");
		editUserMemberVO.setRealname(params.containsKey("realname") ? params.get("realname") : "");
		editUserMemberVO.setRmk(params.containsKey("rmk") ? params.get("rmk") : "");

		/**
		 * 1 历史用户
		 */
		if ("1".equals(params.get("freeUser"))) {
			editUserMemberVO.setFreeUser("t_user_dissociate");
		} else {
			editUserMemberVO.setFreeUser("t_user");
		}
		userMemberMapper.editUserMember(editUserMemberVO);

		/**
		 * 要求打码量
		 */
		UserQuantity userQuantity = new UserQuantity();
		userQuantity.setMarkingQuantity(Double.parseDouble(params.get("markingQuantity")));
		userQuantity.setUid(editUserMemberVO.getUid());
		userQuantityMapper.updateByUid(userQuantity);

		/**
		 * 判断是否有银行卡
		 */
		UserCard userCard = userCardMapper.selectByUid(editUserMemberVO.getUid());
		if (params.containsKey("bankId") && !"".equals(params.get("bankId"))) {
			UserCard userCardObject = new UserCard();
			userCardObject.setUid(editUserMemberVO.getUid());
			userCardObject.setBankId(Integer.parseInt(params.get("bankId") + ""));
			userCardObject.setCardUsername(params.get("cradUsername"));
			userCardObject.setCardAddress(params.get("cardAddress"));
			userCardObject.setCardNum(params.get("cardNum"));
			userCardObject.setAddTime(new Date());
			if (null == userCard) {
				userCardMapper.insertSelective(userCardObject);
			} else {
				userCardMapper.updateByUid(userCardObject);
			}
		}

		return 1;
	}

	/**
	 * 停用启用
	 */
	@Override
	public void disabledEntity(Map<String, String> params) throws Exception {

		String strUid[] = params.get("uid").split(",");
		StringBuffer strbuff = new StringBuffer();

		Arrays.stream(strUid).forEach(value -> {
			strbuff.append("" + value + "").append(",");
		});
		String uids = strbuff.toString().substring(0, strbuff.length() - 1);

		DisabledEntityVO disabledEntityVO = new DisabledEntityVO();
		disabledEntityVO.setIsStop(params.get("isStop"));
		disabledEntityVO.setUids(uids);
		if (params.containsKey("freeUser") && "1".equals(params.get("freeUser"))) {
			disabledEntityVO.setFreeUser("t_user_dissociate");
		} else {
			disabledEntityVO.setFreeUser("t_user");
		}
		userMemberMapper.disabledEntity(disabledEntityVO);

	}

	/**
	 * 手动加扣款页
	 */
	@Override
	public UserMoneyVO additionPage(Map<String, String> params) throws BusinessException {

		/**
		 * 根据uid 查询会员层级
		 */
		UserMember userMember = userMemberMapper.selectByPrimaryKey(Integer.parseInt(params.get("uid") + ""));
		/**
		 * 拼装参数
		 */
		UserMoneyVO userMoneyVO = new UserMoneyVO();

		if (null == userMember) {
			logger.error("根据UID查询会员分层异常");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_USERTYPE_ERROR);
		}
		UserType usertype = userTypeMapper.selectByPrimaryKey(userMember.getTypeId());
		if (null == usertype) {
			logger.error("根据分层ID获取会员积分比例");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_INTEGRAL_ERROR);
		}
		/**
		 * 根据平台商查询平台ID
		 */
		Cagent cagent = cagentMapper.selectByName(params.get("cagent") + "");
		if (null == cagent) {
			logger.error("根据平台商获取平台ID异常");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_CAGENTID_ERROR);
		}
		/**
		 * 根据平台商查询存取款配置
		 */
		PlatWithdrawal platWithdrawal = platWithdrawalMapper.selectByCid(cagent.getId());
		if (null == platWithdrawal) {
			logger.error("获取存取款配置异常");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_CONFIGURATION_ERROR);
		}
		/**
		 * 积分
		 */
		userMoneyVO.setCIntegralRatio(usertype.getcIntegralRatio());
		/**
		 * 优惠
		 */
		userMoneyVO.setCompanyPayProp(platWithdrawal.getCompanyPayProp());
		/**
		 * 彩金
		 */
		userMoneyVO.setGiftBonusProp(platWithdrawal.getGiftBonusProp());
		/**
		 * 打码量
		 */
		userMoneyVO.setDama(platWithdrawal.getDama());

		return userMoneyVO;
	}

	/**
	 * 手动加扣款，赠送彩金
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void addAmount(Map<String, String> params) throws BusinessException {

		/**
		 * 根据uid 查询会员层级
		 */
		UserMember userMember = userMemberMapper.selectByPrimaryKey(Integer.parseInt(params.get("uid") + ""));
		if (null == userMember) {
			logger.error("该用户不存在");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_USERNAME_ERROR);
		}
		/**
		 * 根据平台ID 查询平台商
		 */
		Cagent cagent = cagentMapper.selectByName(params.get("cagent") + "");
		if (null == cagent) {
			logger.error("获取平台商异常");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_CAGENTID_ERROR);
		}
		/**
		 * 根据平台id获取平台商额度
		 */
		CagentStoredvalue cagentStoredvalue = cagentStoredvalueMapper.selectByCid(cagent.getId());

		if (null == cagentStoredvalue) {
			logger.error("获取平台商额度异常");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_CAGENTID_ERROR);
		}
		/**
		 * 单笔金额不的超过20万
		 */
		if (Double.parseDouble(params.get("amount")) > 200000) {
			logger.error("单笔金额不可超过20万");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_AMOUNT_ERROR);
		}

		/**
		 * 根据平台商查询存取款配置
		 */
		PlatWithdrawal platWithdrawal = platWithdrawalMapper.selectByCid(cagent.getId());
		if (null == platWithdrawal) {
			logger.error("获取存取款配置异常");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_CONFIGURATION_ERROR);
		}

		/**
		 * 封装加扣款彩金对象
		 */
		Fundmanage fundmanage = new Fundmanage();
		/**
		 * 操作人
		 */
		fundmanage.setOperatorId(Integer.parseInt(params.get("operator") + ""));
		/**
		 * 金额
		 */
		fundmanage.setAmount(Float.parseFloat(params.get("amount") + ""));
		/**
		 * 时间
		 */
		fundmanage.setAddTime(new Date());
		/**
		 * 备注
		 */
		fundmanage.setRmk(null == params.get("rmk") ? "" : params.get("rmk"));
		/**
		 * 会员ID
		 */
		fundmanage.setUid(Integer.parseInt(params.get("uid") + ""));
		/**
		 * 1 加款 2扣款 3彩金
		 */
		if ("1".equals(params.get("recordType"))) {

			fundmanage.settType("加款");
			fundmanage.setType("JK");
			fundmanage.setNumber("JK" + fundmanage.getAddTime().getTime());
			/**
			 * 是否赠送优惠
			 */
			if ("1".equals(params.get("isOffer"))) {
				fundmanage.setYhAmount(fundmanage.getAmount() * (platWithdrawal.getCompanyPayProp() / 100));
			} else {
				fundmanage.setYhAmount(0f);
			}
			/**
			 * 是否赠送彩金
			 */
			if ("1".equals(params.get("isCJ"))) {
				fundmanage.setCjAmount(fundmanage.getAmount() * (platWithdrawal.getGiftBonusProp() / 100));
				fundmanage.setCjAmount(fundmanage.getCjAmount() > platWithdrawal.getGiftBonusLimit()
						? platWithdrawal.getGiftBonusLimit() : fundmanage.getCjAmount());
			} else {
				fundmanage.setCjAmount(0f);
			}
			/**
			 * 是否计算打码量
			 */
			if ("1".equals(params.get("isDML"))) {
				fundmanage.setDmlAmount((fundmanage.getAmount() + fundmanage.getYhAmount() + fundmanage.getCjAmount())
						* platWithdrawal.getDama());
			}
			/**
			 * 是否计算积分
			 */
			if ("1".equals(params.get("isIntegral"))) {
				UserType usertype = userTypeMapper.selectByPrimaryKey(userMember.getTypeId());
				if (null == usertype) {
					logger.error("获取会员积分比例异常");
					throw new BusinessException(CommonErrorEnum.USERMEMBER_INTEGRAL_ERROR);
				}
				fundmanage.setIntegralAmount((float) (fundmanage.getAmount()
						* (Double.parseDouble(usertype.getcIntegralRatio() + "") / 100)));
			}
			/**
			 * 是否清空打码量
			 */
			if ("1".equals(params.get("isClearDML"))) {
				fundmanage.setIsClearDml((byte) 1);
			}
		} else if ("2".equals(params.get("recordType"))) {
			fundmanage.settType("扣款");
			fundmanage.setType("KK");
			fundmanage.setNumber("KK" + fundmanage.getAddTime().getTime());

			if (userMember.getWallet() < fundmanage.getAmount()) {
				logger.error("扣款金额不能超过用户当前钱包余额");
				throw new BusinessException(CommonErrorEnum.USERMEMBER_DEDUCTION_ERROR);
			}

		} else if ("3".equals(params.get("recordType"))) {

			fundmanage.settType("彩金");
			fundmanage.setType("CJ");
			fundmanage.setNumber("CJ" + fundmanage.getAddTime().getTime());
			/**
			 * 赠送彩金时计算打码量倍率
			 */
			if (params.containsKey("ext_codingRate") && !"0".equals(params.get("ext_codingRate"))) {
				/**
				 * 本金金额
				 */
				if (params.containsKey("ext_initAmount") && !"".equals(params.get("ext_initAmount"))) {
					fundmanage.setDmlAmount(
							(float) ((Double.parseDouble(params.get("ext_initAmount") + "") + fundmanage.getAmount())
									* Integer.parseInt(params.get("ext_codingRate") + "")));
				} else {
					fundmanage
							.setDmlAmount(fundmanage.getAmount() * Integer.parseInt(params.get("ext_codingRate") + ""));
				}
			}

		}
		fundmanageMapper.insertSelective(fundmanage);
	}

	/**
	 * 修改代理商
	 */
	@Override
	public void editTopUidName(Map<String, String> params) {

		/**
		 * 填充数据
		 */
		EditTopUidVO editTopUidVO = new EditTopUidVO();
		editTopUidVO.setUid(params.get("uid"));
		editTopUidVO.setTopUid(Integer.parseInt(params.get("topUid")));
		userMemberMapper.editTopUidName(editTopUidVO);

	}

	/**
	 * 修改会员层级
	 */
	@Override
	public void editUserType(Map<String, String> params) {
		/**
		 * 填充数据
		 */
		EditUserTypeVO editUserType = new EditUserTypeVO();
		editUserType.setTypeid(Integer.parseInt(params.get("typeid")));
		editUserType.setUids(params.get("uid"));
		userMemberMapper.editUserType(editUserType);

	}

	/**
	 * 会员返水
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public List<UserMemberTs> userMemberTs(Map<String, String> params) throws BusinessException {

		/**
		 * 根据UID查询会员所有游戏返水数据
		 */
		UserMemberTsVO userMemberTsVo = new UserMemberTsVO();

		userMemberTsVo.setUid(Integer.parseInt(params.get("uid")));

		List<UserMemberTs> userMemberTs = userMemberMapper.userMemberTs(userMemberTsVo);

		/**
		 * 获取数据字段游戏列表
		 */
		List<DicData> dicData = dicDataMapper.selectDicData();
		/**
		 * 将所有游戏类型转入MAP集合
		 */
		Map<String, Object> dicMap = new HashMap<String, Object>();
		dicData.parallelStream().forEach(value -> {
			dicMap.put(value.getCode().toUpperCase(), value.getName());
		});

		/**
		 * 拼接游戏平台，并且删除MAP中存在的游戏平台
		 */
		userMemberTs.parallelStream().forEach(value -> {
			if (dicMap.containsKey(value.getGametype().toLowerCase())) {
				value.setGameTypeName(dicMap.remove(value.getGametype().toUpperCase()).toString());
				value.setGametype(value.getGametype().toUpperCase());
			}
		});

		/**
		 * 添加没有数据的游戏平台
		 */
		for (Entry<String, Object> entry : dicMap.entrySet()) {
			UserMemberTs tempMap = new UserMemberTs();
			tempMap.setGametype(entry.getKey());
			tempMap.setGameTypeName(entry.getValue().toString());
			tempMap.setUid(Integer.parseInt(params.get("uid")));
			tempMap.setNoteNum(0);
			tempMap.setBetAmount(0d);
			tempMap.setValidBetAmount(0d);
			tempMap.setNetAmount(0d);
			tempMap.setTsAmount(0d);
			tempMap.setUpdatetime(new Date());
			tempMap.setBacktime(new Date());
			userMemberTs.add(tempMap);
		}

		/**
		 * 排序降序
		 */
		List<UserMemberTs> collect = userMemberTs.parallelStream()
				.sorted((map1, map2) -> map1.getGametype().compareTo(map2.getGametype())).collect(Collectors.toList());

		return collect;
	}

	/**
	 * 给予返水
	 */
	@Override
	public void confirmTs(Map<String, String> params) throws BusinessException {

		/**
		 * 根据UID查询会员所有游戏返水数据
		 */
		UserMemberTsVO userMemberTsVo = new UserMemberTsVO();
		userMemberTsVo.setUid(Integer.parseInt(params.get("uid")));
		if (params.containsKey("gametype")) {
			userMemberTsVo.setGametype(params.get("gametype"));
		}
		List<UserMemberTs> userMemberTs = userMemberMapper.userMemberTs(userMemberTsVo);
		if (null == userMemberTs || userMemberTs.size() == 0) {
			logger.error("无返水数据");
			throw new BusinessException(CommonErrorEnum.USERMEMBER_CONFIRMTS_ERROR);
		}
		userMemberTs.parallelStream().forEach(value -> {

			Date date = new Date();

			/**
			 * 根据会员id获取会员信息
			 */
			UserMember userMember = userMemberMapper.selectByPrimaryKey(Integer.parseInt(params.get("uid") + ""));

			if (value.getTsAmount() == 0) {
				logger.error("无返水数据");
			} else {
				/**
				 * 根据平台名称获取平台信息
				 */
				Cagent cagent = cagentMapper.selectByName(userMember.getCagent());
				if (null == cagent) {
					logger.error("根据平台商获取平台ID异常");
					throw new BusinessException(CommonErrorEnum.USERMEMBER_CAGENTID_ERROR);
				}
				/**
				 * 平台ID获取平台商剩余额度
				 */
				CagentStoredvalue cagentstoredValue = cagentStoredvalueMapper.selectByCid(cagent.getId());
				if (null == cagentstoredValue) {
					logger.error("获取平台额度异常");
					throw new BusinessException(CommonErrorEnum.USERMEMBER_REMAINVALUE_ERROR);
				}
				if (cagentstoredValue.getRemainvalue() < value.getTsAmount()) {
					logger.error("平台额度不足");
					throw new BusinessException(CommonErrorEnum.USERMEMBER_INSUFFICIENT_ERROR);
				}

				/**
				 * 资金流水
				 */
				UserTreasure userTreasure = new UserTreasure();
				userTreasure.setUid(userMember.getUid());
				userTreasure.setAmount(value.getTsAmount());
				userTreasure.setOldMoney(userMember.getWallet());
				userTreasure.setNewMoney(userTreasure.getAmount() + userTreasure.getOldMoney());
				userTreasure.setNumber(System.currentTimeMillis() + "");
				userTreasure.settType("返水");
				userTreasure.setType("IN");
				userTreasure.setAddtime(date);
				DicData dicData = dicDataMapper.selectByCode(value.getGametype());
				userTreasure.setPlatformType(null == dicData ? 0 : dicData.getValue());
				userTreasure.setsType(1 + "");
				userTreasure.setRmk(null == dicData ? value.getGametype() + "手工返水" : dicData.getName() + "手工返水");
				userTreasure.setOperatorId(Integer.parseInt(params.get("ruid")));
				userTreasure.setCagent(cagent.getCagent());
				userTreasure.setIsFirst(1);
				userTreasure.setIp(params.get("IP"));

				/**
				 * 追加已用额度，已及修改剩余额度
				 */
				cagentstoredValue.setUsedvaue(cagentstoredValue.getUsedvaue() + value.getTsAmount());
				cagentstoredValue.setRemainvalue(cagentstoredValue.getRemainvalue() - value.getTsAmount());

				/**
				 * 记录额度日志
				 */
				CagentStoredvalueLog cagentStorevaluelog = new CagentStoredvalueLog();
				cagentStorevaluelog.setCid(cagent.getId());
				cagentStorevaluelog.settType("返水");
				cagentStorevaluelog.setType("OUT");
				cagentStorevaluelog.setValue(value.getTsAmount());
				cagentStorevaluelog.setAddtime(date);
				cagentStorevaluelog.setOperatorId(Integer.parseInt(params.get("ruid")));
				cagentStorevaluelog.setLoginIp(params.get("IP"));

				cagentStoredvalueMapper.updateByPrimaryKeySelective(cagentstoredValue);
				cagentStoredvalueLogMapper.insertSelective(cagentStorevaluelog);
				UserTreasureMapper.insertSelective(userTreasure);

				Map<String, String> map = new HashMap<String, String>();
				map.put("uid", userMember.getUid() + "");
				map.put("gametype", value.getGametype());
				map.put("cagent", cagent.getName());
				updateMakeZero(map);
			}
		});
	}

	/**
	 * 
	 * @Description (返水清零)
	 * @param uid
	 * @param gametype
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void updateMakeZero(Map<String, String> params) {

		/**
		 * 封装对象
		 */
		UserMemberTsVO userMemberTsVo = new UserMemberTsVO();
		userMemberTsVo.setUid(Integer.parseInt(params.get("uid")));
		userMemberTsVo.setGametype(params.get("gametype"));
		
		DicData dicData = dicDataMapper.selectByCode(params.get("gametype"));
		UserMember userMember = userMemberMapper.selectByPrimaryKey(Integer.parseInt(params.get("uid") + ""));
		
		userMemberTsVo.setGamaValue(dicData.getName());
		userMemberTsVo.setCagent(userMember.getCagent());
		/**
		 * 记录返水清零记录
		 */
		UserTreasureMapper.cleanUserTsLog(userMemberTsVo);
		/**
		 * 清零返水数据
		 */
		cagentStoredvalueMapper.updateMakeZero(userMemberTsVo);
	}
}

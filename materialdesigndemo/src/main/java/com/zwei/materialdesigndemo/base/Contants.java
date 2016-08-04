package com.zwei.materialdesigndemo.base;

import android.os.Environment;
import android.util.Log;

public class Contants {
    public static final boolean DEBUG = true;
    public static String IS_FIRST_USE = "ISFIRSTUSER";


    // ================================================================
    // LOG
    // ================================================================
    public static void log(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, "=========================================");
            Log.e(tag, msg);
            Log.e(tag, "=========================================");
        }
    }

    public static void log(String msg) {
        if (DEBUG) {
            Log.e("materialdesigndemo", "=========================================");
            Log.e("materialdesigndemo", msg + " ");
            Log.e("materialdesigndemo", "=========================================");
        }
    }

    public static void log(boolean b ,String msg) {
        if (b) {
            Log.e("materialdesigndemo", "=========================================");
            Log.e("materialdesigndemo", msg + " ");
            Log.e("materialdesigndemo", "=========================================");
        }
    }

    public static void logW(String msg) {
        if (DEBUG) {
            Log.w("logzwei", "=========================================");
            Log.w("logzwei", msg);
            Log.w("logzwei", "=========================================");
        }
    }

    // ================================================================
    // 状态码
    // ================================================================
    /**
     * 成功
     */
    public static final int STATUS_SUCCESS = 2000;

    /**
     * 重复评论
     */
    public static final int STATUS_REPEAT = 2001;

    /**
     * 参数非法
     */
    public static final int STATUS_ILLEGAL_PARAMS = 4000;
    /**
     * token缺失
     */
    public static final int STATUS_MISS_TOKEN = 4001;
    /**
     * token过期
     */
    public static final int STATUS_TOKEN_OVERDUR = 4002;
    /**
     * 服务器异常
     */
    public static final int STATUS_SERVER_EXCEPTION = 5000;
    /**
     * 手机号被占用
     */
    public static final int STATUS_PHONE_OCCUPY = 7001;
    /**
     * 发送注册短信太频繁
     */
    public static final int STATUS_SMS_REQUEST_TOO_FAST = 7002;
    /**
     * 手机号不存在
     */
    public static final int STATUS_PHONE_INEXIST = 7003;
    /**
     * 验证不正确
     */
    public static final int STATUS_VERIFY_MISTAKE = 7004;
    /**
     * 验证码过期
     */
    public static final int STATUS_VERIFY_OVERDUR = 7005;
    /**
     * 旧的密码不正确
     */
    public static final int STATUS_OLDER_PASSWORD_MISMATCH = 7006;
    /**
     * 用户名或者密码不匹配
     */
    public static final int STATUS_USERNAME_OR_PASSWORD_MISMATCH = 7003;
    /**
     * 网络不可用
     */
    public static final int STATUS_NETWORK_DISABLED = 1000;
    /**
     * 获取数据失败
     */
    public static final int STATUS_GETDATA_FAILURE = 1001;
    /**
     * 用户状态错误
     */
    public static final int STATUS_USER_STATUS_ERROR = 1002;


    /**
     * 成功
     *
     * @param errorCode
     * @return
     */
    public static boolean isSuccess(int errorCode) {
        if (errorCode == 2000) {
            return true;
        }
        return false;
    }

    /**
     * 客户端问题
     *
     * @param errorCode
     * @return
     */
    public static boolean isClientException(int errorCode) {
        if (errorCode >= 4000 && errorCode < 5000) {
            return true;
        }
        return false;
    }

    /**
     * 服务器问题
     *
     * @param errorCode
     * @return
     */
    public static boolean isServerException(int errorCode) {
        if (errorCode >= 5000 && errorCode < 7000) {
            return true;
        }
        return false;
    }

    /**
     * 接口相关问题
     *
     * @param errorCode
     * @return
     */
    public static boolean isInterfaceException(int errorCode) {
        if (errorCode >= 7000) {
            return true;
        }
        return false;
    }

    // ================================================================
    // 服务器接口地址
    // ================================================================

    /**
     * 存储跟目录
     */
    public static final String MI_JUAN_PATH = Environment.getExternalStorageState() + "/mijuan";

    /**
     * 本地图片保存路径
     */
    public static final String PIC_PAHT = MI_JUAN_PATH + "/picture";


    /**
     * 发布域名
     */
    public static final String release_domain = "http://112.74.18.65:80/o2o-questions";
    /**
     * 测试域名
     */
    public static final String debug_domain = "http://112.74.18.65:8080/o2o-questions";
//	public static final String debug_domain = "http://a4626961.xicp.net/o2o-questions";

    public static String baseUrl = (DEBUG ? debug_domain : release_domain);
    /**
     * 网络域名
     */
    public static final String mijuan_doamin = "http://mijuan.xuebangsoft.net/o2o-questions";


    /**
     * 注册地址
     */
    public static final String URL_REGISTER = baseUrl + "/app/user/register";

    /**
     * 验证码验证地址
     */
    public static final String URL_VALIDATE_VERIFY_CODE = (DEBUG ? debug_domain
            : release_domain) + "/app/user/validateVerifyCode";

    /**
     * 请求发送验证码地址
     */
    public static final String URL_GET_VERRIFY_CODE = (DEBUG ? debug_domain
            : release_domain) + "/app/user/getVerifyCode";

    /**
     * 请求获取个人用户信息
     */
    public static final String URL_GET_USER_INFORMATION = (DEBUG ? debug_domain
            : release_domain) + "/app/user/userInformation";

    /**
     * 重置密码
     */
    public static final String URL_RESET_PASSWORD = (DEBUG ? debug_domain
            : release_domain) + "/app/user/resetPassword";
    /**
     * 请求修改密码
     */
    public static final String URL_MODIFY_PASSWORD = (DEBUG ? debug_domain
            : release_domain) + "/app/user/modifyPassword";

    /**
     * 请求登陆地址
     */
    public static final String URL_LOGIN = (DEBUG ? debug_domain
            : release_domain) + "/app/user/login";

    /**
     * 请求用户数量
     */
    public static final String URL_COUNTER_USER = (DEBUG ? debug_domain
            : release_domain) + "/app/user/counter";

    /**
     * 请求登出地址
     */
    public static final String URL_LOGOUT = (DEBUG ? debug_domain
            : release_domain) + "/app/user/logout";

    /**
     * 请求修改个人信息
     */
    public static final String URL_MODIFY_USER_INFORMATION = (DEBUG ? debug_domain
            : release_domain) + "/app/user/modifyUserInformation";
    /**
     * 请求修改个人信息
     */
    public static final String URL_MODIFY_USER_HEAD = (DEBUG ? debug_domain
            : release_domain) + "/app/user/modifyUserHead";

    /**
     * 请求获取城市列表
     */
    public static final String URL_GET_CITYS = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getCitys";
    /**
     * 请求获取省列表
     */
    public static final String URL_GET_PROVINCES = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getProvinces";

    /**
     * 请求获取区域列表
     */
    public static final String URL_GET_AREAS = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getAreas";

    /**
     * 请求获取学校列表
     */
    public static final String URL_GET_SCHOOLS = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getSchools";

    /**
     * 通过名字找到区域
     */
    public static final String URL_GET_AREA_BY_NAME = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getAreaByName";
    /**
     * 通过名字找到城市
     */
    public static final String URL_GET_CITY_BY_NAME = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getCityByName";
    /**
     * 通过名字找到省
     */
    public static final String URL_GET_PROVINCE_BY_NAME = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getProvinceByName";

    /**
     * 获取试卷列表
     */
    public static final String URL_GET_PAPER_LIST = (DEBUG ? debug_domain
            : release_domain) + "/app/paper/getPaperList";

    /**
     * 获取考试试卷
     */
    public static final String URL_GET_PAPER_EXAM = (DEBUG ? debug_domain
            : release_domain) + "/app/paper/getPaperExam";

    /**
     * 获取考试试卷累计
     */
    public static final String URL_SET_PAPER_EXAM_COUNT = (DEBUG ? debug_domain
            : release_domain) + "/app/paper/setPaperExamCount";

    /**
     * 获取测试试卷
     */
    public static final String URL_GET_PAPER_TEST = (DEBUG ? debug_domain
            : release_domain) + "/app/paper/getPaperTest";

    /**
     * 获取gradelist
     */
    public static final String URL_GET_GRADE_LIST = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getGradeList";

    /**
     * 获取subjectlist
     */
    public static final String URL_GET_SUBJECT_LIST = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getSubjectList";

    /**
     * 获取SynKnowledgesVersion
     */
    public static final String URL_GET_SYN_KNOWLEDGES_VERSION = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getSynKnowledgesVersion";


    public static final String URL_GET_SYN_SYN_KNOWLEDGES_VERSION_GRADE = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getSynKnowledgesVersionGrade";

    /**
     * 提交考试模式结果
     */
    public static final String URL_COMMIT_PAPER_EXAM_RESULT = (DEBUG ? debug_domain
            : release_domain) + "/app/paper/commitExam";

    /**
     * 提交练习模式结果
     */
    public static final String URL_COMMIT_PAPER_TEST_RESULT = (DEBUG ? debug_domain
            : release_domain) + "/app/paper/commitExamForTest";


    /**
     * 下载试卷
     */
    public static final String URL_DOWNLOAD_PAPER = (DEBUG ? debug_domain
            : release_domain) + "/app/paper/downloadPaper";

    /**
     * 纠错题目
     */
    public static final String URL_REPORT_QUESTION_CORRECTION = (DEBUG ? debug_domain
            : release_domain) + "/app/question/reportQuestionCorrection";


    /**
     * 版本信息
     */
    public static final String URL_GET_VERSION_INFO = (DEBUG ? debug_domain
            : release_domain) + "/app/version/getVersionInfo";
    /**
     * 专题知识点
     */
    public static final String URL_GET_KNOWLEDGES = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getKnowledges";

    /**
     * 同步知识点
     */
    public static final String URL_GET_SYNC_KNOWLEDGES = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/getSyncKonwledgesByGrade";


    /**
     * 专题知识点题目列表
     */
    public static final String URL_GET_QUESTION_LIST = (DEBUG ? debug_domain
            : release_domain) + "/app/question/getQuestionList";

    /**
     * 获取新闻内容
     */
    public static final String URL_GET_FINDNEWSTOTHREE = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/findNewsToThree";

    /**
     *
     */
    public static final String URL_COMMIT_HOMEPAGE_QUESTION = (DEBUG ? debug_domain
            : release_domain) + "/app/paper/commitHomePageQuestion";

    /**
     * 同步的操作记录提交
     */
    public static final String URL_USEROPERATERECORD_ADD = (DEBUG ? debug_domain
            : release_domain) + "/app/baseData/userOperateRecord/add";


    /**
     * 获取好友列表
     */
    public static final String URL_FINDFRIENDINSTALL = (DEBUG ? debug_domain
            : release_domain) + "/app/user/findFriendInstall";

    /**
     * 分享链接地址
     */
    public static final String URL_SHARE_ADRESS = "http://mijuan.xuebangsoft.net/o2o-questions/installUser/toFluxReceive";

    /**
     * 后台添加分享记录
     */
    public static final String URL_INSTALLUSER_ADDINSTALLUSER = (DEBUG ? debug_domain
            : release_domain) + "/installUser/addInstallUser";

    /**
     * 请求得奖数量
     */
    public static final String URL_FIND_REWARD_COUNT = (DEBUG ? debug_domain
            : release_domain) + "/app/user/findRewardCount";

    /**
     * 第三方登录openId验证接口
     */
    public static final String URL_THRIRDPARTY_LOGIN = (DEBUG ? debug_domain
            : release_domain) + "/app/user/thirdPartyLogin";

    /**
     * 绑定旧账号关联
     */
    public static final String URL_VALIDATE_USER = (DEBUG ? debug_domain
            : release_domain) + "/app/user/validateUser";

    /**
     * 绑定旧账号关联
     */
    public static final String URL_VALIDATE_MOBLIC = (DEBUG ? debug_domain
            : release_domain) + "/app/user/validateMobile";

    /**
     * 分享题目
     */
    public static final String URL_SHARE_QUESTION = (DEBUG ? debug_domain
            : mijuan_doamin) + "/appShareQuestion/toShareQuestion";

    /**
     * 请求邀请码getInvitationCode
     */
    public static final String URL_GET_INVITATION_CODE = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/activity/getInvitationCode";

    /**
     * 提交绑定邀请码
     */
    public static final String URL_COMIT_INVITATION_CODE = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/activity/invitationUser";

    /**
     * 获取抽奖允许次数
     */
    public static final String URL_GET_ALLOW_COUNT = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/activity/getAllowCount";

    /**
     * 获取获得奖励的信息
     */
    public static final String URL_FIND_All_AWARD = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/activity/findAllAward";


    /**
     * 获取是否中奖
     */
    public static final String URL_IS_GET_AWRAD = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/activity/isGetAward";


    /**
     * 查看当前用户是否中奖
     */
    public static final String URL_FIND_AWARD_RECORD = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/activity/findAwardRecordByLuckUser";


    /**
     * 查看当前用户是否中奖
     */
    public static final String URL_FIND_AWARD_RECORD_BY_USER = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/activity/findAwardRecordByLuckUser";

    /**
     * 查看当前用户是否中奖
     */
    public static final String URL_BIND_AWARD_NUMBER = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/activity/bindAwardNumber";

    /**
     * 获取当前题目的通过率和做题人数
     */
    public static final String URL_GET_QUESTION_COUNT = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/paper/getQuestionViewCount";

    /**
     * 获取文章列表
     */
    public static final String URL_FIND_ARTICLE_LIST = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/findArticle";

    /**
     * 根据文章ID获取文章详情
     */
    public static final String URL_FIND_ARTICLE_BYID = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/findArticleById";


    /**
     * 获取新文章的数量
     */
    public static final String URL_FIND_NEW_ARTICLE_COUNT = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/findNewArticleCount";


    /**
     * 点赞文章
     */
    public static final String URL_PRAISE_ARTICLE = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/praiseArticle";

    /**
     * 收藏文章
     */
    public static final String URL_COLLECTION_ARTICLE = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/collection";

    /**
     * 收藏文章
     */
    public static final String URL_CANCEL_COLLECTION_ARTICLE = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/cancelCollection";

    /**
     * 获取我的收藏文章
     */
    public static final String GET_MY_COLLECTION_ARTICLE = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/myCollection";

    /**
     * 文章分享链接
     */
    public static final String URL_ARTICLE_SHARE = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/shareArticle";

    /**
     * 提交评论
     */
    public static final String URL_SAVE_REPLY = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/saveReply";

    /**
     * 提交评论
     */
    public static final String URL_DELETE_REPLY = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/deleteReply";

    /**
     * 加载所有评论或者回复
     * 分页获取文章，和 评论子回复 共用此接口
     */
    public static final String URL_GET_ALL_REPLY_BY_ID = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/findReplyById";

    /**
     * 评论点赞与取消
     */
    public static final String URL_CLICK_PRAISE = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/clickPraise";


    /**
     * 我的回复
     */
    public static final String URL_FIND_MY_REPLY = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/findMyReply";


    /**
     * 回复我的
     */
    public static final String URL_FIND_REPLY_ME = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/findReplyMe";


    /**
     * 获取未读消息数
     */
    public static final String URL_GET_UNREAD_REPLY_COUNT = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/infoCount";

    /**
     * 将消息标识为已读
     */
    public static final String URL_REPLY_INFO = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/readInfo";

    /**
     * 获取最详细的文章信息
     */
    public static final String URL_FIND_BY_READID = (DEBUG ? debug_domain
            : mijuan_doamin) + "/app/read/findByReadId";


}

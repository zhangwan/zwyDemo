package com.tiger.zwy.http


/**
 * Created by huiT on 2019/12/25.
 */
object HttpConstants {
    const val TIME_OUT: Long = 30

    const val URL_BASE = "http://192.168.1.241/tinytiger_app/public/index.php/"
    const val URL_BASE_H5="https://www.beadwallet.net/"
    object H5 {
        var CONDITIONS = "$URL_BASE_H5/TERMS_AND_CONDITIONS.html" //注册协议
        var PRIVACY_POLICY = "$URL_BASE_H5/PRIVACY_POLICY.html" //隐私协议
    }

    object Code {

        const val SUCCESS = "200"//请求成功
        const val SUCCESS1 = "200"//成功(无需处理)
        const val LOGOUT = "F00001"//未登录

        const val CUSTOMIZE_CODE_401 = "401"//未登录
        const val CUSTOMIZE_CODE_100 = "C100"//数据解析错误
        const val CUSTOMIZE_CODE_200 = "C200"//网络异常
        const val CODE_700 = "700"//接口返回的数据结构和约定的不一致
        const val TIME_OUT = "-1"//网络连接超时
    }

    object AppConstant {
        const val APP_CODE = "fr"
        const val VEST_CODE = "fr_fr"
    }


    /**
     * 产品管理
     */
    object LoanProducter {
        const val GET_LOAN_PRODUCT_LIST = "api/core/loan/producter/getLoanProductPageList"//查询贷款页的接口
        const val SELECT_PRODUCTER_DETAILS = "api/core/loan/producter/select" //取得指定贷款产品信息
        const val SELECT_LOAN_LABEL_ALL = "api/core/loan/loanLabel/selectLoanLabelAll"//查询全部标签(前端)
        const val SELECT_APP_BANNER_ALL = "api/core/app/manager/banner/selectAppBannerAll"//查询全部banner(前端)
        const val INSERT_MARKET = "api/core/appAnalyse/market/insert"//插入更新贷超入住app统计数据
    }

    /**
     * 用户管理
     */
    object Auth {
        const val VERIFY_CODE = "api/core/user/auth/verifyCode"//图片验证码
        const val MSG_CODE = "Login/sendVerificationCode"//获取短信验证码
        const val REGISTER = "api/core/user/register"//注册
        const val LOGIN_PWD = "api/core/user/loginPwd"//密码登录
        const val LOGIN_CODE = "Login/verificationCodeLogin"//手机验证码登录
        const val LOGIN_OUT = "api/core/user/logout"//退出登录
        const val FIND_USER = "api/core/user/findUser"//获取用户基本信息
        const val RESET_PASSWORD = "api/core/user/resetPassword"//忘记密码(未登陆状态使用)
        const val UPDATE_PASSWORD = "api/core/user/updatePassword" //更新密码(登陆状态使用)
        const val UPLOAD = "api/core/user/upload/images/upload"//上传图片
        const val FEEDBACK_INSERT = "api/core/user/feedback/insert"//新增
        const val VERSION_UPDATE = "/api/core/app/manager/version/findByAppType"//查找app
        const val PRIVACY = "/api/core/user/privacy"//隐私协议
    }

}
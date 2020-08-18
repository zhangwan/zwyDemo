package com.tiger.zwy.http

/**
 * Created By HuiT
 * On 2020/1/2
 * desc:
 */
enum class HttpCodeMsg(var code: String, var msg: String) {

    // 公共消息X0开头
    //<string name="S00000">成功</string>
    SUCCESS("S00000", "成功"),
    ERROR("E00000", "异常"),
    FAIL("F00000", "失败"),

    NOT_LOGIN("F00001", "未登录"),
    LOGIN_FAIL("F00002", "登录失败"),
    NOT_AUTH("F00003", "访问受限"),
    PARAM_ERROR("F00004", "参数错误"),
    PARAM_NULL("F00005", "参数为空"),
    DATA_IS_EXIST("F00007", "数据已存在"),
    DATA_NOT_FOUND("F00008", "没有找到记录"),
    SAVE_FAIL("F00009", "保存失败"),
    MODIFY_FAIL("F00010", "修改失败"),
    CREATE_FAIL("F00011", "创建失败"),
    DELETE_FAIL("F00012", "删除失败"),
    INVALID_DATA("F00013", "无效数据"),
    ALREADY_EXPIRATION("F00014", "已经过期"),
    NOT_PARAM("F00015", "缺少参数"),
    CHECK_CONFIG("F00016", "请检查配置"),
    TOO_MANY_REQUESTS("F00017", "请求太多"),
    FOREIGN_KEY_EXISTS("F00018", "数据存在外键关联，禁止执行当前操作"),
    FUNCTION_NOT_REALIZE("F00019", "功能未实现"),
    INVOKING_INTERFACE_ERROR("F00020", "系统模块间调用接口异常"),
    VALIDATE_ERROR("F00021", "数据验证失败"),
    NONE_SERVICE("F00022", "service不存在"),
    MULTI_SERVICE("F00023", "查找到多个service"),
    AUTH_INFO_ERROR("F00024", "鉴权中心返回失败"),
    PART_FAIL("F00025", "部分操作失败"),


    // 基础模块消息X1开头
    BASE_EXAMPLE_SUCCESS("S10000", "基础成功消息样例"),
    BASE_EXAMPLE_ERROR("E10000", "基础异常消息样例"),
    BASE_EXAMPLE_FAIL("F10000", "基础失败消息样例"),
    BASE_EXAMPLE_CODEMAKER_ERROR("F10001", "验证码不正确"),
    BASE_EXAMPLE_OLDPASSWORD_ERROR("F10002", "原密码错误"),
    BASE_EXAMPLE_NOWLOGIN_NO_ROLE("F10003", "当前用户没有关联角色"),
    BASE_EXAMPLE_NOWLOGIN_NO_MENU("F10004", "当前用户没有菜单，检查是否分配角色"),
    BASE_EXAMPLE_CODEMAKER_CREATE_FAIL("F10005", "图片验证码生成失败"),
    BASE_EXAMPLE_USER_USERNAMEORPHONE_EXIST("F10006", "用户名或手机号已存在"),
    BASE_EXAMPLE_USER_PHONE_EXIST("F10007", "手机号已存在"),
    BASE_EXAMPLE_CODE_EXIST("F10008", "编码已存在"),
    BASE_EXAMPLE_DATA_NOEXIST("F10009", "没有找到需要修改的数据"),
    BASE_EXAMPLE_BALANCE_CX("F10010", "先撤销下级机构"),
    BASE_EXAMPLE_SYSTEM_IMAGE_FORMAT_ERROR("F10011", "图片格式错误，仅支持jpg/png"),
    BASE_EXAMPLE_SYSTEM_SYSTEM_IMAGE_SIZE_5M("F10012", "图片大小不能超过5M"),
    BASE_EXAMPLE_SYSTEM_IMAGE_UPLOAD_FAIL("F10013", "图片上传失败"),
    BASE_EXAMPLE_SYSTEM_SUPPLIER_NOT_FAIL("F10014", "该账号不是供应商账号，不能添加"),
    BASE_EXAMPLE_SYSTEM_SYSTEM_IMAGE_SIZE_10M("F10012", "图片大小不能超过10M"),
    BASE_EXAMPLE_SYSTEM_EXCEL_FORMAT_ERROR("F10016", "文件格式错误，仅支持xlsx/xls"),
    BASE_EXAMPLE_SYSTEM_MERCHANT_CODE_EXIST("F10017", "商户编码已存在"),

    BASE_EXAMPLE_SYSTEM_CONTRACT_FORMAT_ERROR("F10017", "合同模板格式错误，仅支持ftl/pdf"),
    BASE_EXAMPLE_SYSTEM_CONTRACT_SIZE_10M("F10018", "合同模板大小不能超过10M"),
    BASE_EXAMPLE_SYSTEM_CONTRACT_UPLOAD_FAIL("F10019", "合同模板文件上传失败"),

    // 共通模块消息X2开头
    COMN_EXAMPLE_SUCCESS("S20000", "共通成功消息样例"),
    COMN_EXAMPLE_ERROR("E20000", "共通异常消息样例"),
    COMN_EXAMPLE_FAIL("F20000", "共通失败消息样例"),

    // 核心模块消息X3开头
    CORE_EXAMPLE_SUCCESS("S30000", "核心成功消息样例"),
    CORE_EXAMPLE_FAIL("F31000", "核心支付模块调用失败"),

    CORE_PAY_NONE_CONFIG("F30000", "不支持的应用或交易类型"),
    CORE_PAY_ENCRYPT("F30001", "加密失败"),
    CORE_PAY_DECRYPT("F30002", "解密失败"),


    //支付模块x33开始
    CORE_TRADE_NONE("S33000", "交易不存在"),
    CORE_TRADE_FINISHED("S33001", "交易完成"),
    CORE_TRADE_IN_PROCESS("S33002", "交易处理中"),
    CORE_TRADE_FAILED("S33003", "交易失败"),
    CORE_TRADE_CANCEL("S33004", "交易取消"),
    CORE_TRADE_NON_SUPPORT("S33010", "不支持的交易类型"),
    CORE_SETTLE_NOT_FINISHED("S33005", "清结算未完成"),
    CORE_REFUND_FAILED("S33006", "退款失败"),
    CORE_REFUND_CANCEL("S33007", "退款取消"),
    CORE_REFUND_FINISHED("S33008", "退款完成"),
    CORE_REFUND_IN_PROCESS("S33009", "退款处理中"),
    CORE_REFUND_ORIGIN_NOT_FINISH("S33011", "交易未完成,无法退款"),
    CORE_REFUND_AMOUNT_EXCEED_LIMIT("S33012", "累计退款金额大于交易金额"),


    CORE_CARD_NONE_PRE_BOUND("F33000", "请先进行预绑定"),
    CORE_CARD_IS_BOUND("F33001", "银行卡已经绑定"),
    CORE_CARD_NOT_BOUND("F33002", "银行卡没有绑定"),
    CORE_CARD_NOT_EXIST("F33003", "此银行卡不存在"),
    CORE_CARD_NOT_EXIST_OR_BOUND("F33004", "银行卡不存在或没有绑定"),
    CORE_CARD_USER_NONE_CARD("F33005", "用户无可用的银行卡"),
    CORE_CLIENT_NONE_INIT("F33006", "未初始化第三方支付配置"),
    CORE_MERCHANT_NONE_EXIST("F33007", "商户支付配置不存在"),


    //微信支付宝支付
    CORE_NOT_SUPPORT_PAY_TYPE("E33000", "不支持的支付类型"),
    CORE_AUTH_ACCESS_TOKEN_INVOKE_FAIL("E33001", "获取accessToken失败"),
    CORE_AUTH_ACCESS_TOKEN_NULL("E33002", "获取accessToken结果为null"),
    CORE_AUTH_ACCESS_TOKEN_FAIL("E33003", "获取accessToken失败"),


    CORE_PAY_REQ_CHECK_USER_ID("C33001", "用户id不能为空"),
    CORE_PAY_REQ_CHECK_USER_ID_CARD("C33002", "用户身份证号不能为空"),
    CORE_PAY_REQ_CHECK_USER_CARD_NAME("C33003", "持卡人姓名不能为空"),
    CORE_PAY_REQ_CHECK_CARD_ID("C33004", "银行卡id不能为空"),
    CORE_PAY_REQ_CHECK_USER_CARD_PHONE("C33005", "银行卡绑定手机号不能为空"),
    CORE_PAY_REQ_CHECK_USER_CARD_NO("C33006", "银行卡号不能为空"),
    CORE_PAY_REQ_CHECK_CARD_VALID_DATE("C33007", "信用卡有效期不能为空"),
    CORE_PAY_REQ_CHECK_CARD_VALID_NO("C33008", "信用卡安全码不能为空"),
    CORE_PAY_REQ_CHECK_ORDER_NO("C33009", "订单号不能为空"),
    CORE_PAY_REQ_CHECK_AMOUNT("C33010", "支付金额不能为空"),
    CORE_PAY_REQ_CHECK_AMOUNT2("C33011", "支付金额需大于0"),
    CORE_PAY_REQ_CHECK_PRE_UNIQUE_CODE("C33012", "预签约唯一码不能为空"),
    CORE_PAY_REQ_CHECK_SMS_CODE("C33013", "短信验证码不能为空"),
    CORE_PAY_REQ_CHECK_PRE_TRADE_UNIQUE_CODE("C33014", "预支付唯一码不能为空"),


    // 审核模块消息X32开头
    AUDIT_RELATION_COUNT_FAIL("F32000", "删除审核规则时，存在产品关联数据，请先删除关联数据"),
    AUDIT_DEBT_DATA_NULL("F32001", "审核模块，获取工单数据为空"),
    AUDIT_CREDIT_INFO_DATA_NULL("F32002", "审核模块，获取工单获取授信单无数据"),
    AUDIT_REJECT_DATA_FAIL("F32003", "保存或者更新授信被拒记录失败"),
    AUDIT_DEBT_STATUS_FAIL("F32004", "前置审核，工单状态不正确"),
    AUDIT_USER_STATUS_FAIL("F32005", "前置审核，获取用户信息为空"),
    AUDIT_CREDIT_DATA_NULL("F32006", "授信单不存在"),
    AUDIT_USER_DATA_NULL("F32007", "借款人不存在"),
    AUDIT_BJSH_CALLBACK_ERROR("F32008", "北京审核回调接口异常"),
    AUDIT_AUTH_CREDIT_DATA_NULL("F32009", "审核模块授信授权数据查询，入参为空"),
    AUDIT_AUTH_CREDIT_PUSH_DATA_NULL("F32010", "审核模块授信授权数据查询，获取推送数据不存在"),
    AUDIT_AUTH_RECORD_DATA_NULL("F32011", "审核模块授信授权数据查询，获取认证记录数据异常"),
    AUDIT_EXIST_PROCESS_CREDIT("F32012", "用户存在正在进行中的授信单信息"),
    AUDIT_CREDIT_STATUS_EXISTS_0_8_DATA("F32013", "用户存在草稿或者撤回授信单"),
    AUDIT_EXIST_REJECT_BLACKLIST("F32014", "存在被拒授信单或在黑名单中"),
    AUDIT_ERROR("F32015", "审核模块系统异常"),
    AUDIT_CLOUD_ERROR("F32016", "审核模块，审核前置异常"),
    AUDIT_AUTH_RECORD_DATA_NOT_EXIST("F32017", "获取认证记录数据不存在"),
    AUDIT_PRODUCT_LINK_DATA_EXIST("F32018", "审核规则关联产品信息，维护规则已存在"),
    AUDIT_CREDIT_DEBT_LINK_NOT_EXIST("F32019", "工单关联授信单信息不存在"),

    //核心->短信 模块消息X34开头
    CORE_SMS_SECRET_ERROR("F34101", "参数密钥验证错误"),
    CORE_SMS_CHANNEL_INVALID("F34103", "短信通道拒绝"),
    CORE_SMS_ACCOUNT_INVALID("F34104", "短信通道鉴权已过期"),
    CORE_SMS_MSGTYPE_INVALID("F34105", "渠道短信下发方式未开通"),
    CORE_SMS_SIGN_INVALID("F34106", "短信签名已过期"),
    CORE_SMS_TEMPLATE_ERROR("F34107", "短信模板信息加载失败"),
    CORE_SMS_SERVICE_NOTEXISTS("F34108", "短信业务服务不存在"),
    CORE_SMS_EXTPARAM_NOTJSON("F34109", "账户扩展参数JSON格式不正确"),

    // 网关模块消息X4开头
    GATE_EXAMPLE_SUCCESS("S40000", "网关成功消息样例"),
    GATE_EXAMPLE_ERROR("E40000", "网关异常消息样例"),
    GATE_EXAMPLE_FAIL("F40000", "网关失败消息样例"),

    // 借贷模块消息X5开头
    LOAN_EXAMPLE_SUCCESS("S50000", "借贷成功消息样例"),
    LOAN_EXAMPLE_ERROR("E50000", "借贷异常消息样例"),
    LOAN_EXAMPLE_FAIL("F50000", "借贷失败消息样例"),
    LOAN_PRODUCT_IS_NOT_EXIST("F50001", "产品不存在"),
    LOAN_EXIST_REJECT_BLACKLIST("F50002", "存在被拒工单或在黑名单中"),
    LOAN_EXIST_PROCESS_DEBT("F50003", "存在进行中工单"),
    LOAN_DEBT_NOT_EXIST("F50004", "工单不存在"),
    LOAN_STATUS_ERROR("F50005", "工单状态错误"),
    LOAN_BANK_CARD_NOT_BIND("F50006", "未绑定银行卡"),
    LOAN_DEBT_GET_CREDIT_AMOUNT_FAIL("F50007", "获取授信额度失败"),
    LOAN_CHANNEL_EXCEPTION("F50008", "获取渠道信息异常"),
    LOAN_CHANNEL_DISABLE("F50009", "渠道已禁用"),
    LOAN_AMOUNT_LOWER_THAN_PRODUCT_MIN("F50010", "低于借款允许下限"),
    LOAN_AMOUNT_HIGHER_THAN_PRODUCT_MAX("F50011", "高于借款允许上限"),

    //还款计划相关
    LOAN_REPAYMENT_GET_DEBT_FAIL("F50101", "工单数据获取失败"),
    LOAN_REPAYMENT_GET_PRODUCT_FAIL("F50102", "产品数据获取失败"),
    LOAN_REPAYMENT_GET_PRODUCT_TERM_FAIL("F50103", "产品分期数据获取失败"),
    LOAN_REPAYMENT_UPDATE_DEBTSTATUS_FAIL("F50104", "修改工单状态失败"),
    LOAN_REPAYMENT_DEBT_NOT_INSTALLMENT("F50105", "不是商城分期工单"),
    LOAN_REPAYMENT_DEBT_STATUS_WRONG("F50106", "工单状态不正确"),
    LOAN_REPAYMENT_BATCH_STATUS_WRONG("F50107", "还款批次状态不正确"),
    LOAN_REPAYMENT_TRADE_STATUS_WRONG("F50108", "支付记录状态不正确"),
    LOAN_REPAYMENT_PLAN_NOT_FOUND("F50109", "还款计划未找到"),
    LOAN_REPAYMENT_REPAY_PROCESSING("F50110", "工单正在处理还款业务"),
    LOAN_REPAYMENT_PLAN_OVERDUE_NOT_FOUND("F50111", "还款计划逾期记录未找到"),

    //支付相关
    LOAN_PAY_CARD_NOT_EXIST("F51000", "银行卡不存在"),
    LOAN_PAY_DEBT_NOT_EXIST("F51001", "工单不存在"),
    LOAN_PAY_DEBT_PROCESSING("F51002", "工单支付中"),
    LOAN_PAY_TRADE_NOT_EXIST("F51003", "交易不存在"),
    LOAN_PAY_REPAY_PLAN_NOT_EXIST("F51004", "还款计划不存在"),

    // 工单模块合同相关
    LOAN_CONTRACT_COUNT_FAIL("F52000", "删除合同模板时，存在产品关联数据，请先删除关联数据"),
    LOAN_CONTRACT_FILENAME_FAIL("F52001", "合同模板文件上传，原始文件名为空"),
    LOAN_CONTRACT_LINK_DATA_EXIST("F52003", "合同模板关联产品信息，维护规则已存在"),

    LOAN_PAY_REQ_CHECK_DEBT_NO("C51000", "工单号不能为空"),
    LOAN_PAY_REQ_CHECK_NUM("C51001", "还款期数不能为空"),

    // 商城模块消息X6开头
    MALL_EXAMPLE_SUCCESS("S60000", "商城成功消息样例"),
    MALL_EXAMPLE_ERROR("E60000", "商城异常消息样例"),
    MALL_EXAMPLE_FAIL("F70000", "商城失败消息样例"),

    // 认证模块消息X7开头
    // 公共[X70000,X70099]
    CREDIT_IDCARD_NOT_YOURSELF("X70000", "请上传本人身份证件照"),
    CREDIT_IDCARD_CONFLICT("X70001", "该身份证已绑定其他账号"),
    IDCARD_NOT_FOUND("X70002", "未获取到身份证信息"),
    IDCARD_FRONT_NOT_FOUND("X70003", "未查询到身份证正面照片"),
    IDCARD_BACK_NOT_FOUND("X70004", "未查询到身份证反面照片"),
    CREDIT_UPLOAD_IDCARD_ERROR("X70005", "上传身份证失败"),

    // 商汤[X70100, X70199]
    CREDIT_UPLOAD_IDCARD_FRONT_BASE64_ERROR("X70100", "上传正面身份证base64串失败"),
    CREDIT_UPLOAD_IDCARD_BACK_BASE64_ERROR("X70101", "上传反面身份证base64串失败"),
    CREDIT_UPLOAD_IDCARD_HAND_BASE64_ERROR("X70102", "上传手持身份证base64串失败"),
    CREDIT_UPLOAD_IDCARD_NOT_CLEAR("X70103", "身份证照片不清晰,请重新上传"),
    CREDIT_UPLOAD_IDCARD_NAME_ERROR("X70104", "姓名识别有误，请重新上传身份证正面照"),
    CREDIT_UPLOAD_IDCARD_GENDER_ERROR("X70105", "性别识别有误，请重新上传身份证正面照"),
    CREDIT_UPLOAD_IDCARD_BIRTHDAY_ERROR("X70106", "出生日期识别有误，请重新上传身份证正面照"),
    CREDIT_UPLOAD_IDCARD_TIMELIMIT_ERROR("X70107", "身份证有效期识别有误，请重新上传身份证正面照"),
    CREDIT_UPLOAD_IDCARD_AUTHORITY_ERROR("X70108", "签发机构识别有误，请重新上传身份证正面照"),
    CREDIT_UPLOAD_IDCARD_NUMBER_ERROR("X70109", "身份证号识别有误，请重新上传身份证正面照"),
    CREDIT_UPLOAD_IDCARD_FRONT_ERROR("X70110", "请上传本人身份证正面照片"),
    CREDIT_UPLOAD_IDCARD_BACK_ERROR("X70111", "请上传本人身份证反面照片"),
    CREDIT_UPLOAD_BANK_CARD_FRONT_BASE64_ERROR("X70112", "上传银行卡正面base64串失败"),
    CREDIT_UPLOAD_BANK_CARD_BACK_BASE64_ERROR("X70113", "上传银行卡反面base64串失败"),


    // 商汤OCR身份证识别
    SENSETIME_OCR_IDCARD_RESULT_EMPTY("X70120", "商汤OCR识别身份证接口返回结果为空"),
    SENSETIME_OCR_IDCARD_RESULT_ERROR("X70121", "商汤识别身份证接口返回结果异常"),

    CARD_TYPE_ERROR("X70131", "请重新上传正确卡类型"),

    // Advance OCR识别身份证
    ADVANCE_OCR_IDCARD_RESULT_EMPTY("X70140", "Advance识别身份证接口返回结果为空"),
    ADVANCE_OCR_IDCARD_RESULT_ERROR("X70141", "Advance识别身份证接口返回结果异常"),
    ADVANCE_FACE_COMPARE_RESULT_EMPTY("X70142", "Advance比对照片接口返回结果为空"),
    ADVANCE_FACE_COMPARE_RESULT_ERROR("X70143", "Advance比对照片接口返回结果异常"),
    ADVANCE_LIVENESS_DETECTION_RESULT_EMPTY("X70144", "Advance活体检测接口返回结果为空"),
    ADVANCE_LIVENESS_DETECTION_RESULT_ERROR("X70145", "Advance活体检测接口返回结果异常"),

    // Accuauth OCR识别身份证
    ACCUAUTH_OCR_IDCARD_RESULT_EMPTY("X70140", "Accuauth识别身份证接口返回结果为空"),
    ACCUAUTH_OCR_IDCARD_RESULT_ERROR("X70141", "Accuauth识别身份证接口返回结果异常"),
    ACCUAUTH_FACE_COMPARE_RESULT_EMPTY("X70142", "Accuauth比对照片接口返回结果为空"),
    ACCUAUTH_FACE_COMPARE_RESULT_ERROR("X70143", "Accuauth比对照片接口返回结果异常"),
    ACCUAUTH_LIVENESS_DETECTION_RESULT_EMPTY("X70144", "Accuauth活体检测接口返回结果为空"),
    ACCUAUTH_LIVENESS_DETECTION_RESULT_ERROR("X70145", "Accuauth活体检测接口返回结果异常"),


    // 腾讯云[X70200, X70299]
    TENCENT_OCR_IDCARD_RESULT_EMPTY("X70200", "腾讯云OCR识别身份证接口返回结果为空"),

    // ai-check系统[X70300, X70399]
    AI_CHECK_OCR_IDCARD_RESULT_ERROR("X70300", "智能识别身份证接口返回结果异常"),
    AI_CHECK_OCR_IDCARD_FRONT_RESULT_EMPTY("X70301", "智能OCR识别身份证正面接口返回结果为空"),
    AI_CHECK_OCR_IDCARD_BACK_RESULT_EMPTY("X70302", "智能OCR识别身份证反面接口返回结果为空"),
    AI_CHECK_OCR_IDCARD_NOT_MATCH("X70303", "正面照与人脸照不匹配"),

    // 后台系统管理
    CREDIT_CAN_NOT_DELETE("X70100", "正在使用中，不可删除!"),
    CREDIT_CAN_NOT_DISABLED("X70100", "正在使用中，不可禁用!"),
    CREDIT_WAY_PRODUCT_LINK_EXIST("X70102", "产品已配置此认证方式!"),
    CREDIT_WAY_ENABLED_EXIST("X70103", "认证方式不可同时启用多个!"),
    CREDIT_CODE_EXIST("X70104", "编码已存在!"),
    CREDIT_WAY_THIRD_NOT_CONFIG("X70105", "认证方式与认证三方未配置!"),
    CREDIT_WAY_THIRD_DISABLED("X70106", "认证方式与认证三方已禁用!"),
    CREDIT_THIRD_NOT_FOUND("X70108", "认证三方未找到!"),
    CREDIT_THIRD_DISABLED("X70109", "认证三方已禁用!"),
    CREDIT_WAY_NOT_FOUND("X70112", "认证方式未找到!"),
    CREDIT_WAY_DISABLED("X70113", "认证方式已禁用!"),


    //贷后模块X702开头
    LOAN_AFTER_AMOUNT_FORMAT_ERROR("F70200", "金额格式错误"),
    LOAN_AFTER_AMOUNT_CAN_NOT_LESS_THAN_ZERO("F70201", "金额不能小于0"),
    LOAN_AFTER_EXIST_APPLY_WITH_AUDITING("F70202", "存在审核中的申请，请稍后再试"),
    LOAN_AFTER_USER_WORK_INFO_NOT_EXIST("F70203", "用户工作信息不存在"),
    LOAN_AFTER_USER_CONTACT_INFO_NOT_EXIST("F70204", "用户联系人信息不存在"),
    LOAN_AFTER_USER_BASE_INFO_NOT_EXIST("F70205", "用户基本信息不存在"),
    LOAN_AFTER_APPLY_REDUCE_AMOUNT_OVER_MAX("F70206", "申请减免金额过大"),
    LOAN_AFTER_NOT_FOUND_REPAY_PLAN("F70207", "未查询到还款计划"),
    LOAN_AFTER_DEBT_HAS_REPAY("F70208", "该工单已还款"),
    LOAN_AFTER_DEBT_CANCEL_DEBT("F70209", "该工单状态不允许取消操作"),
    LOAN_AFTER_DEBT_SEARCH_CREDIT("F70210", "查询授信信息出错"),
    LOAN_AFTER_DEBT_CREDIT_NOT_FOUND("F70211", "授信信息未查到"),
    LOAN_AFTER_DEBT_FILE_SUFFIX_ERROR("F70212", "文件格式错误，仅支持excel"),
    LOAN_AFTER_DEPT_REPAY_TIMES_OVER_LIMIT("F70213", "扣款次数超过部门次数限制"),
    LOAN_AFTER_SYS_USER_DEPT_NOT_EXIST("F70213", "当前系统用户无所属部门"),


    //电销模块
    TELESALE_CUSTOMER_RECORD_NOT_FOUND("F80000", "客户记录未找到"),
    TELESALE_STATISTICS_RECORD_ALREADY_EXIST("F80001", "统计记录已存在"),
    TELESALE_PARAM_IS_WRONG("F80002", "参数不正确"),

    //清结算
    SETTLE_NOT_REPAYMENT_STATUS("F90000", "工单不在还款状态"),

    //用户模块
    USER_NOT_EXIST("F10001", "用户不存在"),
    VERIFY_CODE_ERROR("F10002", "验证码不正确"),
    VERIFY_CODE_EXPIRED("F10003", "验证码已过期"),
    PASSWORD_ERROR("F10004", "密码不正确"),
    SERIAL_NO_BIND("F10005", "手机设备号已绑定"),
    MOBILE_REGISTERED("F10006", "该手机号已注册"),
    WECHAT_NO_BIND("F10007", "微信号已绑定"),
    NEW_AND_OLD_PWD_CANT_MATCH("F10008", "新旧密码不能一致"),
    APP_INFO_NOT_FOUND("F10009", "app信息不存在"),
    VEST_INFO_NOT_FOUND("F10010", "vest信息不存在"),

    // 示例模块消息X9开头
    DEMO_EXAMPLE_SUCCESS("S90000", "基础成功消息样例"),
    DEMO_EXAMPLE_ERROR("E90000", "基础异常消息样例"),
    DEMO_EXAMPLE_FAIL("F90000", "基础失败消息样例"),

    MALL_ACTIVE_NOTFOUND("F80001", "未找到对应活动"),
    MALL_ACTIVE_SECKILL_NOT_STARTTIME("F80002", "秒杀活动必须有开始结束时间"),
    MALL_ACTIVE_SECKILL_NOT_ENDTIME("F80003", "秒杀活动必须有结束结束时间"),
    MALL_ACTIVE_SECKILL_NOT_TAGINFO("F80004", "专场活动必须带有标签信息"),

    MALL_ORDER_NOTFOUND("F80005", "未找到对应订单信息"),
    MALL_ORDER_AFTER_CHECKING("F80006", "售后审核中不能重复申请"),
    MALL_ORDER_AFTER_NOTFOUND("F80007", "未找到对应售后记录"),
    MALL_ORDER_NOTALLOW_CANCEL("F80008", "订单当前状态不允许取消"),
    MALL_ORDER_SHOPPING_CARD_NULL("F80009", "购物车为空"),
    MALL_ORDER_SHOPPING_CARD_LIMIT("F80010", "购物车只能增加100种商品"),
    MALL_ORDER_NOTFOUND_GOODS("F80011", "未查询到对应商品信息"),
    MALL_ORDER_RECHARGE_ACCOUNT_NULL("F80012", "充值账号不能为空"),
    MALL_ORDER_GOODS_INFO_ERROR("F80013", "商品信息错误"),

}
package com.christian.gen.common.domain;

/**
 * @author liugh
 * @since 2018-05-03
 */
public enum ResultConstant {

    /**
     * 异常
     */
    FAILED("90000001", "系统错误"),
    /**
     * 成功
     */
    SUCCESS("00000000", "操作成功"),
    /**
     * 未登录/token过期
     */
    UNAUTHORIZED("90000002", "获取登录用户信息失败"),
    /**
     * 失败
     */
    ERROR("90000000", "操作失败"),
    /**
     * 失败
     */
    PARAM_ERROR("90000003", "参数错误"),

    /**
     * 用户名或密码错误
     */
    INVALID_USERNAME_PASSWORD("10000003", "用户名或密码错误"),
    /**
     *
     */
    INVALID_RE_PASSWORD("10000010", "两次输入密码不一致"),
    /**
     * 用户名或密码错误
     */
    INVALID_PASSWORD("10000009", "旧密码错误"),
    /**
     * 用户名重复
     */
    USERNAME_ALREADY_IN("10000002", "用户已存在"),
    /**
     * 手机号重复
     */
    PHONE_ALREADY_IN("10000015", "用户已存在"),
    /**
     * 用户不存在
     */
    INVALID_USER("10000001", "用户不存在"),
    /**
     * 角色不存在
     */
    INVALID_ROLE("10000004", "角色不存在"),

    /**
     * 角色不存在
     */
    ROLE_USER_USED("10000008", "角色使用中，不可删除"),

    /**
     * 参数错误-已存在
     */
    INVALID_PARAM_EXIST("10000005", "请求参数已存在"),
    /**
     * 参数错误
     */
    INVALID_PARAM_EMPTY("10000006", "缺少必要参数"),
    /**
     * 没有权限
     */
    USER_NO_PERMITION("10000007", "当前用户无该接口权限"),
    /**
     * 校验码错误
     */
    VERIFY_PARAM_ERROR("10000011", "验证码错误"),
    /*
     * 校验码过期
     */
    VERIFY_PARAM_PASS("10000012", "验证码过期"),

    /**
     * 用户没有添加、删除评论或回复的权限
     */
    MOBILE_ERROR("10000014","手机号格式错误") ,
    /**
     * 数据更新或增加失败
     */
    DATA_ERROR("10000015","数据操作错误"),
    
    
    /**
     * 没有结点
     */
    NODE_EMPTY("20000001","结点不存在"),
    
    /**
     * 一个流程模板 只能有 且必须有 一个起始结点
     */
    START_NODE_ERROR("20000002","有且只能有一个起始结点"),
    
    /**
     * 一个流程模板 必须 有 至少一个结束结点
     */
    END_NODE_ERROR("20000003","至少有一个结束结点"),
    
    /**
     * 一个结点 不能既是 起始结点， 又同时 是 结束 结点
     */
    DOUBLE_NODE_ERROR("20000004","不能既是起始结点，又是结束结点"),
    
    /**
     * 自动执行结点 作为 源结点的 流向，必须 带条件。
     */
    RESOURCE_NODE_ERROR("20000005","自动执行结点作为源结点的流向必须带条件"),
    
    /**
     * 没有流向
     */
    DIRECTION_EMPTY("20000006","非结束结点必须有流向"),
    
    /**
     * 不能既是起始结点，又是自动结点
     */
    START_AUTO_NODE_ERROR("20000007","不能既是起始结点，又是自动结点"),
    
    /**
     * 不能既是结束结点，又是自动结点
     */
    END_AUTO_NODE_ERROR("20000008","不能既是结束结点，又是自动结点"),
    
    /**
     * 当前结点ID不一致，请刷新页面
     */
    NODE_ID_ERROR("30000001","当前结点ID不一致，请刷新页面"),
    
    /**
     * 没有该结点执行权限
     */
    NODE_NO_PERMITION("30000002","没有该结点执行权限"),
    ;
    

    public String code;
    public String msg;

    ResultConstant(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

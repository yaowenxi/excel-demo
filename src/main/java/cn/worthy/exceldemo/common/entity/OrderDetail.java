package cn.worthy.exceldemo.common.entity;

import cn.worthy.exceldemo.util.ExcelCell;
import lombok.Data;

/**
 * @author: yaowenxi
 * @version: 1.0
 * @date: 2018/5/23
 * <p>
 * 订单详情
 */
@Data
public class OrderDetail {

    /**
     * 职工Id;
     */
    @ExcelCell(col = 0)
    private String staffId;

    /**
     * 职工姓名
     */
    @ExcelCell(col = 1)
    private String staffName;

    /**
     * 年份
     */
    @ExcelCell(col = 2)
    private String year;

    /**
     * 保险公司
     */
    @ExcelCell(col = 3)
    private String insuranceCompany;

    /**
     * 订单ID
     */
    @ExcelCell(col = 4)
    private String orderId;

    /**
     * 订单类型
     */
    @ExcelCell(col = 5)
    private String orderType;

    /**
     * 订单金额
     */
    @ExcelCell(col = 6)
    private String orderAmount;

    /**
     * 弹性福利供款
     */
    @ExcelCell(col = 7)
    private String flexibleBenefitsAmount;

    /**
     * 个人付款
     */
    @ExcelCell(col = 8)
    private String personalPayment;

    /**
     * 被保人
     */
    @ExcelCell(col = 9)
    private String insured;

    /**
     * 与被保人关系
     */
    @ExcelCell(col = 10)
    private String insuredRelation;

    /**
     * 是否升级订单
     */
    @ExcelCell(col = 11)
    private String upgradeOrder;
}

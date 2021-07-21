package com.jxzj.external.data.entity.insure;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("insure_quotataion_task")
public class InsureQuotationTask implements Serializable {

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 报价请求来源 */
    private Integer quotationSource;

    /** 报价结果回复通知目标用户id */
    private Long replyUserId;

    /** 行驶证照片oss key */
    private String vehicleLicenseImgKey;

    /** 客户名称 */
    private String customerName;

    /** 证件ID(身份证) */
    private String idCard;

    /** 车牌号码 */
    private String licensePlate;

    /** 发动机号 */
    private String engineNo;

    /** 车架号 */
    private String vin;

    /** 整备质量(kg) */
    private Integer unladenMass;

    /** 行驶证初次注册日期 */
    private LocalDate firstRegisterDate;

    /** 任务状态 */
    private Integer state;

    /** 备注 */
    private String memo;

    /** 报价保险公司id */
    private Long insureCompanyId;

    /** 保费 */
    private String premium;

    /** 税款总额 */
    private String tax;

    /** 交强险保险期限开始 */
    private LocalDateTime insureEffectiveBegin;

    /** 交强险保险期限结束 */
    private LocalDateTime insureEffectiveEnd;

    /** 报价单文件oss key */
    private String quotationOfferKey;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 修改时间 */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuotationSource() {
        return quotationSource;
    }

    public void setQuotationSource(Integer quotationSource) {
        this.quotationSource = quotationSource;
    }

    public Long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getVehicleLicenseImgKey() {
        return vehicleLicenseImgKey;
    }

    public void setVehicleLicenseImgKey(String vehicleLicenseImgKey) {
        this.vehicleLicenseImgKey = vehicleLicenseImgKey;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getUnladenMass() {
        return unladenMass;
    }

    public void setUnladenMass(Integer unladenMass) {
        this.unladenMass = unladenMass;
    }

    public LocalDate getFirstRegisterDate() {
        return firstRegisterDate;
    }

    public void setFirstRegisterDate(LocalDate firstRegisterDate) {
        this.firstRegisterDate = firstRegisterDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getInsureCompanyId() {
        return insureCompanyId;
    }

    public void setInsureCompanyId(Long insureCompanyId) {
        this.insureCompanyId = insureCompanyId;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public LocalDateTime getInsureEffectiveBegin() {
        return insureEffectiveBegin;
    }

    public void setInsureEffectiveBegin(LocalDateTime insureEffectiveBegin) {
        this.insureEffectiveBegin = insureEffectiveBegin;
    }

    public LocalDateTime getInsureEffectiveEnd() {
        return insureEffectiveEnd;
    }

    public void setInsureEffectiveEnd(LocalDateTime insureEffectiveEnd) {
        this.insureEffectiveEnd = insureEffectiveEnd;
    }

    public String getQuotationOfferKey() {
        return quotationOfferKey;
    }

    public void setQuotationOfferKey(String quotationOfferKey) {
        this.quotationOfferKey = quotationOfferKey;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}

package com.jxzj.external.data.entity.aptitudes;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "aptitudes")
public class Aptitudes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String corpName;

    private String projectName;

    private String projectType;

    private String contractPrice;

    private String settlementPrice;

    private String technologyGrade;

    private String segmentName;

    private String beginData;

    private String handData;

    private String endData;

    private String projectStatus;

    private String quality;

    private String province;

    private String projectCode;

    private String remak;

    private String companyAptitudeList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(String contractPrice) {
        this.contractPrice = contractPrice;
    }

    public String getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(String settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public String getTechnologyGrade() {
        return technologyGrade;
    }

    public void setTechnologyGrade(String technologyGrade) {
        this.technologyGrade = technologyGrade;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getBeginData() {
        return beginData;
    }

    public void setBeginData(String beginData) {
        this.beginData = beginData;
    }

    public String getHandData() {
        return handData;
    }

    public void setHandData(String handData) {
        this.handData = handData;
    }

    public String getEndData() {
        return endData;
    }

    public void setEndData(String endData) {
        this.endData = endData;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getRemak() {
        return remak;
    }

    public void setRemak(String remak) {
        this.remak = remak;
    }

    public String getCompanyAptitudeList() {
        return companyAptitudeList;
    }

    public void setCompanyAptitudeList(String companyAptitudeList) {
        this.companyAptitudeList = companyAptitudeList;
    }

    @Override
    public String toString() {
        return "Aptitudes [id=" + id + ", corpName=" + corpName + ", projectName=" + projectName + ", projectType="
            + projectType + ", contractPrice=" + contractPrice + ", settlementPrice=" + settlementPrice
            + ", technologyGrade=" + technologyGrade + ", segmentName=" + segmentName + ", beginData=" + beginData
            + ", handData=" + handData + ", endData=" + endData + ", projectStatus=" + projectStatus + ", quality="
            + quality + ", province=" + province + ", projectCode=" + projectCode + ", remak=" + remak
            + ", companyAptitudeList=" + companyAptitudeList + "]";
    }

}

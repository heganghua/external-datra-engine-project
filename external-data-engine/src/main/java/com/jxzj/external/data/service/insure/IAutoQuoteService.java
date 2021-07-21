package com.jxzj.external.data.service.insure;

import org.openqa.selenium.chrome.ChromeDriver;

import com.jxzj.external.data.entity.insure.InsureQuotationTask;

public interface IAutoQuoteService {

    /**
     * 保存验证码
     * 
     * @author heganghua
     * @date 2020/12/22
     * @param img
     * @return void
     */
    public void saveImage(String img);

    /**
     * 截图
     * 
     * @author heganghua
     * @date 2020/12/22
     * @param driver
     * @param fileName
     * @return void
     */
    public void screenshot(ChromeDriver driver, String fileName);

    /**
     * 自动切换到报价页面
     * 
     * @author heganghua
     * @date 2020/12/22
     * @param driver
     * @return
     * @return ChromeDriver
     */
    public ChromeDriver autoOperate(ChromeDriver driver);

    /**
     * 单纯信息录入
     * 
     * @author heganghua
     * @date 2020/12/22
     * @param driver
     * @param entity
     * @return void
     */
    public ChromeDriver writeInData(ChromeDriver driver, InsureQuotationTask entity);

    /**
     * 特种车辆选择
     * 
     * @author heganghua
     * @date 2020/12/22
     * @param dirver
     * @return
     * @return ChromeDriver
     */
    public ChromeDriver specialVehicleSelect(ChromeDriver dirver);

    /**
     * 延时器
     * 
     * @author heganghua
     * @date 2020/12/25
     * @param millis
     * @return void
     */
    void sleepUtils(Long millis);

}

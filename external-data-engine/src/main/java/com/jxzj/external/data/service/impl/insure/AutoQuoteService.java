package com.jxzj.external.data.service.impl.insure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.jxzj.external.data.dao.InsureQuotationTaskMapper;
import com.jxzj.external.data.entity.insure.InsureQuotationTask;
import com.jxzj.external.data.service.insure.IAutoQuoteService;

@Service
public class AutoQuoteService implements IAutoQuoteService {

    public static final String LOGIN_URL = "https://pacas-login.pingan.com.cn/cas/PA003/ICORE_PTS/login";
    private static final Logger logger = LoggerFactory.getLogger(AutoQuoteService.class);
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private InsureQuotationTaskMapper insureQuotationTaskMapper;

    /**
     * 切换到信息录入页面
     * 
     * @author heganghua
     * @date 2020/12/19
     * @param driver
     * @throws InterruptedException
     * @return void
     */
    @Override
    public ChromeDriver autoOperate(ChromeDriver driver) {

        // 点击投保中心
        driver.findElementByXPath("//*[@id=\"nav\"]/li[3]/a").click();
        this.sleepUtils(1000L);
        driver.switchTo().frame("main_c");
        this.sleepUtils(3000L);
        // 专业版投保
        driver.findElementById("toibcsWriter").click();
        driver.findElementById("toibcsWriter").click();
        this.sleepUtils(2000L);
        Set<String> windowHandles = driver.getWindowHandles();
        String searchHandle = driver.getWindowHandle();
        for (String hendles : windowHandles) {
            // 切换到新窗口(只有两个新窗口得时候)
            if (hendles.equals(searchHandle) == false) {
                driver.switchTo().window(hendles);
                logger.info("new windows!");
            }
        }
        driver = this.specialVehicleSelect(driver);
        return driver;
    }

    /**
     * 特种车辆选择
     * 
     * @author heganghua
     * @date 2020/12/22
     * @param driver
     * @return
     * @return ChromeDriver
     */
    @Override
    public ChromeDriver specialVehicleSelect(ChromeDriver driver) {
        this.sleepUtils(3000L);
        driver.switchTo().frame("main");
        // 下拉框 - 选择特种车辆
        WebElement opt = driver.findElementByXPath("//div[@class=\"dib\"]/select");
        Select select = new Select(opt);
        select.selectByValue("1");
        // this.screenshot(driver, "one.png");
        driver.findElementByXPath("//button[@class=\"btn btn-primary w80\"]").click();
        this.sleepUtils(10000L);
        // 信息录入页面截图
        // this.screenshot(driver, "infoInput");
        return driver;
    }

    /**
     * 写入信息
     * 
     * @author heganghua
     * @date 2020/12/22
     * @param driver
     * @param entity
     * @return void
     */
    @Override
    public ChromeDriver writeInData(ChromeDriver driver, InsureQuotationTask entity) {
        driver.manage().window().maximize();
        driver.findElementById("personnelNameCheck").sendKeys(entity.getCustomerName());
        this.sleepUtils(500L);
        // 身份证 - 430626198105145111
        driver.findElement(By.id("personnelCertificateTypeNo")).sendKeys(entity.getIdCard());
        this.sleepUtils(500L);
        // 车牌号 - "粤C-71855"
        driver.findElement(By.id("vehicleLicenseCodeId")).sendKeys(entity.getLicensePlate());
        this.sleepUtils(500L);
        // 发动机号 - "1019J031530"
        driver.findElement(By.id("engineNo")).sendKeys(entity.getEngineNo());
        this.sleepUtils(500L);
        // 车辆号 - "L5E6H3D22KA019135"
        driver.findElement(By.id("vehicleFrameNo")).sendKeys(entity.getVin());
        this.sleepUtils(500L);
        driver.findElementByXPath("//button[@class=\"btn btn-mini btn-primary\"]").click();
        this.sleepUtils(3000L);
        // 警告框处理
        int warningDailogDispose = this.warningDailogDispose(driver, entity.getId(), entity.getVin());
        if (warningDailogDispose == 2) {
            return driver;
        }
        // 整备质量判断
        // String curbWeightStr = String.valueOf(entity.getCurbWeight());
        // logger.info("================ 整备质量" + curbWeightStr);
        // if (null != curbWeightStr && !(curbWeightStr.equals(""))) {
        // String attribute = driver.findElement(By.id("vehWholeWeight")).getAttribute("value");
        // logger.info("================ 整备质量(系统)" + curbWeightStr);
        // if (null != attQRribute && attribute != curbWeightStr) {
        // // 改变整备质量
        // driver.findElement(By.id("vehWholeWeight")).sendKeys(curbWeightStRQR;
        // }
        // }

        // 初日登陆日期 - "2019-12-24"
        driver.findElementByXPath("//*[@id=\"auto0Div\"]/div/form[4]/div/div[2]/div/div[17]/div/input")
            .sendKeys(entity.getFirstRegisterDate().toString());
        // 交强险复选框 以及小微险
        WebElement checkbox1 = driver.findElementByXPath("//div[@id=\"taxInfoTitle\"]/div/div/label/input");
        // logger.info("================ " + checkbox1.toString());
        boolean selected = checkbox1.isSelected();
        if (!selected) {
            logger.info("================ 交强险复选框点击");
            driver.executeScript("arguments[0].click();", checkbox1);
            this.sleepUtils(2000L);
        }
        List<WebElement> eleList = driver.findElementsByXPath("//div[@class=\"ml50 mb10 ng-scope\"]/label/input");
        WebElement lastEle = eleList.get(2);
        boolean selected2 = lastEle.isSelected();
        if (selected2) {
            logger.info("================  小微险复选框点击");
            driver.executeScript("arguments[0].click();", lastEle);
        }
        // 【申请报价】
        driver.findElementByXPath("//button[@class=\"btn btn-primary ml5 ng-scope\"]").click();
        this.sleepUtils(2000L);
        // 【申请报价】后有可能会出现警告框
        warningDailogDispose = this.warningDailogDispose(driver, entity.getId(), entity.getVin());
        if (warningDailogDispose == 2 || warningDailogDispose == 1) {
            // 2: 信息错误; 1:报价完成
            return driver;
        }
        this.sleepUtils(1000L);
        // 有可能会出现对话框，处理对话框
        Integer dialogDispose = this.dialogDispose(driver, entity.getId(), entity.getVin());
        if (dialogDispose == 1) {
            // 打印报价单
            // driver.findElementByXPath("//button[@class=\"btn btn-primary ml5\"]").click();
            // this.sleepUtils(10000L);
            // Set<String> windowHandles2 = driver.getWindowHandles();
            // ArrayList<String> windowhandlesList = new ArrayList<>(windowHandles2);
            // String wh = windowhandlesList.get(windowhandlesList.size() - 1);
            // driver.switchTo().window(wh);
            // this.screenshot(driver, customerModel.getName());
            List<WebElement> spanList = driver.findElementsByXPath("//span[@class=\"cal-sum ng-binding\"]");
            // 保费
            String premium = spanList.get(0).getText();
            // 税款
            String tax = spanList.get(1).getText();
            logger.info("================ 》 保费: " + premium + "    " + "税款合计 ： " + tax);

            // 交强险保险期限
            List<WebElement> timeLimits = driver.findElementsByXPath("//span[@class=\"input-append\"]/input");
            String beginTimeLimit = timeLimits.get(0).getAttribute("value");
            String endTimeLimit = timeLimits.get(1).getAttribute("value");
            logger.info("================ 》 交强险保险期限 》", beginTimeLimit + ": " + endTimeLimit);
            LocalDateTime beginLdt = LocalDateTime.parse(beginTimeLimit, DTF);
            LocalDateTime endLdt = LocalDateTime.parse(endTimeLimit, DTF);

            // 更新任务状态
            InsureQuotationTask updateEntity = new InsureQuotationTask();
            updateEntity.setId(entity.getId());
            updateEntity.setState(2);
            updateEntity.setMemo("报价成功");
            updateEntity.setPremium(premium);
            updateEntity.setTax(tax);
            updateEntity.setInsureEffectiveBegin(beginLdt);
            updateEntity.setInsureEffectiveEnd(endLdt);
            insureQuotationTaskMapper.updateById(updateEntity);

        } else {
            logger.info("================ 不需要报价>>>>>>");
            driver.navigate().refresh();
            return driver;
        }
        logger.info("================ end===============");
        // driver.quit();
        return driver;
    };

    /**
     * 保存验证码为图片
     * 
     * @author heganghua
     * @date 2020/12/17
     * @param img
     * @return void
     * @throws IOException
     */
    @Override
    public void saveImage(String img) {

        String newSrcStr = img.replace("data:image/jpg;base64,", "");
        newSrcStr = newSrcStr.replace("%0D%0A", "");
        logger.info("================ " + img);
        byte[] decode = Base64.getDecoder().decode(newSrcStr);
        try (FileOutputStream fos = new FileOutputStream("./img/randCode.gif")) {
            fos.write(decode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 截图
     * 
     * @author heganghua
     * @date 2020/12/17
     * @param driver
     * @param fileName
     * @return void
     */
    @Override
    public void screenshot(ChromeDriver driver, String fileName) {

        File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("./img/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 对话框处理
     * 
     * @author heganghua
     * @date 2020/12/17
     * @param driver
     * @return
     * @return boolean
     * @throws InterruptedException
     */
    public Integer dialogDispose(ChromeDriver driver, Long taskId, String vehicleFrameNo) {

        // 判断是否有【续保检索及新能源车校验】
        List<WebElement> newEnergyVehice = driver.findElementsByXPath("//span[@class=\"modalBox_title\"]");
        if (CollectionUtils.isNotEmpty(newEnergyVehice)) {
            if (newEnergyVehice.get(0).getText().equals("续保检索及新能源车校验")) {
                logger.info("================ 》 续保检索及新能源车校验 ");
                driver.switchTo().frame("doalogBox");
                // this.screenshot(driver, "dialog1.png");
                driver.findElementByXPath("//button[@class=\"btn btn-blue ml45p\"]").click();
                this.sleepUtils(3000L);
                driver.switchTo().frame("main");
            }
        }
        // 判断元素是否存在 是否有【交强险重复投保提示】
        List<WebElement> haopais =
            driver.findElementsByXPath("//table[@class=\"table table-bordered table-condensed\"]/tbody/tr[2]/td[7]");
        logger.info("================ 交强险重复投保提示长度 》" + haopais.size());
        if (haopais.size() > 0) {
            String haopai = haopais.get(0).getText();
            // 确定 【修改保险期限】
            driver
                .findElementByXPath("//table[@class=\"ui_dialog ng-scope\"]/tbody/tr[2]/td[2]/div/div/div[2]/button[1]")
                .click();
            // 号牌字段出现 车牌号(车牌号长度<=7)时可继续报价
            if (haopai == null || haopai.isEmpty() || haopai.length() <= 7) {
                Alert alert = driver.switchTo().alert();
                logger.info("================ " + alert.getText());
                alert.accept();
                this.sleepUtils(1000L);
                // 再次点击【申请报价】
                driver.findElementByXPath("//button[@class=\"btn btn-primary ml5 ng-scope\"]").click();
                this.sleepUtils(1000L);
                // 再次判断是否有【续保检索及新能源车校验】
                List<WebElement> newEnergyVehice2 = driver.findElementsByXPath("//span[@class=\"modalBox_title\"]");
                if (!newEnergyVehice2.isEmpty()) {
                    if (newEnergyVehice2.get(0).getText().equals("续保检索及新能源车校验")) {
                        driver.switchTo().frame("doalogBox");
                        // this.screenshot(driver, "dialog1.png");
                        driver.findElementByXPath("//button[@class=\"btn btn-blue ml45p\"]").click();
                        driver.switchTo().frame("main");
                    }
                }
                this.sleepUtils(2000L);
                // 确定完成报价
                driver.findElementByClassName("ui_state_highlight").click();
                return 1;
            } else {
                logger.info("================ 保单发生重复投保，与其重复投保的本公司的保单信息如下：车架号 XXXXXXXXXXXX");

                // 更新任务状态
                InsureQuotationTask updateEntity = new InsureQuotationTask();
                updateEntity.setId(taskId);
                updateEntity.setState(3);
                updateEntity.setMemo(haopai);
                updateEntity.setVin(vehicleFrameNo);
                insureQuotationTaskMapper.updateById(updateEntity);
                return -1;
            }
        }
        return 1;
    }

    /**
     * 通过判断这个div的content是否有内容来确定数据是否填写正确
     * 
     * @author heganghua
     * @date 2020/12/23
     * @param driver
     * @return
     * @return String
     */
    public String getDetailContent(ChromeDriver driver) {
        WebElement quoteSuccessfullyButton = driver.findElementByXPath("//div[@class=\"ui_content\"]");
        logger.info("================ " + quoteSuccessfullyButton.toString());
        String text = quoteSuccessfullyButton.getText();

        return text;
    }

    /**
     * 处理警告框<br>
     * 1: 报价完成警告框 <br>
     * 2: 其他警告框<br>
     * 3: 没有警告框
     * 
     * @author heganghua
     * @date 2020/12/24
     * @param driver
     * @return void
     */
    public int warningDailogDispose(ChromeDriver driver, Long taskId, String vehicleFrameNo) {
        // TODO 这里最好使用ui_titile 里面的警告图标判断一下
        WebElement uiContent = driver.findElementByXPath("//div[@class=\"ui_content\"]");
        if (null != uiContent) {
            String text = uiContent.getText();
            logger.info("================ 警告框内容: " + text);
            if (text.equals("") || text == null) {
                return 3;
            } else if (text.indexOf("申请报价完成") != -1) {
                // 报价完成
                driver.findElementByClassName("ui_state_highlight").click();
                List<WebElement> spanList = driver.findElementsByXPath("//span[@class=\"cal-sum ng-binding\"]");
                // 保费
                String premium = spanList.get(0).getText();
                // 税款
                String tax = spanList.get(1).getText();
                logger.info("================ 保费: " + premium + "    " + "税款合计 ： " + tax);
                // 交强险保险期限
                List<WebElement> timeLimits = driver.findElementsByXPath("//span[@class=\"input-append\"]/input");
                logger.info("================ 保险期限元素长度" + timeLimits.size());
                String beginTimeLimit = timeLimits.get(0).getAttribute("value");
                String endTimeLimit = timeLimits.get(1).getAttribute("value");
                logger.info("================  交强险保险期限 》" + beginTimeLimit + ": " + endTimeLimit);
                LocalDateTime beginLdt = LocalDateTime.parse(beginTimeLimit, DTF);
                LocalDateTime endLdt = LocalDateTime.parse(endTimeLimit, DTF);
                InsureQuotationTask updateEntity = new InsureQuotationTask();
                updateEntity.setId(taskId);
                updateEntity.setState(2);
                updateEntity.setMemo("success");
                updateEntity.setPremium(premium);
                updateEntity.setTax(tax);
                updateEntity.setVin(vehicleFrameNo);
                updateEntity.setInsureEffectiveBegin(beginLdt);
                updateEntity.setInsureEffectiveEnd(endLdt);
                insureQuotationTaskMapper.updateById(updateEntity);
                return 1;
            } else if (text.indexOf("车辆信息区域校验错误") != -1 || text.indexOf("未匹配到符合条件的车型") != -1
                || text.indexOf("车三项校验不通过") != -1 || text.indexOf("车辆信息校验不通过") != -1) {
                // 信息错误：车辆信息区域校验错误;未匹配到符合条件的车型;车三项校验不通过
                driver.findElementByClassName("ui_state_highlight").click();
                InsureQuotationTask updateEntity = new InsureQuotationTask();
                updateEntity.setId(taskId);
                updateEntity.setState(3);
                updateEntity.setMemo(text);
                updateEntity.setVin(vehicleFrameNo);
                insureQuotationTaskMapper.updateById(updateEntity);
                return 2;
            }
        }
        return 3;
    }

    /**
     * 延时
     * 
     * @author heganghua
     * @date 2020/12/25
     * @param millis
     * @return void
     */
    @Override
    public void sleepUtils(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断元素是否存在
     * 
     * @author heganghua
     * @date 2020/12/25
     * @param driver
     * @param ele
     * @return
     * @return Boolean
     */
    public Boolean isElementExistByXpath(ChromeDriver driver, String xpathExpression) {
        List<WebElement> findElements = driver.findElements(By.xpath(xpathExpression));
        if (findElements.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

}

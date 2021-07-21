package com.jxzj.external.data.service.impl.insure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxzj.external.data.service.insure.IAutoQuoteService;
import com.jxzj.external.data.service.insure.IPingAnInsureLoginService;

@Service
public class PingAnInsureLoginService implements IPingAnInsureLoginService {

    private static final Logger logger = LoggerFactory.getLogger(PingAnInsureLoginService.class);

    private static final String LOGIN_DO = "https://icore-pts.pingan.com.cn/ebusiness/login.do";

    @Autowired
    public IAutoQuoteService autoQuoteService;

    /**
     * 初始化一个浏览器
     * 
     * @author heganghua
     * @date 2020/12/17
     * @return
     * @return ChromeDriver
     */
    public ChromeDriver initWithChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.setHeadless(Boolean.TRUE);
        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        System.setProperty("webdriver.chrome.driver", "chromeDriver/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }

    /**
     * 登陆
     * 
     * @author heganghua
     * @date 2020/12/19
     * @param driver
     * @return
     * @throws InterruptedException
     * @return ChromeDriver
     */
    public ChromeDriver loginPingAnInsure(ChromeDriver driver) {
        driver.get(AutoQuoteService.LOGIN_URL);
        String title = driver.getTitle();
        System.out.println(title);
        // 账号密码
        driver.findElementById("username").sendKeys("SXNMH-30702");
        driver.findElementById("password").sendKeys("e24ETkt8");
        this.refreshRandCode(driver);
        // WebElement randCode = driver.findElementById("randCode");
        // String srcStr = randCode.getAttribute("src");
        // autoQuoteService.sleepUtils(1000L);
        // autoQuoteService.saveImage(srcStr);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入验证码（1-refresh）：");
        String nextLine = scanner.nextLine();
        while (nextLine.equals("1")) {
            // 刷新验证码
            this.refreshRandCode(driver);
            scanner = new Scanner(System.in);
            System.out.print("请输入验证码（1-refresh）：");
            nextLine = scanner.nextLine();
            if (nextLine.length() == 4) {
                break;
            }
        }
        scanner.close();
        System.out.println("验证码为： " + nextLine);
        // 输入验证码
        driver.findElementById("randCodeText").sendKeys(nextLine);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("loginButton").click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 登陆后截图
        autoQuoteService.screenshot(driver, "login.gif");

        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            logger.info("============ session》" + cookie.getName() + ": " + cookie.getValue());
        }
        return driver;
    }

    /**
     * 刷新验证码
     * 
     * @author heganghua
     * @date 2021/12/29
     * @param driver
     * @return void
     */
    public void refreshRandCode(ChromeDriver driver) {
        driver.findElementById("randCode").click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement randCode = driver.findElementById("randCode");
        String srcStr = randCode.getAttribute("src");
        autoQuoteService.sleepUtils(1000L);
        autoQuoteService.saveImage(srcStr);
    }

    /**
     * 利用cookie登陆平安
     * 
     * @author heganghua
     * @date 2020/12/26
     * @param driver
     * @return
     */
    @Override
    public ChromeDriver loginPingAnByCookies(ChromeDriver driver) {
        driver.get(LOGIN_DO);
        // 读取本地cookies
        try (BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(new FileInputStream("./img/pingan.cookies.txt")))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, "; ");
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    int indexOf = nextToken.indexOf("=");
                    String key = nextToken.substring(0, indexOf);
                    String value = nextToken.substring(indexOf + 1, nextToken.length());
                    // String[] split = nextToken.split("=");
                    logger.info("============= 》" + key + ": " + value);
                    Cookie cookie = new Cookie(key, value, "icore-pts.pingan.com.cn");
                    driver.manage().addCookie(cookie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        driver.get(LOGIN_DO);
        return driver;
    }
}

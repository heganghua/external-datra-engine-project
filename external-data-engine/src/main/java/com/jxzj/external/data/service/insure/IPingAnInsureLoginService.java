package com.jxzj.external.data.service.insure;

import org.openqa.selenium.chrome.ChromeDriver;

public interface IPingAnInsureLoginService {

    /**
     * 初始化一个浏览器
     * 
     * @author heganghua
     * @date 2020/12/21
     * @return
     * @return ChromeDriver
     */
    ChromeDriver initWithChrome();

    /**
     * w 登陆浏览器
     * 
     * @author heganghua
     * @date 2020/12/21
     * @param driver
     * @return
     * @return ChromeDriver
     */
    ChromeDriver loginPingAnInsure(ChromeDriver driver);

    /**
     * 利用cookie登陆
     * 
     * @author heganghua
     * @date 2020/12/26
     * @param driver
     * @return
     * @return ChromeDriver
     */
    ChromeDriver loginPingAnByCookies(ChromeDriver driver);

}

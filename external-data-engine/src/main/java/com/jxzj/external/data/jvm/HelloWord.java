package com.jxzj.external.data.jvm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * 
 * @author hgh
 * @date 2021/10/15
 * 
 *       Heap: Object: HelloWord<br>
 *       Object: SimpleDataFomat<br>
 *       Object: String<br>
 *       object: LOGGER<br>
 *       <br>
 *       Methoed Area: <br>
 *       Class: HelloWord<br>
 *       -Method: sayHello()<br>
 *       Class: SimpleDataFormat<br>
 *       Class:Logger
 * 
 * 
 * 
 */

public class HelloWord {

    private static Logger LOGGER = Logger.getLogger(HelloWord.class.getName());

    public void sayHello(String message) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");
        String today = dateFormat.format(new Date());
        LOGGER.info(today + ": " + message);
    }

}

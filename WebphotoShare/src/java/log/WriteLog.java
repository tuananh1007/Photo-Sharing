/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WriteLog {
public void writeLogInfo(String loginfo)
{
    FileHandler handler=null;
    Logger logger=null;
    try{
    handler = new FileHandler("c:\\log\\my.log",true);
    logger = Logger.getLogger("PhotoSharePro.com");
    logger.addHandler(handler);
    logger.log(Level.SEVERE, loginfo);
    handler.close();
    }catch(IOException e)
    {
    System.out.println("File log ko tim thay");
    }
}
}

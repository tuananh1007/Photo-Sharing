/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.util.UUID;


public class File_Utils {
public static String genFileName(String oldName)
    {
        UUID pri = UUID.randomUUID();
        String newName=pri.toString().replaceAll("-","")+oldName;
        return newName;
    }
}

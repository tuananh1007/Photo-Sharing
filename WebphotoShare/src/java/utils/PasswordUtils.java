/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import log.WriteLog;

public class PasswordUtils {
  public static String getPassword(int n) {
    char[] pw = new char[n];
    int c  = 'A';
    int  r1 = 0;
    for (int i=0; i < n; i++)
    {
      r1 = (int)(Math.random() * 3);
      switch(r1) {
        case 0: c = '0' +  (int)(Math.random() * 10); break;
        case 1: c = 'a' +  (int)(Math.random() * 26); break;
        case 2: c = 'A' +  (int)(Math.random() * 26); break;
      }
      pw[i] = (char)c;
    }
    return new String(pw);
  }
//Encrypt String to MD5 string.
public static String hashPassword(String password) {
String hashword = null;
try {
MessageDigest md5 = MessageDigest.getInstance("MD5");
md5.update(password.getBytes());
BigInteger hash = new BigInteger(1, md5.digest());
hashword = hash.toString(16);
} catch (NoSuchAlgorithmException nsae) {
System.out.println("Algorithm Error"+nsae.getMessage());
WriteLog writelog=new WriteLog();
writelog.writeLogInfo(nsae.getMessage());
}
return hashword;
}
}

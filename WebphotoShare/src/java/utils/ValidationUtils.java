/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
  public static boolean isValidEmailAddress(String emailAddress){
    String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    CharSequence inputStr = emailAddress;
    Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(inputStr);
    return matcher.matches();
  }
}

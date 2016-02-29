/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.text.ParseException;
import java.util.Date;


public class DateUtils {
public static int daydiff(Date toDiff) throws ParseException
{
Date today=new Date();
long diff = today.getTime() - toDiff.getTime();
int i=Integer.parseInt(Long.toString((diff / (1000 * 60 * 60 * 24))));
return i;
}
}

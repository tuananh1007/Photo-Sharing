/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

public class StringUtils {
public static String getSubTilte(String bigTitile,int lengthWanted)
{
String rs=null;
int lengthCut=lengthWanted-3;
if(bigTitile.length()>lengthWanted)
{
    rs=bigTitile.substring(0,lengthCut)+"...";
}
else
    rs=bigTitile;
return rs;
}
}

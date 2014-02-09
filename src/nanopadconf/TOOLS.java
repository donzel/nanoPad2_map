/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nanopadconf;

import java.util.Formatter;

/**
 *
 * @author lambertc
 */
public class TOOLS {


  
  public static String decToHex(int dec) {
    String hex = Integer.toHexString(dec);
    return hex; 
  }

  public static int hexToDec(String hex){
      return Integer.parseInt(hex, 16) ;
  }
  
  
  
}

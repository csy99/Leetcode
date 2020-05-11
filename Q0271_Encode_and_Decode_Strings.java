package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/19/20.
 */
public class Q271_Encode_and_Decode_Strings {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
      if (strs == null || strs.size() == 0) return "";
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < strs.size(); i++) {
        if (strs.get(i).equals(":") || strs.get(i).equals(";"))
          sb.append(strs.get(i));
        sb.append(strs.get(i));
        sb.append(":;");
      }
      return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
      List<String> res = new ArrayList<String>();
      if (str.equals("")) return res;
      String[] arr = str.split(":;");
      for (int i = 0; i < arr.length; i++) {
        if (arr[i].equals("::"))
          res.add(":");
        else if (arr[i].equals(";;"))
          res.add(";");  
        else
          res.add(arr[i]);
      }
      return res;
    }
}

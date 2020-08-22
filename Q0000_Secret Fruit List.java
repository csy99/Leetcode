/**
 * Created by csy99 on 8/22/20.
 */
public class Solution {
    public static int winPrize(String[][] codeList, String[] shoppingCart) {
        // checking corner cases
        if(codeList == null || codeList.length == 0)
            return 1;
        if(shoppingCart == null || shoppingCart.length == 0)
            return 0;

        int i = 0;  // i-th list in codeList
        int cartIdx = 0;  // the idx of shopping cart  
        while (i < codeList.length && cartIdx + codeList[i].length <= shoppingCart.length) {
            boolean match = true;
            for (int j = 0; j < codeList[i].length; j++) {  // j-th element in i-th list in codeList
                if (!codeList[i][j].equals("anything") && !shoppingCart[cartIdx+j].equals(codeList[i][j])) {
                    match = false;
                    break;
                }
            }
            if (match) {
                cartIdx += codeList[i].length;
                i++;
            } else {
                cartIdx++;
            }
        }
        return (i == codeList.length) ? 1 : 0;
    }

}

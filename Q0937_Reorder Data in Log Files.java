/**
 * Created by csy99 on 9/16/21.
 */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digits = new ArrayList();
        List<Log> letters = new ArrayList();
        int n = logs.length;
        String[] res = new String[n];
        for (String log: logs) {
            int cut = log.indexOf(" ");
            char first = log.charAt(cut+1);
            if (Character.isDigit(first)) {
                digits.add(log);
                continue;
            }
            String id = log.substring(0, cut);
            String content = log.substring(cut+1);
            letters.add(new Log(id, content, log));
        }
        Collections.sort(letters);
        int m = letters.size();
        for (int i = 0; i < m; i++)
            res[i] = letters.get(i).log;
        for (int i = 0; i < digits.size(); i++)
            res[i+m] = digits.get(i);
        return res;
    }
}

class Log implements Comparable<Log> {
    String id;
    String contents;
    String log;
    
    public Log(String id, String str, String l) {
        this.id = id;
        contents = str;
        log = l;
    }
    
    public int compareTo(Log other) {
        int rs = contents.compareTo(other.contents);
        if (rs != 0)
            return rs;
        return id.compareTo(other.id);
    }
}

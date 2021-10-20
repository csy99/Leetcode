/**
 * Created by csy99 on 10/20/21.
 */
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList();
        Map<String, List<Transaction>> map = new HashMap();
        StringBuilder sb = new StringBuilder();
        for (String trans: transactions) {
            Transaction cur = new Transaction(trans);
            List<Transaction> records = map.getOrDefault(cur.name, new ArrayList());
            records.add(cur);
            map.put(cur.name, records);
        }
        for (String user: map.keySet()) {
            List<Transaction> records = map.get(user);
            int len = records.size();
            for (int i = 0; i < len; i++) {
                Transaction cur = records.get(i);
                boolean invalid = false;
                for (int j = 0; j < len; j++) {
                    Transaction other = records.get(j);
                    if (cur.invalid(other)) {
                        invalid = true;
                        break;
                    }
                }
                if (invalid)
                    res.add(cur.toString(sb));
            }
        }
        return res;
    }
}

class Transaction {
    String name;
    int time;
    int amount;
    String city;
    
    public Transaction(String trans) {
        String[] arr = trans.split(",");
        name = arr[0];
        time = Integer.parseInt(arr[1]);
        amount = Integer.parseInt(arr[2]);
        city = arr[3];
    }
    
    public String toString(StringBuilder sb) {
        sb.setLength(0);
        sb.append(name).append(",").append(time).append(",").append(amount).append(",").append(city);
        return sb.toString();
    }
    
    public boolean invalid(Transaction other) {
        return invalidAmount() || differentCity(other.city, other.time);
    }
    
    private boolean differentCity(String city, int time) {
        return !this.city.equals(city) && Math.abs(this.time - time) <= 60;
    }
    
    private boolean invalidAmount() {
        return this.amount > 1000;
    }
}

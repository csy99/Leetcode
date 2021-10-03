/**
 * Created by csy99 on 10/3/21.
 */
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> id2employee = new HashMap();
        for (Employee e: employees)
            id2employee.put(e.id, e);
        return accumulation(id2employee, id);
    }
    
    private int accumulation(Map<Integer, Employee> id2employee, int id) {
        Employee cur = id2employee.get(id);
        int sum = cur.importance;
        for (Integer sub_id: cur.subordinates)
            sum += accumulation(id2employee, sub_id);
        return sum;
    }
}

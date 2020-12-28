package leetcode.level.easy.rand4;

import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {
    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> integerEmployeeHashMap = new HashMap<>();
        employees.forEach(employee -> integerEmployeeHashMap.put(employee.id,employee));
        Employee head = integerEmployeeHashMap.get(id);
        int sum = head.importance;
        sum += head.subordinates.stream()
                .mapToInt(subId -> getImportance(integerEmployeeHashMap, subId)).sum();
        return sum;
    }
    int getImportance(HashMap<Integer, Employee>  employees, int id) {
        Employee head = employees.get(id);
        int sum = head.importance;
        sum += head.subordinates.stream()
                .mapToInt(subId -> getImportance(employees, subId)).sum();
        return sum;
    }
}

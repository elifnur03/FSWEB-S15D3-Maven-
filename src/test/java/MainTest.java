import org.example.WordCounter;
import org.example.entity.Employee;

import java.util.*;

class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Ali", "Yılmaz"));
        employees.add(new Employee(2, "Ayşe", "Demir"));
        employees.add(new Employee(1, "Ali", "Yılmaz"));
        employees.add(new Employee(3, "Mehmet", "Kaya"));
        employees.add(new Employee(4, "Zeynep", "Koç"));
        employees.add(new Employee(2, "Ayşe", "Demir"));

        System.out.println("Duplicate Employees:");
        System.out.println(findDuplicates(employees));

        System.out.println("\nUnique Employees Map:");
        System.out.println(findUniques(employees));

        System.out.println("\nOnly Non-Duplicate Employees:");
        System.out.println(removeDuplicates(employees));

        System.out.println("\nWord Count:");
        System.out.println(WordCounter.calculateWord());
    }


    // Tekrar eden employee'leri bulur
    public static List<Employee> findDuplicates(List<Employee> list) {

        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee e : list) {

            int id = e.getId();
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);

            if (countMap.get(id) == 2) {
                duplicates.add(e);
            }
        }

        return duplicates;
    }


    // Her employee'den sadece bir tane Map'e koyar
    public static Map<Integer, Employee> findUniques(List<Employee> list) {

        Map<Integer, Employee> map = new HashMap<>();

        for (Employee e : list) {
            map.putIfAbsent(e.getId(), e);
        }

        return map;
    }


    // Birden fazla geçenleri tamamen siler
    public static List<Employee> removeDuplicates(List<Employee> list) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (Employee e : list) {
            int id = e.getId();
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);
        }

        List<Employee> result = new LinkedList<>();

        for (Employee e : list) {
            if (countMap.get(e.getId()) == 1) {
                result.add(e);
            }
        }

        return result;
    }
}
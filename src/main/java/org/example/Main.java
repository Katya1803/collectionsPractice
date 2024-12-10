package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Tạo danh sách nhân viên
        List<Employee> employees = Arrays.asList(
                new Employee("1", "John Doe", LocalDate.of(2003, 3, 18),10000),
                new Employee("2", "Jane Marry", LocalDate.of(2002, 6,17),12000),
                new Employee("3","Peter Parker", LocalDate.of(2004,9, 4), 9000),
                new Employee("4","Harry Kane", LocalDate.of(2000, 11,25),11000)
        );

        //Lọc nhân viên có lương >= 10000
        System.out.println("Các nhân viên có lương trên 10 triệu: ");
        employees.stream().filter(e -> e.getSalary() >= 10000).forEach(System.out::println);

        //Tổng lương của toàn bộ nhân viên
        Stream<Employee> stream = employees.stream();
        double totalSalary = stream.mapToDouble(Employee::getSalary).sum();
        System.out.println("Total salary: " + totalSalary);
        double avrSalary = totalSalary / employees.size();
        System.out.println("Average salary: " + avrSalary);

        //Sắp xếp nhân viên
        System.out.println("Sắp xếp nhân viên theo tên");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        //Hiện thị Date/Time
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Ngày giờ làm báo cáo: " + today.format(formatter));

        //Tính tuổi nhân viên
        System.out.println("\nTuổi của từng nhân viên:");
        employees.forEach(e -> {
            int age = today.getYear() - e.getDob().getYear();
            System.out.println(e.getName() + " - " + age + " tuổi");
        });

    }
}


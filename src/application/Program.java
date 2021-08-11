package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		// This program register people on an employees list.

		Scanner scanner = new Scanner(System.in);

		int n, id;
		double salary;
		String name;

		List<Employee> employees = new ArrayList<>();

		System.out.println("How many employees will be registered? ");
		n = scanner.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println("Employee #" + (i + 1) + ": ");

			System.out.println("ID: ");
			id = scanner.nextInt();

			System.out.println("Name: ");
			name = scanner.next();

			System.out.println("Salary: ");
			salary = scanner.nextDouble();

			employees.add(new Employee(id, name, salary));
		}

		System.out.println("Enter the ID of the employee " 
				+ "that will have a salary increase");
		id = scanner.nextInt();

		boolean found = false;

		for (Employee obj : employees) {
			if (obj.getId() == id) {
				found = true;

				System.out.println("Enter the increase percentage: ");
				double increase = scanner.nextDouble();

				obj.setSalary(obj.getSalary() * (increase / 100.0d + 1));
				break;
			}
		}

		if (found == false) {
			System.out.println("This ID doesn't exist!");
		}

		System.out.println("List of employees: ");
		for (Employee obj : employees) {
			System.out.println(obj.toString());
		}

		scanner.close();
	}

}

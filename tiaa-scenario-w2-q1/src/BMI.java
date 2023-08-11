import java.util.Scanner;

public class BMI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your height (in cms): ");
		double height = sc.nextDouble();
		height = height / 100.0;
		
		System.out.println("Enter your weight (in kgs): ");
		double weight = sc.nextDouble();
		
		double bmi_index = Math.round(weight / Math.pow(height, 2));
		
		if(bmi_index < 18.5) System.out.println("Underweight");
		else if(bmi_index >= 18.5 && bmi_index < 24.9) System.out.println("Normal weight");
		else if(bmi_index >= 25 && bmi_index < 29.9) System.out.println("Overweight");
		else System.out.println("Obesity");
		
		sc.close();
		
		System.exit(1);
	}
}
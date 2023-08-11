import java.util.*;

public class DuplicateElement {
	public static void main(String[] args) {
		int[] array = new int[]{ 1,2,3,4,2 };
		HashSet<Integer> visited = new HashSet<>();
		
		for(int num: array) {
			if(visited.contains(num)) {
				System.out.println("Duplicate Element: " + num);
				System.exit(1);
			}
			visited.add(num);
		}
		
	}
}
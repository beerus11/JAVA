import java.util.Scanner;

public class StackDemo {
	private static StackClass stack;
	private static Scanner obj;

	public static void main(String args[]) throws Exception {
		obj = new Scanner(System.in);
		System.out.println("Stack Demo");
		stack = new StackClass(100);
		while (true) {
			System.out.println("(1)PUSH");
			System.out.println("(2)POP");
			System.out.println("(3)TOP");
			System.out.println("(4)Exit");
			int input = obj.nextInt();
			switch (input) {
			case 1:
				System.out.println("Enter a Element to insert ");
				stack.push(obj.nextInt());
				System.out.println("Element inserted");
				break;
			case 2:
				stack.pop();
				System.out.println("Element Deleted");
				break;
			case 3:
				System.out.println("Top Element is:" + stack.top());
				break;
			case 4:
				System.exit(0);
				break;
			default:
				break;
			}
		}

	}
}

public class RecursionExamples {
    // Factorial using recursion
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1; // base case
        return n * factorial(n - 1);    // recursive case
    }

    // Fibonacci using recursion
    public static int fibonacci(int n) {
        if (n <= 1) return n;  // base case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int num = 5;

        // Factorial example
        System.out.println("Factorial of " + num + " = " + factorial(num));

        // Fibonacci example
        System.out.print("First " + num + " Fibonacci numbers: ");
        for (int i = 0; i < num; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}

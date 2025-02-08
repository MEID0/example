import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class DemoClass {
    private static final String PASSWORD = "admin123"; // Security: Hardcoded password
    private int unusedVariable; // Code smell: Unused field

    public static void main(String[] args) {
        int x = 10;
        int y = 0;
        int result = x / y; // Bug: Division by zero (ArithmeticException)

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add(null); // Code smell: Adding null to a collection

        String name = getName(); // Bug: Potential null pointer dereference
        System.out.println(name.length());

        duplicateMethod(); // Code duplication
        duplicateMethod(); // Code duplication

        // Resource leak: Connection not closed
        try {
            Connection conn = DriverManager.getConnection("jdbc:fake:localhost", "user", PASSWORD);
        } catch (Exception e) {
            // Empty catch block: Poor error handling
        }
    }

    private static String getName() {
        return Math.random() > 0.5 ? "John" : null; // Returns null randomly
    }

    private static void duplicateMethod() {
        System.out.println("This is a duplicated method.");
    }

    // Duplicate method (identical to above)
    private static void duplicateMethod() {
        System.out.println("This is a duplicated method.");
    }
}}
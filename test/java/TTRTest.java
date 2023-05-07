import org.junit.Test;
import static org.junit.Assert.*;

public class TTRTest {
    @Test
    public void testAddition() {






            // Define the menu options
            String option1 = "1. Buy a ticket\n";
            String option2 = "2. View timetable\n";
            String option3 = "3. Cancel reservation\n";
            String option4 = "4. Exit\n";

            // Print the menu with the options and the title
            System.out.println("=== Ticket to Ride ===\n");
            System.out.print(option1);
            System.out.print(option2);
            System.out.print(option3);
            System.out.print(option4);



    }

    @Test
    public void testSubtraction() {
        assertEquals(2, 4 - 2);
    }
}

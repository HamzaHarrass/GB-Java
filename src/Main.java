import Services.BookService;
import Services.BorrowService;
import Services.BoorrowerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //
        //
        //
        //
        //
        //

        //BorrowService.FindBorrow();

        //
        //BoorrowerService.DeleteBorrower();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            System.out.println("\033[1;32m╔════════════════════════════════╗");
            System.out.println("║     Welcome to the Library     ║");
            System.out.println("║   Management System            ║");
            System.out.println("╚════════════════════════════════╝\033[0m");

            while (!exit) {
                System.out.println("_______________________");
                System.out.println("\033[1;31mSelect an operation:\033[0m");
                System.out.println("_______________________");
                System.out.println("1. Add Book");
                System.out.println("2. Update Book");
                System.out.println("3. Delete Books");
                System.out.println("4. search By Author");
                System.out.println("5. search By Title");
                System.out.println("6. Show all available books");
                System.out.println("7. Add Borrower");
                System.out.println("8. Return book");
                System.out.println("9. Statistic");
                System.out.println("10. Exit");
                System.out.println("_______________________");

                System.out.println(".........................");
                System.out.println("\033[1;31mEntre Your Choice :\033[0m");



                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        BookService.AddBook();
                        break;
                    case 2:
                        BookService.UpdateBook();
                        break;
                    case 3:

                        BookService.DeleteBook();
                        break;
                    case 4:

                        BookService.ChercherAuteurBook();
                        break;
                    case 5:

                        BookService.ChercherTitleBook();
                        break;
                    case 6:
                        BookService.FindBook();
                        break;
                    case 7:
                        BoorrowerService.AddBorrower();
                        break;
                    case 8:
                        BorrowService.FindBorrow();
                        break;
                    case 9:
                        BookService.StatistiqueBookDisponible();
                        BookService.StatistiqueBoukEmprunte();
                        break;
                        case 10:
                            BorrowService.AddBrrower();
                        break;
                    case 11:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }




}

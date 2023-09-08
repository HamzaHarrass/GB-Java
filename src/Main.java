import Services.BookService;
import Services.BorrowService;

public class Main {
    public static void main(String[] args) {
        //BookService.AddBook();
        //BookService.UpdateBook();
        //BookService.DeleteBook();
        //BookService.FindBook();
        //BookService.ChercherTitleBook();
        //BookService.ChercherAuteurBook();
        BookService.StatistiqueBookDisponible();
        BookService.StatistiqueBoukEmprunte();
        BorrowService.AddBrrower();
    }
}

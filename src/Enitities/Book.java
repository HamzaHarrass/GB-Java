package Enitities;


import java.util.List;



public class Book {
    private String isbn;

    private String titre;
    private String statu;
    private int auteurid;
    private Auteur auteur;
    private List<Borrow> borrows;

    public Book(String isbn, String titre, String statu, int auteurid) {
        this.isbn = isbn;
        this.titre = titre;
        this.statu = statu;
        this.auteurid = auteurid;
    }

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public int getAuteurid() {
        return auteurid;
    }

    public void setAuteurid(int auteurid) {
        this.auteurid = auteurid;
    }

/*    public static void findBook() {

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM book");
            ResultSet resultSet = stmt.executeQuery();
            System.out.println("|      isbn              |  titre    | status    |");
            System.out.println("|------------------------|---------|-----------|");
            while (resultSet.next()) {
                System.out.println("    " + resultSet.getString("isbn") + "                     |     " + resultSet.getString("titre") + "  | " + resultSet.getString("statu") + "      |" + resultSet.getInt("auteurid"));
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);//scanf
        System.out.print("Enter book isbn: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter book titre: ");
        String titre = scanner.nextLine();
        System.out.print("Enter book status: ");
        String statu = scanner.nextLine();
        System.out.print("Enter book auteurid: ");
        int authorid = scanner.nextInt();
        try{
            String query ="SELECT * From book WHERE isbn=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,isbn);
            ResultSet resultSet = preparedStatement.executeQuery();
             boolean count = resultSet.next();
             if (count=true){
                System.out.println("isbn deja exists!!");
                 System.out.print("Enter book isbn: ");
                 String ISBN =scanner.nextLine();
             }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            String sql = "INSERT INTO book(isbn,titre,statu,auteurid) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, isbn);
            preparedStatement.setString(2, titre);
            preparedStatement.setString(3, statu);
            preparedStatement.setInt(4, authorid);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Data insertion failed.");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void UpdateBook(){
        Scanner Scanner =new Scanner(System.in);
        try{
            System.out.println("Enter the book isbn to update: ");
            String isbn = Scanner.nextLine();
            System.out.println("Enter the new book titre: ");
            String newTitre = Scanner.nextLine();
            System.out.println("Entre the new status");
            String newStatus = Scanner.nextLine();
            System.out.println("Entre the new auteurId");
            int newAuteurId = Scanner.nextInt();

            System.out.println("before : " + isbn + newTitre + newStatus + newAuteurId);

            String sql = "UPDATE book SET titre=? , statu=? , auteurid=? WHERE isbn=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newTitre);
            preparedStatement.setString(2, newStatus);
                preparedStatement.setInt(3, newAuteurId);
            preparedStatement.setString(4, isbn);

            int rowsAffected = preparedStatement.executeUpdate();

//            System.out.println(rowsAffected);

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("Data update failed.");
            }
        }catch (Exception e){
          e.printStackTrace();
        }
    }
    public static void DeleteBook(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the book isbn to DELETE: ");
            String isbn = scanner.nextLine();
            String sql ="DELETE FROM book WHERE isbn=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,isbn);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Enitities.Book Delete successfully.");
            } else {
                System.out.println("Enitities.Book Delete failed.");
            }
                }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}



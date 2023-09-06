package Enitities;

import java.awt.print.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.sql.Connection;


public class Auteur {
    private String nom;
    private  String prenom;
    private Date dateNaissance;

    private List<Book> books;

    public  Auteur(String nom,String prenom ,Date dateNaissance){
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaissance=dateNaissance;
    }
    public void Auteur(){}
    public  String getNom(){
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom(){
        return  prenom;
    }
    public  void  setPrenom(String prenom) {
        this.prenom=prenom;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public  void  setDateNaissance(Date dateNaissance) {
        this.dateNaissance=dateNaissance;
    }
    /*public static void findAuthor(){
        DbConnection db = new DbConnection();
       Connection connection = db.conn();
       try{
           PreparedStatement stmt = connection.prepareStatement("SELECT * FROM auteur");
           ResultSet resultSet =  stmt.executeQuery();
               System.out.println("|  id    |  Nom    | Prenom    | datenaissance    |");
               System.out.println("|--------|---------|-----------|------------------|");
           while (resultSet.next()){
               System.out.println("    "+resultSet.getInt("id") + "    | " + resultSet.getString("nom")+ "  | " + resultSet.getString("prenom")+ "      |" + resultSet.getString("datenaissance"));
           }
           stmt.close();
           connection.close();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
    public static  void addAuteur(){
        DbConnection db = new DbConnection();
        Connection connection = db.conn();
        try{

        }catch (Exception e){

        }
    }*/

}


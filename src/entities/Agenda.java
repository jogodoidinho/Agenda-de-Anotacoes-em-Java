package entities;

import db.DB;
import db.DBException;
import entities.Exception.agendaException;
import entities.interfaces.CalendarInterface;
import entities.utils.returnPost;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agenda extends DB implements CalendarInterface {
    private final String name;
    Connection conn = DB.getConnection();
    private final int year = LocalDate.now().getYear();
    int id;


    public Agenda(String name) {
        this.name = name;
        try {
            PreparedStatement st = conn.prepareStatement(
                    "SELECT * FROM teste.users " + "WHERE Author = ?"
            );
            st.setString(1,name);
            ResultSet result = st.executeQuery();
            if(result.next()){
                id = result.getInt("ID");
            }
            else{
                id = createPeople(name);
            }


        } catch (SQLException e) {
            throw new DBException(e.getMessage() + " Construtor");
        }

    } //CERTO

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getAuthor_ID(){
        return id;
    }



    @Override
    public boolean addNote(String Title,String note, LocalDate date) {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO notes" +
                            "(Title,PostDate,Content,Author_ID)" +
                            "Values" +
                            "(?,?,?,?)"
            );

            st.setString(1,Title);
            st.setDate(2, Date.valueOf(date));
            st.setString(3,note);
            st.setInt(4,getAuthor_ID());
            int rows = st.executeUpdate();
            if(rows > 0){
                return true;
            }
            else{
                throw new agendaException("Problema ao Postar: addNote");
            }


        }
        catch (SQLException e){
            throw new DBException(e.getMessage() + " ERRO NO addNote");
        }



    } //CERTO

    @Override
    public void deleteNote(LocalDate date) {
        int id = check(getName());

        if(id != 0){

            try{
                PreparedStatement st = conn.prepareStatement(
                        "DELETE FROM teste.notes WHERE PostDate = ? and Author_ID = ?");
                st.setDate(1,Date.valueOf(date));
                st.setInt(2, id);
                int row = st.executeUpdate();
                if(row < 0){
                    throw new agendaException("PROBLEMA no deleteNote, AO EXECUTAR UPDATE");
                }

            } catch (SQLException e) {
                throw new DBException(e.getMessage() + " ERRO NO deleteNote");
            }

        }
        else {
            throw new agendaException("ERROR NO DELETE NOTE POIS ID = 0");
        }



    } //CERTO,mas pode melhorar,pq apaga o dia inteiro

    @Override
    public List<returnPost> showNote(LocalDate day) {
        int id = check(getName());
        List<returnPost> list = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(
                    "Select * FROM notes WHERE Author_ID = ? AND PostDate = ?"
            );
            st.setInt(1,id);
            st.setDate(2, Date.valueOf(day));
            ResultSet result = st.executeQuery();

            while (result.next()){
                returnPost p = new returnPost(result.getString("Content"),result.getDate("PostDate").toLocalDate());
                list.add(p);
            }
            return list;

        }
        catch (SQLException e){
            throw new DBException(e.getMessage() + "ERRO NO showNote");
        }
    } //CERTO

    @Override
    public List<returnPost> showAllNotesofYear() {
        int id = check(getName());
        List<returnPost> list = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement(
                    "Select * FROM notes WHERE Author_ID = ?"
            );
            st.setInt(1,id);
            ResultSet result = st.executeQuery();

            while (result.next()){
                returnPost p = new returnPost(result.getString("Content"),result.getDate("PostDate").toLocalDate());
                list.add(p);
            }
            return list;


        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }

    } //CERTO

    private int createPeople(String name){
        try {
            PreparedStatement new_people = conn.prepareStatement("INSERT INTO users" +"(Author)"+"Values" + "(?)",Statement.RETURN_GENERATED_KEYS);
            new_people.setString(1,name);
            new_people.executeUpdate();

            ResultSet id = new_people.getGeneratedKeys();


            if(id.next()){
                return id.getInt("ID");
            }
            else{
                throw new agendaException("PROBLEMA AO PEGAR O ID NO CreatePeople");
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage() + " CreatePeople");
        }
    } //CERTO

    private int check(String name) {
        try{
            PreparedStatement st = conn.prepareStatement(
                    "SELECT ID FROM users" + " WHERE Author = ?");
            st.setString(1,name);

            ResultSet result = st.executeQuery();
            if(result.next()){
                return result.getInt("ID");
            }
            else{
                return 0;
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage() + " ERRO NO deleteNote");
        }


    } //CERTO

    public void closeConn() throws SQLException {
        conn.close();
    } //CERTO

    public void deleteNotewithTitle(String title,LocalDate date){
        int id = check(getName());

        if(id != 0){

            try{
                PreparedStatement st = conn.prepareStatement(
                        "DELETE FROM teste.notes WHERE PostDate = ? and Author_ID = ? and Title = ?");
                st.setDate(1,Date.valueOf(date));
                st.setInt(2, id);
                st.setString(3,title);
                int row = st.executeUpdate();
                if(row < 0){
                    throw new agendaException("PROBLEMA no deleteNote, AO EXECUTAR UPDATE");
                }

            } catch (SQLException e) {
                throw new DBException(e.getMessage() + " deleteNotewithTitle");
            }

        }
        else {
            throw new agendaException("ERROR NO DELETE NOTE POIS ID = 0");
        }

    }

}

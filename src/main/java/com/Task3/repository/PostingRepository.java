package com.Task3.repository;

import com.Task3.models.Posting;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.LocalDate.now;

public class PostingRepository {
    public PostingRepository () {
    }

    public static ArrayList<Posting> getPostings(String period, String Auth_Post) throws SQLException {
        ArrayList<Posting> postings = new ArrayList<Posting>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/TASK3", "root", "11111111");
            Statement statement = conn.createStatement();
            ResultSet data = (Auth_Post.equals("1") || Auth_Post.equals("0")) ?
                    statement.executeQuery("SELECT * FROM postings WHERE Auth_post = " + Auth_Post + ";") :
                    statement.executeQuery("SELECT * FROM postings;");
            while (data.next()) {
                Posting p = new Posting(
                        data.getLong(1),
                        data.getInt(2),
                        data.getString(3),
                        data.getString(4),
                        data.getString(5),
                        data.getInt(6),
                        data.getString(7),
                        data.getFloat(8),
                        data.getString(9),
                        data.getString(10),
                        data.getShort(11));
                LocalDate date = now();
                int year = date.getYear();
                int month = date.getMonthValue();
                int day = date.getDayOfMonth();
                if(period.equals("year")) {
                    if(Integer.parseInt(p.Posting_Date.split("\\.")[2]) == year) {
                        postings.add(p);
                    }
                }
                else if(period.equals("month")) {
                    if(Integer.parseInt(p.Posting_Date.split("\\.")[1]) == month &&
                            Integer.parseInt(p.Posting_Date.split("\\.")[2]) == year) {
                        postings.add(p);
                    }
                }
                else if(period.equals("day")) {
                    if(Integer.parseInt(p.Posting_Date.split("\\.")[0]) == day &&
                            Integer.parseInt(p.Posting_Date.split("\\.")[1]) == month &&
                            Integer.parseInt(p.Posting_Date.split("\\.")[2]) == year) {
                        postings.add(p);
                    }
                }
                else if(period.length() == 0) {
                    postings.add(p);
                }
            }
        } catch (Exception e){
            throw e;
        }
        return postings;
    }


    public static void New(Posting post) throws SQLException {
        String query = "insert into postings (Mat_Doc, item, Doc_Date, Posting_Date, Material_Description, Quantity, BUn,  Amount_LC, Crcy, User_Name, Auth_post) values (" +
                post.Mat_Doc + ", " +
                post.Item + ", " +
                "\"" + post.Doc_Date + "\", " +
                "\"" + post.Posting_Date + "\", " +
                "\"" + post.Material_Description + "\", " +
                 + post.Quantity + ", " +
                "\"" + post.BUn + "\", " +
                + post.Amount_LC + ", " +
                "\"" + post.Crcy + "\", " +
                "\"" + post.User_Name + "\", " +
                 + post.Auth_Post + ");";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/TASK3", "root", "11111111")) {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("connectoin failed\n" + e.toString());
            System.out.println(query);
        }
    }
}

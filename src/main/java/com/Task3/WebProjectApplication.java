package com.Task3;

import au.com.bytecode.opencsv.CSVReader;
import com.Task3.models.Login;
import com.Task3.models.Posting;
import com.Task3.repository.LoginRepository;
import com.Task3.repository.PostingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class WebProjectApplication {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "11111111")) {
            Statement statement = conn.createStatement();
            statement.executeUpdate("DROP DATABASE IF EXISTS TASK3;");
            statement.executeUpdate("CREATE DATABASE TASK3;");
            statement.executeUpdate("USE TASK3;");
            statement.executeUpdate("CREATE TABLE postings(" +
                    "   Mat_Doc bigint not null," +
                    "    item int," +
                    "    Doc_Date varchar(11)," +
                    "    Posting_Date varchar(11)," +
                    "    Material_Description varchar(100)," +
                    "    Quantity int," +
                    "    BUn varchar(5)," +
                    "    Amount_LC float," +
                    "    Crcy varchar(5)," +
                    "    User_Name varchar(20)," +
                    "    Auth_post tinyint);");
            statement.executeUpdate("CREATE TABLE logins(" +
                    "   Application varchar(5)," +
                    "    AppAccountName varchar(20) not null primary key," +
                    "    IsActive tinyint," +
                    "    JobTitle varchar(40)," +
                    "    Department varchar(40));");
            // DATABASE CREATED;

            CSVReader reader1 = new CSVReader(new FileReader("src/main/resources/logins.csv"), ',', '"', 2);
            CSVReader reader2 = new CSVReader(new FileReader("src/main/resources/postings.csv"), ';', '"', 2);

            List<String[]> logins = reader1.readAll();
            ArrayList<Login> logs = new ArrayList<Login>();
            for(String[] row : logins){
                short IsActive = (row[2].replaceAll("\\s+","").equals("True")) ? (short)1 : (short)0;
                Login login = new Login(
                        row[0].replaceAll("\\s+",""),
                        row[1].replaceAll("\\s+",""),
                        IsActive,
                        row[3].replaceAll("\\s+"," "),
                        row[4].replaceAll("\\s+"," "));
                LoginRepository.New(login);
                logs.add(login);
            } // выполнено задание 3.1 и 3.4


            List<String[]> postings = reader2.readAll();
            for(String[] row : postings){
                short Auth_Post = (short)0;
                for (Login log: logs) {
                    if(row[9].replaceAll("\\s+","").equals(log.AppAccountName)){
                        Auth_Post = log.IsActive;
                        break;
                    }
                } // выполнена проверка на авторизацию (задание 3.3)

                PostingRepository.New(new Posting(Long.parseLong(row[0].replaceAll("\\s+","")),
                        Integer.parseInt(row[1].replaceAll("\\s+","")),
                        row[2].replaceAll("\\s+",""),
                        row[3].replaceAll("\\s+",""),
                        row[4].replaceAll("\\s+",""),
                        Integer.parseInt(row[5].replaceAll("\\s+","")),
                        row[6].replaceAll("\\s+",""),
                        Float.parseFloat(row[7].replaceAll("\\s+","").replace(',','.')),
                        row[8].replaceAll("\\s+",""),
                        row[9].replaceAll("\\s+",""),
                        Auth_Post
                ));
            } // выполнено задание 3.2 и 3.5
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        SpringApplication.run(WebProjectApplication.class, args);
    }

}

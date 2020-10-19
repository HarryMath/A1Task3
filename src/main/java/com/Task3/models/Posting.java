package com.Task3.models;

//import javax.persistence.Entity;

//@Entity
public class Posting {
    public long Mat_Doc;
    public int Item;
    public String Doc_Date;
    public String Posting_Date;
    public String Material_Description;
    public int Quantity;
    public String BUn;
    public float Amount_LC;
    public String Crcy;
    public String User_Name;
    public short Auth_Post; // TASK 3.3 Добавить булевое поле "авторизованная поставка" в данные из postings.csv

    public Posting(long Mat_Doc, int Item, String Doc_Date, String Posting_Date,
                String Material_Description, int Quantity, String BUn, float Amount_LC,
                String Crcy, String User_Name, short Auth_Post) {
        this.Mat_Doc = Mat_Doc;
        this.Item = Item;
        this.Doc_Date = Doc_Date;
        this.Posting_Date = Posting_Date;
        this.Material_Description = Material_Description;
        this.Quantity = Quantity;
        this.BUn = BUn;
        this.Amount_LC = Amount_LC;
        this.Crcy = Crcy;
        this.User_Name = User_Name;
        this.Auth_Post = Auth_Post;
    }
}

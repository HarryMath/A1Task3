package com.Task3.models;


import com.Task3.repository.PostingRepository;
import java.util.ArrayList;

public class Response {
    public int success;
    public ArrayList<Posting> postings = new ArrayList<Posting>();

    public Response(String period, String Auth_Post) {
        if((period.equals("day") || period.equals("year") || period.equals("month") || period.length() == 0) &&
                (Auth_Post.equals("0") || Auth_Post.equals("1") || Auth_Post.length() == 0)) {
            try {
                this.postings = PostingRepository.getPostings(period, Auth_Post);
                this.success = 1;
            } catch (Exception e)
            {
                e.printStackTrace();
                System.out.println(e.getMessage());
                this.success = 0;
            }
        }
        else {
            this.success = 0;
        }
    }
}

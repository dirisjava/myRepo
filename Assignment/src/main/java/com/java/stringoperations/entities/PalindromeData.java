package com.java.stringoperations.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "palindromedata")
public class PalindromeData implements Serializable {

    private static final long serialVersionUID = 4048798961366546485L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(name = "palindrome")
    private String palindrome;

    public PalindromeData() {
    }

    public PalindromeData(String palindrome) {
        this.palindrome = palindrome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPalindrome() {
        return palindrome;
    }

    public void setPalindrome(String palindrome) {
        this.palindrome = palindrome;
    }

    @Override
    public String toString() {
        return "PalindromeData{" +
                "id='" + id + '\'' +
                ", palindrome='" + palindrome + '\'' +
                '}';
    }
}

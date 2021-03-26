package com.java.stringoperations.services;

import com.java.stringoperations.entities.PalindromeData;
import com.java.stringoperations.repositories.StringOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StringOperationService {

    int resultStart;
    int resultLength;

    @Autowired
    private StringOperationRepository stringOperationRepository;

    public PalindromeData saveLongestSubstring(String input) {
        String longestPalindrome = longestPalindrome(input);
        System.out.println(longestPalindrome);
        return stringOperationRepository.save(new PalindromeData(longestPalindrome));
    }

    public Integer binaryReversal(String input){
        int number = Integer.parseInt(input);
        if(number > 0) {
            String binary = String.format("%8s", Integer.toBinaryString(number)).replace(' ', '0');
            return Integer.parseInt(new StringBuilder(binary).reverse().toString(),2);
        }
        return null;
    }

    private String longestPalindrome(String s) {
        try {
            int strLength = s.length();
            if (strLength < 2) {
                return s;
            }
            for (int start = 0; start < strLength - 1; start++) {
                expandRange(s, start, start);
                expandRange(s, start, start + 1);
            }
            return s.substring(resultStart, resultStart + resultLength);
        }catch(Exception e){
            return s;
        }
    }

    private void expandRange(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() &&
                str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }

}

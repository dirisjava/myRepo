package com.java.stringoperations.controllers;

import com.java.stringoperations.entities.PalindromeData;
import com.java.stringoperations.services.StringOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operations")
public class StringOperationController {

    @Autowired
    private StringOperationService stringOperationService;

    @PostMapping(value = "/palindrome/{input}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PalindromeData> getUserById(@PathVariable("input") String input) {
        return ResponseEntity.ok(stringOperationService.saveLongestSubstring(input));
    }

    @GetMapping(value = "/binaryreversal/{input}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer binaryReversal(@PathVariable("input") String input) {
        return stringOperationService.binaryReversal(input);
    }
}

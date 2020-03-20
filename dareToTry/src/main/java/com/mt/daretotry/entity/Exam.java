package com.mt.daretotry.entity;

import org.springframework.data.annotation.Id;

public class Exam {
	
        @Id
	    public String id;
        String examTitle;
        Question questions[];      
        
}

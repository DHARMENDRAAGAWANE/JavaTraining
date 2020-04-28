package com.mt.daretotry.entity;

import org.springframework.data.annotation.Id;

public class Question {
	@Id
	String id;
	String questionTitle;
	String question;
	String options[];
	String actualAnswer;

}

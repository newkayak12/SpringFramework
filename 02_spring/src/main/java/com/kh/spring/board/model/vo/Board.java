package com.kh.spring.board.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Board {

	/*
	 *  	"BOARDNO" NUMBER, 
            "BOARDTITLE" VARCHAR2(50), 
            "BOARDWRITER" VARCHAR2(15),
            "BOARDCONTENT" VARCHAR2(2000), 
            "BOARDDATE" DATE DEFAULT SYSDATE, 
            "BOARDREADCOUNT" NUMBER DEFAULT 0, 
	 * 
	 * 
	 */
	
	private int boardNo;
	private String boardTitle, boardWriter, boardContent;
	private Date date;
	private int boardReadCount;
	private List<Attachment> attachment = new ArrayList();;
	
}

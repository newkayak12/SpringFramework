package com.kh.spring.board.model.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attachment {

	
//	  ATTACHMENTNO NUMBER PRIMARY KEY,
//      BOARDNO NUMBER NOT NULL,
//      ORIGINALFILENAME VARCHAR2(255) NOT NULL,
//      RENAMEDFILENAME VARCHAR2(255) NOT NULL,
//      UPLOADDATE DATE DEFAULT SYSDATE,
//      DOWNLOADCOUNT NUMBER DEFAULT 0,
//      STATUS VARCHAR2(1) DEFAULT 'Y',
	
	
	private int attachmentNo;
	private String originalFileName, renamedFileName;
	private Date uploadDate;
	private int downloadCount;
	private String status;

}

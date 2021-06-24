package com.spring.hellospring.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

//	mybatis에서 사용할 타입 객체를 등록
//  TypeHandler라는 인터페이스가 있음
public class StringArrayTypeHandler implements TypeHandler<String[]>{

	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		if(parameter!=null) {
			ps.setString(i, String.join(",", parameter));
//			join < - >split
		} else {
			ps.setString(i, "");
		}
		
	}

	
//	rs.get~와 같은
	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		
		return rs.getString(columnName).split(",");
	}

	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getString(columnIndex).split(",");
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		
//		callableStatement > 함수를 실행하는 경우 
		return cs.getString(columnIndex).split(",");
	}

	
	

	
}

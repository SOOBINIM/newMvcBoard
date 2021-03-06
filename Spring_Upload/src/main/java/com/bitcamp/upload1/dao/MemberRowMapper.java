package com.bitcamp.upload1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.upload1.member.model.Member;


// 공통 적인 부분
public class MemberRowMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {					
		
			Member member = new Member();
			member.setIdx(rs.getInt("idx"));
			member.setMember_id(rs.getString("member_id"));						
			member.setMember_name(rs.getString("member_name"));
			member.setPassword(rs.getString("password"));
			member.setRegdate(rs.getDate("regdate"));
			member.setPhoto(rs.getString("photo"));
			
			return member;
	}

}

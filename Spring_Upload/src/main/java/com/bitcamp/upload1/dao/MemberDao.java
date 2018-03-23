package com.bitcamp.upload1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.upload1.member.model.Member;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	// 생성자 방식으로 의존 설정
	public MemberDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int insertMember(Member member) {
		String sql = "insert into member (member_id, member_name, password, photo) "
				+ " values (?,?,?,?)";
		
		int resultCnt = jdbcTemplate.update(
				sql,
				member.getMember_id(),
				member.getMember_name(),
				member.getPassword(),
				member.getPhoto());
		
		return resultCnt;
	}
	
	public Member selectById(String id) {
		String sql = "select * from member where member_id=?";
		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper(),id);
		return result.isEmpty() ? null : result.get(0);
		}

		/*	@Override
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
		}*/		

	public List<Member> selectMembers() {
		String sql = "select * from member";
		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper());		
		return result;
	}
	
}

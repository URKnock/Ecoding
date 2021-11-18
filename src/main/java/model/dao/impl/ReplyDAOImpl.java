package model.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dao.ReplyDAO;
import model.util.JDBCUtil;
import model.service.dto.ReplyDTO;

public class ReplyDAOImpl implements ReplyDAO{
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "REPLY.reply_id AS reply_id, REPLY.reply_date AS reply_date, " +
								"REPLY.reply_content, REPLY.post_id AS post_id, REPLY.ecoer_id AS ecoer_id ";
		
	public ReplyDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}	
	
	public List<ReplyDTO> getReplyList() {
		String allQuery = query + "FROM REPLY";
		jdbcUtil.setSqlAndParameters(allQuery, null); // JDBCUtil 에 query 설정
		try { 
			ResultSet rs = jdbcUtil.executeQuery(); // query 문 실행
			List<ReplyDTO> list = new ArrayList<ReplyDTO>(); // DTO 객체들을 담기 위한 리스트 생성
			while (rs.next()) {
				ReplyDTO dto = new ReplyDTO(); // ReplyDTO 객체 생성 후 검색 결과 저장
				dto.setReplyContent(rs.getString("reply_content"));
				dto.setReplyDate(rs.getString("reply_date"));
				dto.setReplyId(rs.getInt("reply_id"));
				dto.setEcoerId(rs.getString("ecoers"));
				dto.setPostId(rs.getInt("post_id"));
				list.add(dto); // 리스트에 DTO 객체 저장
			}
			return list; // 게시글정보를 저장한 DTO 객체들의 리스트를 반환
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		} return null;
	}

	public int insertReply(ReplyDTO reply) {
		int result = 0;
		String insertQuery = "INSERT INTO REPLY VALUES (seq_reply.nextval, ?, ?, ?, ?, ?, ?) ";
		
		Object[] param = new Object[] {reply.getReplyDate(), reply.getReplyContent(), reply.getPostId(), reply.getEcoerId()};
		jdbcUtil.setSqlAndParameters(insertQuery, param); // JDBCUtil 에 insert문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate(); // insert 문 실행
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return result;
	}

	public int updateReply(ReplyDTO reply) {
		int result = 0;
		String updateQuery = "UPDATE REPLY SET reply_content = ? WHERE reply_id = ?";
		
		Object[] param = new Object[] {reply.getReplyContent(), reply.getReplyId()};
		jdbcUtil.setSqlAndParameters(updateQuery, param); // JDBCUtil 에 update문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate(); // update 문 실행
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return result;
	}

	public int deleteReply(int replyId) {
		int result = 0;
		String deleteQuery = "DELETE FROM REPLY WHERE reply_id = ?";
		
		Object[] param = new Object[] {replyId};
		jdbcUtil.setSqlAndParameters(deleteQuery, param); // JDBCUtil 에 update문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate(); // update 문 실행
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return result;
	}

	public ReplyDTO getReply(int replyId) {
		String searchQuery = query + "FROM REPLY WHERE reply_id = ?";
		Object[] param = new Object[] {replyId};
		jdbcUtil.setSqlAndParameters(searchQuery, param); 
		
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			ReplyDTO dto = null;
			if (rs.next()) {
				dto = new ReplyDTO();
				dto.setReplyId(replyId);
				dto.setReplyContent(rs.getString("reply_content"));
				dto.setReplyDate(rs.getString("reply_date"));
				dto.setEcoerId(rs.getString("ecoers"));
				dto.setPostId(rs.getInt("post_id"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public List<ReplyDTO> getReplyListByPost(int postId) {
		String searchQuery = query + "FROM REPLY WHERE post_id = ?";
		Object[] param = new Object[] { postId };
		jdbcUtil.setSqlAndParameters(searchQuery, param); 
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<ReplyDTO> list = new ArrayList<>();
			ReplyDTO dto = null;
			while (rs.next()) {
				dto = new ReplyDTO();
				dto.setPostId(postId);
				dto.setReplyContent(rs.getString("reply_content"));
				dto.setReplyDate(rs.getString("reply_date"));
				dto.setReplyId(rs.getInt("reply_id"));
				dto.setEcoerId(rs.getString("ecoers"));
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}

package model.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dao.CommentDAO;
import model.util.JDBCUtil;
import model.service.dto.CommentDTO;

public class CommentDAOImpl implements CommentDAO{
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "COMMENT.comment_id AS comment_id, COMMENT.comment_date AS comment_date, " +
								"COMMENT.comment_content, COMMENT.post_id AS post_id, COMMENT.ecoers AS ecoers ";
		
	public CommentDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}	
	
	public List<CommentDTO> getCommentList() {
		String allQuery = query + "FROM COMMENT";
		jdbcUtil.setSqlAndParameters(allQuery, null); // JDBCUtil 에 query 설정
		try { 
			ResultSet rs = jdbcUtil.executeQuery(); // query 문 실행
			List<CommentDTO> list = new ArrayList<CommentDTO>(); // DTO 객체들을 담기 위한 리스트 생성
			while (rs.next()) {
				CommentDTO dto = new CommentDTO(); // CommentDTO 객체 생성 후 검색 결과 저장
				dto.setCommentContent(rs.getString("comment_content"));
				dto.setCommentDate(rs.getString("comment_date"));
				dto.setCommentId(rs.getString("comment_id"));
				dto.setEcoerId(rs.getString("ecoers"));
				dto.setPostId(rs.getString("post_id"));
				list.add(dto); // 리스트에 DTO 객체 저장
			}
			return list; // 게시글정보를 저장한 DTO 객체들의 리스트를 반환
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		} return null;
	}

	public int insertComment(CommentDTO comment) {
		int result = 0;
		String insertQuery = "INSERT INTO COMMENT VALUES (seq_comment.nextval, ?, ?, ?, ?, ?, ?) ";
		
		Object[] param = new Object[] {comment.getCommentDate(), comment.getCommentContent(), comment.getPostId(), comment.getEcoerId()};
		jdbcUtil.setSqlAndParameters(insertQuery, param); // JDBCUtil 에 insert문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate(); // insert 문 실행
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return 0;
	}

	public int updateComment(CommentDTO comment) {
		int result = 0;
		String updateQuery = "UPDATE COMMENT SET comment_content = ? WHERE comment_id = ?";
		
		Object[] param = new Object[] {comment.getCommentContent(), comment.getCommentId()};
		jdbcUtil.setSqlAndParameters(updateQuery, param); // JDBCUtil 에 update문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate(); // update 문 실행
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return 0;
	}

	public int deleteComment(int commentCode) {
		int result = 0;
		String deleteQuery = "DELETE FROM COMMENT WHERE comment_id = ?";
		
		Object[] param = new Object[] {commentCode};
		jdbcUtil.setSqlAndParameters(deleteQuery, param); // JDBCUtil 에 update문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate(); // update 문 실행
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return 0;
	}

	public CommentDTO findComment(int commentCode) {
		String searchQuery = query + "FROM COMMENT WHERE comment_id = ?";
		Object[] param = new Object[] {commentCode};
		jdbcUtil.setSqlAndParameters(searchQuery, param); 
		
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			CommentDTO dto = null;
			if (rs.next()) {
				dto = new CommentDTO();
				dto.setCommentContent(rs.getString("comment_content"));
				dto.setCommentDate(rs.getString("comment_date"));
				dto.setCommentId(rs.getString("comment_id"));
				dto.setEcoerId(rs.getString("ecoers"));
				dto.setPostId(rs.getString("post_id"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}	
}

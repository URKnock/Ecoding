package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.dao.PostDAO;
import model.dao.impl.mapper.ReactMapper;
import util.JDBCUtil;
import model.service.dto.PostDTO;

public class PostDAOImpl implements PostDAO {
	private JDBCUtil jdbcUtil = null;
	private SqlSessionFactory sqlSessionFactory = null;
	
	private static String query = "SELECT * ";
		
	public PostDAOImpl() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		jdbcUtil = new JDBCUtil();
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}	

	public List<PostDTO> getPostByCId(int cId) {
		String searchQuery = query + "FROM POST WHERE POST.community_id = ? ORDER By post_id";
		Object[] param = new Object[] {cId};
		jdbcUtil.setSqlAndParameters(searchQuery, param); 

		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<PostDTO> list = new ArrayList<>();
			while (rs.next()) {
				PostDTO dto = new PostDTO();
				dto.setPostId(rs.getInt("post_id"));
				dto.setTitle(rs.getString("title"));
				dto.setPostDate(rs.getString("post_date"));
				dto.setPostContent(rs.getString("post_content"));
				dto.setPostFile(rs.getString("post_file"));
				dto.setViews(rs.getString("views"));
				dto.setLikes(rs.getString("likes"));
				dto.setReports(rs.getString("reports"));
				dto.setEcoerId(rs.getString("ecoer_id"));
				dto.setCommunityId(rs.getInt("community_id"));
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
	
	public List<PostDTO> getPostListByTitle(String pTitle) {
		String searchQuery = query + "FROM POST WHERE POST.title LIKE '%?%'";
		Object[] param = new Object[] {pTitle};
		jdbcUtil.setSqlAndParameters(searchQuery, param); 

		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<PostDTO> list = new ArrayList<>();
			while (rs.next()) {
				PostDTO dto = new PostDTO();
				dto.setPostId(rs.getInt("post_id"));
				dto.setTitle(rs.getString("title"));
				dto.setPostDate(rs.getString("post_date"));
				dto.setPostContent(rs.getString("post_content"));
				dto.setPostFile(rs.getString("post_file"));
				dto.setViews(rs.getString("views"));
				dto.setLikes(rs.getString("likes"));
				dto.setReports(rs.getString("reports"));
				dto.setEcoerId(rs.getString("ecoer_id"));
				dto.setCommunityId(rs.getInt("community_id"));
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

	public List<PostDTO> getPostList() {
		String allQuery = query + "FROM POST";
		jdbcUtil.setSqlAndParameters(allQuery, null); // JDBCUtil 에 query 설정
		try { 
			ResultSet rs = jdbcUtil.executeQuery(); // query 문 실행
			List<PostDTO> list = new ArrayList<PostDTO>(); // DTO 객체들을 담기 위한 리스트 생성
			while (rs.next()) {
				PostDTO dto = new PostDTO(); // PostDTO 객체 생성 후 검색 결과 저장
				dto.setPostId(rs.getInt("post_id"));
				dto.setTitle(rs.getString("title"));
				dto.setPostDate(rs.getString("post_date"));
				dto.setPostContent(rs.getString("post_content"));
				dto.setPostFile(rs.getString("post_file"));
				dto.setViews(rs.getString("views"));
				dto.setLikes(rs.getString("likes"));
				dto.setReports(rs.getString("reports"));
				dto.setEcoerId(rs.getString("ecoer_id"));
				dto.setCommunityId(rs.getInt("community_id"));
				list.add(dto); // 리스트에 DTO 객체 저장
			}
			return list; // 게시글정보를 저장한 DTO 객체들의 리스트를 반환
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		} return null;
	}

	public int insertPost(PostDTO post) {
		int result = 0;
		String insertQuery = "INSERT INTO POST VALUES (seq_post.nextval, ?, SYSDATE, ?, ?, 0, 0, 0, ?, ?) ";
		Object[] param = new Object[] {post.getTitle(), post.getPostContent(), post.getPostFile(), post.getEcoerId(), post.getCommunityId()};
		jdbcUtil.setSqlAndParameters(insertQuery, param); // JDBCUtil 에 insert문과 매개변수 설정
		
		try {
			jdbcUtil.executeUpdate(); // insert 문 실행
			jdbcUtil.setSqlAndParameters("SELECT seq_post.currval AS result FROM POST", null);
			ResultSet rs = jdbcUtil.executeQuery();
			if(rs.next()) {
				result = rs.getInt("result");
			}
		} catch (Exception ex) { 
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	public int updatePost(PostDTO post) {
		int result = 0;
		String updateQuery = "UPDATE POST SET title = ?, post_content = ?, post_file = ? WHERE post_id = ?";
		
		Object[] param = new Object[] {post.getTitle(), post.getPostContent(), post.getPostFile(), post.getPostId()};
		jdbcUtil.setSqlAndParameters(updateQuery, param); // JDBCUtil 에 update문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate(); // update 문 실행
		} catch (Exception ex) { 
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	public int deletePost(int pId) {
		int result = 0;
		String deleteQuery = "DELETE FROM POST WHERE post_id = ?";
		
		Object[] param = new Object[] {pId};
		jdbcUtil.setSqlAndParameters(deleteQuery, param); // JDBCUtil 에 update문과 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception ex) { 
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	public int viewPost(int id) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.getMapper(ReactMapper.class).viewPost(id); 
		} catch(Exception ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return result;
	}

	// 계정당 1회 -> ecoer_id / post_id / is_like
	public int likePost(String ecoerId, int postId) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			ReactMapper mapper = sqlSession.getMapper(ReactMapper.class);
			result = mapper.likePost(postId);
			mapper.insertLikeEcoer(ecoerId, postId);
		} catch(Exception ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return result;
	}
	
	public int reportPost(String ecoerId, int postId) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			ReactMapper mapper = sqlSession.getMapper(ReactMapper.class);
			mapper.reportPost(postId);
			mapper.insertReportEcoer(ecoerId, postId);
			result = mapper.getReportCount(postId);
		} catch(Exception ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return result;
	}
	
	public int deleteReactByPid(int postId) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			ReactMapper mapper = sqlSession.getMapper(ReactMapper.class);
			mapper.deleteReactByPostId(postId);
		} catch(Exception ex) {
			sqlSession.rollback();
			ex.printStackTrace();
			return -1;
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return result;
	}
	
	public PostDTO getPostByCode(int pCode) {
		String searchQuery = query + "FROM POST WHERE POST.post_id = ?";
		Object[] param = new Object[] {pCode};
		jdbcUtil.setSqlAndParameters(searchQuery, param); 
		
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			PostDTO dto = null;
			if (rs.next()) {
				dto = new PostDTO();
				dto.setPostId(rs.getInt("post_id"));
				dto.setTitle(rs.getString("title"));
				dto.setPostDate(rs.getString("post_date"));
				dto.setPostContent(rs.getString("post_content"));
				dto.setPostFile(rs.getString("post_file"));
				dto.setViews(rs.getString("views"));
				dto.setLikes(rs.getString("likes"));
				dto.setReports(rs.getString("reports"));
				dto.setEcoerId(rs.getString("ecoer_id"));
				dto.setCommunityId(rs.getInt("community_id"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public PostDTO getPostByTitle(String title) {
		String searchQuery = query + "FROM POST WHERE POST.title=?";
		Object[] param = new Object[] {title};
		jdbcUtil.setSqlAndParameters(searchQuery, param); 

		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			PostDTO dto = null;
			if (rs.next()) {
				dto = new PostDTO();
				dto.setPostId(rs.getInt("post_id"));
				dto.setTitle(rs.getString("title"));
				dto.setPostDate(rs.getString("post_date"));
				dto.setPostContent(rs.getString("post_content"));
				dto.setPostFile(rs.getString("post_file"));
				dto.setViews(rs.getString("views"));
				dto.setLikes(rs.getString("likes"));
				dto.setReports(rs.getString("reports"));
				dto.setEcoerId(rs.getString("ecoer_id"));
				dto.setCommunityId(rs.getInt("community_id"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public List<PostDTO> getPostListByKeyword(String keyword, String type) {
		String searchQuery = query + "FROM POST WHERE " + type + " LIKE '%" + keyword + "%' ORDER BY post_id";
		jdbcUtil.setSqlAndParameters(searchQuery, null);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<PostDTO> list = new ArrayList<>();
			while (rs.next()) {
				PostDTO dto = new PostDTO();
				dto.setPostId(rs.getInt("post_id"));
				dto.setTitle(rs.getString("title"));
				dto.setPostDate(rs.getString("post_date"));
				dto.setPostContent(rs.getString("post_content"));
				dto.setPostFile(rs.getString("post_file"));
				dto.setViews(rs.getString("views"));
				dto.setLikes(rs.getString("likes"));
				dto.setReports(rs.getString("reports"));
				dto.setEcoerId(rs.getString("ecoer_id"));
				dto.setCommunityId(rs.getInt("community_id"));
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

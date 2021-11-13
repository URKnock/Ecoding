// Java Project �� JDBCUtil
// DBCP2 ���� jar ������ ������Ʈ�� �����ؾ� ������
// commons-dbcp2-X.X.X.jar, commons-pool2-X.X.X.jar, commons-logging-X.X.jar
package model.dao;

import java.sql.*;

public class JDBCUtil {
	private static ConnectionManager connMan = new ConnectionManager();
	private String sql = null; // ������ query
	private Object[] parameters = null;; // PreparedStatement �� �Ű����� ���� �����ϴ� �迭
	private static Connection conn = null;
	private PreparedStatement pstmt = null;
	private CallableStatement cstmt = null;
	private ResultSet rs = null;
	private int resultSetType = ResultSet.TYPE_FORWARD_ONLY, resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;

	// �⺻ ������
	public JDBCUtil() {
	}

	/*
	 * // �Ű����� ���� query�� ���޹޾� query�� �����ϴ� ������ public JDBCUtil(String sql) {
	 * this.setSql(sql); }
	 * 
	 * // �Ű������� �迭�� �Բ� query�� ���޹޾� ������ �����ϴ� ������ public JDBCUtil(String sql, Object[]
	 * parameters) { this.setSql(sql); this.setParameters(parameters); }
	 * 
	 * // sql ���� setter public void setSql(String sql) { this.sql = sql; }
	 * 
	 * // Object[] ���� setter public void setParameters(Object[] parameters) {
	 * this.parameters = parameters; }
	 */

	// sql ���� getter
	public String getSql() {
		return this.sql;
	}

	// �Ű����� �迭���� Ư����ġ�� �Ű������� ��ȯ�ϴ� �޼ҵ�
	private Object getParameter(int index) throws Exception {
		if (index >= getParameterSize())
			throw new Exception("INDEX ���� �Ķ������ �������� �����ϴ�.");
		return parameters[index];
	}

	// �Ű������� ������ ��ȯ�ϴ� �޼ҵ�
	private int getParameterSize() {
		return parameters == null ? 0 : parameters.length;
	}

	// sql �� Object[] ���� setter
	public void setSqlAndParameters(String sql, Object[] parameters) {
		this.sql = sql;
		this.parameters = parameters;
		this.resultSetType = ResultSet.TYPE_FORWARD_ONLY;
		this.resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;
	}

	// sql �� Object[], resultSetType, resultSetConcurrency ���� setter
	public void setSqlAndParameters(String sql, Object[] parameters, int resultSetType, int resultSetConcurrency) {
		this.sql = sql;
		this.parameters = parameters;
		this.resultSetType = resultSetType;
		this.resultSetConcurrency = resultSetConcurrency;
	}

	// ������ PreparedStatement�� ��ȯ
	private PreparedStatement getPreparedStatement() throws SQLException {
		if (conn == null) {
			conn = connMan.getConnection();
			conn.setAutoCommit(false);
		}
		if (pstmt != null)
			pstmt.close();
		pstmt = conn.prepareStatement(sql, resultSetType, resultSetConcurrency);
		// JDBCUtil.printDataSourceStats(ds);
		return pstmt;
	}

	// JDBCUtil�� ������ �Ű������� �̿��� executeQuery�� �����ϴ� �޼ҵ�
	public ResultSet executeQuery() {
		try {
			pstmt = getPreparedStatement();
			for (int i = 0; i < getParameterSize(); i++) {
				pstmt.setObject(i + 1, getParameter(i));
			}
			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// JDBCUtil�� ������ �Ű������� �̿��� executeUpdate�� �����ϴ� �޼ҵ�
	public int executeUpdate() throws SQLException, Exception {
		pstmt = getPreparedStatement();
		int parameterSize = getParameterSize();
		for (int i = 0; i < parameterSize; i++) {
			if (getParameter(i) == null) { // �Ű����� ���� ���� �κ��� ���� ���
				pstmt.setString(i + 1, null);
			} else {
				pstmt.setObject(i + 1, getParameter(i));
			}
		}
		return pstmt.executeUpdate();
	}

	// ������ CallableStatement�� ��ȯ
	private CallableStatement getCallableStatement() throws SQLException {
		if (conn == null) {
			conn = connMan.getConnection();
			conn.setAutoCommit(false);
		}
		if (cstmt != null)
			cstmt.close();
		cstmt = conn.prepareCall(sql);
		return cstmt;
	}

	// JDBCUtil�� ������ �Ű������� �̿��� CallableStatement�� execute�� �����ϴ� �޼ҵ�
	public boolean execute(JDBCUtil source) throws SQLException, Exception {
		cstmt = getCallableStatement();
		for (int i = 0; i < source.getParameterSize(); i++) {
			cstmt.setObject(i + 1, source.getParameter(i));
		}
		return cstmt.execute();
	}

	// PK �÷� �̸� �迭�� �̿��Ͽ� PreparedStatement�� ���� (INSERT������ Sequence�� ���� PK ���� �����ϴ� ���)
	private PreparedStatement getPreparedStatement(String[] columnNames) throws SQLException {
		if (conn == null) {
			conn = connMan.getConnection();
			conn.setAutoCommit(false);
		}
		if (pstmt != null)
			pstmt.close();
		pstmt = conn.prepareStatement(sql, columnNames);
		return pstmt;
	}

	// �� �޼ҵ带 �̿��Ͽ� PreparedStatement�� ������ �� executeUpdate ����
	public int executeUpdate(String[] columnNames) throws SQLException, Exception {
		pstmt = getPreparedStatement(columnNames); // �� �޼ҵ带 ȣ��
		int parameterSize = getParameterSize();
		for (int i = 0; i < parameterSize; i++) {
			if (getParameter(i) == null) { // �Ű����� ���� ���� �κ��� ���� ���
				pstmt.setString(i + 1, null);
			} else {
				pstmt.setObject(i + 1, getParameter(i));
			}
		}
		return pstmt.executeUpdate();
	}

	// PK �÷��� ��(��)�� �����ϴ� ResultSet ��ü ���ϱ�
	public ResultSet getGeneratedKeys() {
		try {
			return pstmt.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// �ڿ� ��ȯ
	public void close() {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (cstmt != null) {
			try {
				cstmt.close();
				cstmt = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void commit() {
		try {
			conn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void rollback() {
		try {
			conn.rollback();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void shutdownPool() {
		this.close();
		connMan.close();
	}
	
	public void printDataSourceStats() {
		connMan.printDataSourceStats();
	}
}

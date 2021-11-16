package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Ecoer;
import model.dao.EcoerDAO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */
public class UserManager { //EcoerManager처럼 사용
	private static UserManager userMan = new UserManager();
	private EcoerDAO ecoerDAO;

	//private UserAnalysis userAanlysis; 사용 안 함

	private UserManager() {
		try {
			ecoerDAO = new EcoerDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	public int create(Ecoer ecoer) throws SQLException, ExistingUserException {
		if (ecoerDAO.existingEcoer(ecoer.getEcoerId()) == true) {
			throw new ExistingUserException(ecoer.getEcoerId() + "는 이미 존재합니다.");
		}
		return ecoerDAO.create(ecoer);
	}

	public int update(Ecoer ecoer) throws SQLException, UserNotFoundException {
		return ecoerDAO.update(ecoer);
	}	

	public int remove(String userId) throws SQLException, UserNotFoundException {
		return ecoerDAO.remove(userId);
	}

	public Ecoer findEcoer(String ecoerId)
		throws SQLException, UserNotFoundException {
		Ecoer ecoer = ecoerDAO.findEcoer(ecoerId);
		
		if (ecoer == null) {
			throw new UserNotFoundException(ecoerId + "를 찾을 수 없습니다.");
		}		
		return ecoer;
	}

	public List<Ecoer> findEcoerList() throws SQLException {
			return ecoerDAO.findEcoerList();
	}
	
	public List<Ecoer> findEcoerList(int currentPage, int countPerPage)
		throws SQLException {
		return ecoerDAO.findEcoerList(); //(currentPage, countPerPage); ==> Page는 쓰지않는지?
	}

	public boolean login(String ecoerId, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		Ecoer ecoer = findEcoer(ecoerId);

		if (!ecoer.matchPassword(password)) {
			throw new PasswordMismatchException("패스워드가 올바르지 않습니다.");
		}
		return true;
	}

	public EcoerDAO getEcoerDAO() {
		return this.ecoerDAO;
	}
}

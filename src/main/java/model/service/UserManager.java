package model.service;

import java.sql.SQLException;
import java.util.List;

import model.DAOFactory;
import model.dao.EcoerDAO;
import model.service.dto.EcoerDTO;
import model.service.dto.ReactDTO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */
public class UserManager { //EcoerManager처럼 사용
	private static UserManager userMan = new UserManager();
	private DAOFactory factory;
	private EcoerDAO ecoerDAO;

	//private UserAnalysis userAanlysis; 사용 안 함

	private UserManager() {
		try {
			factory = new DAOFactory();
			ecoerDAO = factory.getEcoerDAO(); //EcoerDAOImpl을 리턴
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	public int create(EcoerDTO ecoer) throws SQLException, ExistingUserException {
		if (ecoerDAO.existingEcoer(ecoer.getEcoerId()) == true) {
			throw new ExistingUserException(ecoer.getEcoerId() + "는 이미 존재합니다.");
		}
		return ecoerDAO.insert(ecoer);
	}

	public int update(EcoerDTO ecoer) throws SQLException, UserNotFoundException {
		return ecoerDAO.update(ecoer);
	}	

	public int remove(String userId) throws SQLException, UserNotFoundException {
		return ecoerDAO.delete(userId);
	}

	public EcoerDTO findEcoer(String ecoerId)
		throws SQLException, UserNotFoundException {
		EcoerDTO ecoer = ecoerDAO.findEcoer(ecoerId);
		
		if (ecoer == null) {
			throw new UserNotFoundException("UserManager: " + ecoerId + "를 찾을 수 없습니다.");
		}		
		return ecoer;
	}

	public List<EcoerDTO> getEcoerList() throws SQLException {
			return ecoerDAO.getEcoerList();
	}
	
	public List<EcoerDTO> getEcoerList(int currentPage, int countPerPage)
		throws SQLException {
		return ecoerDAO.getEcoerList(); //(currentPage, countPerPage); ==> Page는 쓰지않는지?
	}
	
	public ReactDTO getReactByEcoer(String ecoerId) {
		return ecoerDAO.getReactByEcoer(ecoerId);
	}

	public boolean login(String ecoerId, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		EcoerDTO ecoer = findEcoer(ecoerId);

		if (!ecoer.matchPassword(password)) {
			throw new PasswordMismatchException("패스워드가 올바르지 않습니다.");
		}
		ecoer.setReact(getReactByEcoer(ecoerId));
		return true;
	}

	public EcoerDAO getEcoerDAO() {
		return this.ecoerDAO;
	}
}

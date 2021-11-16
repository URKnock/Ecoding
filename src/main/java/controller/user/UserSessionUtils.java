package controller.user;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "ecoerId";

    /* ���� �α����� ������� ID�� ���� */
    public static String getLoginEcoerId(HttpSession session) {
        String ecoerId = (String)session.getAttribute(USER_SESSION_KEY);
        return ecoerId;
    }

    /* �α����� ���������� �˻� */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginEcoerId(session) != null) {
            return true;
        }
        return false;
    }

    /* ���� �α����� ������� ID�� ecoerId���� �˻� */
    public static boolean isLoginUser(String ecoerId, HttpSession session) {
        String loginEcoer = getLoginEcoerId(session);
        if (loginEcoer == null) {
            return false;
        }
        return loginEcoer.equals(ecoerId);
    }
}

package a_feb_27;

import java.util.ArrayList;

public class H_MemberService {
	private static H_MemberService service = new H_MemberService();

	private H_MemberService() {
	}

	public H_MemberService getInstance() {
		return service;
	}

	private ArrayList<H_Member> list = new ArrayList<>();

	public Boolean 아이디사용가능(String username) {
		for (H_Member m : list) {
			if (m.getUsername().equals(username) == true) {
				return false;
			}
		}
		return true;
	}

	public void 회원가입(H_Member member) {
		list.add(member);
	}

	public String 아이디찾기(String email) {
		for (H_Member m : list) {
			if (m.getEmail().equals(email) == true) {
				return m.getPassword();
			}
		}
		return null;
	}

	public Boolean login(String username, String password) {
		for (H_Member m : list) {
			if (m.getUsername().equals(username) == true && m.getPassword().equals(password) == true) {
				return true;
			}
		}
		return false;
	}

	public Boolean changePassword(String password, String newPassword) {
		for (H_Member m : list) {
			if (m.getPassword().equals(password) == true) {
				m.setPassword(newPassword);
				return true;
			}
		}
		return false;
	}
}
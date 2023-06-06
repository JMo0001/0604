package exception;

public class PasswordTest {
	private String userPW;
	
	public String getUserPW() {
		return userPW;
	}
	
	public void setUserPW(String userPW) throws PasswordException {
		if(userPW==null) {
			throw new PasswordException("비밀번호는 null일 수 없습니다.");
		}else if(userPW.length()<5) {
			throw new PasswordException("비밀번호는 5자 이상이어야 합니다.");
			
		}else if(userPW.matches("[a-zA-A]+")) {
			throw new PasswordException("비밀번호는 문자열로만 만들어질수 없습니다.");
		}
		this.userPW=userPW;
	}
	

	public static void main(String[] args) {
		PasswordTest test = new PasswordTest();

		String userPW = null;
		try {
			test.setUserPW(userPW);
		}catch(PasswordException e) {
			System.out.println(e.getMessage());
		}
		
		String usrPW = "AAAAAEE";
		try {
			test.setUserPW(userPW);
		} catch (PasswordException e) {
			System.out.println(e.getMessage());
		}
		
		userPW = "1234";
		try {
			test.setUserPW(userPW);
		}catch(PasswordException e) {
			System.out.println(e.getMessage());
		}
	
	}

}

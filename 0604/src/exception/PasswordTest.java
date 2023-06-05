package exception;

public class PasswordTest {
	private String userPW;
	
	public String getUserPW() {
		return userPW;
	}
	
	public void setUserPW(String userPW) throws PasswordException {
		if(userPW==null) {
			throw new PasswordException("비밀번호는 null일 수 없습니다.")
		}else if(userPW<5||)
		
	}
	

	public static void main(String[] args) {

	}

}

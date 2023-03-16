package board.entity;

// 좋아요

// 좋아요한 사용자 이메일(문자열) /
// 좋아요한 사용자 프로필 사진(문자열) / 
// 좋아요한 사용자 닉네임(문자열)
public class Like {
	
	private String userEmail;
	private String userProfileImageUrl;
	private String userNickname;
	
	public Like() {}

	public Like(String userEmail, String userProfileImageUrl, String userNickname) {
		super();
		this.userEmail = userEmail;
		this.userProfileImageUrl = userProfileImageUrl;
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserProfileImageUrl() {
		return userProfileImageUrl;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserProfileImageUrl(String userProfileImageUrl) {
		this.userProfileImageUrl = userProfileImageUrl;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	@Override //재정의
	public String toString() {
		return "Like [userEmail=" + userEmail + ", userProfileImageUrl=" + userProfileImageUrl + ", userNickname="
				+ userNickname + "]";
	}
	
}

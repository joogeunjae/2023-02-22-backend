package board.dto.response.board;

import java.util.List;

import board.entity.Board;
import board.entity.Comment;
import board.entity.Like;

public class GetBoardResponseDto {
	
		//화면상 보여지는 것들
		private int boardNumber;
		private String title;
		private String content;
		private String boardImageUrl;
		private String writerEmail;
		private String writerProfileImageUrl;
		private String writerNickname;
		private String writerDate;
		private int likeCount;
		private List<Like> likeList;
		private int CommentCount;
		private List<Comment> commentList;
		
		public GetBoardResponseDto() {}

		
		public GetBoardResponseDto(int boardNumber, String title, String content, String boardImageUrl,
				String writerEmail, String writerProfileImageUrl, String writerNickname, String writerDate,
				int likeCount, List<Like> likeList, int commentCount, List<Comment> commentList) {
			this.boardNumber = boardNumber;
			this.title = title;
			this.content = content;
			this.boardImageUrl = boardImageUrl;
			this.writerEmail = writerEmail;
			this.writerProfileImageUrl = writerProfileImageUrl;
			this.writerNickname = writerNickname;
			this.writerDate = writerDate;
			this.likeCount = likeCount;
			this.likeList = likeList;
			CommentCount = commentCount;
			this.commentList = commentList;
		}


		public GetBoardResponseDto(Board board) {
			this.boardNumber = board.getBoardNumber();
			this.title = board.getTitle();
			this.content = board.getContent();
			this.boardImageUrl = board.getBoardImageUrl();
			this.writerEmail = board.getWriterEmail();
			this.writerProfileImageUrl = board.getWriterProfileImageUrl();
			this.writerNickname = board.getWriterNickname();
			this.writerDate = board.getWriterDate();
			this.likeCount = board.getLikeList().size();
			this.likeList = board.getLikeList();
			CommentCount = board.getCommentList().size();
			this.commentList = board.getCommentList();
		}


		public int getBoardNumber() {
			return boardNumber;
		}


		public String getTitle() {
			return title;
		}


		public String getContent() {
			return content;
		}


		public String getBoardImageUrl() {
			return boardImageUrl;
		}


		public String getWriterEmail() {
			return writerEmail;
		}


		public String getWriterProfileImageUrl() {
			return writerProfileImageUrl;
		}


		public String getWriterNickname() {
			return writerNickname;
		}


		public String getWriterDate() {
			return writerDate;
		}


		public int getLikeCount() {
			return likeCount;
		}


		public List<Like> getLikeList() {
			return likeList;
		}


		public int getCommentCount() {
			return CommentCount;
		}


		public List<Comment> getCommentList() {
			return commentList;
		}


		public void setBoardNumber(int boardNumber) {
			this.boardNumber = boardNumber;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public void setContent(String content) {
			this.content = content;
		}


		public void setBoardImageUrl(String boardImageUrl) {
			this.boardImageUrl = boardImageUrl;
		}


		public void setWriterEmail(String writerEmail) {
			this.writerEmail = writerEmail;
		}


		public void setWriterProfileImageUrl(String writerProfileImageUrl) {
			this.writerProfileImageUrl = writerProfileImageUrl;
		}


		public void setWriterNickname(String writerNickname) {
			this.writerNickname = writerNickname;
		}


		public void setWriterDate(String writerDate) {
			this.writerDate = writerDate;
		}


		public void setLikeCount(int likeCount) {
			this.likeCount = likeCount;
		}


		public void setLikeList(List<Like> likeList) {
			this.likeList = likeList;
		}


		public void setCommentCount(int commentCount) {
			CommentCount = commentCount;
		}


		public void setCommentList(List<Comment> commentList) {
			this.commentList = commentList;
		}


		@Override
		public String toString() {
			return "GetBoardResponseDto [boardNumber=" + boardNumber + ", title=" + title + ", content=" + content
					+ ", boardImageUrl=" + boardImageUrl + ", writerEmail=" + writerEmail + ", writerProfileImageUrl="
					+ writerProfileImageUrl + ", writerNickname=" + writerNickname + ", writerDate=" + writerDate
					+ ", likeCount=" + likeCount + ", likeList=" + likeList + ", CommentCount=" + CommentCount
					+ ", commentList=" + commentList + "]";
		}
		
		
}

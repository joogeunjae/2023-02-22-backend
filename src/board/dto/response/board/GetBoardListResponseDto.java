package board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import board.entity.Board;

public class GetBoardListResponseDto {
	
	private int boardNumber;
	private String writerPofileImageUrl;
	private String writerNickname;
	private String writerDate;
	private String title;
	private String content;
	private String boardImageUrl;
	private int commentCount;
	private int likeCount;
	private int viewCount;
	
	public GetBoardListResponseDto() {}

	public GetBoardListResponseDto(int boardNumber, String writerPofileImageUrl, String writerNickname,
			String writerDate, String title, String content, String boardImageUrl, int commentCount, int likeCount,
			int viewCount) {
		this.boardNumber = boardNumber;
		this.writerPofileImageUrl = writerPofileImageUrl;
		this.writerNickname = writerNickname;
		this.writerDate = writerDate;
		this.title = title;
		this.content = content;
		this.boardImageUrl = boardImageUrl;
		this.commentCount = commentCount;
		this.likeCount = likeCount;
		this.viewCount = viewCount;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public String getWriterPofileImageUrl() {
		return writerPofileImageUrl;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public String getWriterDate() {
		return writerDate;
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

	public int getCommentCount() {
		return commentCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public int getViewCount() {
		return viewCount;
	}
	
	public void GetBoardListReponseDto(Board board) {
		this.boardNumber = board.getBoardNumber();
		this.writerPofileImageUrl = board.getWriterProfileImageUrl();
		this.writerNickname = board.getWriterNickname();
		this.writerDate = board.getWriterDate();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.boardImageUrl = board.getBoardImageUrl();
		this.commentCount = board.getCommentList().size();
		this.likeCount = board.getLikeList().size();
		this.viewCount = board.getViewCount();
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public void setWriterPofileImageUrl(String writerPofileImageUrl) {
		this.writerPofileImageUrl = writerPofileImageUrl;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	public void setWriterDate(String writerDate) {
		this.writerDate = writerDate;
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

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "GetBoardListResponseDto [boardNumber=" + boardNumber + ", writerPofileImageUrl=" + writerPofileImageUrl
				+ ", writerNickname=" + writerNickname + ", writerDate=" + writerDate + ", title=" + title
				+ ", content=" + content + ", boardImageUrl=" + boardImageUrl + ", commentCount=" + commentCount
				+ ", likeCount=" + likeCount + ", viewCount=" + viewCount + "]";
	}
	
	public static List<GetBoardListResponseDto> copyList(List<Board> boardList) {
		List<GetBoardListResponseDto> result = new ArrayList<>();
		
		for(Board board: boardList) {
			GetBoardListResponseDto item = new GetBoardListResponseDto();
			result.add(item);
		}
		return result;
	}
	
}

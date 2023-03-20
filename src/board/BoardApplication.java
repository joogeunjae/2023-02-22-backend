package board;

import java.util.Scanner;

import board.common.constant.HttpStatus;
import board.controller.BoardController;
import board.controller.UserController;
import board.dto.request.board.PostBoardDto;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;

public class BoardApplication {

	private static UserController userController = new UserController();
	private static BoardController boardController = new BoardController();
	
	
	private static final String SIGN_UP = "POST /sign-up";
	private static final String SIGN_IN = "POST /sign-in";
	
	private static final String POST_BOARD = "POST /board";
	
	private static final String GET_BOARD = "GET /board";
	private static final String GET_BOARD_LIST = "GET /board/list";
	
	private static final String PATCH_BOARD = "PATCH /board";
	
	private static final String DELETE_BOARD = "DELETE /board";
	
	
	public static void main(String[] args) {
		
		while(true) {	
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("URL End point :");
			String endPoint = scanner.nextLine();
			
			switch(endPoint) {
			
			case SIGN_UP:
				SignUpDto signUpDto = new SignUpDto();
				System.out.print("이메일 :");
				signUpDto.setEmail(scanner.nextLine());
				System.out.print("비밀번호 :");
				signUpDto.setPassword(scanner.nextLine());
				System.out.print("비밀번호 확인 :");
				signUpDto.setPasswordCheck(scanner.nextLine());
				System.out.print("닉네임 :");
				signUpDto.setNickname(scanner.nextLine());
				System.out.print("휴대전화 번호 :");
				signUpDto.setPhoneNumber(scanner.nextLine());
				System.out.print("주소 :");
				signUpDto.setAddress(scanner.nextLine());
				System.out.print("상세주소 주소 :");
				signUpDto.setAddressDetail(scanner.nextLine());

				//System.out.println(signUpDto.toString()); 잘받아 와지는지 검증
				
				userController.signUp(signUpDto);
				break;
			
			case SIGN_IN:
				SignInDto signInDto = new SignInDto();
				System.out.println("이메일 :");
				signInDto.setEmail(scanner.nextLine());
				System.out.println("비밀번호 :");
				signInDto.setPassword(scanner.nextLine());
				
//				System.out.println(signInDto.toString());
				
				userController.signIn(signInDto);
				break;
				
			case POST_BOARD:
				PostBoardDto postBoardDto = new PostBoardDto();
				System.out.print("제목 :");
				postBoardDto.setTitle(scanner.nextLine());
				System.out.print("내용 :");
				postBoardDto.setContent(scanner.nextLine());;
				System.out.print("이미지 :");
				postBoardDto.setBoardImageUrl(scanner.nextLine());
				System.out.print("작성자 이메일 :");
				postBoardDto.setWriterEmail(scanner.nextLine());
				
				boardController.postBoard(postBoardDto);
				break;
				
			// 사용자한테서 전체 리스트를 받아오기
			case GET_BOARD_LIST:
				boardController.getBoardList();
				break;
				
			case GET_BOARD:
				
				int boardNumber =0;
				
				try {
					System.out.print("게시물 번호 :");
					boardNumber = scanner.nextInt();
				} catch (Exception exception) {
					exception.printStackTrace();
					continue;
				}
				// 선언을 했는데 boardNumber가 빨간줄이 끄이는 이유는 try catch로 묶어놨기 때문
				// boardNumber를 try catch 밖에다 선언
				boardController.getBoard(boardNumber);
				
			default:
				System.out.println(HttpStatus.NOT_FOUND);
			}	
		}
	}
}

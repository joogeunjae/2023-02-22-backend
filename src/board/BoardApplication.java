package board;

import java.util.Scanner;

import board.common.constant.HttpStatus;
import board.controller.BoardController;
import board.controller.UserController;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;

public class BoardApplication {

	private static UserController userController = new UserController();
	private static BoardController boardController = new BoardController();
	
	
	private static final String SIGN_UP = "POST / sign-up";
	private static final String SIGN_IN = "POST / sign-in";
	
	public static void main(String[] args) {
		
		while(true) {	
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("URL End point :");
			String endPoint = scanner.nextLine();
			
			switch(endPoint) {
			
			case SIGN_UP:
				SignUpDto signUpDto = new SignUpDto();
				System.out.print("�̸��� :");
				signUpDto.setEmail(scanner.nextLine());
				System.out.print("��й�ȣ :");
				signUpDto.setPassword(scanner.nextLine());
				System.out.print("��й�ȣ Ȯ�� :");
				signUpDto.setPasswordCheck(scanner.nextLine());
				System.out.print("�г��� :");
				signUpDto.setNickname(scanner.nextLine());
				System.out.print("�޴���ȭ ��ȣ :");
				signUpDto.setPhoneNumber(scanner.nextLine());
				System.out.print("�ּ� :");
				signUpDto.setAddress(scanner.nextLine());
				System.out.print("���ּ� �ּ� :");
				signUpDto.setAddressDetail(scanner.nextLine());

				//System.out.println(signUpDto.toString()); �߹޾� �������� ����
				
				userController.signUp(signUpDto);
				break;
			
			case SIGN_IN:
				SignInDto signInDto = new SignInDto();
				System.out.println("�̸��� :");
				signInDto.setEmail(scanner.nextLine());
				System.out.println("��й�ȣ :");
				signInDto.setPassword(scanner.nextLine());
				
//				System.out.println(signInDto.toString());
				
				userController.signIn(signInDto);
				break;
			default:
				System.out.println(HttpStatus.NOT_FOUND);
			}	
		}
	}
}

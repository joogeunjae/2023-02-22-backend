package trainReservation.dto;

import java.util.Scanner;

public class GetReservationDto {
	
	private String reservationNumber;
	
	public GetReservationDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("예약 번호 :");
		this.reservationNumber = scanner.nextLine();
	}

	public GetReservationDto(String reservationNumber) { // 생성 할 때만 사용할 수 있고
		this.reservationNumber = reservationNumber;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {// 생성 후 사용할 수 있다.
		this.reservationNumber = reservationNumber;
	}

	@Override
	public String toString() {
		return "GetReservationDto [reservationNumber=" + reservationNumber + "]";
	}
	
}

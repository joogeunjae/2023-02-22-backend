package trainReservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Train;
import trainReservation.service.ReservationService;

//Controller class (����)
//����ڷκ��� �Է¹޴� ��� / �Է¹��� �����͸� ���� ��� / ����Ͻ� ������ ����� ��ȯ
public class ReservationController {
	
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	private ReservationService reservationService;
	
	public ReservationController() {
		this.reservationService = new ReservationService();
	}
	
	public void reservation() {
		while (true) {
			GetTrainListDto getTrainListDto = new GetTrainListDto();
			
			LocalTime departureTime = null;
			
			if (getTrainListDto.isEmpty()) {
				System.out.println("��� �Է��ϼ���.");
				continue;
			}
			
			try {
				departureTime = LocalTime.parse(getTrainListDto.getDepartureTime(), timeFormatter);
			} catch(Exception exception) {
				System.out.println("�߸��� �ð��Դϴ�.");
				continue;
			}
			
			if (getTrainListDto.getNumberOfPeople() <= 0) {
				System.out.println("�߸��� �ο��Դϴ�.");
				continue;
			}
			
			if (getTrainListDto.isEqualStation()) {
				System.out.println("��߿��� �������� �����ϴ�.");
				continue;
			}
			
			List<Train> possibleTrains = reservationService.getPossibleTrainList(getTrainListDto, departureTime);
			
			System.out.println(possibleTrains.toString());
			
			
			
			ReservationInfo reservationInfo = null;
			while (true) {
				
				PostReservationDto postReservationDto = new PostReservationDto(getTrainListDto.getNumberOfPeople());
				reservationInfo = reservationService.postReservation(postReservationDto, getTrainListDto);
				if (reservationInfo == null) continue;
				break;
				
			}
			System.out.println(reservationInfo.toString());
			
			
		}
	}

}

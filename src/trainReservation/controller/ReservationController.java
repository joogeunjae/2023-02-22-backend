package trainReservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import trainReservation.dto.GetReservationDto;
import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Train;
import trainReservation.service.ReservationService;

//Controller class (����)
//����ڷκ��� �Է¹޴� ��� / �Է¹��� �����͸� ���� ��� / ����Ͻ� ������ ����� ��ȯ
public class ReservationController {
																		//H = �ð� m = ��
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	private ReservationService reservationService;
	
	private GetTrainListDto getTrainListDto;
	private GetReservationDto getReservationDto;
	private PostReservationDto postReservationDto;
	
	public ReservationController() {
		this.reservationService = new ReservationService();
	}
	
	public void reservation() {
		while (true) {
			getTrainListDto = new GetTrainListDto();
			
			LocalTime departureTime = null;
			
			if (getTrainListDto.isEmpty()) {
				System.out.println("��� �Է��ϼ���.");
				continue;
			}
											//20230318, 2023-03-18, 23-08-18, 2023-03-18 07:18:15
																			//yyyy-MM-dd HH:mm:ss
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
			//������(������Ƽ�� Ÿ��) �׳� Stack�� ����
			//������(���۷��� Ÿ��) ���� �ּҸ� ������ ����
			List<Train> possibleTrains = reservationService.getPossibleTrainList(getTrainListDto, departureTime);
			
			System.out.println(possibleTrains);
			
			postReservation();
			break;
		}
	}
	
	public void postReservation() {
		while (true) {
			
			postReservationDto = new PostReservationDto(getTrainListDto.getNumberOfPeople());
			ReservationInfo reservationInfo = reservationService.postReservation(postReservationDto, getTrainListDto);
			if (reservationInfo == null) continue;
			System.out.println(reservationInfo.toString());
			break;
		}
		
	}
	
	public void getReservation() { 
		
		while(true) {
			
			getReservationDto = new GetReservationDto();
			String reservationNumber = getReservationDto.getReservationNumber();
			
			if(reservationNumber.isBlank()) {
				System.out.println("�����ȣ�� �Է� �ϼ���.");
				continue;
			}
			
			ReservationInfo reservationInfo = reservationService.getReservation(getReservationDto);
			
			String message = reservationInfo == null ? "�ش��ϴ� �����ȣ�� �����ϴ�."
													 : reservationInfo.toString();
			System.out.println(message);
			break;
		}
		
	}


}

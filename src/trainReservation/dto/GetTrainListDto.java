package trainReservation.dto;

import java.util.Scanner;

// DTO : Data Transfer Object
// ���̾ �����͸� ������ �� ����ϴ� ��ü

public class GetTrainListDto {

	private String departureStation;
	private String arrivalStation;
	private String departureTime;
	private int numberOfPeople;
	
	public GetTrainListDto() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("��߿� : ");
		this.departureStation = scanner.nextLine();
		System.out.print("������ : ");
		this.arrivalStation = scanner.nextLine();
		System.out.print("��� �ð� : ");
		this.departureTime = scanner.nextLine();
		System.out.print("�ο� : ");
		this.numberOfPeople = scanner.nextInt();
	}

	public GetTrainListDto(String departureStation, String arrivalStation, String departureTime, int numberOfPeople) {
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.departureTime = departureTime;
		this.numberOfPeople = numberOfPeople;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	@Override
	public String toString() {
		return "GetTrainListDto [departureStation=" + departureStation + ", arrivalStation=" + arrivalStation
				+ ", departureTime=" + departureTime + ", numberOfPeople=" + numberOfPeople + "]";
	}
	
	public boolean isEmpty() {
		return this.departureStation.isBlank() ||
				this.arrivalStation.isBlank() ||
				this.departureTime.isBlank();
	}
	
	public boolean isEqualStation() {
		return this.departureStation.equals(this.arrivalStation);
	}
	
	public boolean isEqualDepartureStation(String station) {
		return this.departureStation.equals(station);
	}
	
	public boolean isEqualArrivalStation(String station) {
		return this.arrivalStation.equals(station);
	}
}

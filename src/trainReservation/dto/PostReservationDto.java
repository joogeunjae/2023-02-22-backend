package trainReservation.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostReservationDto {
	
	private String trainNumber;
	private List<String> steats;
	
	public PostReservationDto(int numberOfPeople) {
		
		Scanner scanner = new Scanner(System.in);
		this.steats = new ArrayList<>();
		
		while (true) {
			System.out.println("ž���� ���� ��ȣ : ");
			this.trainNumber = scanner.nextLine();
			
			if (this.trainNumber.isBlank()) {
				System.out.println("���� ��ȣ�� �Է��ϼ���.");
				continue;
			} 
			break;
		}
		
		while (this.steats.size() < numberOfPeople) {
			System.out.println("�¼� ��ȣ : ");
			String seat = scanner.nextLine();
			
			if (seat.isBlank()) {
				System.out.println("�¼� ��ȣ�� �Է��ϼ���.");
				continue;
			}
			this.steats.add(seat);
		}
		
	}

	public PostReservationDto(String trainNumber, List<String> steats) {
		this.trainNumber = trainNumber;
		this.steats = steats;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public List<String> getSteats() {
		return steats;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public void setSteats(List<String> steats) {
		this.steats = steats;
	}

	@Override
	public String toString() {
		return "PostReservationDto [trainNumber=" + trainNumber + ", steats=" + steats + "]";
	}
	
	public boolean isEqualTrainNumber(String trainNumber) {
		return this.trainNumber.equals(trainNumber);
	}
	
}

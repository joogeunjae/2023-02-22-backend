package trainReservation.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.Cost;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Seat;
import trainReservation.entity.StopStation;
import trainReservation.entity.Train;

// Service class(����)
// ���� �����Ͻ� ���� ���


public class ReservationService {
	
	private static List<Train> trains = new ArrayList<>();
	private static List<Cost> costs = new ArrayList<>();
	private static List<ReservationInfo> reservations = new ArrayList<>();

	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	public ReservationService() {
		initData();
	}

	public List<Train> getPossibleTrainList(GetTrainListDto dto, LocalTime departureTime) {
		
		List<Train> possibleTrains = new ArrayList<>();
		
		for (Train train: trains) {
			
			List<StopStation> stopStations = train.getStopStations();
			int sameStationIndex = -1;
			
			for (int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex++) {
				StopStation stopStation = stopStations.get(stopStationIndex);
				String stopStationName = stopStation.getStationName();
				
				if (!dto.isEqualDepartureStation(stopStationName)) continue;
				
				LocalTime stationDepartureTime = LocalTime.parse(stopStation.getDepartureTime(), timeFormatter);
				
				if (stationDepartureTime.isBefore(departureTime)) break;
				
				sameStationIndex = stopStationIndex;
				break;
			}
			
			if (sameStationIndex == -1) continue;
			
			boolean isPossible = false;
			
			for (int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex++) {
				String stationName = stopStations.get(stopStationIndex).getStationName();
				
				if (!dto.isEqualArrivalStation(stationName)) continue;
				
				if (stopStationIndex <= sameStationIndex) break;
				
				isPossible = true;
				break;
			}
			
			if (!isPossible) continue;
			
			List<Seat> seats = train.getSeats();
			int possibleSeatCount = 0;
			
			for (Seat seat: seats) if (!seat.isSeatStatus()) possibleSeatCount++;
			
			if (possibleSeatCount < dto.getNumberOfPeople()) continue;
			
			possibleTrains.add(train);
			
		}
		
		return possibleTrains;
		
	}
	
	public ReservationInfo postReservation(PostReservationDto postReservationDto, GetTrainListDto getTrainListDto) {
		
		Train train = null;
		for (Train trainItem: trains)
			if (postReservationDto.isEqualTrainNumber(trainItem.getTrainNumber())) {
				train = trainItem;
				break;
			}
		
		if (train == null) {
			System.out.println("�������� �ʴ� ���� ��ȣ�Դϴ�.");
			return null;
		}
		
		boolean designationState = true;
		List<Seat> seats = train.getSeats();
		List<String> inputSeatNumbers = postReservationDto.getSteats();
		
		for (int index = 0; index < seats.size(); index++) {
			Seat seat = seats.get(index);
			for (String seatNumber: inputSeatNumbers) {
				if (!seat.getSeatNumber().equals(seatNumber)) continue;
				if (seat.isSeatStatus()) {
					designationState = false;
					break;
				}
				seat.setSeatStatus(true);
				break;
			}
			if (!designationState) break;
		}
		
		if (!designationState) {
			System.out.println("�¼� ������ �����߽��ϴ�.");
			return null;
		}
		
		int totalCost = 0;
		for (Cost cost: costs) {
			boolean isEqualDepartureStation = 
					getTrainListDto.isEqualDepartureStation(cost.getDepartureStation());
			boolean isEqualArrivalStation =
					getTrainListDto.isEqualArrivalStation(cost.getArrivalStation());
			
			if (!isEqualDepartureStation || !isEqualArrivalStation) continue;
			totalCost = cost.getAmount() * getTrainListDto.getNumberOfPeople();
			break;
		}
		
		String departureTime = "";
		String arrivalTime = "";
		
		for (StopStation stopStation: train.getStopStations()) {
			boolean isEqualDepartureStation =
					getTrainListDto.isEqualDepartureStation(stopStation.getStationName());
			boolean isEqualArrivalStation = 
					getTrainListDto.isEqualArrivalStation(stopStation.getStationName());
			
			if (isEqualDepartureStation) departureTime = stopStation.getDepartureTime();
			if (isEqualArrivalStation) arrivalTime = stopStation.getArrivalTime();
		}
		
		ReservationInfo reservationInfo = new ReservationInfo(
				postReservationDto.getTrainNumber(),
				postReservationDto.getSteats(),
				getTrainListDto.getDepartureStation(),
				departureTime,
				getTrainListDto.getArrivalStation(),
				arrivalTime,
				totalCost
		);
		
		reservations.add(reservationInfo);

		return reservationInfo;
		
	}
	
	private static void initData() {
		
		costs.add(new Cost("�λ꿪", "���￪", 30000));
		costs.add(new Cost("�λ꿪", "������", 20000));
		costs.add(new Cost("�λ꿪", "�뱸��", 10000));
		costs.add(new Cost("�뱸��", "���￪", 20000));
		costs.add(new Cost("�뱸��", "������", 10000));
		costs.add(new Cost("������", "���￪", 10000));

		costs.add(new Cost("���￪", "�λ꿪", 30000));
		costs.add(new Cost("���￪", "�뱸��", 20000));
		costs.add(new Cost("���￪", "������", 10000));
		costs.add(new Cost("������", "�λ꿪", 20000));
		costs.add(new Cost("������", "�뱸��", 10000));
		costs.add(new Cost("�뱸��", "�λ꿪", 10000));
		
		Train train;
		
		List<Seat> seats = new ArrayList<>();
		List<StopStation> stopStations = new ArrayList<>();
		
		seats.add(new Seat(1, "A1", false));
		seats.add(new Seat(1, "B1", false));
		seats.add(new Seat(1, "A2", false));
		seats.add(new Seat(1, "B2", false));
		seats.add(new Seat(2, "A1", false));
		seats.add(new Seat(2, "B1", false));
		seats.add(new Seat(2, "A2", false));
		seats.add(new Seat(2, "B2", false));
		seats.add(new Seat(3, "A1", false));
		seats.add(new Seat(3, "B1", false));
		seats.add(new Seat(3, "A2", false));
		seats.add(new Seat(3, "B2", false));
		
		stopStations.add(new StopStation("���￪", "", "06:00"));
		stopStations.add(new StopStation("������", "06:45", "07:00"));
		stopStations.add(new StopStation("�뱸��", "07:45", "08:00"));
		stopStations.add(new StopStation("�λ꿪", "09:00", ""));
		
		train = new Train("KTX001", "���￪", "06:00", "�λ꿪", "9:00", 180, "KTX", stopStations, seats);
		trains.add(train);
		
		seats = new ArrayList<>();
		stopStations = new ArrayList<>();
		
		seats.add(new Seat(1, "A1", false));
		seats.add(new Seat(1, "B1", false));
		seats.add(new Seat(1, "A2", false));
		seats.add(new Seat(1, "B2", false));
		seats.add(new Seat(2, "A1", false));
		seats.add(new Seat(2, "B1", false));
		seats.add(new Seat(2, "A2", false));
		seats.add(new Seat(2, "B2", false));
		seats.add(new Seat(3, "A1", false));
		seats.add(new Seat(3, "B1", false));
		seats.add(new Seat(3, "A2", false));
		seats.add(new Seat(3, "B2", false));
		
		stopStations.add(new StopStation("�λ꿪", "", "09:00"));
		stopStations.add(new StopStation("�뱸��", "09:45", "10:00"));
		stopStations.add(new StopStation("������", "10:45", "11:00"));
		stopStations.add(new StopStation("���￪", "12:00", ""));
		
		train = new Train("KTX002", "�λ�", "09:00", "���￪", "12:00", 180, "KTX", stopStations, seats);
		trains.add(train);
	}
}

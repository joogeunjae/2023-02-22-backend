package trainReservation.entity;

// ������ Entity class
public class StopStation {
	private String stationName;
	private String departureTime;
	private String arrivalTime;
	
	public StopStation() {}

	public StopStation(String stationName, String arrivalTime, String departureTime) {
		super();
		this.stationName = stationName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getStationName() {
		return stationName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	@Override
	public String toString() {
		return "StopStation [stationName=" + stationName + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}
	
	
}

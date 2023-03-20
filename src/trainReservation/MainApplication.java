package trainReservation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import trainReservation.controller.ReservationController;
import trainReservation.dto.GetTrainListDto;
import trainReservation.entity.Cost;
import trainReservation.entity.Seat;
import trainReservation.entity.StopStation;
import trainReservation.entity.Train;
import trainReservation.service.ReservationService;

public class MainApplication {
	
		private static ReservationController reservationController = new ReservationController();
		
		public static void main(String[] args) {
			
			while(true) {
				Scanner scanner = new Scanner(System.in);
				String endPoint = scanner.nextLine();
				
				//POST GET UPDATE DELETE = RestAPI
				if(endPoint.equals("POST / reservation")) {
				reservationController.reservation();
				}
				if(endPoint.equals("GET / reservation")) {
				reservationController.getReservation();
				}
				
			}
			
			
		}


}
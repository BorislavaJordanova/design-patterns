package observer;

public class ObserverMain {

	public static void main(String[] args) {


		Flight flight = new Flight("LO633");
		
		Observer obs1 = new Passenger("Ivan");
		Observer obs2 = new Passenger("Dimitur");
		Observer obs3 = new Passenger("Stefan");
		
		flight.subscribe(obs1);
		flight.subscribe(obs2);
		flight.subscribe(obs3);
		
		flight.setFlightStatus("Expected");
		
		flight.setFlightStatus("Landed");
		
		flight.setFlightStatus("Check-in");
		
		flight.setFlightStatus("Departed");

	}

}

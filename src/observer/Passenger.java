package observer;

public class Passenger implements Observer {

	private String name;
	private Observable flight;
	
	
	public Passenger(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		if(this.flight == null) {
			System.out.println(this.getName() + " has no flight set");
			return;
		}
		String flightStatus = this.flight.getUpdate();
		System.out.println(this.getName() + " received an update for flight " + this.flight.getFlightNumber() + ": " + flightStatus);
	}

	@Override
	public void setFlight(Observable flight) {
		this.flight = flight;
	}

	public String getName() {
		return name;
	}

}

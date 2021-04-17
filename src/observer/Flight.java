package observer;

import java.util.ArrayList;
import java.util.List;

public class Flight implements Observable {

	private List<Observer> observers;
	private String flightStatus;
	private String flightNumber;
	
	public Flight(String flightNumber) {
		this.observers = new ArrayList<>();
		this.flightNumber = flightNumber;
	}

	@Override
	public void subscribe(Observer observer) {
		this.observers.add(observer);
		observer.setFlight(this);
	}

	@Override
	public void unsubscribe(Observer observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: this.observers) {
			observer.update();
		}
	}

	@Override
	public String getUpdate() {
		return this.flightStatus;
	}
	
	@Override
	public String getFlightNumber() {
		return this.flightNumber;
	}
	
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
		this.notifyObservers();
	}

}

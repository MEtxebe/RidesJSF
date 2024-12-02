package eredua.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Ride;
import exceptions.RideAlreadyExistException;
import exceptions.RideMustBeLaterThanTodayException;

public class queryBean {
	private FacadeBean facade= new FacadeBean();
	
	private String departCity;
	private static List<String> departCities = new ArrayList<String>();
	
	private String arrivalCity;
	private static List<String> arrivalCities = new ArrayList<String>();;
	
	private Integer numberOfSeats;
	private float price;

	private Date date;
	
	
	private static List<Ride> ibilaldiak=new ArrayList<Ride>();
	
	public queryBean(){
		//Create rides
		   Calendar today = Calendar.getInstance();
		   
		   int month=today.get(Calendar.MONTH);
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=1; year+=1;}  
		   
		ibilaldiak.add(new Ride("Donostia", "Bilbo", UtilDate.newDate(year,month,15), 4, 7, null));
		ibilaldiak.add(new Ride("Donostia", "Gazteiz", UtilDate.newDate(year,month,6), 4, 8, null));
		ibilaldiak.add(new Ride("Bilbo", "Donostia", UtilDate.newDate(year,month,25), 4, 4, null));
		
		departCities.add("Donostia");
		departCities.add("Gasteiz");
		arrivalCities.add("Bilbo");
		arrivalCities.add("Barcelona");
	}

	// Método para crear el viaje
    public String createRide() throws RideMustBeLaterThanTodayException, RideAlreadyExistException {
    	BLFacade blf= facade.getBusinessLogic();
    	blf.createRide(this.departCity, this.arrivalCity, this.date, this.numberOfSeats, this.price, "Unregistered User");
        return "confirmation.xhtml"; 
    }
	
    public String getDepartCity() {
		return departCity;
	}
	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public static List<String> getArrivalCities() {
		return arrivalCities;
	}

	public static void setArrivalCities(List<String> arrivalCities) {
		queryBean.arrivalCities = arrivalCities;
	}

	public static List<Ride> getIbilaldiak() {
		return ibilaldiak;
	}

	public static void setIbilaldiak(List<Ride> ibilaldiak) {
		queryBean.ibilaldiak = ibilaldiak;
	}

	public FacadeBean getFacade() {
		return facade;
	}

	public void setFacade(FacadeBean facade) {
		this.facade = facade;
	}

	public static List<String> getDepartCities() {
		return departCities;
	}

	public static void setDepartCities(List<String> departCities) {
		queryBean.departCities = departCities;
	}
	
	

}
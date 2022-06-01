package myVelib;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class representing the whole system
 * @author jehandebryas
 *
 */

public class MyVelib {

	private Map<UUID,Station> stations;
	private Map<UUID,Bicycle> bicycles;
	private Map<UUID,User> users;
	private double side;
	private Statistics statistics;
	
	/**
	 * constructor
	 * @param stations
	 * @param bicycles
	 * @param users
	 * @param registrationCards
	 * @param side
	 * @param statistics
	 */
	public MyVelib(Map<UUID, Station> stations, Map<UUID, Bicycle> bicycles, Map<UUID, User> users, double side, Statistics statistics) {
		super();
		this.stations = stations;
		this.bicycles = bicycles;
		this.users = users;
		this.side = side;
		this.statistics = statistics;
	}
	
	public MyVelib() {
		super();
		this.stations = new HashMap<UUID,Station>();
		this.bicycles = new HashMap<UUID,Bicycle>();
		this.users = new HashMap<UUID,User>();
	}
	
	
	/**
	 * getters & setters
	 * @return
	 */
	
	public Map<UUID, Station> getStations() {
		return stations;
	}

	public void setStations(Map<UUID, Station> stations) {
		this.stations = stations;
	}

	public Map<UUID, Bicycle> getBicycles() {
		return bicycles;
	}

	public void setBicycles(Map<UUID, Bicycle> bicycles) {
		this.bicycles = bicycles;
	}

	public Map<UUID, User> getUsers() {
		return users;
	}

	public void setUsers(Map<UUID, User> users) {
		this.users = users;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	/**
	 * adders to all the maps 
	 * @param args
	 */
	
	
	//add a station to stations
	public void addStation(Station station) {
		this.stations.put(station.getID(), station);
	}
	
	
	//add a bicycle to bicycles
	public void addBicycle(Bicycle bicycle) {
		this.bicycles.put(bicycle.getID(), bicycle);
	}
	
	//add a user to users
	public void addUser(User user) {
		this.users.put((UUID) user.getID(), user);
	}
	
	
	//create a small world with stations, bicycles, users, etc.
	public void createMyVelib() {
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date beginningDate;
		try {
			beginningDate = formatter.parse("00-00-2022");
		} catch (ParseException e) {
			beginningDate = new Date();
			e.printStackTrace();
		}		
		
		//create stations, each are the same
		
		int numberofStations = 20;
		this.setSide(10);
		
		
		//for each station create random number of parking slots, with random number of bicycle
		for(int i = 0 ; i < numberofStations; i++) {
			
			//each station has between 5 and 25 parking slots
			Station station = new Station();
			station.setLocation(new Location(this.getSide()));
			station.setOnline(true);
			station.setType((new Random().nextDouble())<0.5 ? StationType.Plus : StationType.Standard);
			
			for(int j = 0 ; j< new Random().nextInt(20)+5;j++) {
				ParkingSlot parkingSlot = new ParkingSlot(station, beginningDate);
				if(new Random().nextDouble() < 0.2) {
					parkingSlot.setBicycle(null);
					parkingSlot.setState(ParkingSlotState.FreeToUse);
				}else {
					parkingSlot.setBicycle((new Random().nextDouble() < 0.5) ? new ElectricalBicycle():new MechanicalBicycle());
					parkingSlot.setState(ParkingSlotState.Bicycle);
				}
				station.addParkingSlot(parkingSlot);
				
				
			}
			this.addStation(station);			
		}
		
		/**
		 * we create 50 users on this map
		 */
		
		for(int i=0;i<50;i++) {
			
			RegistrationCard rC = null;
			if(new Random().nextDouble() < 0.2) {
				rC = new NoCard();
			}else{
				if(new Random().nextDouble() < 0.5) {
					rC = new Vlibre();
				}else {
				rC = new Vmax();
				}
			}
			
			User newuser = new User("Woz",new Location(this.getSide()),new CreditCard(),rC,this);
			//System.out.println(newuser.toString());
			this.addUser(newuser);
		}
		
		
	}

	//setUp
	
	public void setUp(int nStations, int nSlots, double s, int nBikes) {
		
		
		if(nBikes>nStations*nSlots) {
			System.out.println("numberof bikes must be smaller than the total ammount of parking solts");
			return;
		}
		
		int bikePerStation = nBikes/nStations;
		int remainingBikes = nBikes%nStations;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date beginningDate;
		try {
			beginningDate = formatter.parse("01-01-2022");
		} catch (ParseException e) {
			beginningDate = new Date();
			e.printStackTrace();
		}		
		
		//create stations, each are the same
		
		int numberofStations = nStations;
		this.setSide(s);
		
		
		//for each station create random number of parking slots, with random number of bicycle
		for(int i = 0 ; i < numberofStations; i++) {
			
			//each station has between 5 and 25 parking slots
			Station station = new Station();
			station.setLocation(new Location(this.getSide()));
			station.setOnline(true);
			station.setType((new Random().nextDouble())<0.5 ? StationType.Plus : StationType.Standard);
			
			for(int j = 0 ; j< nSlots;j++) {
				ParkingSlot parkingSlot = new ParkingSlot(station, beginningDate);
				Bicycle newBicycle = (new Random().nextDouble() < 0.5) ? new ElectricalBicycle():new MechanicalBicycle();
				if(j<nSlots-bikePerStation) {
					if(remainingBikes==0) {
					parkingSlot.setBicycle(null);
					parkingSlot.setState(ParkingSlotState.FreeToUse);
					}else {
						parkingSlot.setBicycle(newBicycle);
						this.addBicycle(newBicycle);
						parkingSlot.setState(ParkingSlotState.Bicycle);
						remainingBikes--;
					}
				}else {
					parkingSlot.setBicycle(newBicycle);
					this.addBicycle(newBicycle);
					parkingSlot.setState(ParkingSlotState.Bicycle);
				}
				station.addParkingSlot(parkingSlot);
				
				
			}
			this.addStation(station);
			//System.out.println(remainingBikes);
		}
		
		
	}
	
}

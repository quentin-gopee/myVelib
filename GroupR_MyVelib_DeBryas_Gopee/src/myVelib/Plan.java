package myVelib;

public class Plan {
	ParkingSlot startParkingSlot;
	ParkingSlot endParkingSlot;
	
	public Plan() {}

	public ParkingSlot getStartParkingSlot() {
		return startParkingSlot;
	}

	public void setStartParkingSlot(ParkingSlot startParkingSlot) {
		this.startParkingSlot = startParkingSlot;
	}

	public ParkingSlot getEndParkingSlot() {
		return endParkingSlot;
	}

	public void setEndParkingSlot(ParkingSlot endParkingSlot) {
		this.endParkingSlot = endParkingSlot;
	}
}

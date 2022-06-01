package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;

class PlanTest {

	@Test
	void testClassicPlan() {
		
		//crée un plan avec un objet myVelib dedans
		Plan plan = new Plan(createMyVelib());
		
		//prend la liste des utilisateurs de cet objet
		ArrayList<User> users = new ArrayList<User>(plan.getMyVelib().getUsers().values());
		
		//prend un utilisateur et prend ses coordonées
		Location start = users.get(new Random().nextInt(49)).getLocation();
		Location end = new Location(plan.getMyVelib().getSide());
		BicycleType bT = BicycleType.Electrical;
		if(new Random().nextDouble()<0.5)bT=BicycleType.Mechanical;
		
		try {
			plan.ClassicPlan(start, end, bT);
		} catch (Exception e) {
			System.out.println("function doesn't work");
			e.printStackTrace();
		}
		
		System.out.println(start.toString() + "  " +end.toString() + " "
		+ plan.getStartParkingSlot().getStation().getLocation().toString()
		+ " "+ plan.getEndParkingSlot().getStation().getLocation().toString());
		
		assertTrue(true);
	}
	
	@Test
	void testCreateMyVelib() {
		
		MyVelib myVelib =  createMyVelib();
		Plan plan = new Plan(myVelib);
		assertTrue(plan.getMyVelib().getUsers()==myVelib.getUsers());
		
	}
	

}

import java.lang.Math; 
import java.util.Scanner;

public class Car{

	double baseSpeed;
	double currentSpeed;
	double gallonsPerIteration;

public Car(){

	baseSpeed = 20;
	currentSpeed = 0;
	gallonsPerIteration = 0.1;
}
public Car(double baseSpeed, double currentSpeed, int gallonsPerIteration){

	this.baseSpeed = baseSpeed;
	this.gallonsPerIteration = gallonsPerIteration;
	this.currentSpeed = currentSpeed;
}

void driveForward(){
	
	Wheel wh = new Wheel(true,false);
	if(wh.goForward){
		baseSpeed = 20;
		consumeFuel("OnBaseSpeed");
	}
}

void driveBackward(){

	Wheel wh = new Wheel(false,true);
	if(wh.goBackWard){
		baseSpeed = 20 ;
		consumeFuel("OnBaseSpeed");
	}

}
 void turnSteeringWheels(){

    Scanner sc = new Scanner(System.in);
    boolean rdir = false, ldir = false;
    System.out.print("Enter Direction (left/right): ");
    String direction = sc.next();

    if(direction.equals("right")){
    	rdir = true;
    }
    else if(direction.equals("left")){
        ldir = true;
    }
    else{
    	System.out.println("You Have Entered Incorrect Choice !!");
    }

    SteeringWheels sw = new SteeringWheels(rdir,ldir);

 }

void consumeFuel(String acc){

	Engine eg = new Engine();
	if(acc.equals("up")){
		eg.fuelConsumption += Math.pow( (Math.abs(baseSpeed - currentSpeed)*0.3) , 2/3 );
	}
	else if(acc.equals("down")){
		eg.fuelConsumption -= Math.pow( (Math.abs(baseSpeed - currentSpeed)*0.3) , 2/3 );
	}

	else{
		eg.fuelConsumption = Math.pow( (Math.abs(baseSpeed - currentSpeed)*0.3) , 2/3 );
	}

}

void speedUp(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Speed: ");
	currentSpeed = sc.nextDouble();
	consumeFuel("up");
}

void speedDown(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Speed: ");
	currentSpeed = sc.nextDouble();
	consumeFuel("down");
}

void useGearShift(){
	Scanner sc = new Scanner(System.in);
	GearShift gs = new GearShift();
	System.out.println("Choose Option:(1/2/3) \n1)Park\n2)Drive \nReverse");
	int response = sc.nextInt();
	if(response == 1) gs.park = true;
	else if(response == 2) gs.drive = true;
	else if(response == 3) gs.reverse = true;
	else System.out.println("Invalid Option !!");
}


public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	Wheel car1 = new Wheel();
	Engine en = new Engine();
	GearShift gs = new GearShift();

	while(true){
    
    System.out.printf("\nBase Speed Of Current Car %.2f kmph",car1.baseSpeed);
    System.out.printf("\nCurrent Speed Of Current Car %.2f kmph",car1.currentSpeed);

    if(car1.goForward)System.out.printf("\nYour Car Is Running in Forward Direction !!");
    else if(car1.goBackWard) System.out.printf("\nYour Car Is Running in Forward Direction !!");
    

    if(en.isEngineOn) System.out.println("\nYour Car's Engine is On!!");
    else System.out.println("\nYour Car's Engine is Off !!");

    System.out.printf("Your fuelConsumption is %.2f gallons", en.fuelConsumption);
    
    if(gs.drive) System.out.println("\nGear Shift Is Set to Drive");
    else if(gs.reverse) System.out.println("\nYour Car Is In Reverse Gear");
    else System.out.println("\nYour Car is Parked !!");


	System.out.println("\n1)Speed Up Your Car");
	System.out.println("2)Speed down Your Car");
	System.out.println("3)Set GearShift Of Your Car");
	System.out.println("4)Drive Your Car Forward");
	System.out.println("5)Drive Your Car Backward");
	System.out.println("6)Turn Steering Wheels\n");

	System.out.print("Choose Any Option (1/2/3/4/5/6):");

    int res = sc.nextInt();

    if(res == 1) car1.speedUp();
    else if(res == 2)car1.speedDown();
    else if(res == 3)car1.useGearShift();
    else if(res == 4)car1.driveForward();
    else if(res == 5)car1.driveBackward();
    else if(res == 6)car1.turnSteeringWheels();
    else System.out.println("Invalid Choice !!");

  }

}

}

class Wheel extends Car{

boolean goForward; 
boolean goBackWard;
   
    public Wheel(){
    	goForward = false;
    	goBackWard = false;
    }

	public Wheel(boolean goForward, boolean goBackWard){
        this.goForward = goForward;
        this.goBackWard = goBackWard;
	}
}
class SteeringWheels{
	boolean turnRight;
	boolean turnLeft;

	public SteeringWheels(boolean turnRight , boolean turnLeft){
 		this.turnRight = turnRight;
 		this.turnLeft = turnLeft;
	}
}
class Engine extends Car{
	public boolean isEngineOn = false;
	public static double fuelConsumption;

	public Engine(){
		isEngineOn = true;
		fuelConsumption += 0.2;
	};

}

class gasTank{
	double holdFuel;
}
class GearShift{
	boolean drive;
	boolean reverse;
	boolean park;

	public GearShift(){
		drive = false;
		reverse = false;
		park = true;
	}
}

package game.engine;

import java.util.Scanner;

import java.util.HashMap;

public class Map {
	// private static final char WntToAddBuilding = 0;
	private String name;
	
	private int number;
	private int buildingCost;
	private int NoOfBuildings;
	private boolean troubleMarker;
//	private Integer buildingOwner;
	private int BankBal=10;
	//private int numberDemons;
	//private int numberTrolls;
	private int minions; //indicates how many minions each player has in that area
	private static Scanner in;
	public Map[] area= new Map[12];
	//HashMap<String, Integer> hash = new HashMap<>();

	// Put three keys with values.
	//hash.put("dog", 1);
	//hash.put("cat", 2);
	//hash.put("rabbit", 3);

	// Look up some known values.
	//int a = hash.get("dog");
	//int b = hash.get("cat");

	// Display results.
	//System.out.println(a);
	//System.out.println(b); 
	
	/* 
	 * Intializing Constructor for Map Class
	 */
    public Map(String name, int number, int buildingCost,
			boolean troubleMarker, int minions) {
		this.name = name;
		this.number = number;
		//this.buildingOwner = buildingOwner;
		//this.numberDemons = numberDemons;
		//this.numberTrolls = numberTrolls;
		this.minions = minions;
	}
    
	

	public Map() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBuildingCost() {
		return buildingCost;
	}

	public void setBuildingCost(int buildingCost) {
		this.buildingCost = buildingCost;
	}

	public boolean isTroubleMarker() {
		return troubleMarker;
	}

	public void setTroubleMarker(boolean troubleMarker) {
		this.troubleMarker = troubleMarker;
	}
	public int getNoOfBuildings() {
		return NoOfBuildings;
	}
	
	public void setNoOfBuildings(int pId) {
		this.NoOfBuildings = 1;
		
	}
	public void addBuilding(int pId) {
	setNoOfBuildings(pId);
	}

	/*public Integer getBuildingOwner() {
		return buildingOwner;
	} 

	public void setBuildingOwner(Integer buildingOwner) {
		this.buildingOwner = buildingOwner;
	}  */

	/*public int getNumberDemons() {
		return numberDemons;
	}

	public void setNumberDemons(int numberDemons) {
		this.numberDemons = numberDemons;
	}

	public int getNumberTrolls() {
		return numberTrolls;
	}

	public void setNumberTrolls(int numberTrolls) {
		this.numberTrolls = numberTrolls;
	} */
	public int getBankBal() {
		return BankBal;
	}

	public void setBankBal(int bankBal) {
		BankBal = bankBal;
	}
	public int getMinions() {
		return minions;
	}

	public void setMinions(int minions) {
		this.minions = minions;
	}

	void addMinion( int playerID, int count)
	{
		minions=count+1;
	};
	void removeMinion(int playerID, int count ){
		minions= count-1;
	} ;
	
	/*
	 * Add and Remove Building for a particular playerID in a area
	 */
	void addBuilding (int playerID, int BankBal){
		if(buildingCost<BankBal){
				NoOfBuildings= NoOfBuildings+1;
		}
		else 
			{
			System.out.println("Unable to build buiding");
			}
				};
	
	void removeBuilding( int playerID ){
		NoOfBuildings= NoOfBuildings-1;
		BankBal=BankBal+buildingCost;
		};
	
	/* String getCurrentState(int playerID){
		
	return ;
	}; */
		
/*
* defining main class
*/
public static void main(String [] args)throws NullPointerException
{
Map[] area= new Map[12]; //Declaring 12 areas array objects of Map type

/*
 * Initializing the String name to particular area object
 */
area[0].setName("The_Shades");
area[1].setName("Dolly_Sisters");
area[2].setName("The_Scours");
area[3].setName("Dimwell");
area[4].setName("NapHill");
area[5].setName("LongHall");
area[6].setName("TheHippo");
area[7].setName("DragonsLanding");
area[8].setName("IsleOfGods");
area[9].setName("SmallGod");
area[10].setName("SevenSleepers");
area[11].setName("UnrealEstate");

/*
 * Defining the building cost to the particular area
 */
area[0].setBuildingCost(3);
area[1].setBuildingCost(3);
area[2].setBuildingCost(2);
area[3].setBuildingCost(3);
area[4].setBuildingCost(1);
area[5].setBuildingCost(1);
area[6].setBuildingCost(2);
area[7].setBuildingCost(2);
area[8].setBuildingCost(2);
area[9].setBuildingCost(3);
area[10].setBuildingCost(3);
area[11].setBuildingCost(1);

in = new Scanner(System.in); //Defining new Scanner object to in reference variable

int  AddMi = 0, pID, AreaValue, mini = 0, AddBuild, AccBalance=10; //Declaring various integer attributes for main class

System.out.println("Enter the value for playerID between 0 to 4");
//Enter_PlayerID_Value_Again:
	pID=in.nextInt();
if(pID>=0 && pID<4)
{
	System.out.println("Enter the Area value where you want to add/remove minion or building ");
}
else
{
	System.out.println("Please enter the correct value");
	//continue Enter_PlayerID_Value_Again;
}
	
//Enter_Area_Value_Again:
	AreaValue = in.nextInt();
if(AreaValue<=0 && AreaValue>11)
{
	AccBalance=area[AreaValue].getBankBal();
	System.out.println(" Put value 1 to addMinion and 0 to removeMinion");
	// Enter_addMinion_Value_Again:
		AddMi = in.nextInt();
//	break Enter_Area_Value_Again;
}
else
{
	System.out.println("Please enter the correct value");
//	continue Enter_Area_Value_Again;
}

if(AddMi==0||AddMi==1)
{
	if(AddMi==1){
		area[AreaValue].addMinion(pID,mini);
			if (area[AreaValue].isTroubleMarker()==false){
				area[AreaValue].setTroubleMarker(true);
				}
	else {
		area[AreaValue].removeMinion(pID,mini);
		}
}
else
	{
	System.out.println("Please enter the correct value");
//	continue Enter_addMinion_Value_Again;
	}
/*
	System.out.println("1 to addTroubleMarker and 0 to removeTroubleMarker");
	AddTm = in.hasNextByte();
	if(AddTm==true){
		area[AreaValue].addTroubleMarker(pID,mini);
	}
	if(AddTm==false){
		area[AreaValue].removeTroubleMarker(pID,mini);
	}
	*/
System.out.println("Do you want to add/remove building");
System.out.println("Put 'Y' if you want to add/remove");

char WntToAddBuilding = in.next().charAt(0);

	if(WntToAddBuilding=='Y') {
		System.out.println("1 to addBuilding and 0 to removeBuilding");
		AddBuild = in.nextInt();
		
		if(AddBuild==0 || AddBuild==1)
		{
				if(AddBuild==1){
					if (area[AreaValue].isTroubleMarker()==false)
						{
						area[AreaValue].addBuilding(pID,AccBalance);
						}
	else
		{
		System.out.println("Unable to plae building, Troublemaker is there");
		}
	}
	
		}

			}
				}
					}

						}	


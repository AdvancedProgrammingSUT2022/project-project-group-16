package Models.Player;

import Controllers.GameController;
import Models.City.City;
import Models.Resources.LuxuryResource;
import Models.Resources.Resource;
import Models.Terrain.Improvement;
import Models.Terrain.Tile;
import Models.Units.Unit;
import Models.User;

import java.util.*;

public class Player extends User
{
	private Unit selectedUnit = null;
	private City selectedCity = null;
	private final Civilization civilization;
	private int food = 0;
	private int cup = 0;
	private int gold = 0;
	private int happiness = 0;
	private final ArrayList<Technology> technologies = new ArrayList<>();
	private Technology researchingTechnology;
	private ArrayList<Resource> resources;
	private final ArrayList<LuxuryResource> acquiredLuxuryResources = new ArrayList<>(); // this is for checking to increase happiness when acquiring luxury resources
	private ArrayList<Improvement> improvements = new ArrayList<>();
	private final HashMap<Tile, TileState> map;
	private ArrayList<City> cities = new ArrayList<>();
	private City initialCapitalCity;    //??TODO
	private City currentCapitalCity;    //??TODO
	private final Stack<Notification> notifications = new Stack<>();
	private ArrayList<Unit> units = new ArrayList<>();

	public Player(Civilization civilization, String username, String nickname, String password)
	{
		super(username, nickname, password);
		this.civilization = civilization;
		map = new HashMap<>();
		for(Tile tile : GameController.getInstance().getMap())
			map.put(tile, TileState.FOG_OF_WAR);
		setTileStates();
	}

	public City getSelectedCity() {
		return selectedCity;
	}
	public Unit getSelectedUnit() {
		return selectedUnit;
	}
	public void setSelectedUnit(Unit unit)
	{
		this.selectedUnit = unit;
	}
	public void setSelectedCity(City city)
	{
		this.selectedCity = city;
	}
	public Civilization getCivilization()
	{
		return civilization;
	}
	public int getFood()
	{
		return food;
	}
	public void setFood(int food)
	{
		this.food = food;
	}
	public int getGold()
	{
		return gold;
	}
	public void setGold(int gold)
	{
		this.gold = gold;
	}
	public int getHappiness()
	{
		return happiness;
	}
	public void setHappiness(int happiness)
	{
		this.happiness = happiness;
	}
	public ArrayList<Technology> getTechnologies()
	{
		return technologies;
	}
	public void addTechnology(Technology technology)
	{
		technologies.add(technology);
	}
	public Technology getResearchingTechnology()
	{
		return researchingTechnology;
	}
	public int getCup() {
		return cup;
	}
	public void updateCup()
	{
		for (City city : this.cities) this.cup += city.getCupYield();
	}

	public void setResearchingTechnology(Technology researchingTechnology)
	{
		this.researchingTechnology = researchingTechnology;
	}
	public ArrayList<Resource> getResources()
	{
		return resources;
	}
	public void setResources(ArrayList<Resource> resources)
	{
		this.resources = resources;
	}
	public HashMap<Tile, TileState> getMap()
	{
		return map;
	}
	public void addCity(City newCity) {
		cities.add(newCity);
	}
	public void setMap(ArrayList<Tile> map)
	{
		// TODO
	}
	//TODO: set tile states maybe????!!!
	public ArrayList<City> getCities()
	{
		return cities;
	}
	public void setCities(ArrayList<City> cities)
	{
		this.cities = cities;
	}
	public City getInitialCapitalCity()
	{
		return initialCapitalCity;
	}
	public void setInitialCapitalCity(City initialCapitalCity)
	{
		this.initialCapitalCity = initialCapitalCity;
	}
	public City getCurrentCapitalCity()
	{
		return currentCapitalCity;
	}
	public void setCurrentCapitalCity(City currentCapitalCity)
	{
		this.currentCapitalCity = currentCapitalCity;
	}
	public Stack<Notification> getNotifications()
	{
		return notifications;
	}
	public ArrayList<Unit> getUnits()
	{
		return units;
	}
	public void setUnits(ArrayList<Unit> units)
	{
		this.units = units;
	}
	
	public void setTileStates()
	{
		Random tileStateRandom = new Random();
		for(Map.Entry<Tile, TileState> entry : map.entrySet())
			map.replace(entry.getKey(), TileState.values()[tileStateRandom.nextInt(TileState.values().length)]);
	}
}
























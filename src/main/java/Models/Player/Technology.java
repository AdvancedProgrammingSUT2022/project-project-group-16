package Models.Player;

import java.util.ArrayList;
public enum Technology
{
	AGRICULTURE(),
	ANIMAL_HUSBANDRY(),
	ARCHERY(),
	BRONZE_WORKING(),
	CALENDAR(),
	MASONRY(),
	MINING(),
	POTTERY(),
	THE_WHEEL(),
	TRAPPING(),
	WRITING(),
	CONSTRUCTION(),
	HORSEBACK_RIDING(),
	IRON_WORKING(),
	MATHEMATICS(),
	PHILOSOPHY(),
	CHIVALRY(),
	CIVIL_SERVICE(),
	CURRENCY(),
	EDUCATION(),
	ENGINEERING(),
	MACHINERY(),
	METAL_CASTING(),
	PHYSICS(),
	STEEL(),
	THEOLOGY(),
	ACOUSTICS(),
	ARCHAEOLOGY(),
	BANKING(),
	CHEMISTRY(),
	ECONOMICS(),
	FERTILIZER(),
	GUN_POWDER(),
	METALLURGY(),
	MILITARY_SCIENCE(),
	PRINTING_PRESS(),
	RIFLING(),
	SCIENTIFIC_THEORY(),
	BIOLOGY(),
	COMBUSTION(),
	DYNAMITE(),
	ELECTRICITY(),
	RADIO(),
	RAILROAD(),
	REPLACEABLE(),
	PARTS(),
	STEAM_POWER(),
	TELEGRAPH();
	
	Technology(int cost, int turns, ArrayList<Technology> requiredTechnologies)
	{
	
	}
}
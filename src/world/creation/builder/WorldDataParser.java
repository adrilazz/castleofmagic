package world.creation.builder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.stream.Stream;

import world.Armor;
import world.GearContainer;
import world.HealthOrb;
import world.Mobile;
import world.Weapon;
import world.creation.factorymethod.ElementFactory;
import world.creation.factorymethod.ElementFactoryImpl;
import world.creation.factorymethod.MobileFactory;
import world.creation.factorymethod.MobileFactoryImpl;

public class WorldDataParser {
	
	String path;
	
	ElementFactory elementFactory;
	
	MobileFactory mobileFactory;	
	
	WorldBuilder builder;	
	
	public WorldDataParser() {
		
		elementFactory = new ElementFactoryImpl();	
		
		mobileFactory = new MobileFactoryImpl();
	}

	public WorldDataParser(WorldBuilder build) {
		this();
		builder = build;		
	}

	public WorldDataParser(String fileAddress, WorldBuilder build) {
		this();
		path = fileAddress;
		builder = build;		
	}
	
	public void construct() {
		//this.parseFile(path);
		
		//Rooms:
		builder.buildRoom("0", "Home Room", "Silly room not used for anything but required to make access to DatabaseObject array.");
		
		//Prolog:
		builder.buildRoom("1", "1", "null");	
		builder.addMobile("1", mobileFactory.createMobile("M1", "", "Mover1", ""));
		
		builder.buildRoom("2", "2", "null");	
		builder.addMobile("2", mobileFactory.createMobile("M2", "", "Mover2", ""));
		
		builder.buildRoom("3", "3", "null");	
		builder.addMobile("3", mobileFactory.createMobile("M3", "", "Mover3", ""));
		
		builder.buildRoom("4", "", "null");	
		builder.addMobile("4", mobileFactory.createMobile("M", "", "Mover4", ""));
		
		builder.buildRoom("5", "", "null");	
		builder.addMobile("5", mobileFactory.createMobile("M", "", "Mover5", ""));
		
		builder.buildRoom("6", "", "null");	
		builder.addMobile("6", mobileFactory.createMobile("M", "", "Mover6", ""));
		
		builder.buildRoom("7", "", "null");	
		builder.addMobile("7", mobileFactory.createMobile("M", "", "Mover7", ""));
		
		builder.buildRoom("8", "", "null");	
		builder.addMobile("8", mobileFactory.createMobile("M", "", "Mover8", ""));
		
		builder.buildRoom("9", "", "null");	
		builder.addMobile("9", mobileFactory.createMobile("M", "", "Mover9", ""));
		
		builder.buildRoom("10", "", "null");	
		builder.addMobile("10", mobileFactory.createMobile("M", "", "Mover10", ""));
		
		//Map 1
		builder.buildRoom("11", "11", "null");	
		builder.addMobile("11", mobileFactory.createMobile("M11", "", "Mover11", ""));
		builder.buildRoom("12", "12", "null");
		builder.addMobile("12", mobileFactory.createMobile("M12", "", "Mover12", ""));
		builder.buildRoom("13", "13", "null");
		builder.addMobile("13", mobileFactory.createMobile("M13", "", "Mover13", ""));
		builder.buildRoom("14", "14", "null");
		builder.addMobile("14", mobileFactory.createMobile("M14", "", "Mover14", ""));
		builder.buildRoom("15", "15", "null");
		builder.addMobile("15", mobileFactory.createMobile("M15", "", "Mover15", ""));
	
		//Map 2
		builder.buildRoom("21", "Misty Meadows", "You suddenly hear a voice in the distance");
		builder.buildExit("15", "s", "21");
		builder.buildRoom("22", "", "null");
		builder.buildExit("21", "s", "22");
		builder.buildExit("22", "n", "21");
		builder.buildRoom("23", "", "null");
		builder.buildExit("22", "s", "23");
		builder.addMobile("23", mobileFactory.createMobile("Damian", "Short scared man with a gray beard.", "DAMIAN", ""));
		builder.buildRoom("24", "", "null");
		builder.buildExit("23", "n", "24");
		builder.buildExit("24", "s", "23");
		builder.buildRoom("26", "", "null");
		builder.buildExit("24", "w", "26");
		builder.buildExit("26", "e", "24");
		builder.buildRoom("27",  "",  "null");
		builder.addMobile("27", mobileFactory.createMobile("M27", "", "Mover27", ""));
		builder.buildExit("26", "w", "27");
		builder.buildRoom("28", "", "null");
		builder.buildExit("27", "e", "28");
		builder.buildExit("28", "w", "27");
		builder.buildRoom("29", "", "null");
		builder.buildExit("28", "e", "29");
		
		//Map 3
		builder.buildRoom("31", "Magic Portal", "Blue Portal");
		builder.buildExit("29", "e", "31");
		builder.buildRoom("32", "", "null");
		builder.buildExit("31", "e", "32");
		builder.addMobile("32", mobileFactory.createMobile("M32", "", "Mover32", ""));
		builder.buildRoom("33", "", "null");
		builder.buildExit("32", "1", "33");
		builder.addMobile("33", mobileFactory.createMobile("M33", "", "Mover33", ""));
		builder.buildRoom("34", "", "null");
		builder.addMobile("34", mobileFactory.createMobile("M34", "", "Mover34", ""));
		builder.buildRoom("35", "", "null");
		builder.addMobile("35", mobileFactory.createMobile("M35", "", "Mover35", ""));
		builder.buildRoom("36", "", "null");
		builder.addMobile("36", mobileFactory.createMobile("M36", "", "Mover36", ""));
		builder.buildRoom("37", "", "null");
		builder.addMobile("37", mobileFactory.createMobile("M37", "", "Mover37", ""));
		builder.buildRoom("38", "", "null");
		builder.addMobile("38", mobileFactory.createMobile("M38", "", "Mover38", ""));
		
		//Map 4
		builder.buildRoom("41", "Tavern Second Floor", "Tavern");
		builder.addMobile("41", mobileFactory.createMobile("M41", "", "Mover41", ""));
		builder.buildRoom("42", "", "null");
		builder.addMobile("42", mobileFactory.createMobile("M42", "", "Mover42", ""));
		builder.buildRoom("43", "", "null");
		builder.addMobile("43", mobileFactory.createMobile("M43", "", "Mover43", ""));
		builder.buildRoom("44", "", "null");
		builder.addMobile("44", mobileFactory.createMobile("M44", "", "Mover44", ""));
		builder.buildRoom("40", "", "null");
		builder.buildRoom("45", "", "null");
		builder.buildExit("40", "e", "45");
		builder.buildRoom("46", "", "null");
		builder.buildExit("45", "w", "46");
		builder.buildExit("46", "e", "45");
		builder.buildRoom("47", "", "null");
		builder.buildRoom("49", "", "null");
		builder.buildExit("45", "n", "49");
		builder.buildExit("49", "s", "45");
		builder.buildExit("47", "s", "45");
		builder.buildRoom("48", "", "null");
		builder.buildExit("49", "w", "48");
		builder.buildExit("47", "w", "48");
		builder.buildExit("48", "e", "47");
		
		//Map 5
		builder.buildRoom("50", "Tavern Ground Floor", "Tv");
		builder.buildExit("48", "w", "50");
		builder.buildExit("50", "e", "48");
		builder.buildRoom("51", "", "null");
		builder.buildExit("50", "s", "51");
		builder.buildExit("51", "n", "50");
		builder.buildRoom("52", "", "null");
		builder.buildExit("51", "s", "52");
		builder.buildExit("52", "n", "51");
		builder.buildRoom("53", "", "null");
		builder.buildExit("52", "e", "53");
		builder.buildRoom("54", "", "null");
		builder.buildExit("53", "w", "54");
		builder.buildExit("54", "e", "53");
		builder.buildExit("54", "n", "51");
		builder.buildRoom("55", "", "null");
		builder.addMobile("55", mobileFactory.createMobile("M55", "", "Mover55", ""));
		builder.buildExit("53", "s", "55");
		builder.buildExit("55", "n", "53");
		builder.buildRoom("56", "", "null");
		builder.buildExit("53", "n", "56");
		builder.buildExit("53", "e", "56");
		builder.buildRoom("57", "", "null");
		builder.buildExit("57", "n", "56");
		builder.buildExit("57", "e", "56");
		builder.buildExit("57", "s", "55");
		builder.buildExit("57", "w", "54");
		builder.buildExit("56", "s", "57");
		builder.buildExit("56", "w", "57");
		builder.buildRoom("58", "", "null");
		builder.buildExit("56", "n", "58");
		builder.buildExit("58", "s", "56");
		
		//Map 6
		builder.buildRoom("60", "Town Center", "R");
		builder.buildExit("58", "n", "60");
		builder.addMobile("60", mobileFactory.createMobile("M60", "", "Mover60", ""));
		builder.buildRoom("61", "", "null");
		builder.buildRoom("62", "", "null");
		builder.buildRoom("63", "", "null");
		builder.buildRoom("64", "", "null");
		builder.buildRoom("65", "", "null");
		builder.buildRoom("66", "", "null");
		builder.buildRoom("612", "", "null");
		builder.buildRoom("622", "", "null");
		builder.buildRoom("632", "", "null");
		builder.buildRoom("642", "", "null");
		builder.buildRoom("652", "", "null");
		builder.buildRoom("662", "", "null");
		
		builder.buildExit("61", "e", "62");
		builder.buildExit("62", "e", "63");
		builder.buildExit("63", "e", "64");
		builder.buildExit("64", "n", "65");
		builder.buildExit("65", "n", "66");
		
		builder.buildExit("62", "w", "612");
		builder.buildExit("63", "w", "622");
		builder.buildExit("64", "w", "632");
		builder.buildExit("65", "s", "642");
		builder.buildExit("66", "s", "652");
		
		builder.buildExit("612", "e", "62");
		builder.buildExit("622", "e", "63");
		builder.buildExit("632", "e", "64");
		builder.buildExit("642", "n", "65");
		builder.buildExit("652", "n", "66");
		
		builder.buildExit("622", "w", "612");
		builder.buildExit("632", "w", "622");
		builder.buildExit("642", "w", "632");
		builder.buildExit("652", "s", "642");
		builder.buildExit("662", "s", "652");
		
		builder.buildRoom("601", "", "null");
		builder.buildExit("601", "n", "642");
		builder.buildExit("64", "s", "601");
		builder.buildExit("642", "s", "601");
		
		builder.buildRoom("68", "Shipyard", "R");
		builder.addMobile("68", mobileFactory.createMobile("M68", "", "Mover68", ""));
		builder.buildExit("601", "s", "68");
		builder.buildExit("68", "n", "601");
		
		builder.buildRoom("67", "Bridge", "R");
		builder.addMobile("67", mobileFactory.createMobile("M67", "", "Mover67", ""));
		builder.buildExit("61", "w", "67");
		builder.buildExit("612", "w", "67");
		builder.buildExit("67", "e", "61");
		builder.buildExit("67", "e", "612");
		
		builder.buildRoom("602",  "",  "null");
		builder.buildExit("602", "w", "642");
		builder.buildExit("64", "e", "602");
		builder.buildExit("642", "e", "602");
		
		builder.buildRoom("69", "Market Festival", "R");
		builder.addMobile("69", mobileFactory.createMobile("M69", "", "Mover69", ""));
		builder.buildExit("602", "e", "69");
		builder.buildRoom("604", "", "null");
		builder.buildExit("69", "w", "604");
		builder.buildExit("604", "w", "642");
		builder.buildExit("604", "e", "69");
		
		//Castle Courtyard
		builder.buildRoom("700", "Castle Courtyard", "R");
		builder.buildExit("66", "n", "700");
		builder.buildExit("662", "n", "700");
		builder.buildExit("700", "s", "662");
		builder.addMobile("700", mobileFactory.createMobile("M700", "", "Mover700", ""));
		builder.buildRoom("702", "", "null");
		builder.addMobile("702", mobileFactory.createMobile("M702", "", "Mover702", ""));
		builder.buildRoom("703", "", "null");
		builder.addMobile("703", mobileFactory.createMobile("M703", "", "Mover703", ""));
		builder.buildRoom("704", "", "null");
		builder.addMobile("704", mobileFactory.createMobile("M704", "", "Mover704", ""));
		builder.buildRoom("705", "", "null");
		builder.buildRoom("706", "", "null");
		builder.buildRoom("707", "", "null");
		builder.buildExit("705", "n", "706");
		builder.buildExit("706", "n", "707");
		builder.buildExit("707", "s", "706");
		builder.buildExit("706", "s", "705");
		
		builder.buildRoom("710", "", "null");
		builder.buildExit("707", "n", "710");
		builder.buildExit("710", "s", "707");
		
		builder.buildRoom("711", "", "null");
		builder.buildRoom("712", "", "null");
		builder.buildRoom("713", "", "null");
		builder.buildRoom("714", "", "null");
		builder.buildRoom("720", "", "null");
		
		builder.buildExit("710", "w", "711");
		builder.buildExit("711", "e", "710");
		builder.buildExit("711", "n", "712");
		builder.buildExit("712", "s", "711");
		builder.buildExit("712", "n", "720");
		builder.buildExit("720", "s", "712");
		
		builder.buildExit("710", "e", "713");
		builder.buildExit("713", "w", "710");
		builder.buildExit("713", "n", "714");
		builder.buildExit("714", "s", "713");
		builder.buildExit("714", "n", "720");
		builder.buildRoom("721", "", "null");
		builder.buildRoom("722", "", "null");
		builder.buildExit("720", "n", "721");
		builder.buildExit("721", "n", "722");
		builder.buildExit("722", "s", "721");
		builder.buildExit("721", "s", "720");
		builder.buildRoom("730", "", "null");
		builder.buildExit("722", "n", "730");
		builder.addMobile("730", mobileFactory.createMobile("M730", "", "Mover730", ""));
		builder.buildRoom("731", "", "null");
		builder.addMobile("731", mobileFactory.createMobile("M731", "", "Mover731", ""));
		builder.buildRoom("735", "", "null");
		builder.addMobile("735", mobileFactory.createMobile("Ruth", "", "StateRuth", ""));
		builder.buildRoom("732", "", "null");
		builder.buildRoom("733", "", "null");
		builder.buildExit("732", "u", "733");
		builder.buildRoom("734", "", "null");
		builder.buildExit("733", "n", "734");
		
		//Entrance Hall
		builder.buildRoom("740", "Entrance Hall", "R");
		builder.buildExit("734", "n", "740");
		builder.buildRoom("741", "", "null");
		builder.buildRoom("742", "", "null");
		builder.buildExit("740", "n", "741");
		builder.buildExit("741", "s", "740");
		builder.buildExit("741", "n", "742");
		builder.buildExit("742", "s", "741");
		builder.addMobile("742", mobileFactory.createMobile("M742", "", "Mover742", "")); //Move
		builder.buildRoom("743", "", "null");
		builder.addMobile("743", mobileFactory.createMobile("M743", "", "Mover743", ""));//Elden and mov
		builder.buildRoom("744", "", "null");
		builder.addMobile("744", mobileFactory.createMobile("M744", "", "Mover744", ""));//Sheldon and mov
		builder.buildRoom("745", "", "null");
		builder.addMobile("745", mobileFactory.createMobile("M745", "", "Mover745", ""));//Think and mov
		//After first encounter with twins
		builder.buildRoom("746", "", "null");
		builder.buildRoom("748", "", "null");
		builder.buildExit("746", "n", "748");
		builder.buildExit("748", "s", "746");
		builder.buildRoom("747", "", "null");
		builder.buildExit("746", "e", "747");
		builder.buildExit("747", "w", "746");

		//Torture Chamber
		builder.buildRoom("760", "Torture Chamber", "R");
		builder.buildExit("747", "e", "760");
		builder.buildRoom("761", "", "null");
		builder.buildExit("760", "e", "761");
		builder.addMobile("761", mobileFactory.createMobile("M761", "", "Mover761", ""));//Gunter help! and mov
		
		builder.buildRoom("762", "", "null");
		builder.addMobile("762", mobileFactory.createMobile("M762", "", "Mover762", ""));//Wait for Interact
		builder.buildRoom("763", "", "null");
		builder.buildExit("762", "1", "763");
		builder.addMobile("763", mobileFactory.createMobile("M763", "", "Mover763", ""));//Mov
		builder.buildRoom("764", "", "null");
		builder.addMobile("764", mobileFactory.createMobile("M764", "", "Mover764", ""));//Mov
		builder.buildRoom("765", "", "null");
		builder.addMobile("765", mobileFactory.createMobile("M765", "", "Mover765", ""));//Mov
		builder.buildRoom("766", "", "null");
		builder.addMobile("766", mobileFactory.createMobile("M766", "", "Mover766", ""));//Mov
		builder.buildRoom("767", "", "null");
		builder.addMobile("767", mobileFactory.createMobile("M767", "", "Mover767", ""));//Gunter dialog and Mov
		
		builder.buildRoom("768", "", "null");
		builder.buildRoom("769", "", "null");
		builder.buildExit("768", "w", "769");
		builder.buildExit("769", "e", "768");
		builder.buildRoom("770", "", "null");
		builder.buildExit("769", "w", "770");
		
		//Second encounter with twins
		builder.buildRoom("750", "Entrance Hall", "R");
		builder.buildExit("770", "w", "750");
		builder.buildRoom("751", "", "null");
		builder.buildExit("750", "w", "751");
		builder.buildRoom("752", "", "null");
		builder.buildExit("751", "n", "752");
		builder.addMobile("752", mobileFactory.createMobile("M752", "", "Mover752", ""));//Open Chest
		builder.buildRoom("753", "", "null");
		builder.buildExit("752", "s", "753");
		builder.addMobile("753", mobileFactory.createMobile("M753", "", "Mover753", ""));//Elden dialog
		
		builder.buildRoom("754", "Twins Card Game", "R");
		builder.buildExit("753", "1", "754");
		
		builder.buildRoom("755", "", "null");
		builder.addMobile("755", mobileFactory.createMobile("M755", "", "Mover755", ""));//Shall pass
		builder.buildExit("754", "up", "755");
		builder.buildRoom("756", "", "null");
		builder.buildExit("755", "w", "756");
		
		//Magic Stairs
		builder.buildRoom("800", "Magic Stairs", "R");
		builder.buildExit("756", "w", "800");
		builder.addMobile("800", mobileFactory.createMobile("M800", "", "Mover800", ""));//Mov
		builder.buildRoom("801", "", "null");
		builder.addMobile("801", mobileFactory.createMobile("M801", "", "Mover801", ""));//Mov
		builder.buildRoom("802", "", "null");
		builder.addMobile("802", mobileFactory.createMobile("M802", "", "Mover802", ""));//Mov
		builder.buildRoom("803", "", "null");
		builder.buildRoom("899", "", "null");//restart maze
		builder.addMobile("899", mobileFactory.createMobile("M899", "", "Mover899", ""));//Mov
		builder.buildRoom("804", "", "null");
		builder.buildExit("803", "s", "804");
		builder.buildExit("899", "s", "804");
		builder.buildExit("804", "n", "803");
		builder.buildRoom("805", "", "null");
		builder.buildExit("804", "s", "805");
		builder.buildExit("805", "n", "804");
		builder.buildRoom("806", "", "null");
		builder.buildExit("805", "s", "806");
		builder.buildExit("806", "n", "805");
		builder.buildRoom("807", "", "null");
		builder.buildExit("806", "s", "807");
		builder.buildExit("807", "w", "806");
		builder.buildRoom("808", "", "null");
		builder.buildExit("807", "n", "808");
		builder.buildExit("808", "s", "807");
		builder.buildRoom("809", "", "null");
		builder.buildExit("808", "n", "809");
		builder.buildExit("809", "s", "808");
		builder.buildRoom("870", "", "null");
		builder.buildExit("809", "n", "870"); 
		builder.addMobile("870", mobileFactory.createMobile("M870", "", "Mover870", ""));//Mov
		builder.buildRoom("871", "", "null");
		builder.addMobile("871", mobileFactory.createMobile("M871", "", "Mover871", ""));//Mov		
		builder.buildRoom("880", "", "null");
		builder.buildRoom("810", "", "null");
		builder.buildRoom("811", "", "null");
		builder.buildRoom("881", "", "null");
		builder.buildRoom("812", "", "null");
		builder.buildRoom("882", "", "null");
		
		
		builder.buildExit("880", "w", "810");
		builder.buildExit("810", "w", "811");
		builder.buildExit("811", "w", "812");
		builder.buildExit("882", "w", "812");
		
		builder.buildExit("812", "e", "882");
		builder.buildExit("882", "e", "881");
		builder.buildExit("881", "e", "880");
		
		builder.buildExit("810", "e", "880");
		builder.buildExit("811", "e", "881");	
		builder.buildExit("881", "w", "811");
		builder.buildExit("812", "w", "899");
		
		builder.buildRoom("813", "", "null");
		builder.buildExit("812", "n", "813");
		builder.buildExit("882", "n", "813");
		builder.buildExit("813", "s", "882");
		
		builder.buildRoom("814", "", "null");
		builder.buildExit("813", "n", "814");
		builder.buildExit("814", "s", "813");
		
		builder.buildRoom("815", "", "null");
		builder.buildExit("814", "n", "815");
		builder.addMobile("815", mobileFactory.createMobile("M815", "", "Mover815", ""));//Mov	
		builder.buildRoom("816", "", "null");
		builder.addMobile("816", mobileFactory.createMobile("M816", "", "Mover816", ""));//Mov	
		builder.buildRoom("817", "", "null");
		builder.buildRoom("818", "", "null");
		builder.buildExit("817", "n", "818");
		builder.buildExit("818", "s", "817");
		builder.buildRoom("819", "", "null");
		builder.buildExit("818", "n", "819");
		builder.buildExit("819", "s", "818");
		
		//Throne Room
		builder.buildRoom("900", "Throne Room", "R");
		builder.addMobile("900", mobileFactory.createMobile("M", "", "Mover900", ""));//Mov	to 901
		builder.buildExit("819", "n", "900"); 
		builder.buildRoom("901", "", "null");
		builder.addMobile("901", mobileFactory.createMobile("M", "", "Mover901", ""));//Wendy is there & Mov
		builder.buildRoom("902", "", "null");
		builder.buildRoom("903", "", "null");
		builder.buildExit("902", "n", "903"); 
		builder.buildExit("903", "s", "902"); 
		builder.buildRoom("904", "", "null");
		builder.buildExit("903", "n", "904"); 
		builder.buildExit("904", "s", "903"); 
		builder.buildRoom("905", "", "null");
		builder.buildExit("904", "n", "905"); 
		builder.buildExit("905", "s", "904"); 
		builder.buildRoom("906", "", "null");
		builder.buildExit("905", "n", "906"); 
		builder.buildExit("906", "s", "905"); 
		builder.buildRoom("907", "", "null");
		builder.buildExit("906", "n", "907"); 
		builder.addMobile("907", mobileFactory.createMobile("M", "", "Mover907", ""));//Mov	to 910
		
		builder.buildRoom("910", "", "null");
		builder.addMobile("910", mobileFactory.createMobile("M", "", "Mover910", ""));//Mov	to 911
		builder.buildRoom("911", "", "null");
		builder.addMobile("911", mobileFactory.createMobile("M", "", "Mover911", ""));// Playwithme & movto912
		builder.buildRoom("912", "", "null"); //Play minigame here
		
		builder.buildRoom("913", "", "null");
		builder.buildExit("912", "u", "913"); 
		builder.addMobile("913", mobileFactory.createMobile("M", "", "Mover913", ""));//Mov 
		builder.buildRoom("914", "", "null");
		builder.addMobile("914", mobileFactory.createMobile("M", "", "Mover914", ""));//Mov 
		builder.buildRoom("915", "", "null");
		builder.addMobile("915", mobileFactory.createMobile("M", "", "Mover915", ""));//Mov 
		builder.buildRoom("916", "", "null");
		builder.addMobile("916", mobileFactory.createMobile("M", "", "Mover916", ""));//Mov 
		builder.buildRoom("917", "", "null");
		builder.addMobile("917", mobileFactory.createMobile("M", "", "Mover917", ""));//Wendy dialog & mov
		builder.buildRoom("918", "", "null");
		builder.addMobile("918", mobileFactory.createMobile("M", "", "Mover918", ""));//Mov
		builder.buildRoom("919", "", "null");
		builder.addMobile("919", mobileFactory.createMobile("M", "", "Mover919", ""));//Mov
		builder.buildRoom("920", "", "null");
		builder.addMobile("920", mobileFactory.createMobile("M", "", "Mover920", ""));//Mov
		builder.buildRoom("921", "", "null");
		builder.addMobile("921", mobileFactory.createMobile("M", "", "Mover921", ""));//Kamek dialog & mov
		builder.buildRoom("922", "", "null");
		builder.addMobile("922", mobileFactory.createMobile("M", "", "Mover922", ""));//Mov
		builder.buildRoom("923", "", "null");
		builder.addMobile("923", mobileFactory.createMobile("M", "", "Mover923", ""));//Mov
		builder.buildRoom("924", "", "null");
		builder.addMobile("924", mobileFactory.createMobile("M", "", "Mover924", ""));//Mov
		builder.buildRoom("925", "", "null");
		builder.addMobile("925", mobileFactory.createMobile("M", "", "Mover925", ""));//Mov
		builder.buildRoom("926", "", "null");
		builder.addMobile("926", mobileFactory.createMobile("M", "", "Mover926", ""));//Mov
		builder.buildRoom("927", "", "null");
		builder.addMobile("927", mobileFactory.createMobile("M", "", "Mover927", ""));//Mov
		builder.buildRoom("928", "", "null");
		builder.addMobile("928", mobileFactory.createMobile("M", "", "Mover928", ""));//Mov
		builder.buildRoom("929", "", "null");
		builder.addMobile("929", mobileFactory.createMobile("M", "", "Mover929", ""));//Mov
		builder.buildRoom("930", "", "null");
		builder.addMobile("930", mobileFactory.createMobile("M", "", "Mover930", ""));//Mov
		builder.buildRoom("931", "", "null");
		builder.addMobile("931", mobileFactory.createMobile("M", "", "Mover931", ""));//Mov
		builder.buildRoom("932", "", "null");
		builder.addMobile("932", mobileFactory.createMobile("M", "", "Mover932", ""));//Mov
		builder.buildRoom("933", "", "null"); // The end screen
		builder.addMobile("933", mobileFactory.createMobile("M", "", "Mover933", ""));//Mov
		builder.buildRoom("934", "", "null"); // The end screen
		builder.addMobile("934", mobileFactory.createMobile("M", "", "Mover934", ""));//Mov
		
		
		
		//Epilog
		builder.buildRoom("940", "", "null");
		builder.buildRoom("941", "", "null");
		builder.addMobile("941", mobileFactory.createMobile("M", "", "Mover941", ""));//Dialog Kamek
		builder.buildRoom("942", "", "null");
		builder.addMobile("942", mobileFactory.createMobile("M", "", "Mover942", ""));//Dialog Sheldon
		
		builder.buildExit("940", "s", "942"); 
		builder.buildExit("942", "n", "940"); 
		builder.buildExit("940", "n", "941");
		builder.buildExit("941", "s", "940");
		
		builder.buildRoom("943", "", "null");
		builder.buildExit("941", "1", "943");
		builder.buildExit("943", "u", "941");
		
		builder.buildRoom("944", "", "null");
		builder.buildExit("942", "1", "944");
		builder.buildExit("944", "u", "942");
		
		
	}
	
	public void parseFile(String fileAddress) {

		builder.buildRoom("0", "Home Room", "Silly room not used for anything but required to make access to DatabaseObject array.");
		
		String fileContent = this.readLineByLineJava8(fileAddress);
		
		StringTokenizer st = new StringTokenizer(fileContent, "\n");
		
		this.process(st);
		
	}
	
	private void process(StringTokenizer st) {
		
		while(st.hasMoreTokens()) {
			String line = st.nextToken();
			
			//System.out.println("LINE: "+ line);
			
			//  Room structure
			
			if(line.startsWith("Room")) {
				this.buildRoom(line, st);				
			}

			if(line.startsWith("Exit")) {
				this.buildExit(line);				
			}

			if(line.startsWith("ADD")) {
				this.nestInstruction(line);				
			}	
			
			//  Gear			

			if(line.startsWith("Weapon")) {
				this.buildWeapon(st);				
			}		

			if(line.startsWith("Armor")) {
				this.buildArmor(st);				
			}

			if(line.startsWith("Orb")) {
				this.buildOrb(st);		
			}


			if(line.startsWith("GearContainer")) {
				this.buildGearContainer(st);		
			}			
			
			// Mobile

			if(line.startsWith("Mobile")) {
				this.buildMobile(st);				
			}

			if(line.startsWith("Stat")) {
				this.updateStat(line);			
			}			
		}	
		
		builder.populate();	
	}
	
	private void buildRoom(String line, StringTokenizer st) {
		String id = line.substring(5);
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		builder.buildRoom(id, name, description.toString());
	}
	
	private void buildExit(String line) {

		StringTokenizer st = new StringTokenizer(line.substring(5), " ");
		
		String room1 = st.nextToken();
		String whichWay = st.nextToken();
		String room2 = st.nextToken();
		
		builder.buildExit(room1, whichWay, room2);		
	}

	private void nestInstruction(String line) {

		StringTokenizer st = new StringTokenizer(line.substring(4), " ");
		
		String room1 = st.nextToken();
		String room2 = st.nextToken();
		
		builder.nestRooms(room1, room2);		
	}

	private void buildWeapon(StringTokenizer st) {
				
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		
		String levelString = st.nextToken();
		int level = Integer.parseInt(levelString.substring(6));
		String damageString = st.nextToken();
		int damage = Integer.parseInt(damageString.substring(7));
		

		String locationString = st.nextToken();
		String where = locationString.substring(9);
				
		Weapon weapon = elementFactory.buildWeapon(name, description.toString(), level, damage);


		//System.out.println("Created " + weapon.getName());
		
		builder.addGear(where, weapon);		

		System.out.println("Added " + weapon.getName() + " to " + where);
	}

	private void buildArmor(StringTokenizer st) {
				
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		
		String levelString = st.nextToken();
		int level = Integer.parseInt(levelString.substring(6));
		String damageString = st.nextToken();
		char type = damageString.substring(5).charAt(0);
		

		String locationString = st.nextToken();
		String where = locationString.substring(9);
				
		Armor armor = elementFactory.buildArmor(name, description.toString(), level, type);
		
		builder.addGear(where, armor);		

		System.out.println("Added " + armor.getName() + " to " + where);
	}

	private void buildOrb(StringTokenizer st) {
				
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		
		String levelString = st.nextToken();
		int healthPoints = Integer.parseInt(levelString.substring(13));

		String locationString = st.nextToken();
		String where = locationString.substring(9);
				
		HealthOrb orb = elementFactory.buildHealthOrb(name, description.toString(), healthPoints);
		
		builder.addGear(where, orb);		

		System.out.println("Added " + orb.getName() + " to " + where);
	}

	private void buildGearContainer(StringTokenizer st) {
				
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		
		String maxSizeString = st.nextToken();
		int maxSize = Integer.parseInt(maxSizeString.substring(8));
		
		String canCarryString = st.nextToken();
		String canCarryShort = canCarryString.substring(9);
		boolean canCarry = Boolean.parseBoolean(canCarryShort);

		String locationString = st.nextToken();
		String where = locationString.substring(9);
				
		GearContainer container = elementFactory.buildGearContainer(name, description.toString(), maxSize, canCarry);
		
		builder.addGear(where, container);		

		System.out.println("Added " + container.getName() + " to " + where);
	}

	private void buildMobile(StringTokenizer st) {
				
		String name = st.nextToken().substring(5);
		
		StringBuffer description = new StringBuffer();
		boolean finished = false;
		while(st.hasMoreTokens() && !finished) {
			String nextLine = st.nextToken();
			finished = nextLine.equalsIgnoreCase("END");
			if(!finished) {
				description.append(nextLine);
			}			
		}
		
		String strategyString = st.nextToken();
		
		/*
		StringTokenizer stStrategy = new StringTokenizer(strategyString," ");
		
		stStrategy.nextToken();
		
//		String strategy = stStrategy.nextToken();
//		String message4strategy = "";
//		
//		if(stStrategy.hasMoreTokens()) {
//			message4strategy = stStrategy.nextToken();
//		}
		*/

		strategyString = strategyString.substring(9);

		//System.out.println(name);
		//System.out.println(strategyString);
		
		String strategy = strategyString;
		
		String message4strategy = "";

		if(strategyString.indexOf(' ')>-1) {
			strategy = strategyString.substring(0,strategyString.indexOf(' '));
			message4strategy = strategyString.substring(strategyString.indexOf(' ')+1,strategyString.length());
		}		
		
		//System.out.println(name);
		//System.out.println(strategy);
		//System.out.println(message4strategy);

		String locationString = st.nextToken();
		String where = locationString.substring(9);
		
		Mobile mobile = mobileFactory.createMobile(name, description.toString(), strategy, message4strategy);
	
		if(where.startsWith("CLONE")) {
			
			this.storeMobile2clone(where, mobile);			
		}
		else {
			//System.out.println("Buit mobile " + mobile.getName());
			
			builder.addMobile(where, mobile);			
		}
	}
	
	private void storeMobile2clone(String where, Mobile mobile) {
		builder.populateWith(where, mobile);		
	}

	private void updateStat(String line) {
		
		StringTokenizer st = new StringTokenizer(line," ");
		
		st.nextToken();
		
		String name = st.nextToken();

		String trait = st.nextToken();

		String valueString = st.nextToken();
		int value = Integer.parseInt(valueString);
		
		builder.addStatToMobile(name, trait, value);
	}

    private String readLineByLineJava8(String filePath) {
    	
        StringBuilder contentBuilder = new StringBuilder();
 
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return contentBuilder.toString();
    }
}

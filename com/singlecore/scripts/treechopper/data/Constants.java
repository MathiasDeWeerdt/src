package com.singlecore.scripts.treechopper.data;

import org.osbot.rs07.utility.Area;

import com.singlecore.api.PriceChecker;

public class Constants {

	public static final Area BANK_AREA_VWEST = new Area(3179, 3448, 3191, 3432);
	public static final Area TREE_AREA_VWEST = new Area(3158, 3420, 3171, 3396);
	
	public static final Area BANK_AREA_DRAYNOR = new Area(3088, 3246, 3097, 3240);
	public static final Area TREE_AREA_DRAYNOR  = new Area(3081, 3239, 3092, 3225);
	
	public static final Area BANK_AREA_VEAST = new Area(3250, 3425, 3258, 3414);
	public static final Area TREE_AREA_VEAST = new Area(3275, 3427, 3286, 3409);
	
	public static final Area BANK_AREA_SEERS = new Area(2720, 3497, 2731, 3489);
	
	public static final Area TREE_AREA_SEERS_MAPLE = new Area(2704, 3518, 2733, 3499);
	public static final Area TREE_AREA_SEERS_YEW = new Area(2702, 3470, 2722, 3455);
	public static final Area TREE_AREA_SEERS_MAGIC_1 = new Area(2689, 3430, 2707, 3415);
	public static final Area TREE_AREA_SEERS_MAGIC_2 = new Area(2699, 3403, 2709, 3391);
	
	public static final Area BANK_AREA_EDGEVILLE = new Area(3090, 3501, 3099, 3487);
	public static final Area TREE_AREA_EDGEVILLE = new Area(3084, 3483, 3091, 3466);
	
	public static Area BANK_AREA_SELECTED = null;
	public static Area TREE_AREA_SELECTED = null;
	
	public static boolean powerChop = false;
	public static boolean pickupNest = false;
	
	public static final String TREE = "Tree";
	public static final String OAK = "Oak";
	public static final String WILLOW = "Willow";
	public static final String MAPLE = "Maple Tree";
	public static final String YEW = "Yew";
	public static final String MAGIC = "Magic Tree";
	
	public static int LOG_PRICE = 0;
	public static int OAK_PRICE = 0;
	public static int WILLOW_PRICE = 0;
	public static int MAPLE_PRICE = 0;
	public static int YEW_PRICE = 0;
	public static int MAGIC_PRICE = 0;
	
	public static void setPrices() throws Exception {
		LOG_PRICE = PriceChecker.LOGS.getPrice();
		OAK_PRICE = PriceChecker.OAK_LOGS.getPrice();
		WILLOW_PRICE = PriceChecker.WILLOW_LOGS.getPrice();
		MAPLE_PRICE = PriceChecker.MAPLE_LOGS.getPrice();
		YEW_PRICE = PriceChecker.YEW_LOGS.getPrice();
		MAGIC_PRICE = PriceChecker.MAGIC_LOGS.getPrice();
	}
	
	public static String selectedTree = "";
	
	public static final int BRONZE_AXE = 1351;
	public static final int IRON_AXE = 1349;
	public static final int STEEL_AXE = 1353;
	public static final int BLACK_AXE = 1361;
	public static final int MITHRIL_AXE = 1355;
	public static final int ADAMANT_AXE = 1357;
	public static final int RUNE_AXE = 1359;
	
	public static int selectedAxe = 1359;
	
	public static int logsChopped;
	public static int nestsFound;
	public static int startXp;
	
	public static String treeName = "Willow";
	public static String status = "Init";

}

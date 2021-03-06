package com.singlecore.scripts.treechopper.data;

import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.utility.Area;

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
	
	public static final Area BANK_AREA_CATHERBY = new Area(2805, 3447, 2813, 3437);
	public static final Area TREE_AREA_CATHERBY = new Area(2754, 3441, 2782, 3421);
	
	public static Area BANK_AREA_SELECTED = null;
	public static Area TREE_AREA_SELECTED = null;
	
	public static final Position[] pathToYewsCath = new Position[] {
		new Position(2810, 3438, 0),
		new Position(2810, 3435, 0),
		new Position(2805, 3433, 0),
		new Position(2802, 3433, 0),
		new Position(2795, 3433, 0),
		new Position(2791, 3433, 0),
		new Position(2788, 3433, 0),
		new Position(2783, 3433, 0),
		new Position(2779, 3433, 0),
		new Position(2774, 3432, 0),
		new Position(2767, 3432, 0)
	};
	
	public static final Position[] pathToBankCath = new Position[] {
		new Position(2768, 3432, 0),
		new Position(2770, 3433, 0),
		new Position(2774, 3435, 0),
		new Position(2777, 3436, 0),
		new Position(2780, 3437, 0),
		new Position(2786, 3438, 0),
		new Position(2792, 3437, 0),
		new Position(2793, 3435, 0),
		new Position(2797, 3434, 0),
		new Position(2802, 3432, 0),
		new Position(2805, 3432, 0),
		new Position(2807, 3432, 0),
		new Position(2808, 3433, 0),
		new Position(2810, 3437, 0),
		new Position(2810, 3441, 0)
	};
	
	public static final Position[] pathToMagics = new Position[] {
			new Position(2725, 3490, 0),
			new Position(2725, 3483, 0),
			new Position(2725, 3479, 0),
			new Position(2725, 3474, 0),
			new Position(2725, 3469, 0),
			new Position(2723, 3462, 0),
			new Position(2723, 3455, 0),
			new Position(2721, 3453, 0),
			new Position(2719, 3447, 0),
			new Position(2717, 3442, 0),
			new Position(2713, 3438, 0),
			new Position(2711, 3435, 0),
			new Position(2707, 3431, 0),
			new Position(2703, 3428, 0),
			new Position(2700, 3424, 0),
			new Position(2698, 3423, 0)
	};
	
	public static final Position[] pathToMagicBank = new Position[] {
			new Position(2698, 3424, 0),
			new Position(2701, 3429, 0),
			new Position(2705, 3432, 0),
			new Position(2705, 3437, 0),
			new Position(2710, 3440, 0),
			new Position(2710, 3441, 0),
			new Position(2713, 3447, 0),
			new Position(2716, 3450, 0),
			new Position(2718, 3453, 0),
			new Position(2721, 3456, 0),
			new Position(2723, 3458, 0),
			new Position(2725, 3462, 0),
			new Position(2726, 3465, 0),
			new Position(2726, 3471, 0),
			new Position(2726, 3473, 0),
			new Position(2726, 3478, 0),
			new Position(2726, 3481, 0),
			new Position(2728, 3485, 0),
			new Position(2726, 3491, 0)
	};
	
	public static boolean powerChop = false;
	
	public static final String TREE = "Tree";
	public static final String OAK = "Oak";
	public static final String WILLOW = "Willow";
	public static final String MAPLE = "Maple Tree";
	public static final String YEW = "Yew";
	public static final String MAGIC = "Magic Tree";
	
	public static int SELECTED_PRICE = 0;
	
	public static String selectedTree = "";
	
	public static final int BRONZE_AXE = 1351;
	public static final int IRON_AXE = 1349;
	public static final int STEEL_AXE = 1353;
	public static final int BLACK_AXE = 1361;
	public static final int MITHRIL_AXE = 1355;
	public static final int ADAMANT_AXE = 1357;
	public static final int RUNE_AXE = 1359;
	public static final int DRAGON_AXE = 6739;
	
	public static int selectedAxe = 1359;
	
	public static int logsChopped;
	public static int nestsFound;
	public static int startXp;
	
	public static String treeName = "Willow";
	public static String status = "Init";

}

package rktechltd.aklfishing.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;

import java.util.ArrayList;
import java.util.List;

import rktechltd.aklfishing.models.Category;
import rktechltd.aklfishing.models.Checklist;
import rktechltd.aklfishing.models.Faq;
import rktechltd.aklfishing.models.Fish;
import rktechltd.aklfishing.models.FishCatch;
import rktechltd.aklfishing.models.FishingExperience;
import rktechltd.aklfishing.models.ImageHelper;
import rktechltd.aklfishing.models.Location;
import rktechltd.aklfishing.models.NetRule;

/**
 * Created by romelyn on 13/05/2016.
 */
public class AKLFishingDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "aklfishingdatabase.db";
    public static final int DB_VERSION = 2;

    private static final String TEXT_TYPE = " TEXT";
    private static final String REAL_TYPE = " REAL";
    private static final String DATE_TYPE = " DATE";
    private static final String TIME_TYPE = " TIME";
    private static final String NUMERIC_TYPE = " NUMERIC";
    private static final String BLOB_TYPE = " BLOB";
    private static final String COMMA_SEP = ",";

    private static final String CREATE_CATEGORY_TABLE = "CREATE TABLE " + AKLFishingDBTables.Category.TABLE_NAME + " (" +
            AKLFishingDBTables.Category.COLUMN_CAT_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Category.COLUMN_CAT_NAME + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Category.COLUMN_CAT_DESC + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Category.PRIMARY_KEY +
            " )";

    private static final String CREATE_CHECKLIST_TABLE = "CREATE TABLE " + AKLFishingDBTables.CheckList.TABLE_NAME + " (" +
            AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_TITLE + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_IMAGE + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.CheckList.PRIMARY_KEY +
            " )";
    private static final String CREATE_FAQ_TABLE = "CREATE TABLE " + AKLFishingDBTables.Faq.TABLE_NAME + " (" +
            AKLFishingDBTables.Faq.COLUMN_FAQ_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Faq.COLUMN_FAQ_QUESTION + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Faq.COLUMN_FAQ_ANSWER + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Faq.PRIMARY_KEY +
            " )";
    private static final String CREATE_FISH_TABLE = "CREATE TABLE " + AKLFishingDBTables.Fish.TABLE_NAME + " (" +
            AKLFishingDBTables.Fish.COLUMN_FISH_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_FISH_NAME + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_FISH_CAT+ NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_FISH_DESC+ TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_FISH_IMAGE+ TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_MIN_FISH_LENGTH_CM+ NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_MIN_FISH_MAX_DAILY_LIMIT + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.COLUMN_IS_COMBINED_BAG + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Fish.PRIMARY_KEY +
            " )";



    private static final String CREATE_LOCATION_TABLE = "CREATE TABLE " + AKLFishingDBTables.Location.TABLE_NAME + " (" +
            AKLFishingDBTables.Location.COLUMN_LOCATION_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.Location.COLUMN_LOCATION_NAME + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Location.COLUMN_lOCATION_LATITUDE+ REAL_TYPE + COMMA_SEP +
            AKLFishingDBTables.Location.COLUMN_LOCATION_LONGITUDE+ REAL_TYPE + COMMA_SEP +
            AKLFishingDBTables.Location.COLUMN_LOCATION_N0TE+ TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.Location.PRIMARY_KEY +
            " )";

    private static final String CREATE_FISHEXPERIENCE_TABLE = "CREATE TABLE " + AKLFishingDBTables.FishingExperience.TABLE_NAME + " (" +
            AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_LOCATION_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_DATE+ DATE_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_TIME+ TIME_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_REMARK+ TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishingExperience.PRIMARY_KEY +
            " )";

    private static final String CREATE_FISHCATCH_TABLE = "CREATE TABLE " + AKLFishingDBTables.FishCatch.TABLE_NAME + " (" +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_EXPERIENCE + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_NAME + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_LENGTH + REAL_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_WEIGHT + REAL_TYPE + COMMA_SEP +
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_REMARK + TEXT_TYPE + COMMA_SEP+
            AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_IMAGE + TEXT_TYPE + COMMA_SEP+
            AKLFishingDBTables.FishCatch.PRIMARY_KEY +
            " )";

    private static final String CREATE_NETRULES_TABLE = "CREATE TABLE " + AKLFishingDBTables.NetRules.TABLE_NAME + " (" +
            AKLFishingDBTables.NetRules.COLUMN_NETRULES_ID + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.NetRules.COLUMN_NETRULES_TITLE + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.NetRules.COLUMN_NETRULES_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
            AKLFishingDBTables.NetRules.COLUMN_NETRULES_PENALTY + NUMERIC_TYPE + COMMA_SEP +
            AKLFishingDBTables.NetRules.COLUMN_NETRULES_IMAGE + BLOB_TYPE + COMMA_SEP +
            AKLFishingDBTables.NetRules.PRIMARY_KEY +
            " )";

    private static final String DELETE_CATEGORY_TABLE = "DROP TABLE IF EXISTS " + AKLFishingDBTables.Category.TABLE_NAME;
    private static final String DELETE_FISH_TABLE = "DROP TABLE IF EXISTS " + AKLFishingDBTables.Fish.TABLE_NAME;
    private static final String DELETE_lOCATION_TABLE = "DROP TABLE IF EXISTS " + AKLFishingDBTables.Location.TABLE_NAME;
    private static final String DELETE_FISHEXPERIENCE_TABLE = "DROP TABLE IF EXISTS " + AKLFishingDBTables.FishingExperience.TABLE_NAME;
    private static final String DELETE_FISHCATCH_TABLE= "DROP TABLE IF EXISTS " + AKLFishingDBTables.FishCatch.TABLE_NAME;
    private static final String DELETE_CHECKLIST_TABLE= "DROP TABLE IF EXISTS " + AKLFishingDBTables.CheckList.TABLE_NAME;
    private static final String DELETE_NETRULES_TABLE= "DROP TABLE IF EXISTS " + AKLFishingDBTables.NetRules.TABLE_NAME;
    private static final String DELETE_FAQ_TABLE= "DROP TABLE IF EXISTS " + AKLFishingDBTables.Faq.TABLE_NAME;


    public AKLFishingDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_FISH_TABLE);
        db.execSQL(CREATE_LOCATION_TABLE);
        db.execSQL(CREATE_FISHEXPERIENCE_TABLE);
        db.execSQL(CREATE_FISHCATCH_TABLE);
        db.execSQL(CREATE_CHECKLIST_TABLE);
        db.execSQL(CREATE_NETRULES_TABLE);
        db.execSQL(CREATE_FAQ_TABLE);

        //save existing data TBA
        //checkListId, String title, String description, byte[] image) {
      Checklist[] checklists = new Checklist[]{ new Checklist(1,"Life Jackets and personal floatation device (PFDs)","Maritime law requires ALL skippers to carry enough life jackets of the right size and type for everyone on board. Wearing a life jacket is mandatory at all times unless the risk is very low.", ImageHelper.convertImage("drawable/safetychecklist/LifeJackets.png") ),
                                                new Checklist(2,"Communication Equipment","This include distress beacons (EPIRB or PLB) VHF radio, flares, and cellphones.  On any trip you need to carry two means of waterproof communication and three means if you are over 2 miles from shore.",ImageHelper.convertImage("drawable/safetychecklist/Communication.png") ),
                                                new Checklist(3,"Navigation","You will need a chart and compass in all but the smallest of boats if you go more than a mile or two from shore.  A GPS and a depth sounder are also very useful.  Exactly what you carry will depend on the size and type of your boat and how far from land you go.  Talk to Coastguard of New Zealand for advice.",ImageHelper.convertImage("drawable/safetychecklist/Navigation.png") ),
                                                new Checklist(4,"Anchor","To determine the right size for your boat, the anchor should weigh not less than 1.5kg per meter of boat length, with chain at least equal to the length of the boat.  A non-floating rope well secured to the boat should be as long as is.",ImageHelper.convertImage("drawable/safetychecklist/anchor.png") ),
                                                new Checklist(5,"First Aid Kit","Your kit should contain enough supplies to cover minor accidents or injuries.  Remember to carry a remedy for sea sickness as well as sun block.",ImageHelper.convertImage("drawable/safetychecklist/FirstAid.png") ),
                                                new Checklist(6,"Fire Extinguishers","If you have an engine or cooker on board always carry at least one fire extinguisher that is suitable for your type of boating.  Know how to use it and ensure it is serviced regularly.",ImageHelper.convertImage("drawable/safetychecklist/FireExtinguishers.png") ),
                                                new Checklist(7,"Throwing Line","A floating line at least 12m in length with a floating weight at one end",ImageHelper.convertImage("drawable/safetychecklist/ThrowingLine.png") ),
                                                new Checklist(8,"Protective Clothin","Carry adequate warm protective clothing",ImageHelper.convertImage("drawable/safetychecklist/ProtectiveClothing.png") ),
                                                new Checklist(8,"Knife","Has many uses - remember to keep it sharp.",ImageHelper.convertImage("drawable/safetychecklist/Knife.png") ),
                                                new Checklist(9,"Torch","Always carry a torch with spare batteries and bulb.",ImageHelper.convertImage("drawable/safetychecklist/Torch.png") ),
      };

        Category[] cats = new Category[]{new Category(1, "Fin Fish", "Fin Fish"),
                                         new Category(2, "Cray Fish", "Cray Fish"),
                                         new Category(3, "Shell Fish", "Shell Fish")
        };

        Fish[] fishes = new Fish[]{ new Fish(1, "Blue Cod", "Blue Cod", ImageHelper.convertImage("drawable/fish/finfish/bluecod.png"), 1, 30, 20, 1),
                                    new Fish(2, "Blue Moki", "Blue Moki", ImageHelper.convertImage("drawable/fish/finfish/bluemoki.png"),1, 40, 20, 1),
                                    new Fish(3, "Blue Nose", "Blue Nose", ImageHelper.convertImage("drawable/fish/finfish/bluenose.png"),1, 0, 5, 1),
                                    new Fish(4, "Butterfish ", "Butterfish", ImageHelper.convertImage("drawable/fish/finfish/butterfish.png"), 1, 35, 20, 1),
                                    new Fish(5, "Elephant Fish", "Elephant Fish", ImageHelper.convertImage("drawable/fish/finfish/elephantfish.png"), 1, 0, 20, 1),
                                    new Fish(6, "Flat Fish", "Flat Fish", ImageHelper.convertImage("drawable/fish/finfish/flatfish.png"), 1, 25, 20, 1),
                                    new Fish(9, "John Dory", "John Dory", ImageHelper.convertImage("drawable/fish/finfish/johndory.png"), 1, 0, 20, 1),
                                    new Fish(10, "Kahawai", "Kahawai", ImageHelper.convertImage("drawable/fish/finfish/kahawai.png"), 1, 0, 20, 1),
                                    new Fish(11, "Parore", "Parore", ImageHelper.convertImage("drawable/fish/finfish/parore.png"), 1, 0, 20, 1),
                                    new Fish(12, "Porae", "Porae", ImageHelper.convertImage("drawable/fish/finfish/porae.png"), 1, 0, 20, 1),
                                    new Fish(13, "Rays Bream", "Rays Bream", ImageHelper.convertImage("drawable/fish/finfish/raysbream.png"), 1, 0, 0, 1),
                                    new Fish(14, "Gurnard", "Gurnard", ImageHelper.convertImage("drawable/gurnard.png"),1, 25, 20, 1),
                                    new Fish(15, "Red Moki", "Red Moki", ImageHelper.convertImage("drawable/fish/finfish/redmoki.png"), 1, 40, 20, 1),
                                    new Fish(16, "Red Snapper", "Red Snapper", ImageHelper.convertImage("drawable/fish/finfish/redsnapper.png"), 1, 20, 0, 1),
                                    new Fish(17, "Rig", "Rig", ImageHelper.convertImage("drawable/fish/finfish/rig.png"), 1, 0, 20, 1),
                                    new Fish(18, "Sand Flounder", "Sand Flounder", ImageHelper.convertImage("drawable/fish/finfish/sandflounder.png"), 1, 23, 20, 1),
                                    new Fish(19, "School Shark", "School Shark", ImageHelper.convertImage("drawable/fish/finfish/schoolshark.png"),1, 0, 20, 1),
                                    new Fish(20, "Tarakihi", "Tarakihi", ImageHelper.convertImage("drawable/fish/finfish/tarakihi.png"), 1, 25, 20, 1),
                                    new Fish(21, "Trevally", "Trevally", ImageHelper.convertImage("drawable/fish/finfish/trevally.png"),1, 25, 20, 1),
                                    new Fish(22, "Eel", "Eel", ImageHelper.convertImage("drawable/fish/finfish/eel.png"), 1, 0, 6, 1),
                                    new Fish(23, "Garfish", "Garfish", ImageHelper.convertImage("drawable/fish/finfish/garfish.png"),1, 0, 0, 1),
                                    new Fish(24, "Groper", "Groper", ImageHelper.convertImage("drawable/fish/finfish/groper.png"), 1, 0, 5, 1),
                                    new Fish(25, "Kingfish", "Kingfish", ImageHelper.convertImage("drawable/fish/finfish/kingfish.png"), 1, 75, 3, 1),
                                    new Fish(26, "Grey Mullet", "Grey Mullet", ImageHelper.convertImage("drawable/fish/finfish/greymullet.png"), 1, 0, 30, 1),
                                    new Fish(27, "Pilchards", "Pilchards", ImageHelper.convertImage("drawable/fish/finfish/pilchards.png"), 1, 0, 0, 1),
                                    new Fish(28, "Snapper", "Snapper", ImageHelper.convertImage("drawable/fish/finfish/snapper.png"),1, 27, 10, 1),
                                    new Fish(29, "Yellow Eyed Mullet", "Yellow Eyed Mullet", ImageHelper.convertImage("drawable/fish/finfish/yelloweyedmullet.png"), 1, 0, 0, 1),

                                    new Fish(30, "Anchovy", "Anchovy", ImageHelper.convertImage("drawable/fish/finfish/anchovy.png"),1, 0, 0, 1),
                                    new Fish(31, "Barracouta", "Barracouta", ImageHelper.convertImage("drawable/fish/finfish/barracouta.png"), 1, 0, 0, 1),
                                    new Fish(32, "Big Eye Tuna", "Big Eye Tuna", ImageHelper.convertImage("drawable/fish/finfish/bigeyetuna.png"), 1, 0, 0, 1),
                                    new Fish(33, "Blue Mackerel", "Blue Mackerel", ImageHelper.convertImage("drawable/fish/finfish/bluemackerel.png"), 1, 0, 0, 1),
                                    new Fish(34, "Blue Marlin", "Blue Marlin", ImageHelper.convertImage("drawable/fish/finfish/bluemarlin.png"),1, 0, 0, 1),
                                    new Fish(35, "Blue Mao", "Blue Mao", ImageHelper.convertImage("drawable/fish/finfish/bluemaomao.png"), 1, 0, 0, 1),

                                    new Fish(37, "Blue Shark", "Blue Shark", ImageHelper.convertImage("drawable/fish/finfish/blueshark.png"), 1, 0, 0, 1),
                                    new Fish(38, "Bronze Shark", "Bronze Shark", ImageHelper.convertImage("drawable/fish/finfish/bronzeshark.png"), 1, 0, 0, 1),
                                    new Fish(39, "Cardinalfish", "Cardinalfish", ImageHelper.convertImage("drawable/fish/finfish/cardinalfish.png"), 1, 0, 0, 1),
                                    new Fish(40, "Frostfish", "Frostfish", ImageHelper.convertImage("drawable/fish/finfish/frostfish.png"),1, 0, 0, 1),

                                    new Fish(42, "Gemfish", "Gemfish", ImageHelper.convertImage("drawable/fish/finfish/gemfish.png"), 1, 0, 0, 1),
                                    new Fish(43, "Greenback Flounder", "Greenback Flounder", ImageHelper.convertImage("drawable/fish/finfish/greenbackflounder.png"), 1, 25, 20, 1),
                                    new Fish(44, "Hake", "Hake", ImageHelper.convertImage("drawable/fish/finfish/hake.png"),1, 0, 0, 1),
                                    new Fish(45, "Hammerhead Shark ", "Hammerhead Shark", ImageHelper.convertImage("drawable/fish/finfish/hammerhearshark.png"),1, 0, 0, 1),
                                    new Fish(46, "Hoki", "Hoki", ImageHelper.convertImage("drawable/fish/finfish/hoki.png"), 1, 0, 0, 1),
                                    new Fish(47, "Jack Mackerel", "Jack Mackerel", ImageHelper.convertImage("drawable/fish/finfish/jackmackerel.png"), 1, 0, 0, 1),
                                    new Fish(48, "Leather Jacket", "Leather Jacket", ImageHelper.convertImage("drawable/fish/finfish/leatherjacket.png"),1, 0, 0, 1),
                                    new Fish(49, "Ling", "Ling", ImageHelper.convertImage("drawable/fish/finfish/ling.png"), 1, 0, 0, 1),
                                    new Fish(50, "Mako Shark", "Mako Shark", ImageHelper.convertImage("drawable/fish/finfish/makoshark.png"), 1, 0, 0, 1),

                                    new Fish(51, "Marble Fish", "Marble Fish", ImageHelper.convertImage("drawable/fish/finfish/marblefish.png"),1, 0, 0, 1),
                                    new Fish(52, "Marlin", "Marlin", ImageHelper.convertImage("drawable/fish/finfish/marlin.png"), 1, 0, 0, 1),
                                    new Fish(53, "Moonfish", "Moonfish", ImageHelper.convertImage("drawable/fish/finfish/moonfish.png"), 1, 0, 0, 1),
                                    new Fish(54, "Pacific Bluefin Tuna", "Pacific Bluefin Tuna", ImageHelper.convertImage("drawable/fish/finfish/pacificbluefintuna.png"), 1, 0, 0, 1),
                                    new Fish(55, "Porbeagle Shark", "Porbeagle Shark", ImageHelper.convertImage("drawable/fish/finfish/porbeagleshark.png"),1, 0, 0, 1),
                                    new Fish(56, "Quinnat Salmon", "Quinnat Salmon", ImageHelper.convertImage("drawable/fish/finfish/quinnatsalmon.png"),1, 0, 0, 1),
                                    new Fish(57, "Red Cod", "Red Cod", ImageHelper.convertImage("drawable/fish/finfish/redcod.png"), 1, 25, 20, 1),
                                    new Fish(58, "Sea Perch", "Sea Perch", ImageHelper.convertImage("drawable/fish/finfish/seaperch.png"),1, 0, 10, 1),
                                    new Fish(59, "7 Gill Shark", "7 Gill Shark", ImageHelper.convertImage("drawable/fish/finfish/sevengillshark.png"), 1, 0, 0, 1),
                                    new Fish(60, "Silver Warehou", "Silver Warehou", ImageHelper.convertImage("drawable/fish/finfish/silverwarehou.png"), 1, 0, 0, 1),

                                    new Fish(61, "Skate", "Skate", ImageHelper.convertImage("drawable/fish/finfish/skate.png"), 1, 0, 0, 1),
                                    new Fish(62, "Skipjack", "Skipjack", ImageHelper.convertImage("drawable/fish/finfish/skipjack.png"), 1, 0, 0, 1),
                                    new Fish(63, "Slender Sprat", "Slender Sprat", ImageHelper.convertImage("drawable/fish/finfish/slendersprat.png"), 1, 0, 0, 1),
                                    new Fish(64, "Smelt", "Smelt", ImageHelper.convertImage("drawable/fish/finfish/smelt.png"), 1, 0, 0, 1),
                                    new Fish(65, "Spiny Dogfish", "Spiny Dogfish", ImageHelper.convertImage("drawable/fish/finfish/spinydogfish.png"),1, 0, 0, 1),
                                    new Fish(66, "Stargazer", "Stargazer", ImageHelper.convertImage("drawable/fish/finfish/stargazer.png"), 1, 0, 0, 1),
                                    new Fish(67, "Swordfish", "Swordfish", ImageHelper.convertImage("drawable/fish/finfish/swordfish.png"), 1, 0, 0, 1),
                                    new Fish(68, "Trumpeter", "Trumpeter", ImageHelper.convertImage("drawable/fish/finfish/trumpeter.png"), 1, 0, 0, 1),
                                    new Fish(69, "Warehou", "Warehou", ImageHelper.convertImage("drawable/fish/finfish/warehou.png"), 1, 0, 0, 1),
                                    new Fish(70, "Wrasse", "Wrasse", ImageHelper.convertImage("drawable/fish/finfish/wrasse.png"), 1, 0, 0, 1),
                                    new Fish(71, "Yellowfin Tuna", "Yellowfin Tuna", ImageHelper.convertImage("drawable/fish/finfish/yellowfintuna.png"), 1, 0, 0, 1),


                                    new Fish(72, "Koura", "Koura", ImageHelper.convertImage("drawable/fish/crayfish/koura.png"), 2, 0, 0, 1),
                                    new Fish(73, "Packhorse Rock Lobster", "Packhorse Rock Lobster", ImageHelper.convertImage("drawable/fish/crayfish/packhorserocklobster.png"), 2, 22, 6, 1),
                                    new Fish(74, "Spiny Rock Lobster", "Spiny Rock Lobster", ImageHelper.convertImage("drawable/fish/crayfish/spinyrocklobster.png"), 2, 6, 6, 1),


                                    new Fish(75, "Arrow Squid", "Arrow Squid", ImageHelper.convertImage("drawable/fish/shellfish/spinyrocklobster.png"), 3, 0, 50, 1),
                                    new Fish(76, "Cockle", "Cockle", ImageHelper.convertImage("drawable/fish/shellfish/spinyrocklobster.png"), 3, 0, 50, 1),
                                    new Fish(77, "Kina", "Kina", ImageHelper.convertImage("drawable/fish/shellfish/kina.png"),3, 0, 50, 1),
                                    new Fish(78, "Knobbed Whelk", "Knobbed Whelk", ImageHelper.convertImage("drawable/fish/shellfish/knobbedwhelk.png"), 3, 0, 50, 1),
                                    new Fish(79, "Mussel", "Mussel", ImageHelper.convertImage("drawable/fish/shellfish/mussel.png"), 3, 0, 25, 1),
                                    new Fish(80, "Octopus", "Octopus", ImageHelper.convertImage("drawable/fish/shellfish/octopus.png"),3, 0, 50, 1),
                                    new Fish(81, "Oyster (dredge)", "Oyster (dredge)", ImageHelper.convertImage("drawable/fish/shellfish/oysterdredge.png"), 3, 6, 50, 1),
                                    new Fish(82, "Oyster (rock/pacific)", "Oyster (rock/pacific)", ImageHelper.convertImage("drawable/fish/shellfish/oysterrockpacific.png"),3, 0, 100, 1),
                                    new Fish(83, "Paddle Crab", "Paddle Crab", ImageHelper.convertImage("drawable/fish/shellfish/paddlecrab.png"), 3, 0, 50, 1),
                                    new Fish(84, "Paua", "Paua", ImageHelper.convertImage("drawable/fish/shellfish/paua.png"), 3, 13, 15, 1),
                                    new Fish(85, "Pipi", "Pipi", ImageHelper.convertImage("drawable/fish/shellfish/pipi.png"), 3, 0, 50, 1),
                                    new Fish(86, "Red Crab", "Red Crab", ImageHelper.convertImage("drawable/fish/shellfish/redcrab.png"),3, 0, 50, 1),
                                    new Fish(87, "Scallop", "Scallop", ImageHelper.convertImage("drawable/fish/shellfish/scallop.png"), 3, 10, 20, 1),
                                    new Fish(89, "Trough Shell", "Trough Shell", ImageHelper.convertImage("drawable/fish/shellfish/troughshell.png"), 3, 0, 50, 1),
                                    new Fish(90, "Tuatua", "Tuatua", ImageHelper.convertImage("drawable/fish/shellfish/tuatua.png"), 3, 0, 50, 1)
        };




        Faq [] faqs = new Faq[] { new Faq(1, "Do I need a fishing licence?", "Yes you need a fishing licence to fish in all freshwater fisheries in NZ, these can be purchased online or once you arrive in NZ at most sports stores and retailers  specialising in fishing and the outdoors."),
                                  new Faq(2, "When does the fishing season start in New Zealand?", "The lowland streams all open on the 1st October with the back country rivers opening on the 1st NOVEMBER. The Southern Lakes are open all year round for fishing with some great options if your here during this time and interested in a days fishing."),
                                  new Faq(3, "Can I bring my own fishing gear to New Zealand?", "Yes, we recommend you bring your own gear to NZ where where possible. Using your own fishing equipment gives  you added confidence.you added confidence.")
        };


          NetRule[] netRules = new NetRule[] { new NetRule(1,"Set nets must have surface float at each end that is clearly and legibly marked with the fisher's last name, initials and phone no.","Set nets must be marked",250, ImageHelper.convertImage("drawable/netrules/netsmarked.png")),
                                               new NetRule(2, "Suitable anchors and floats must be used to deploy a set net", "Use stakes to hold nets is prohibited", 250, ImageHelper.convertImage("drawable/netrules/netprohibited.png")),
                                               new NetRule(3, "Nets must not be used in a way that allows fish to be stranded in the net by the falling tide", "Stalling of nets is probihited", 250, ImageHelper.convertImage("drawable/netrules/netnotallowed.png")),
                                               new NetRule(4, "No net (Either used alone or with other nets) can be set more than a quarter of the way across a channel, bay or waterway", "Restrictions on nets in channels", 250,ImageHelper.convertImage("drawable/netrules/netchannels.png")),
                                               new NetRule(5, "NOTE: Drag nets may only be 40m in length", "Set nets must be less than 60m in length", 250,ImageHelper.convertImage("drawable/netrules/60mlength.png")),
                                               new NetRule(6, "NOTE: There must be at least 2 fishers on the boat and the second net may only be used if it is less than 10m long and has a mesh of a less than 50mm", "Maximum one net per person or one set and one bait net per vessel", 250,ImageHelper.convertImage("drawable/netrules/baitvessel.png")),
                                               new NetRule(7, "A person may not set any set within 60m of another net.", "Nets must be more than 60m apart", 250,ImageHelper.convertImage("drawable/netrules/60mapart.png")),
                                               new NetRule(8, "No person may possess or use a baited net other than a fyke net or hinaki net.", "Using baited nets is prohibited", 250,ImageHelper.convertImage("drawable/netrules/bait.png"))
          };

        for(Checklist c : checklists ){
          saveCheckList(c);
         }

        for(Category c : cats ){
            saveCategory(c);
        }
        for(Faq f : faqs ){
            saveFaq(f);
        }

        for(NetRule n : netRules ){
            saveNetRule(n);
        }

        for(Fish f :fishes ){
            saveFish(f);
        }

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_CATEGORY_TABLE);
        db.execSQL(DELETE_FISH_TABLE);
        db.execSQL(DELETE_lOCATION_TABLE);
        db.execSQL(DELETE_FISHEXPERIENCE_TABLE);
        db.execSQL(DELETE_FISHCATCH_TABLE);
        db.execSQL(DELETE_CHECKLIST_TABLE);
        db.execSQL(DELETE_NETRULES_TABLE);
        db.execSQL(DELETE_FAQ_TABLE);
        onCreate(db);
    }

    public boolean saveCategory(Category aCategory) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AKLFishingDBTables.Category.COLUMN_CAT_ID, aCategory.getCategoryId());
        cv.put(AKLFishingDBTables.Category.COLUMN_CAT_NAME, aCategory.getCategoryName());
        cv.put(AKLFishingDBTables.Category.COLUMN_CAT_DESC, aCategory.getCategoryDescription());

        db.insert(AKLFishingDBTables.Category.TABLE_NAME, null, cv);
        db.close();
        return true;
    }

    public boolean saveCheckList(Checklist aCheckList){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_ID,aCheckList.getCheckListId());
        cv.put(AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_TITLE, aCheckList.getTitle());
        cv.put(AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_DESCRIPTION,aCheckList.getDescription());
        cv.put(AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_IMAGE,aCheckList.getImage());
        db.insert(AKLFishingDBTables.CheckList.TABLE_NAME,null, cv);
        db.close();
        return true;
    }
    public boolean saveFaq(Faq aFaq){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AKLFishingDBTables.Faq.COLUMN_FAQ_ID,aFaq.getFaqId());
        cv.put(AKLFishingDBTables.Faq.COLUMN_FAQ_QUESTION,aFaq.getQuestion());
        cv.put(AKLFishingDBTables.Faq.COLUMN_FAQ_ANSWER,aFaq.getAnswer());
        db.insert(AKLFishingDBTables.Faq.TABLE_NAME,null, cv);
        db.close();
        return true;
    }

    public boolean saveFish(Fish aFish) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AKLFishingDBTables.Fish.COLUMN_FISH_ID, aFish.getFishId());
        cv.put(AKLFishingDBTables.Fish.COLUMN_FISH_NAME, aFish.getFishName());
        cv.put(AKLFishingDBTables.Fish.COLUMN_FISH_CAT, aFish.getFishCat());
        cv.put(AKLFishingDBTables.Fish.COLUMN_FISH_DESC, aFish.getFishDescription());
        cv.put(AKLFishingDBTables.Fish.COLUMN_FISH_IMAGE, aFish.getFishImage());
        cv.put(AKLFishingDBTables.Fish.COLUMN_MIN_FISH_LENGTH_CM, aFish.getMinFishLengthCm());
        cv.put(AKLFishingDBTables.Fish.COLUMN_MIN_FISH_MAX_DAILY_LIMIT, aFish.getMinFishLengthCm());
        cv.put(AKLFishingDBTables.Fish.COLUMN_IS_COMBINED_BAG, aFish.isCombinedBag());
        db.insert(AKLFishingDBTables.Fish.TABLE_NAME, null, cv);
        db.close();
        return true;
    }

    public boolean saveFishingCatch(FishCatch aFishCatch) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_ID, aFishCatch.getFishCatchId());
        cv.put(AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_EXPERIENCE, aFishCatch.getFx());
        cv.put(AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_LENGTH,aFishCatch.getLength());
        cv.put(AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_WEIGHT, aFishCatch.getWeight());
        cv.put(AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_IMAGE, aFishCatch.getPicture());
        cv.put(AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_REMARK, aFishCatch.getRemark());
        db.insert(AKLFishingDBTables.FishCatch.TABLE_NAME, null, cv);
        db.close();
        return true;
    }
    public boolean saveFishingExperience(FishingExperience aFishExp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_ID, aFishExp.getExperienceId());
        cv.put(AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_LOCATION_ID, aFishExp.getLocation());
        cv.put(AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_DATE,aFishExp.getDate().toString());
        cv.put(AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_TIME, aFishExp.getTime().toString());
        cv.put(AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_REMARK, aFishExp.getRemark());
        db.insert(AKLFishingDBTables.FishingExperience.TABLE_NAME, null, cv);
        db.close();
        return true;
    }

    public boolean saveLocation(Location aLocation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AKLFishingDBTables.Location.COLUMN_LOCATION_ID, aLocation.getLocationId());
        cv.put(AKLFishingDBTables.Location.COLUMN_LOCATION_NAME, aLocation.getLocationName());
        cv.put(AKLFishingDBTables.Location.COLUMN_LOCATION_LONGITUDE, aLocation.getLongitude());
        cv.put(AKLFishingDBTables.Location.COLUMN_lOCATION_LATITUDE, aLocation.getLatitude());
        cv.put(AKLFishingDBTables.Location.COLUMN_LOCATION_N0TE, aLocation.getNote());
        db.insert(AKLFishingDBTables.Location.TABLE_NAME, null, cv);
        db.close();
        return true;
    }

    public boolean saveNetRule(NetRule aNetRule){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AKLFishingDBTables.NetRules.COLUMN_NETRULES_ID,aNetRule.getRulesId());
        cv.put(AKLFishingDBTables.NetRules.COLUMN_NETRULES_TITLE, aNetRule.getTitle());
        cv.put(AKLFishingDBTables.NetRules.COLUMN_NETRULES_DESCRIPTION,aNetRule.getDescription());
        cv.put(AKLFishingDBTables.NetRules.COLUMN_NETRULES_PENALTY, aNetRule.getPenalty());
        cv.put(AKLFishingDBTables.NetRules.COLUMN_NETRULES_IMAGE,aNetRule.getImage());
        db.insert(AKLFishingDBTables.NetRules.TABLE_NAME,null, cv);
        db.close();
        return true;
    }

    public List<Category> getAllCategories() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Category> catList=null;
        String query = "SELECT " + AKLFishingDBTables.Category.COLUMN_CAT_ID + ", "
                + AKLFishingDBTables.Category.COLUMN_CAT_NAME + ", "
                + AKLFishingDBTables.Category.COLUMN_CAT_DESC + " FROM "
                + AKLFishingDBTables.Category.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            catList = new ArrayList<Category>();
            cursor.moveToFirst();
            do {
                Category aCat = new Category(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                catList.add(aCat);
            } while (cursor.moveToNext());
            db.close();

        }
        return catList;
    }


    public List<Checklist> getAllChecklist() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Checklist> checkList=null;
        String query = "SELECT " + AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_ID + ", "
                + AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_TITLE+ ", "
                + AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_DESCRIPTION+ ", "
                + AKLFishingDBTables.CheckList.COLUMN_CHECKLIST_IMAGE + " FROM "
                + AKLFishingDBTables.CheckList.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            checkList = new ArrayList<Checklist>();
            cursor.moveToFirst();
            do {
                Checklist aCheckList = new Checklist(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getBlob(3));
                checkList.add(aCheckList);
            } while (cursor.moveToNext());
            db.close();

        }
        return checkList;
    }

    public List<Faq> getAllFaqs() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Faq> faqs=null;
        String query = "SELECT " + AKLFishingDBTables.Faq.COLUMN_FAQ_ID + ", "
                + AKLFishingDBTables.Faq.COLUMN_FAQ_QUESTION+ ", "
                + AKLFishingDBTables.Faq.COLUMN_FAQ_ANSWER+ " FROM "
                + AKLFishingDBTables.Faq.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            faqs = new ArrayList<Faq>();
            cursor.moveToFirst();
            do {
                Faq aFaq = new Faq(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                faqs.add(aFaq);
            } while (cursor.moveToNext());
            db.close();
        }
        return faqs;
    }

    public List<Fish> getAllFishes(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Fish> fishes=null;
        String query = "SELECT " + AKLFishingDBTables.Fish.COLUMN_FISH_ID + ", "
                + AKLFishingDBTables.Fish.COLUMN_FISH_NAME+ ", "
                + AKLFishingDBTables.Fish.COLUMN_FISH_DESC+ ", "
                + AKLFishingDBTables.Fish.COLUMN_FISH_IMAGE+ ", "
                + AKLFishingDBTables.Fish.COLUMN_FISH_CAT+ ", "
                + AKLFishingDBTables.Fish.COLUMN_MIN_FISH_LENGTH_CM+ ", "
                + AKLFishingDBTables.Fish.COLUMN_MIN_FISH_MAX_DAILY_LIMIT+ ", "
                + AKLFishingDBTables.Fish.COLUMN_IS_COMBINED_BAG+ " FROM "
                + AKLFishingDBTables.Fish.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            fishes = new ArrayList<Fish>();
            cursor.moveToFirst();
            do {
                Fish aFish = new Fish(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getBlob(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),cursor.getInt(7));
                fishes.add(aFish);
            } while (cursor.moveToNext());
            db.close();
        }
        return fishes;
    }

    public List<FishCatch> getAllFishCatch(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<FishCatch> fishes=null;
        String query = "SELECT " + AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_ID + ", "
                + AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_LENGTH+ ", "
                + AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_EXPERIENCE+ ", "
                + AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_LENGTH+", "
                + AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_WEIGHT+ ", "
                + AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_IMAGE+ ", "
                + AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_NAME+ ", "
                + AKLFishingDBTables.FishCatch.COLUMN_FISH_CATCH_REMARK+ " FROM "
                + AKLFishingDBTables.FishCatch.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            fishes = new ArrayList<FishCatch>();
            cursor.moveToFirst();
            do {
                FishCatch aFish = new FishCatch(cursor.getInt(0), cursor.getInt(1), cursor.getDouble(2),cursor.getDouble(3),cursor.getBlob(4),cursor.getString(5),cursor.getString(6));
                fishes.add(aFish);
            } while (cursor.moveToNext());
            db.close();
        }
        return fishes;
    }

   /* FishingExperience(int experienceId, int location, Date date, Time time, String remark)
    public List<FishingExperience> getAllFishingExperience(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<FishingExperience> experiences=null;
        String query = "SELECT " + AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_ID + ", "
                + AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_LOCATION_ID+ ", "
                + AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_DATE+ ", "
                + AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_TIME+", "
                + AKLFishingDBTables.FishingExperience.COLUMN_FISHING_EXPERIENCE_REMARK+ " FROM "
                + AKLFishingDBTables.FishingExperience.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            experiences = new ArrayList<FishingExperience>();
            cursor.moveToFirst();
            do {
                FishingExperience exp = new FishingExperience(cursor.getInt(0), cursor.getInt(1), cursor.getString(2),cursor.getDouble(3),cursor.getBlob(4),cursor.getString(5),cursor.getString(6));
                experiences.add(exp);
            } while (cursor.moveToNext());
            db.close();
        }
        return fishes;
    }*/

/*

    public List<User> getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> userList;
        String query = "SELECT " + COLUMN_FIRST_NAME + ", "
                + COLUMN_LAST_NAME + ", "
                + COLUMN_USER_ID + ", "
                + COLUMN_USER_PASSWORD + " from " + TABLE_USERS;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            userList = new ArrayList<User>();
            cursor.moveToFirst();
            do {
                User aUser = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                userList.add(aUser);
            } while (cursor.moveToNext());
            db.close();
            return userList;
        }

        return null;
    }

    public User findUser(String userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[]{COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_USER_ID, COLUMN_USER_PASSWORD},
                COLUMN_USER_ID + "=?", new String[]{userId}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            User aUser = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            db.close();
            return aUser;
        }

        return null;
    }
*/

}

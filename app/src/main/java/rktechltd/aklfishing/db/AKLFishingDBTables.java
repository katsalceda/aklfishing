package rktechltd.aklfishing.db;


import android.provider.BaseColumns;

/**
 * Created by romelyn on 12/05/2016.
 */
public class AKLFishingDBTables {
    public AKLFishingDBTables(){    }

    public static abstract class Category implements BaseColumns {
        public static final String TABLE_NAME = "category";
        public static final String COLUMN_CAT_ID = "categoryId";
        public static final String COLUMN_CAT_NAME = "categoryName";
        public static final String COLUMN_CAT_DESC = "categoryDescription";
        public static final String PRIMARY_KEY="PRIMARY KEY("+ COLUMN_CAT_ID+")";
        public static final String[] ALL_COLUMNS ={COLUMN_CAT_ID,COLUMN_CAT_NAME,COLUMN_CAT_DESC};
    }

    public static abstract class CheckList implements BaseColumns {
        public static final String TABLE_NAME = "checkList";
        public static final String COLUMN_CHECKLIST_ID = "checkListId";
        public static final String COLUMN_CHECKLIST_TITLE = "title";
        public static final String COLUMN_CHECKLIST_DESCRIPTION = "description";
        public static final String COLUMN_CHECKLIST_IMAGE = "image";
        public static final String PRIMARY_KEY = "PRIMARY KEY (" + COLUMN_CHECKLIST_ID + ")";
        public static final String[] ALL_COLUMNS = {COLUMN_CHECKLIST_ID,COLUMN_CHECKLIST_TITLE, COLUMN_CHECKLIST_DESCRIPTION, COLUMN_CHECKLIST_IMAGE};
    }

    public static abstract class Faq implements BaseColumns {
        public static final String TABLE_NAME = "faq";
        public static final String COLUMN_FAQ_ID = "faqId";
        public static final String COLUMN_FAQ_QUESTION = "question";
        public static final String COLUMN_FAQ_ANSWER = "answer";
        public static final String PRIMARY_KEY = "PRIMARY KEY (" + COLUMN_FAQ_ID + ")";
        public static final String[] ALL_COLUMNS = {COLUMN_FAQ_ID, COLUMN_FAQ_QUESTION, COLUMN_FAQ_ANSWER};
    }
    public static abstract class Fish implements BaseColumns{
        public static final String TABLE_NAME = "fish";
        public static final String COLUMN_FISH_ID = "fishId";
        public static final String COLUMN_FISH_NAME = "fishName";
        public static final String COLUMN_FISH_DESC = "fishDescription";
        public static final String COLUMN_FISH_IMAGE = "fishImage";
        public static final String COLUMN_FISH_CAT ="categoryId";
        public static final String COLUMN_MIN_FISH_LENGTH_CM ="minFishLengthCm";
        public static final String COLUMN_MIN_FISH_MAX_DAILY_LIMIT="maxDailyLimit";
        public static final String COLUMN_IS_COMBINED_BAG="isCombinedBag";
        public static final String PRIMARY_KEY="PRIMARY KEY("+ COLUMN_FISH_ID+")";
        public static final String[] ALL_COLUMNS ={COLUMN_FISH_ID,COLUMN_FISH_NAME,COLUMN_FISH_DESC,COLUMN_FISH_IMAGE,COLUMN_FISH_CAT,COLUMN_MIN_FISH_LENGTH_CM,COLUMN_MIN_FISH_MAX_DAILY_LIMIT,COLUMN_IS_COMBINED_BAG};
    }
    public static abstract class FishingExperience implements BaseColumns{
        public static final String TABLE_NAME = "fishingExperience";
        public static final String COLUMN_FISHING_EXPERIENCE_ID ="fishingExperienceId";
        public static final String COLUMN_FISHING_EXPERIENCE_LOCATION_ID ="locationId";
        public static final String COLUMN_FISHING_EXPERIENCE_DATE ="dateEx";
        public static final String COLUMN_FISHING_EXPERIENCE_TIME ="timeEx";
        public static final String COLUMN_FISHING_EXPERIENCE_REMARK ="remark";
        public static final String PRIMARY_KEY="PRIMARY KEY ("+COLUMN_FISHING_EXPERIENCE_ID+")";
        public static final String[] ALL_COLUMNS ={COLUMN_FISHING_EXPERIENCE_ID,COLUMN_FISHING_EXPERIENCE_LOCATION_ID,COLUMN_FISHING_EXPERIENCE_DATE,COLUMN_FISHING_EXPERIENCE_TIME,COLUMN_FISHING_EXPERIENCE_REMARK};
    }

    public static abstract class FishCatch implements BaseColumns{
        public static final String TABLE_NAME = "fishCatch";
        public static final String COLUMN_FISH_CATCH_ID ="fishCatchId";
        public static final String COLUMN_FISH_CATCH_EXPERIENCE ="experienceId";
        public static final String COLUMN_FISH_CATCH_LENGTH ="fishLength";
        public static final String COLUMN_FISH_CATCH_WEIGHT ="fishWeight";
        public static final String COLUMN_FISH_CATCH_REMARK ="remark";
        public static final String COLUMN_FISH_CATCH_NAME ="catchName";
        public static final String COLUMN_FISH_CATCH_IMAGE ="image";
        public static final String PRIMARY_KEY="PRIMARY KEY ("+COLUMN_FISH_CATCH_ID+")";
        public static final String[] ALL_COLUMNS ={COLUMN_FISH_CATCH_ID,COLUMN_FISH_CATCH_EXPERIENCE,COLUMN_FISH_CATCH_LENGTH,COLUMN_FISH_CATCH_WEIGHT,COLUMN_FISH_CATCH_REMARK,COLUMN_FISH_CATCH_NAME};
    }

    public static abstract class Location implements BaseColumns{
        public static final String TABLE_NAME = "location";
        public static final String COLUMN_LOCATION_ID = "locationId";
        public static final String COLUMN_LOCATION_NAME = "locationName";
        public static final String COLUMN_lOCATION_LATITUDE = "locationLatitude";
        public static final String COLUMN_LOCATION_LONGITUDE = "locationLongitude";
        public static final String COLUMN_LOCATION_N0TE ="locationNote";
        public static final String PRIMARY_KEY="PRIMARY KEY("+ COLUMN_LOCATION_ID+")";
        public static final String[] ALL_COLUMNS ={COLUMN_LOCATION_ID,COLUMN_LOCATION_NAME,COLUMN_LOCATION_LONGITUDE,COLUMN_lOCATION_LATITUDE,COLUMN_LOCATION_N0TE};
    }

    public static abstract class NetRules implements BaseColumns {
        public static final String TABLE_NAME = "netRules";
        public static final String COLUMN_NETRULES_ID = "netRulesId";
        public static final String COLUMN_NETRULES_TITLE = "title";
        public static final String COLUMN_NETRULES_DESCRIPTION = "description";
        public static final String COLUMN_NETRULES_PENALTY = "penalty";
        public static final String COLUMN_NETRULES_IMAGE = "image";
        public static final String PRIMARY_KEY = "PRIMARY KEY (" + COLUMN_NETRULES_ID + ")";
        public static final String[] ALL_COLUMNS = {COLUMN_NETRULES_ID, COLUMN_NETRULES_TITLE, COLUMN_NETRULES_DESCRIPTION,COLUMN_NETRULES_PENALTY, COLUMN_NETRULES_IMAGE};
    }



}

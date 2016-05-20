package rktechltd.aklfishing.db;

import android.content.Context;

import java.util.ArrayList;

import rktechltd.aklfishing.models.Category;
import rktechltd.aklfishing.models.Checklist;
import rktechltd.aklfishing.models.Faq;
import rktechltd.aklfishing.models.Fish;
import rktechltd.aklfishing.models.FishCatch;
import rktechltd.aklfishing.models.FishingExperience;
import rktechltd.aklfishing.models.Location;
import rktechltd.aklfishing.models.NetRule;

/**
 * Created by romelyn on 18/05/2016.
 */
public class AKLFishingDAO {
    AKLFishingDBHelper db ;

    public AKLFishingDAO(Context context){
        db = new AKLFishingDBHelper(context);
    }

    public void insertNewCategory(Category cat){}
    public void insertNewChecklist(Checklist checklist){}
    public void insertNewFaq(Faq faq){}
    public void insertNewFish(Fish fish){}
    public void insertNewFishCatch(FishCatch fishCatch){}
    public void insertNewFishingExperience(FishingExperience fishEx){}
    public void insertNewLocation(Location location){}
    public void insertNewNetRule(NetRule netRule){}


    public ArrayList<Category> getAllCatgories(){
        ArrayList<Category> categories = new ArrayList<Category>();
        return categories;
    }

    public ArrayList<Checklist> getAllChecklist(){
        ArrayList<Checklist> checklists = new ArrayList<Checklist>();
        return checklists;
    }

    public ArrayList<Faq> getAllFaq(){
        ArrayList<Faq> faqs = new ArrayList<Faq>();
        return faqs;
    }

    public ArrayList<Fish> getAllFishes(){
        ArrayList<Fish> fishes = new ArrayList<Fish>();
        return fishes;
    }

    public ArrayList<FishCatch> getAllFishCatches(){
        ArrayList<FishCatch> fishCatches = new ArrayList<FishCatch>();
        return fishCatches;
    }

    public ArrayList<FishingExperience> getAllFishingExp(){
        ArrayList<FishingExperience> fishingExperiences = new ArrayList<FishingExperience>();
        return fishingExperiences;
    }

    public ArrayList<Location> getAllLocations(){
        ArrayList<Location> locations = new ArrayList<Location>();
        return locations;
    }

    public ArrayList<NetRule> getAllNetRules(){
        ArrayList<NetRule> netRules = new ArrayList<NetRule>();
        return netRules;
    }

    public void updateCategory(Category cat){}
    public void updateChecklist(Checklist checklist){}
    public void updateFaq(Faq faq){}
    public void updateFish(Fish fish){}
    public void updateFishCatch(FishCatch fishCatch){}
    public void updateFishingExperience(FishingExperience fishEx){}
    public void updateLocation(Location location){}
    public void updateNetRule(NetRule netRule){}

    public void deleteCategory(Category cat){}
    public void deleteChecklist(Checklist checklist){}
    public void deleteFaq(Faq faq){}
    public void deleteFish(Fish fish){}
    public void deleteFishCatch(FishCatch fishCatch){}
    public void deleteFishingExperience(FishingExperience fishEx){}
    public void deleteLocation(Location location){}
    public void deleteNetRule(NetRule netRule){}



}

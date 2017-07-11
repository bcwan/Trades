package com.cmps115.trades;

/**
 * Created by Daniel on 5/24/2017.
 */

public class ListingEntry {

    private String name;
    private ProfileEntry lister;
    private String description;

    //Constructors
    public ListingEntry(){

    }

    public ListingEntry(String name, ProfileEntry lister, String desc){
        this.name= name;
        this.lister= lister;
        this.description=  desc;
    }

    //Mutators
    public void setName(String word){
        this.name= word;
    }

    public void setLister(ProfileEntry lister){
        this.lister= lister;
    }

    public void setDesc(String word){
        this.description= word;
    }

    //Accessors
    public String getName(){
        return name;
    }

    public ProfileEntry getLister(){
        return lister;
    }

    public String getDesc(){
        return description;
    }

}

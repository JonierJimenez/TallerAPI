package com.example.volleyjson;

import android.os.Parcel;
import android.os.Parcelable;

public class Pokemon implements Parcelable {

    private  int Number;
    private String Name;
    private String Url;

    public Pokemon(String name, String url){
        this.Name=name;
        this.Url=url;
    }

    public Pokemon() {

    }

    protected Pokemon(Parcel in) {
        Name = in.readString();
        Url = in.readString();
    }

    public static final Parcelable.Creator<Pokemon> CREATOR = new Parcelable.Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public int getNumber() {
        String[] urlPartes= Url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length-1]);
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Override
    public String toString() {
        return "Pokemons{" +
                ", NAME='" + Name + '\'' +
                ", URL='" + Url + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeString(Url);
    }
}

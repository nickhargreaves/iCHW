package com.databasetest.sample;


public class Households {
	
	int _id;
	String _householdnumber;
	String _village;
	String _chw;
	
	public Households(String Householdnumber,String Village,String CHW)
	{
		
		this._householdnumber=Householdnumber;
		this._village=Village;
		this._chw=CHW;
	}
	
	public Households(String Householdnumber,String Village)
	{
		this._householdnumber=Householdnumber;
		this._village=Village;
	}
	
	public int getID()
	{
		return this._id;
	}
	public void SetID(int ID)
	{
		this._id=ID;
	}
	
	public String getHouseholdnumber()
	{
		return this._householdnumber;
	}
	
	public String getVillage()
	{
		return this._village;
	}
	
	public void setHouseholdnumber(String Householdnumber)
	{
		this._householdnumber=Householdnumber;
	}
	public void setVillage(String Village)
	{
		this._village=Village;
	}
	
	
	
	public void setCHW(String CHW)
	{
		this._chw=CHW;
	}
	
	public String getCHW()
	{
		return this._chw;
	}
}

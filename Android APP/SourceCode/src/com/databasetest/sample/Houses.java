package com.databasetest.sample;


public class Houses {
	
	int _id;
	String _householdnumber;
	String _village;
	String _chw;
	String _coordinates;
	int _haslatrine;
	int _treatswater;
	String _method;
	int _handwashing;
	int _staplefood;
	int _iec;
	String _personname;
	
	public Houses(String Householdnumber,String Village,String CHW,String Coordinates,int Haslatrine,int Treatswater, String method, int Handwashing,int Staplefood, int IEC, String PersonName)
	{
		
		this._householdnumber=Householdnumber;
		this._village=Village;
		this._chw=CHW;
		this._coordinates=Coordinates;
		this._haslatrine=Haslatrine;
		this._treatswater=Treatswater;
		this._method=method;
		this._handwashing=Handwashing;
		this._staplefood=Staplefood;
		this._iec=IEC;
		this._personname=PersonName;
	}

	public Houses(String Householdnumber,String Village,String CHW,String Coordinates,int Haslatrine,int Treatswater,int Handwashing,int Staplefood)
	{
		
		this._householdnumber=Householdnumber;
		this._village=Village;
		this._chw=CHW;
		this._coordinates=Coordinates;
		this._haslatrine=Haslatrine;
		this._treatswater=Treatswater;
		this._handwashing=Handwashing;
		this._staplefood=Staplefood;
		
	}
	public Houses(String Householdnumber,String Village,String CHW,String Coordinates,int Haslatrine,int Treatswater,int Handwashing)
	{
		
		this._householdnumber=Householdnumber;
		this._village=Village;
		this._chw=CHW;
		this._coordinates=Coordinates;
		this._haslatrine=Haslatrine;
		this._treatswater=Treatswater;
		this._handwashing=Handwashing;

	}
	public Houses(String Householdnumber,String Village,String CHW,String Coordinates,int Haslatrine,int Treatswater)
	{
		
		this._householdnumber=Householdnumber;
		this._village=Village;
		this._chw=CHW;
		this._coordinates=Coordinates;
		this._haslatrine=Haslatrine;
		this._treatswater=Treatswater;
		
	}
	public Houses(String Householdnumber,String Village,String CHW,String Coordinates,int Haslatrine)
	{
		
		this._householdnumber=Householdnumber;
		this._village=Village;
		this._chw=CHW;
		this._coordinates=Coordinates;
		this._haslatrine=Haslatrine;

	}
	public Houses(String Householdnumber,String Village,String CHW,String PersonName)
	{
		
		this._householdnumber=Householdnumber;
		this._village=Village;
		this._chw=CHW;
		this._personname=PersonName;

	}
	public Houses(String Householdnumber,String Village,String CHW)
	{
		
		this._householdnumber=Householdnumber;
		this._village=Village;
		this._chw=CHW;

	}
	public Houses(String Householdnumber,String Village)
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
	public String getMethod()
	{
		return this._method;
	}
	public String getPersonName()
	{
		return this._personname;
	}
	
	public String setPersonName()
	{
		return this._personname;
	}
	
	public void setHouseholdnumber(String Householdnumber)
	{
		this._householdnumber=Householdnumber;
	}
	public void setVillage(String Village)
	{
		this._village=Village;
	}
	
	public String getCoordinates()
	{
		return this._coordinates;
	}
	public void SetCoordinates(String Coordinates)
	{
		this._coordinates=Coordinates;
	}
	
	public void setCHW(String CHW)
	{
		this._chw=CHW;
	}
	
	public String getCHW()
	{
		return this._chw;
	}
	public int getHaslatrine()
	{
		return this._haslatrine;
	}
	public void SetHaslatrine(int Haslatrine)
	{
		this._haslatrine=Haslatrine;
	}
	
	public int getTreatswater()
	{
		return this._treatswater;
	}
	public void SetTreatswater(int Treatswater)
	{
		this._treatswater=Treatswater;
	}
	
	public int getHandwashing()
	{
		return this._handwashing;
	}
	public void SetHandwashing(int Handwashing)
	{
		this._handwashing=Handwashing;
	}
	
	public int getStaplefood()
	{
		return this._staplefood;
	}
	public void SetStaplefood(int Staplefood)
	{
		this._staplefood=Staplefood;
	}
	
	public int getIEC()
	{
		return this._iec;
	}
	public void SetIEC(int IEC)
	{
		this._iec=IEC;
	}
}

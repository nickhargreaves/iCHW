package com.databasetest.sample;

public class Individualso16 {
			
		int _id;
		String _householdnumber;
		String _village;
		int _PID;
		
		String _phonenumber;
	
		
		
		public Individualso16(String Householdnumber,String Village,int PID, String Phonenumber)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			this._phonenumber=Phonenumber;
		
		}
		public int getID()
		{
			return this._id;
		}
		public String getHouseholdnumber()
		{
			return this._householdnumber;
		}
		public String getVillage()
		{
			return this._village;
		}
		public int getPID()
		{
			return this._PID;
		}
		public String getPhonenumber()
		{
			return this._phonenumber;
		}
	
}
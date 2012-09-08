package com.databasetest.sample;

public class Individualsgen {
			
		int _id;
		String _householdnumber;
		String _village;
		int _PID;
		
		String _relationtohead;
		int _bc;
		int _bednet;
		String _howoften;
		int _knowhivstatus;
		int _chronic;
		int _disability;
		
		
		public Individualsgen(String Householdnumber,String Village,int PID, String Relationtohead, int bc, int bednet, String howoften, int knowhivstatus, int chronic, int disability)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			this._relationtohead=Relationtohead;
			this._bc=bc;
			this._bednet=bednet;
			this._howoften=howoften;
			this._knowhivstatus=knowhivstatus;
			this._chronic=chronic;
			this._disability=disability;
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
		public String getRelationtohead()
		{
			return this._relationtohead;
		}
		public int getBc()
		{
			return this._bc;
		}
		public int getBednet()
		{
			return this._bednet;
		}
		public String getHowoften()
		{
			return this._howoften;
		}
		public int getKnowhivstatus()
		{
			return this._knowhivstatus;
		}
		public int getChronic()
		{
			return this._chronic;
		}
		public int getDisability()
		{
			return this._disability;
		}
}
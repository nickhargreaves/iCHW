package com.databasetest.sample;

public class Individualsai {
			
		int _id;
		String _householdnumber;
		String _village;
		int _PID;
		
		int _personflagged;
		String _remarks;
		String _flaggedreason;
	
		
		
		public Individualsai(String Householdnumber,String Village,int PID, int Personflagged, String Remarks, String Flaggedreason)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			this._personflagged=Personflagged;
			this._remarks=Remarks;
			this._flaggedreason=Flaggedreason;
		
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
		public int getPersonflagged()
		{
			return this._personflagged;
		}
		public String getRemarks()
		{
			return this._remarks;
		}
		public String getFlaggedreason()
		{
			return this._flaggedreason;
		}
}
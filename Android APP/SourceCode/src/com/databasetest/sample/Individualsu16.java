package com.databasetest.sample;

public class Individualsu16 {
			
		int _id;
		String _householdnumber;
		String _village;
		int _PID;
		
		int _orphan;
		int _ovc;
	
		
		
		public Individualsu16(String Householdnumber,String Village,int PID, int Orphan, int OVC)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			this._orphan=Orphan;
			this._ovc=OVC;
		
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
		public int getOrphan()
		{
			return this._orphan;
		}
		public int getOVC()
		{
			return this._ovc;
		}
	
}
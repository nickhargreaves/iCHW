package com.databasetest.sample;

public class Individualsmi {
			
		int _id;
		String _householdnumber;
		String _village;
		int _PID;
		
		int _currentlypregnant;
		String _lastperioddate;
		int _birthinlast12;
		String _outcome;
		String _whenbbd;
		String _anc;
		String _anc2;
		String _wheredeliver;
		
		
		public Individualsmi(String Householdnumber,String Village,int PID, int Currentlypregnant, String Lastperiodate, int Birthinlast12, String Outcome, String Whenbbd, String ANC, String ANC2, String Wheredeliver)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			this._currentlypregnant=Currentlypregnant;
			this._lastperioddate=Lastperiodate;
			this._birthinlast12=Birthinlast12;
			this._outcome=Outcome;
			this._whenbbd=Whenbbd;
			this._anc=ANC;
			this._anc2=ANC2;
			this._wheredeliver=Wheredeliver;
		
			
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
		public int getCurrentlypregnant()
		{
			return this._currentlypregnant;
		}
		public int getBirthinlast12()
		{
			return this._birthinlast12;
		}
		
		
		public String getLastperioddate()
		{
			return this._lastperioddate;
		}
		public String getOutcome()
		{
			return this._outcome;
		}
		public String getWhenbbd()
		{
			return this._whenbbd;
		}
		public String getANC()
		{
			return this._anc;
		}
		public String getANC2()
		{
			return this._anc2;
		}
		public String getWheredeliver()
		{
			return this._wheredeliver;
		}
}
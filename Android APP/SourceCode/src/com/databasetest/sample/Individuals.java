package com.databasetest.sample;

public class Individuals {
			
		int _id;
		String _householdnumber;
		String _village;
		int _PID;
		String _personname;
		String _bdate;
		String _sex;
		String _sdate;
		
		public Individuals(String Householdnumber,String Village,int PID, String personname, String bdate, String sex, String sdate)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			this._personname=personname;
			this._bdate=bdate;
			this._sex=sex;
			this._sdate=sdate;
		}
		public Individuals(String Householdnumber,String Village,int PID, String personname, String bdate, String sex)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			this._personname=personname;
			this._bdate=bdate;
			this._sex=sex;
		}
		
		public Individuals(String Householdnumber,String Village,int PID, String personname, String sdate)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			this._personname=personname;
			this._sdate=sdate;
			
		}
		
		public Individuals(String Householdnumber,String Village,int PID, String personname)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			this._personname=personname;
			
		}
		
		public Individuals(String Householdnumber,String Village,int PID)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			
		}
		public Individuals(String Householdnumber,String Village)
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
		
		public String getpersonname()
		{
			return this._personname;
		}
		public String getbdate()
		{
			return this._bdate;
		}
		public String getsdate()
		{
			return this._sdate;
		}
		public String getsex()
		{
			return this._sex;
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
		public void setpersonname(String personname)
		{
			this._personname=personname;
		}
		
		public void setbdate(String bdate)
		{
			this._bdate=bdate;
		}
		public void setsdate(String sdate)
		{
			this._sdate=sdate;
		}
		public void setsex(String sex)
		{
			this._sex=sex;
		}
				
		public void setPID(int PID)
		{
			this._PID=PID;
		}
		
		public int getPID()
		{
			return this._PID;
		}
	}

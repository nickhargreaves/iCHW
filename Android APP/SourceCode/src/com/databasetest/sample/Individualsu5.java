package com.databasetest.sample;

public class Individualsu5 {
			
		int _id;
		String _householdnumber;
		String _village;
		int _PID;
		
		int _cliniccard;
		int _penta1given;
		String _penta1date;
		int _penta3given;
		String _penta3date;
		int _measlesgiven;
		String _measlesdate;
		int _fullyimmunized;
		int _vitamina;
		String _vitaminadate;
		int _deworm;
		String _dewormdate;
		String _malnutrition;
		
		
		public Individualsu5(String Householdnumber,String Village,int PID, int Cliniccard, int Penta1given, String Penta1date, int Penta3given, String Penta3date, int Measlesgiven, String Measlesdate, int Fullyimmunized, int Vitamina, String Vitaminadate, int Deworm, String Dewormdate, String Malnutrition)
		{
			
			this._householdnumber=Householdnumber;
			this._village=Village;
			this._PID=PID;
			this._cliniccard=Cliniccard;
			this._penta1given=Penta1given;
			this._penta1date=Penta1date;
			this._penta3given=Penta3given;
			this._penta3date=Penta3date;
			this._measlesgiven=Measlesgiven;
			this._measlesdate=Measlesdate;
			this._fullyimmunized=Fullyimmunized;
			this._vitamina=Vitamina;
			this._vitaminadate=Vitaminadate;
			this._deworm=Deworm;
			this._dewormdate=Dewormdate;
			this._malnutrition=Malnutrition;
			
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
		public int getClinicard()
		{
			return this._cliniccard;
		}
		public int getPenta1given()
		{
			return this._penta1given;
		}
		public int getPenta3given()
		{
			return this._penta3given;
		}
		public int getMeaslesgiven()
		{
			return this._measlesgiven;
		}
		public String getPenta1date()
		{
			return this._penta1date;
		}
		public String getPenta3date()
		{
			return this._penta3date;
		}
		public String getMeaslesdate()
		{
			return this._measlesdate;
		}
		public int getFullyimmunized()
		{
			return this._fullyimmunized;
		}
		public int getVitamina()
		{
			return this._vitamina;
		}
		public int getDeworm()
		{
			return this._deworm;
		}
		public String getVitaminadate()
		{
			return this._vitaminadate;
		}
		public String getDewormdate()
		{
			return this._dewormdate;
		}
		public String getMalnutrition()
		{
			return this._malnutrition;
		}
		
}
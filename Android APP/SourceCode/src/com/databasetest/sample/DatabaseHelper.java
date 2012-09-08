package com.databasetest.sample;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	static final String dbName="Chw29";
	static final String Households="Households";
	static final String Houses="Houses";
	static final String colID="HouseholdsID";
	static final String colHousesID="colHousesID";
	static final String colHouseholdnumber="HouseholdNumber";
	static final String colVillage="Village";
	static final String colCHW="CHW";
	
	static final String deptTable="Dept";
	static final String colDeptID="DeptID";
	static final String colDeptName="DeptName";
	
	static final String viewEmps="ViewEmps";
	
	static final String Individuals="Individuals";
	static final String colIndID="IndID";
	static final String colIndName="IndName";
	static final String colIndHouse="House";
	static final String colIndVillage="Village";
	static final String colIndBd="Birthday";
	static final String colIndSex="Sex";
	static final String colIndPID="PID";
	static final String colDeath="death";
	static final String colDuedate="duedate";
	static final String colIndPhone="PhoneNumber";
	static final String sdate="sdate";
	
	static final String colRel="Relationship";
	static final String colBC="BirthCertificate";
	static final String colBednet="Bednet";
	static final String colHowoften="Howoften";
	static final String colKnowHIVstatus="KnowHIVstatus";
	static final String colChronic="Chronic";
	static final String colDisability="Disability";
	
	static final String colOrphan="Orphan";
	static final String colOVC="OVC";
	
	static final String colFlagged="flagged";
	static final String colRemarks="remarks";
	static final String colFlaggedreason="flaggedreason";
	
	static final String colCliniccard="cliniccard";
	static final String colPenta1="penta1";
	static final String colPenta1date="penta1date";
	static final String colPenta3="penta3";
	static final String colPenta3date="penta3date";
	static final String colMeasles="measles";
	static final String colMeaslesdate="measlesdate";
	static final String colFullyimmunized="fullyimmunized";
	static final String colVitamina="vitamina";
	static final String colMalnutrition="malnutrition";
	static final String colDeworming="deworming";
	static final String colDewormingdate="dewormingdate";
	static final String colVitaminadate="vitaminadate";
	
	static final String colANC="anc";
	static final String colANC2="anc2";
	static final String colBirthinlast12="birthinlast12";
	static final String colCurrentlypregnant="currentlypregnant";
	static final String colWhenbbd="whenbbd";
	static final String colWheredeliver="wheredeliver";
	static final String colOutcome="outcome";
	static final String colLastperioddate="lastperddate";
	
	static final String householdnumber="householdnumber";
	static final String iec="iec";
	static final String staplefood="staplefood";
	static final String treatswater="treatswater";
	static final String method="method";
	static final String handwashing="handwashing";
	static final String haslatrine="haslatrine";
	static final String coordinates="coordinates";
	static final String chw="chw";
	static final String village="village";
	static final String personname="personname";
	
	
	public DatabaseHelper(Context context) {
		super(context, dbName, null,82);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		//db.execSQL("CREATE TABLE "+deptTable+" ("+colDeptID+ " INTEGER PRIMARY KEY , "+
		//		colDeptName+ " TEXT)");
		
		db.execSQL("CREATE TABLE "+Households+" ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
				colHouseholdnumber+" TEXT, "+colVillage+" TEXT, "+colCHW+" TEXT)");
		
		db.execSQL("CREATE TABLE "+Houses+" ("+colHousesID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
		householdnumber+" INTEGER, "
		+village+" TEXT, "
		+chw+" TEXT, "
		+coordinates+" TEXT, "
		+haslatrine+" INTEGER, "
		+treatswater+" INTEGER, "
		+method+" TEXT, "
		+handwashing+" INTEGER, "
		+staplefood+" INTEGER, "
		+iec+" INTEGER, "
		
		+personname+" TEXT) ");
		
		db.execSQL("CREATE TABLE "+Individuals+" ("+colIndID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
				colIndHouse+" TEXT, "
				+colIndVillage+" TEXT,"
				+colIndName+" TEXT ,"
				+colIndSex+" TEXT,"
				+colIndPID+" INTEGER,"
				+colIndBd+" TEXT,"
				+sdate+" TEXT,"
				//general information
				+colRel+" TEXT,"
				+colBC+" INTEGER,"
				+colBednet+" INTEGER,"
				+colHowoften+" TEXT,"
				+colKnowHIVstatus+" INTEGER,"
				+colChronic+" INTEGER,"
				+colDisability+" INTEGER,"
				//over16
				+colIndPhone+" TEXT,"
				//under16
				+colOrphan+" INTEGER,"
				+colOVC+" INTEGER,"
				//under5
				+colCliniccard+" INTEGER,"
				+colPenta1+" INTEGER,"
				+colPenta1date+" TEXT,"
				+colPenta3+" INTEGER,"
				+colPenta3date+" TEXT,"
				+colMeasles+" INTEGER,"
				+colFullyimmunized+" INTEGER,"
				+colMeaslesdate+" TEXT,"
				+colVitamina+" INTEGER,"
				+colMalnutrition+" TEXT,"
				+colDeworming+" INTEGER,"
				+colVitaminadate+" INTEGER,"
				+colDewormingdate+" INTEGER,"
				//maternal information
				+colANC+" TEXT,"
				+colANC2+" TEXT,"
				+colBirthinlast12+" INTEGER,"
				+colCurrentlypregnant+" INTEGER,"
				+colWhenbbd+" TEXT,"
				+colWheredeliver+" TEXT,"
				+colOutcome+" TEXT,"
				+colLastperioddate+" TEXT,"
				+colDeath+" TEXT,"
				//additional information
				+colDuedate+" TEXT,"
				+colFlagged+" INTEGER,"
				+colRemarks+" TEXT,"
				+colFlaggedreason+" TEXT)");
		
		
		//db.execSQL("CREATE TRIGGER fk_empdept_deptid " +
			//	" BEFORE INSERT "+
				//" ON "+HouseholdsTable+
				
				//" FOR EACH ROW BEGIN"+
				//" SELECT CASE WHEN ((SELECT "+colDeptID+" FROM "+deptTable+" WHERE "+colDeptID+"=new."+colDept+" ) IS NULL)"+
				//" THEN RAISE (ABORT,'Foreign Key Violation') END;"+
				//"  END;");
		
		//db.execSQL("CREATE VIEW "+viewEmps+
			//	" AS SELECT "+HouseholdsTable+"."+colID+" AS _id,"+
				//" "+HouseholdsTable+"."+colName+","+
				//" "+HouseholdsTable+"."+colAge+","+
				//" "+deptTable+"."+colDeptName+""+
				//" FROM "+HouseholdsTable+" JOIN "+deptTable+
				//" ON "+HouseholdsTable+"."+colDept+" ="+deptTable+"."+colDeptID
				//);
		//Inserts pre-defined departments
		InsertHousehold(db);
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (632, 'Murombo', 1, '34.12446 ,0.15002', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Thomas Omenya Ngauwa')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (633, 'Murombo', 2, '34.12444 ,0.015', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Eunice Akinyi Omenya')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (634, 'Murombo', 3, '34.13446 ,0.14595', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Bernard Odongo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (635, 'Murombo', 4, '34.12435 ,0.15011', 'pamela2', 0, 0, 'pur or other water treatment', 0, 0, 0, 'Vitalis Onyango Outa')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (636, 'Murombo', 5, '34.12444 ,0.15022', 'pamela2', 0, 0, 'pur or other water treatment', 1, 1, 0, 'Seline Atieno Oduor')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (637, 'Murombo', 6, '34.12441 ,0.15023', 'pamela2', 0, 1, 'pur or other water treatment', 1, 1, 1, 'Pamela Adongo Otieno')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (638, 'Murombo', 7, '34.12455 ,0.15064', 'pamela2', 1, 0, 'boil', 1, 1, 1, 'Masela Agutu Oduor')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (639, 'Murombo', 8, '34.12457 ,0.15062', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Evance Ochieng Odhiambo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (640, 'Murombo', 9, '34.12455 ,0.01506', 'pamela2', 1, 0, 'strain through cloth', 1, 1, 1, 'George Odhiambo Oduor')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (641, 'Murombo', 10, '34.12446 ,0.15074', 'pamela2', 1, 0, 'boil', 1, 1, 1, 'Philista Auma Rida')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (642, 'Murombo', 11, '34.12433 ,0.15079', 'pamela2', 1, 0, '', 1, 1, 1, 'Maria Achieng  Outa')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (643, 'Murombo', 12, '34.12441 ,0.15069', 'pamela2', 1, 1, 'boil', 1, 1, 1, 'Vitalis Ogutu Rida')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (644, 'Murombo', 13, '34.12453 ,0.15085', 'pamela2', 0, 0, 'pur or other water treatment', 1, 1, 1, 'William Ogola Ogutu')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (645, 'Murombo', 14, '34.12491 ,0.15087', 'pamela2', 0, 0, 'pur or other water treatment', 1, 1, 1, 'Monica Apondi Asur')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (646, 'Murombo', 15, '34.12472 ,0.15061', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'John Odera Nyabongo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (647, 'Murombo', 16, '34.12488 ,0.15087', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Vitalis Owiti Odipo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (648, 'Murombo', 17, '34.12471 ,0.15064', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Anna Otieno Odera')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (649, 'Murombo', 18, '34.12478 ,0.15055', 'pamela2', 1, 0, 'pur or other water treatment', 1, 1, 1, 'George Nyabongo Odera')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (650, 'Murombo', 19, '34.12485 ,0.15031', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Helen Awuor Omondi')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (651, 'Murombo', 20, '34.12483 ,0.15028', 'pamela2', 0, 0, 'pur or other water treatment', 0, 0, 0, 'George Oduor Osulo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (652, 'Murombo', 21, '34.12488 ,0.01503', 'pamela2', 1, 0, 'pur or other water treatment', 1, 1, 1, 'Maurice Odhiambo Osulo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (653, 'Murombo', 22, '34.12485 ,0.15025', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Christopher Otieno Osulo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (654, 'Murombo', 23, '34.12548 ,0.01509', 'pamela2', 0, 0, 'pur or other water treatment', 1, 1, 1, 'Domtila Oduol')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (655, 'Murombo', 24, '34.12536 ,0.15053', 'pamela2', 1, 0, 'pur or other water treatment', 1, 1, 1, 'Dismas Agoro Obura')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (656, 'Murombo', 25, '34.12537 ,0.15037', 'pamela2', 1, 1, 'boil', 1, 1, 1, 'Wilfrida Atieno Osodo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (657, 'Murombo', 26, '34.12533 ,0.15056', 'pamela2', 1, 0, 'pur or other water treatment', 1, 1, 1, 'Consolata Juma Agoro')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (658, 'Murombo', 27, '34.12532 ,0.15028', 'pamela2', 1, 0, 'pur or other water treatment', 1, 1, 1, 'Fredrick Onyango Sodo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (659, 'Murombo', 28, '34.12536 ,0.15028', 'pamela2', 1, 0, 'boil', 1, 1, 1, 'Alfred Oduor Osodo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (660, 'Murombo', 29, '34.12531 ,0.15024', 'pamela2', 1, 0, 'boil', 1, 1, 1, 'Charles Otieno Osodo ')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (661, 'Murombo', 30, '34.12533 ,0.14572', 'pamela2', 1, 1, 'boil', 1, 1, 1, 'Consolata Juma Singienda')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (662, 'Murombo', 31, '34.12531 ,0.14572', 'pamela2', 1, 0, 'none', 1, 1, 1, 'Eveline Achieng Singienda')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (663, 'Murombo', 32, '34.12549 ,0.14582', 'pamela2', 1, 0, 'none', 1, 1, 1, 'Johana Obonyo Hawala')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (664, 'Murombo', 33, '34.12555 ,0.14591', 'pamela2', 1, 0, '', 1, 1, 1, 'Jane Awuor Omondi')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (665, 'Murombo', 34, '34.12566 ,0.14574', 'pamela2', 0, 1, '', 1, 1, 1, 'Maria Orocho')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (666, 'Murombo', 35, '34.12576 ,0.14559', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Celestine Atieno Otieno')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (667, 'Murombo', 36, '34.12566 ,0.14564', 'pamela2', 0, 0, '', 1, 1, 1, 'Rose Adhiambo Odhiambo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (668, 'Murombo', 37, '34.12573 ,0.14557', 'pamela2', 1, 0, '', 1, 1, 1, 'Jane Omondi')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (669, 'Murombo', 38, '34.13044 ,0.14524', 'pamela2', 0, 0, '', 1, 1, 0, 'Steven Oduor Agoro')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (670, 'Murombo', 39, '34.13045 ,0.01453', 'pamela2', 1, 0, '', 1, 1, 1, 'Thomas Agola Odongo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (671, 'Murombo', 40, '34.13026 ,0.14537', 'pamela2', 1, 0, '', 1, 1, 1, 'Joseph Radine Oguda')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (672, 'Murombo', 41, '34.13026 ,0.14527', 'pamela2', 1, 0, '', 1, 1, 1, 'Peter Okoth Radine')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (673, 'Murombo', 42, '34.12585 ,0.01453', 'pamela2', 0, 0, 'boil', 1, 1, 1, 'Alex Onyango Osumba')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (674, 'Murombo', 43, '34.12578 ,0.01459', 'pamela2', 0, 0, '', 1, 1, 1, 'Mary Akinyi Onyango')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (675, 'Murombo', 44, '34.12584 ,0.14523', 'pamela2', 0, 0, '', 1, 1, 1, 'Fredrick Odhiambo Onyango')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (676, 'Murombo', 45, '34.12571 ,0.14597', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Anastasia Aduol Okoth')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (677, 'Murombo', 46, '34.12578 ,0.14594', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Joseph Owino Onyango')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (678, 'Murombo', 47, '34.12577 ,0.14598', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Wilfrida Anyango Okoth')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (679, 'Murombo', 48, '34.12579 ,0.15046', 'pamela2', 0, 0, 'none', 0, 0, 0, 'Anjeline Akinyi Oduor')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (680, 'Murombo', 49, '34.12576 ,0.15046', 'pamela2', 1, 0, 'none', 1, 1, 1, 'Rita Adhiambo Oduor')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (681, 'Murombo', 50, '34.12578 ,0.15065', 'pamela2', 1, 0, 'none', 1, 1, 1, 'John Ogutu Mugura')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (682, 'Murombo', 51, '34.12577 ,0.15068', 'pamela2', 1, 0, 'none', 1, 1, 1, 'Caroline Adhiambo Ogutu')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (683, 'Murombo', 52, '34.1301 ,0.01511', 'pamela2', 1, 0, 'none', 1, 1, 1, 'Leonard Onyango Obala')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (684, 'Murombo', 53, '34.12598 ,0.15113', 'pamela2', 1, 0, 'none', 1, 1, 0, 'Richard Ouma Chiawa')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (685, 'Murombo', 54, '34.13591 ,0.15063', 'pamela2', 1, 1, 'boil', 1, 1, 1, 'Mary Akinyi Ochieng')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (686, 'Murombo', 55, '34.12587 ,0.15063', 'pamela2', 1, 1, 'boil', 1, 1, 1, 'Francisca Aoko Ochieng')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (687, 'Murombo', 56, '34.12581 ,0.01506', 'pamela2', 1, 1, 'boil', 1, 1, 1, 'Seline Ochieng')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (688, 'Murombo', 57, '34.13042 ,0.15021', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Patrick Ouma Ohonjo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (689, 'Murombo', 58, '34.13007 ,0.15042', 'pamela2', 1, 0, 'none', 1, 1, 1, 'George Aringo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (690, 'Murombo', 59, '34.13059 ,0.15003', 'pamela2', 1, 0, 'none', 1, 1, 1, 'Geoffry Otieno')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (691, 'Murombo', 60, '34.13043 ,0.15031', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Cornelia Aor Ohonjo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (692, 'Murombo', 61, '34.13081 ,0.15019', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Alice Atieno Okoth')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (693, 'Murombo', 62, '34.13095 ,0.01502', 'pamela2', 1, 1, 'strain through cloth', 1, 1, 1, 'Margret Awuor Owino')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (694, 'Murombo', 63, '34.13089 ,0.15026', 'pamela2', 1, 0, 'none', 1, 1, 1, 'Maria Abongo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (695, 'Murombo', 64, '34.13073 ,0.15027', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Steven Onyango Aloo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (696, 'Murombo', 65, '34.13072 ,0.15032', 'pamela2', 0, 0, 'none', 1, 1, 1, 'David Oching Aloo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (697, 'Murombo', 66, '34.13075 ,0.15037', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Joseph Aloo Ngayo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (698, 'Murombo', 67, '34.13068 ,0.15058', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Colleta Achieng Oduor')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (699, 'Murombo', 68, '34.13068 ,0.15072', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Grace Akinyi Nyaholo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (700, 'Murombo', 69, '34.13073 ,0.15077', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Josphine Apiyo Oluoch')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (701, 'Murombo', 70, '34.13079 ,0.15142', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Florence Owama')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (702, 'Murombo', 71, '34.13087 ,0.15108', 'pamela2', 0, 0, 'pur or other water treatment', 1, 0, 1, 'Joseph Ogutu Omondi')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (703, 'Murombo', 72, '34.13044 ,0.01509', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Edwin Oloo')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (704, 'Murombo', 73, '34.13111 ,0.15141', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Anastasia Ojema')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (705, 'Murombo', 74, '34.13104 ,0.15151', 'pamela2', 0, 0, 'pur or other water treatment', 0, 0, 0, 'Josephine Auma')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (706, 'Murombo', 75, '34.13123 ,0.15168', 'pamela2', 1, 0, '', 1, 1, 1, 'Joseph Obiero')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (707, 'Murombo', 76, '34.13122 ,0.15137', 'pamela2', 0, 0, 'none', 1, 1, 1, 'Paul Owino Ojema')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (708, 'Murombo', 77, '34.13143 ,0.15195', 'pamela2', 1, 0, 'none', 1, 1, 1, 'Patrick Ambuchi')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (709, 'Murombo', 78, '34.13143 ,0.15196', 'pamela2', 1, 1, 'pur or other water treatment', 1, 1, 1, 'Fredrick Areck')");
		db.execSQL("INSERT INTO `Houses` (`colHousesID`, `village`, `householdnumber`, `coordinates`, `chw`, `haslatrine`, `treatswater`, `method`, `staplefood`, `handwashing`, `iec`, `personname`) VALUES (710, 'Murombo', 79, '34.13102 ,0.15154', 'pamela2', 0, 0, 'pur or other water treatment', 1, 1, 1, 'John Ndege Odhoji')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3261, 'Thomas Omenya Ngauwa', 'Male', 1, 'Murombo', '1-1-1932', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3262, 'Pertonila Adhiambo Omenya', 'Female', 1, 'Murombo', '1-1-1950', 2, '2')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3264, 'Eunice Akinyi Omenya', 'Female', 2, 'Murombo', '1-1-1960', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3265, 'Levis Oduor Omenya', 'Male', 2, 'Murombo', '1-1-2009', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3266, 'David Omondi Omenya', 'Male', 2, 'Murombo', '1-1-2000', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3268, 'Bernard Odongo', 'Male', 3, 'Murombo', '1-1-1972', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3269, 'Elizabeth Anyango', 'Female', 3, 'Murombo', '1-1-1975', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3270, 'Maureen Auma', 'Female', 3, 'Murombo', '1-1-2009', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3272, 'Vitalis Onyango Outa', 'Male', 4, 'Murombo', '1-1-1963', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3273, 'Meshak Yore', 'Male', 4, 'Murombo', '1-1-2002', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3274, 'Victor Omondi', 'Male', 4, 'Murombo', '1-1-2000', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3276, 'Seline Atieno Oduor', 'Female', 5, 'Murombo', '1-1-1984', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3277, 'Mary Atieno Oduor', 'Female', 5, 'Murombo', '1-1-2003', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3278, 'Sylvia Akinyi Oduor', 'Female', 5, 'Murombo', '1-1-1999', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3279, 'Regan Otieno Oduor', 'Male', 5, 'Murombo', '1-1-2000', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3280, 'Mourice Odhiambo Oduor', 'Male', 5, 'Murombo', '1-1-1996', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3282, 'Pamela Adongo Otieno', 'Female', 6, 'Murombo', '1-1-1968', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3283, 'Lilian Achieng Otieno', 'Female', 6, 'Murombo', '1-1-2001', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3284, 'Risper Awino Otieno', 'Female', 6, 'Murombo', '1-1-2003', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3285, 'Mercy Akoth Otieno', 'Female', 6, 'Murombo', '1-1-1994', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3286, 'Caroline Auma Otieno', 'Female', 6, 'Murombo', '1-1-1977', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3288, 'Masela Agutu Oduor', 'Female', 7, 'Murombo', '1-1-1940', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3289, 'Lydia Achieng Owino', 'Female', 7, 'Murombo', '1-1-2002', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3290, 'Edwin Otieno Owino', 'Male', 7, 'Murombo', '1-1-1995', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3292, 'Evance Ochieng Odhiambo', 'Male', 8, 'Murombo', '1-1-1985', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3293, 'Lorine Auma Ochieng', 'Female', 8, 'Murombo', '1-1-1987', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3294, 'Christopher Oduor Ochieng ', 'Male', 8, 'Murombo', '1-1-2004', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3295, 'Benta Atieno Ochieng', 'Female', 8, 'Murombo', '1-1-2005', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3297, 'George Odhiambo Oduor', 'Male', 9, 'Murombo', '1-1-1965', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3299, 'Philista Auma Rida', 'Female', 10, 'Murombo', '1-1-1945', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3301, 'Maria Achieng  Outa', 'Female', 11, 'Murombo', '1-1-1946', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3304, 'Vitalis Ogutu Rida', 'Male', 12, 'Murombo', '1-1-1962', 1, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3305, 'Elizabeth Achieng Ogutu', 'Female', 12, 'Murombo', '1-1-1982', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3306, 'Philista Oronge Ogutu', 'Female', 12, 'Murombo', '1-1-1996', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3307, 'Anastasia Auma Ogutu', 'Female', 12, 'Murombo', '1-1-1998', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3309, 'William Ogola Ogutu', 'Male', 13, 'Murombo', '1-1-1943', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3311, 'Monica Apondi Asur', 'Female', 14, 'Murombo', '1-1-1945', 1, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3312, 'Trevance Omondi Asur', 'Male', 14, 'Murombo', '1-1-2005', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3314, 'John Odera Nyabongo', 'Male', 15, 'Murombo', '1-1-1928', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3315, 'Anastasia Achola Odera', 'Female', 15, 'Murombo', '1-1-1943', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3317, 'Vitalis Owiti Odipo', 'Male', 16, 'Murombo', '1-1-1971', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3319, 'Anna Otieno Odera', 'Female', 17, 'Murombo', '1-1-1943', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3320, 'Joel Oduor Odera', 'Male', 17, 'Murombo', '1-1-1989', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3322, 'George Nyabongo Odera', 'Male', 18, 'Murombo', '1-1-1966', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3323, 'Pamela Auma Nyabongo', 'Female', 18, 'Murombo', '1-1-1979', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3324, 'Selestine Anyango Nyabongo', 'Female', 18, 'Murombo', '1-1-2000', 3, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3325, 'Mary Gorrety Nyabongo', 'Female', 18, 'Murombo', '1-1-2002', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3326, 'Quinter Atieno Nyabongo', 'Female', 18, 'Murombo', '1-1-2005', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3327, 'Stacy Auma Nyabongo', 'Female', 18, 'Murombo', '1-1-2009', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3329, 'Helen Awuor Omondi', 'Female', 19, 'Murombo', '1-1-1984', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3330, 'Clifford Obura Omondi', 'Male', 19, 'Murombo', '1-1-2005', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3331, 'Preshia Adhiambo Omondi', 'Female', 19, 'Murombo', '1-1-2006', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3332, 'Nichol Atieno Omondi', 'Female', 19, 'Murombo', '1-1-2009', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3334, 'George Oduor Osulo', 'Male', 20, 'Murombo', '1-1-1978', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3335, 'Mercy Atieno Oduor', 'Female', 20, 'Murombo', '1-1-1983', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3336, 'Steve Biko Oduor', 'Male', 20, 'Murombo', '1-1-2002', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3337, 'Ferrol Odhiambo Oduor', 'Male', 20, 'Murombo', '1-1-2005', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3338, 'Sheven Adhiambo Oduor', 'Female', 20, 'Murombo', '1-1-2009', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3341, 'Maurice Odhiambo Osulo', 'Male', 21, 'Murombo', '1-1-1973', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3342, 'Lilian Achieng Odhiambo', 'Female', 21, 'Murombo', '1-1-1984', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3343, 'Conjestina Achieng Odhiambo', 'Female', 21, 'Murombo', '1-1-2006', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3344, 'Fidel Oduor Odhiambo', 'Male', 21, 'Murombo', '1-1-2009', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3346, 'Christopher Otieno Osulo', 'Male', 22, 'Murombo', '1-1-1982', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3347, 'Judith Awio Otieno', 'Female', 22, 'Murombo', '1-1-1986', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3348, 'Jeff Otieno Otieno', 'Male', 22, 'Murombo', '1-1-2007', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3349, 'Mishel Anyango Otieno', 'Female', 22, 'Murombo', '1-1-2009', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3351, 'Domtila Oduol', 'Female', 23, 'Murombo', '1-1-1944', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3352, 'Pamela Achieng Oduol', 'Female', 23, 'Murombo', '1-1-1972', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3354, 'Dismas Agoro Obura', 'Male', 24, 'Murombo', '1-1-1952', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3355, 'Christine Akinyi Agoro', 'Female', 24, 'Murombo', '1-1-1964', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3356, 'Caroline Awuor Agoro', 'Female', 24, 'Murombo', '1-1-1995', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3357, 'Beatrice Atieno Agoro', 'Female', 24, 'Murombo', '1-1-1997', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3358, 'Ben Onyango Agoro', 'Male', 24, 'Murombo', '1-1-2005', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3359, 'Eddah Onyango Agoro', 'Female', 24, 'Murombo', '1-1-2004', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3360, 'Nicholas Ochieng Agoro', 'Male', 24, 'Murombo', '1-1-1992', 7, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3362, 'Wilfrida Atieno Osodo', 'Female', 25, 'Murombo', '', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3364, 'Consolata Juma Agoro', 'Female', 26, 'Murombo', '1-1-1968', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3365, 'Jacinta Atieno Agoro', 'Female', 26, 'Murombo', '1-1-1988', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3366, 'Barrack Otieno Agoro', 'Male', 26, 'Murombo', '1-1-2006', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3367, 'Victor Ouma Agoro', 'Male', 26, 'Murombo', '1-1-2000', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3368, 'Bryan Obura Agoro', 'Male', 26, 'Murombo', '1-1-2004', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3369, 'Elizabeth Awino Agoro', 'Female', 26, 'Murombo', '1-1-1999', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3370, 'Kevin Omondi Agoro', 'Male', 26, 'Murombo', '1-1-1994', 7, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3372, 'Fredrick Onyango Sodo', 'Male', 27, 'Murombo', '1-1-1972', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3373, 'Lydia Akoth Onyango', 'Female', 27, 'Murombo', '1-1-1986', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3374, 'Felix Onyango Onyago ', 'Male', 27, 'Murombo', '1-1-2003', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3375, 'Bilha Achieng Onyango', 'Female', 27, 'Murombo', '1-1-2005', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3376, 'Elvis Ochieng Onyango', 'Male', 27, 'Murombo', '1-1-2008', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3377, 'Bereline Akinyi Onyango', 'Female', 27, 'Murombo', '1-1-2011', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3379, 'Alfred Oduor Osodo', 'Male', 28, 'Murombo', '1-1-1977', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3381, 'Charles Otieno Osodo ', 'Male', 29, 'Murombo', '1-1-1983', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3382, 'Alice Atieno Otieno', 'Female', 29, 'Murombo', '1-1-1985', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3383, 'Lucy Awuor Otieno', 'Female', 29, 'Murombo', '1-1-2003', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3385, 'Consolata Juma Singienda', 'Female', 30, 'Murombo', '1-1-1964', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3387, 'Eveline Achieng Singienda', 'Female', 31, 'Murombo', '1-1-1964', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3388, 'Faith Adhiambo Singienda', 'Female', 31, 'Murombo', '1-1-2000', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3389, 'John Otieno Singienda', 'Male', 31, 'Murombo', '1-1-2001', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3391, 'Johana Obonyo Hawala', 'Male', 32, 'Murombo', '1-1-1963', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3392, 'Helen Atieno Obonyo', 'Female', 32, 'Murombo', '1-1-1987', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3393, 'Gift Owino Obonyo', 'Male', 32, 'Murombo', '1-1-2004', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3394, 'Edith Achieng Obong', 'Female', 32, 'Murombo', '1-1-2009', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3396, 'Jane Awuor Omondi', 'Female', 33, 'Murombo', '1-1-1966', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3397, 'Lilian Adhiambo Omondi', 'Female', 33, 'Murombo', '1-1-2001', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3398, 'Kennedy Ogutu Omondi', 'Male', 33, 'Murombo', '1-1-2003', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3400, 'Maria Orocho', 'Female', 34, 'Murombo', '1-1-1954', 1, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3401, 'Elvice Otieno Orocho', 'Male', 34, 'Murombo', '1-1-2001', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3402, 'Grace Aatieno Orocho', 'Female', 34, 'Murombo', '1-1-2002', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3403, 'Morin Akinyi Orocho', 'Female', 34, 'Murombo', '1-1-1999', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3405, 'Celestine Atieno Otieno', 'Female', 35, 'Murombo', '1-1-1966', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3406, 'Vincent Otieno Otieno', 'Male', 35, 'Murombo', '1-1-1999', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3408, 'Rose Adhiambo Odhiambo', 'Female', 36, 'Murombo', '1-1-1988', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3409, 'Susan Atieno Odhiamo', 'Female', 36, 'Murombo', '1-1-2004', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3410, 'Sharon Akinyi Odhiambo', 'Female', 36, 'Murombo', '1-1-2000', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3411, 'Paul Omondi', 'Male', 36, 'Murombo', '1-1-2010', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3413, 'Jane Omondi', 'Female', 37, 'Murombo', '1-1-1970', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3415, 'Steven Oduor Agoro', 'Male', 38, 'Murombo', '1-1-1982', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3416, 'Eunice Atieno Oduor', 'Female', 38, 'Murombo', '1-1-1986', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3417, 'Felix Ouma Oduor', 'Male', 38, 'Murombo', '1-1-2003', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3418, 'Levix Otieno Oduor', 'Male', 38, 'Murombo', '1-1-2004', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3419, 'Lawrence Otieno Oduor', 'Male', 38, 'Murombo', '1-1-2007', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3420, 'Elizabeth Akinyi Oduor', 'Female', 38, 'Murombo', '1-1-2009', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3422, 'Thomas Agola Odongo', 'Male', 39, 'Murombo', '1-1-1937', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3423, 'Jenipher Juma Agoro', 'Female', 39, 'Murombo', '1-1-1953', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3424, 'Quinter Atieno Agoro', 'Female', 39, 'Murombo', '1-1-2009', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3425, 'Lucas Ogola Agoro', 'Male', 39, 'Murombo', '1-1-1988', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3427, 'Joseph Radine Oguda', 'Male', 40, 'Murombo', '1-1-1944', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3428, 'Lewnida Taka Agoro', 'Female', 40, 'Murombo', '1-1-1966', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3429, 'Prisca Anyango Radine', 'Female', 40, 'Murombo', '1-1-1987', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3430, 'Caroline Juma Radine', 'Female', 40, 'Murombo', '1-1-2001', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3432, 'Peter Okoth Radine', 'Male', 41, 'Murombo', '1-1-1982', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3433, 'Maurine Atieno Okoth', 'Female', 41, 'Murombo', '1-1-1993', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3435, 'Alex Onyango Osumba', 'Male', 42, 'Murombo', '1-1-1938', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3436, 'Brigita Onyango', 'Female', 42, 'Murombo', '1-1-1945', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3438, 'Mary Akinyi Onyango', 'Female', 43, 'Murombo', '1-1-1962', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3439, 'Eunice Auma Onyango', 'Female', 43, 'Murombo', '1-1-1997', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3441, 'Fredrick Odhiambo Onyango', 'Male', 44, 'Murombo', '1-1-1983', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3443, 'Anastasia Aduol Okoth', 'Female', 45, 'Murombo', '1-1-1929', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3445, 'Joseph Owino Onyango', 'Male', 46, 'Murombo', '1-1-1983', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3446, 'Elizabeth  Achieng Owino', 'Female', 46, 'Murombo', '1-1-1985', 2, '2')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3448, 'Wilfrida Anyango Okoth', 'Female', 47, 'Murombo', '1-1-1937', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3450, 'Anjeline Akinyi Oduor', 'Female', 48, 'Murombo', '1-1-1961', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3451, 'Monica Awino Oduor', 'Female', 48, 'Murombo', '1-1-1992', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3452, 'Vincent Otieno Oduor', 'Male', 48, 'Murombo', '1-1-1994', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3453, 'Joseph Ogutu Oduor', 'Male', 48, 'Murombo', '1-1-1997', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3454, 'Peter Omondi Oduor', 'Male', 48, 'Murombo', '1-1-2002', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3456, 'Rita Adhiambo Oduor', 'Female', 49, 'Murombo', '1-1-1963', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3457, 'Prisca Awuor Oduor', 'Female', 49, 'Murombo', '1-1-1994', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3458, 'Samwel Ooko Oduor', 'Male', 49, 'Murombo', '1-1-1997', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3459, 'Florence Anyango Oduor', 'Female', 49, 'Murombo', '1-1-2002', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3460, 'Moses Ouma Oduor', 'Male', 49, 'Murombo', '1-1-2007', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3461, 'Mary Aoko Oduor', 'Female', 49, 'Murombo', '1-1-2009', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3463, 'John Ogutu Mugura', 'Male', 50, 'Murombo', '1-1-1952', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3464, 'Prisca Aoko Ogutu', 'Female', 50, 'Murombo', '1-1-1961', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3465, 'Carina Juma Ogutu', 'Female', 50, 'Murombo', '1-1-1994', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3466, 'Gilbert Onyango Ogutu', 'Male', 50, 'Murombo', '1-1-2002', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3467, 'Joan Lazima Ogutu', 'Female', 50, 'Murombo', '1-1-2007', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3468, 'Synthia Akinyi Ogutu', 'Female', 50, 'Murombo', '1-1-1998', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3470, 'Caroline Adhiambo Ogutu', 'Female', 51, 'Murombo', '1-1-1980', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3471, 'Pamela Akinyi Ogutu', 'Female', 51, 'Murombo', '1-1-2002', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3472, 'Florence Akinyi Ogutu', 'Female', 51, 'Murombo', '1-1-2005', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3473, 'Emmanuel Oduor Ogutu', 'Male', 51, 'Murombo', '1-1-2010', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3474, 'Millicent Helen Ogutu', 'Female', 51, 'Murombo', '1-1-2003', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3476, 'Leonard Onyango Obala', 'Male', 52, 'Murombo', '1-1-1954', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3477, 'Consolata Akinyi', 'Female', 52, 'Murombo', '1-1-1966', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3478, 'Ambrose Oballa', 'Male', 52, 'Murombo', '1-1-1985', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3479, 'Mourine Achieng', 'Female', 52, 'Murombo', '1-1-1986', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3480, 'Josephine Atieno', 'Female', 52, 'Murombo', '1-1-1987', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3481, 'Conlince Odinga', 'Male', 52, 'Murombo', '1-1-1999', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3482, 'Gregory Onyango', 'Male', 52, 'Murombo', '1-1-2000', 7, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3483, 'Elivia Awuor', 'Female', 52, 'Murombo', '1-1-2002', 8, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3484, 'Sevian Akinyi', 'Female', 52, 'Murombo', '1-1-2004', 9, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3485, 'Geovin Ochieng', 'Male', 52, 'Murombo', '1-1-2006', 10, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3487, 'Richard Ouma Chiawa', 'Male', 53, 'Murombo', '1-1-1968', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3488, 'Florence Atieno Ouma', 'Female', 53, 'Murombo', '1-1-1970', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3489, 'Dorothy Akinyi Ouma', 'Female', 53, 'Murombo', '1-1-1993', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3490, 'Mercy Awuor', 'Female', 53, 'Murombo', '1-1-1996', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3491, 'Immelda Anyango Ouma', 'Female', 53, 'Murombo', '1-1-2002', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3492, 'Sythia Achieng Ouma', 'Female', 53, 'Murombo', '1-1-1999', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3493, 'Iyurn Owino Ouma', 'Male', 53, 'Murombo', '1-1-2010', 7, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3495, 'Mary Akinyi Ochieng', 'Female', 54, 'Murombo', '1-1-1968', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3496, 'Christine Achieng Ochieng', 'Female', 54, 'Murombo', '1-1-1999', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3498, 'Francisca Aoko Ochieng', 'Female', 55, 'Murombo', '1-1-1966', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3499, 'Bonface Ochieng', 'Male', 55, 'Murombo', '1-1-2001', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3501, 'Seline Ochieng', 'Female', 56, 'Murombo', '1-1-1960', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3502, 'Michael Okoth  Ochieng', 'Male', 56, 'Murombo', '1-1-1987', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3503, 'Mercy Akoth Ochieng', 'Female', 56, 'Murombo', '1-1-1996', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3505, 'Patrick Ouma Ohonjo', 'Male', 57, 'Murombo', '1-1-1974', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3506, 'Joseph Oduor Ouma ', 'Male', 57, 'Murombo', '1-1-2005', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3507, 'Rita Ouma', 'Female', 57, 'Murombo', '1-1-1988', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3508, 'Gloria Atieno Ouma', 'Female', 57, 'Murombo', '1-1-2003', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3509, 'Edaline Atieno Ouma', 'Female', 57, 'Murombo', '1-1-2009', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3511, 'George Aringo', 'Male', 58, 'Murombo', '1-1-1935', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3513, 'Geoffry Otieno', 'Male', 59, 'Murombo', '1-1-1975', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3515, 'Cornelia Aor Ohonjo', 'Female', 60, 'Murombo', '1-1-1937', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3516, 'Synthia Akoth Ohonjo', 'Female', 60, 'Murombo', '1-1-2003', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3517, 'David Onyango Ohonjo', 'Male', 60, 'Murombo', '1-1-1999', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3518, 'Christine Atieno Ohonjo', 'Female', 60, 'Murombo', '1-1-1995', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3519, 'Lilian Akinyi Ohonjo', 'Female', 60, 'Murombo', '1-1-1993', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3521, 'Alice Atieno Okoth', 'Female', 61, 'Murombo', '', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3522, 'Molly Akinyi Okoth', 'Female', 61, 'Murombo', '', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3523, 'Monica Akinyi Okoth', 'Female', 61, 'Murombo', '', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3525, 'Margret Awuor Owino', 'Female', 62, 'Murombo', '1-1-1977', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3526, 'Elizabeth Atieno Owino', 'Female', 62, 'Murombo', '1-1-1996', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3527, 'Macelus Okoth Owino', 'Male', 62, 'Murombo', '1-1-1999', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3528, 'Gabriel Otieno Owino', 'Male', 62, 'Murombo', '1-1-2009', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3530, 'Maria Abongo', 'Female', 63, 'Murombo', '1-1-1928', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3532, 'Steven Onyango Aloo', 'Male', 64, 'Murombo', '1-1-1983', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3533, 'Eveline Awuor Onyango', 'Female', 64, 'Murombo', '1-1-1991', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3534, 'Emmanuel Owino Onyango', 'Male', 64, 'Murombo', '1-1-2002', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3535, 'Sheril Anyango Onyango', 'Female', 64, 'Murombo', '1-1-2009', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3537, 'David Oching Aloo', 'Male', 65, 'Murombo', '1-1-1975', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3538, 'Lydia Achieng Ochieng', 'Female', 65, 'Murombo', '1-1-1981', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3539, 'Synthia Anyango ochieng', 'Female', 65, 'Murombo', '1-1-2001', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3540, 'Denis Oluoch Ochieng', 'Male', 65, 'Murombo', '1-1-2003', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3541, 'Chrisphine Otieno Ochieng', 'Male', 65, 'Murombo', '1-1-2005', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3542, 'Millicent Akoth Ochieng', 'Female', 65, 'Murombo', '1-1-2007', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3543, 'Fedel Oduor Ochieng', 'Male', 65, 'Murombo', '1-1-2009', 7, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3545, 'Joseph Aloo Ngayo', 'Female', 66, 'Murombo', '1-1-1928', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3546, 'Jackim Ouma Aloo', 'Female', 66, 'Murombo', '1-1-1989', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3548, 'Colleta Achieng Oduor', 'Female', 67, 'Murombo', '1-1-1960', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3549, 'Alfonce Onyango Oduor', 'Male', 67, 'Murombo', '1-1-2001', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3551, 'Grace Akinyi Nyaholo', 'Female', 68, 'Murombo', '1-1-1957', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3552, 'Seline Anyango Nyaholo', 'Female', 68, 'Murombo', '1-1-1995', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3553, 'Agnes Achieng Nyaholo', 'Female', 68, 'Murombo', '1-1-1996', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3554, 'Iyurn Ochieng Nyaholo', 'Male', 68, 'Murombo', '1-1-2003', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3555, 'Esther Akinyi Nyaholo', 'Female', 68, 'Murombo', '1-1-2009', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3557, 'Josphine Apiyo Oluoch', 'Female', 69, 'Murombo', '1-1-1935', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3559, 'Florence Owama', 'Female', 70, 'Murombo', '1-1-1972', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3560, 'Lucy Atieno', 'Female', 70, 'Murombo', '1-1-1992', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3561, 'Mary Awino', 'Female', 70, 'Murombo', '1-1-2005', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3562, 'Steve Oluoch', 'Male', 70, 'Murombo', '1-1-2001', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3563, 'Nicholas Ochieng', 'Male', 70, 'Murombo', '1-1-1997', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3564, 'Melkisedex Otieno', 'Male', 70, 'Murombo', '1-1-1994', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3565, 'Veronica Apondi', 'Female', 70, 'Murombo', '1-1-1999', 7, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3567, 'Joseph Ogutu Omondi', 'Male', 71, 'Murombo', '1-1-1958', 1, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3568, 'Colleta Atieno Ogutu', 'Female', 71, 'Murombo', '1-1-1968', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3569, 'Denis Omondi', 'Male', 71, 'Murombo', '1-1-1994', 3, '4')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3570, 'Fred Onyango', 'Male', 71, 'Murombo', '1-1-1994', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3571, 'Jack Okoth', 'Male', 71, 'Murombo', '1-1-1999', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3572, 'Evans Otieno', 'Male', 71, 'Murombo', '1-1-2001', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3573, 'Melvin Adhiambo', 'Female', 71, 'Murombo', '1-1-2003', 7, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3574, 'Soffy Akinyi', 'Female', 71, 'Murombo', '1-1-2005', 8, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3575, 'Baliack Ochieng', 'Male', 71, 'Murombo', '1-1-2007', 9, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3577, 'Edwin Oloo', 'Male', 72, 'Murombo', '', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3579, 'Anastasia Ojema', 'Female', 73, 'Murombo', '1-1-1960', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3580, 'Fredrick odhiambo', 'Male', 73, 'Murombo', '1-1-1985', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3581, 'Patricia Awino', 'Female', 73, 'Murombo', '1-1-1989', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3583, 'Josephine Auma', 'Female', 74, 'Murombo', '1-1-1957', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3584, 'David Odhiambo', 'Male', 74, 'Murombo', '7-12-1995', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3585, 'Paul Ochieng', 'Male', 74, 'Murombo', '12-10-1997', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3587, 'Joseph Obiero', 'Male', 75, 'Murombo', '1-1-1985', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3588, 'Linet Atieno', 'Female', 75, 'Murombo', '1-1-1988', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3589, 'EvansOdhiambo', 'Male', 75, 'Murombo', '1-1-2006', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3590, 'Mercy Adhiambo', 'Female', 75, 'Murombo', '1-1-2008', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3591, 'Bravine Odhiambo', 'Male', 75, 'Murombo', '1-1-2011', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3593, 'Paul Owino Ojema', 'Male', 76, 'Murombo', '1-1-1937', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3594, 'Lucy Achieng Owiino', 'Female', 76, 'Murombo', '3-31-1969', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3595, 'Victor Odhiambo', 'Male', 76, 'Murombo', '11-23-2006', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3596, 'Esbon Owino Owino', 'Male', 76, 'Murombo', '8-16-2004', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3597, 'Antone Otieno Owino', 'Male', 76, 'Murombo', '10-23-2002', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3598, 'Vincensia Auma Owino', 'Female', 76, 'Murombo', '1-18-2001', 6, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3599, 'Dorine Akinyi Owino', 'Female', 76, 'Murombo', '9-15-1993', 7, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3601, 'Patrick Ambuchi', 'Male', 77, 'Murombo', '1-1-1975', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3602, 'Philista Ambuchi', 'Female', 77, 'Murombo', '1-1-1986', 2, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3603, 'Melkisedex Ambuchi', 'Male', 77, 'Murombo', '1-1-2004', 3, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3604, 'Metrine Ambuchi', 'Male', 77, 'Murombo', '1-1-2007', 4, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3605, 'Mishel Ambuchi', 'Female', 77, 'Murombo', '1-1-2009', 5, '')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3607, 'Fredrick Areck', 'Male', 78, 'Murombo', '1-1-1937', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3609, 'John Ndege Odhoji', 'Male', 79, 'Murombo', '1-1-1929', 1, '1')");
		db.execSQL("INSERT INTO `individuals` ( `IndID`, `IndName`, `Sex`, `House`, `Village`, `Birthday`, `PID`, `Relationship`) VALUES (3610, 'Jenipher Akinyi Ngenge', 'Female', 79, 'Murombo', '1-1-1942', 2, '')");
		}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		db.execSQL("DROP TABLE IF EXISTS "+Households);
		//db.execSQL("DROP TABLE IF EXISTS "+deptTable);
		db.execSQL("DROP TABLE IF EXISTS "+Houses);
		db.execSQL("DROP TABLE IF EXISTS "+Individuals);
		//db.execSQL("DROP TRIGGER IF EXISTS dept_id_trigger");
		//db.execSQL("DROP TRIGGER IF EXISTS dept_id_trigger22");
		//db.execSQL("DROP TRIGGER IF EXISTS fk_empdept_deptid");
		//db.execSQL("DROP VIEW IF EXISTS "+viewEmps);
		onCreate(db);
	}
	
	 void AddHouseholds(Households emp2)
	{
		  
		 SQLiteDatabase db= this.getWritableDatabase();
		 	
		ContentValues cv=new ContentValues();
		cv.put(colHouseholdnumber, emp2.getHouseholdnumber());
		cv.put(colVillage, emp2.getVillage());
		cv.put(colCHW, emp2.getCHW());
		//cv.put(colDept,2);
		db.insert(Households, colHouseholdnumber, cv);
		db.close();
			
	}
	 void AddIndividual(Individuals emp)
		{
			  
			 SQLiteDatabase db= this.getWritableDatabase();
			 	
			ContentValues cv=new ContentValues();
			cv.put(colIndName, emp.getpersonname());
			cv.put(colIndHouse, emp.getHouseholdnumber());
			cv.put(colIndVillage, emp.getVillage());
			
			cv.put(colIndSex, emp.getsex());
			cv.put(colIndPID, emp.getPID());
			cv.put(colIndBd, emp.getbdate());
			//cv.put(colDept,2);
			db.insert(Individuals, colIndName, cv);
			db.close();
				
		}
	 void AddHouse(Houses emp) {
			// TODO Auto-generated method stub
			
				// TODO Auto-generated method stub
				SQLiteDatabase db=this.getWritableDatabase();
				ContentValues values = new ContentValues();
				  values.put(householdnumber, emp.getHouseholdnumber());
				  values.put(village, emp.getVillage());
				  values.put(coordinates, emp.getCoordinates());
				  values.put(haslatrine, emp.getHaslatrine());
				  values.put(treatswater, emp.getTreatswater());
				  values.put(method, emp.getMethod());
				  values.put(handwashing, emp.getHandwashing());
				  values.put(staplefood, emp.getStaplefood());
				  values.put(iec, emp.getIEC());
				  values.put(chw, emp.getCHW());
				  values.put(personname, emp.getPersonName());
				 
				  //db.execSQL("UPDATE Households SET HouseholdNumber='"+);
				  db.insert(Houses, householdnumber, values);
				  db.close();
			
		}
	 
	 void deleteAll() {
			SQLiteDatabase db= this.getWritableDatabase();
		      db.delete(Households, null, null);
		   }
	 void deleteHouses() {
			SQLiteDatabase db= this.getWritableDatabase();
		      db.delete(Houses, null, null);
		   }
	 
	 void deleteInds() {
			SQLiteDatabase db= this.getWritableDatabase();
		      db.delete(Individuals, null, null);
		   }
	 
	 int getHouseholdsCount()
	 {
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cur= db.rawQuery("Select * from "+Households, null);
		int x= cur.getCount();
		cur.close();
		return x;
	 }
	 int getHousesCount(Households emp)
	 {
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cur= db.rawQuery("Select * from "+Houses+" WHERE village='"+emp.getVillage()+"'", null);
		int x= cur.getCount();
		cur.close();
		return x;
	 }
	 int getHousesCount1()
	 {
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cur= db.rawQuery("Select * from "+Houses, null);
		int x= cur.getCount();
		cur.close();
		return x;
	 }
	 int getMembersCount(Individuals emp)
	 {
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cur= db.rawQuery("Select * from "+Individuals+" where Village='"+emp.getVillage()+"' and House='"+emp.getHouseholdnumber()+"'", null);
		int x= cur.getCount();
		cur.close();
		return x;
	 }
	 Cursor getAllHouseholds()
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 
		 
		 
		 //Cursor cur= db.rawQuery("Select "+colID+" as _id , "+colName+", "+colAge+" from "+HouseholdsTable, new String [] {});
		 Cursor cur= db.rawQuery("SELECT colHousesID  AS _id, householdnumber, village, personname FROM "+Houses,null);
		 return cur;
		 
	 }
	 Cursor getHouseholdMembers(Individuals emp)
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 
		 
		 
		 //Cursor cur= db.rawQuery("Select "+colID+" as _id , "+colName+", "+colAge+" from "+HouseholdsTable, new String [] {});
		 Cursor cur= db.rawQuery("SELECT IndID  AS _id, IndName, PID, Sex, Birthday FROM "+Individuals+" WHERE "+colIndVillage+"='"+emp.getVillage()+"' AND "+colIndHouse+"='"+emp.getHouseholdnumber()+"'",null);
		 return cur;
		 
	 }
	 Cursor getHouseholdInfo()
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 
		 
		 
		 //Cursor cur= db.rawQuery("Select "+colID+" as _id , "+colName+", "+colAge+" from "+HouseholdsTable, new String [] {});
		 Cursor cur= db.rawQuery("SELECT * FROM "+Houses+" WHERE village='Ogero' AND householdnumber='1'",null);
		 return cur;
		 
	 }
	 
	 public List<String> selectVillage() {
			SQLiteDatabase db=this.getReadableDatabase();
			
		      List<String> list = new ArrayList<String>();
		      Cursor cursor = db.query(Households, new String[] { colVillage },
		        null, null, null, null, "HouseholdsID desc LIMIT 1");
		      if (cursor.moveToFirst()) {
		         do {
		            list.add(cursor.getString(0));
		         } while (cursor.moveToNext());
		      }
		      if (cursor != null && !cursor.isClosed()) {
		         cursor.close();
		      }
		      return list;
		   }
	 
	public List<String> SelectName(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT IndName FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	
	public List<String> SelectAge(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT Birthday FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectVitamina(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT vitamina FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectDeworming(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT deworming FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectSex(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT Sex FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectBabydied(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT whenbbd FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectWheredeliver(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT wheredeliver FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectOutcome(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT outcome FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectCurrentlypregnant(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT currentlypregnant FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectBirthinlast12(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT birthinlast12 FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectANC(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT anc FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectANC2(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT anc2 FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectOVC(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT OVC FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectOrphan(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT Orphan FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectRemarks(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT remarks FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectFlagged(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT flagged FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectCliniccard(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT cliniccard FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectFullyimmunized(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT fullyimmunized FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectMalnutrition(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT malnutrition FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectPenta1(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT penta1 FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectPenta3(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT penta3 FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectFlaggedreasons(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT flaggedreason FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectPhonenumber(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT PhoneNumber FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectBC(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT BirthCertificate FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectBednet(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT Bednet FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectKnowhivstatus(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT KnowHIVstatus FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectChronic(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT Chronic FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectPenta1date(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT penta1date FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectVitaminadate(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT vitaminadate FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectDewormdate(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT dewormingdate FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectPenta3date(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT penta3date FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectLastperiod(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT lastperddate FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectMeasles(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT measles FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectMeaslesdate(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT measlesdate FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectDisability(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT Disability FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectRelation(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT Relationship FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectHowoften(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT Howoften FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	
	public List<String> SelectDOB(Individuals emp) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT Birthday FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"' AND PID='"+emp.getPID()+"' ORDER BY IndID desc LIMIT 1", null);
	      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
	      // null, null, null, null, "IndID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	
	public List<String> selectHouseholdnumber() {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.query(Households, new String[] { colHouseholdnumber },
	        null, null, null, null, "HouseholdsID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectHaslatrine(Houses emp2) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT haslatrine FROM Houses WHERE village='"+emp2.getVillage()+"' AND householdnumber='"+emp2.getHouseholdnumber()+"' ORDER BY "+colHousesID+" desc LIMIT 1", null);
	      
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	
	public List<String> SelectCoordinates(Houses emp2) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT coordinates FROM Houses WHERE village='"+emp2.getVillage()+"' AND householdnumber='"+emp2.getHouseholdnumber()+"' ORDER BY "+colHousesID+" desc LIMIT 1", null);
	      
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	
	public List<String> SelectTreatswater(Houses emp2) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT treatswater FROM Houses WHERE village='"+emp2.getVillage()+"' AND householdnumber='"+emp2.getHouseholdnumber()+"' ORDER BY "+colHousesID+" desc LIMIT 1", null);
	      
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectMethod(Houses emp2) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT method FROM Houses WHERE village='"+emp2.getVillage()+"' AND householdnumber='"+emp2.getHouseholdnumber()+"' ORDER BY "+colHousesID+" desc LIMIT 1", null);
	      
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectHandwashing(Houses emp2) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT handwashing FROM Houses WHERE village='"+emp2.getVillage()+"' AND householdnumber='"+emp2.getHouseholdnumber()+"' ORDER BY "+colHousesID+" desc LIMIT 1", null);
	      
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	
	public List<String> SelectStaplefood(Houses emp2) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT staplefood FROM Houses WHERE village='"+emp2.getVillage()+"' AND householdnumber='"+emp2.getHouseholdnumber()+"' ORDER BY "+colHousesID+" desc LIMIT 1", null);
	      
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	public List<String> SelectIec(Houses emp2) {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.rawQuery("SELECT iec FROM Houses WHERE village='"+emp2.getVillage()+"' AND householdnumber='"+emp2.getHouseholdnumber()+"' ORDER BY "+colHousesID+" desc LIMIT 1", null);
	      
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	
	public List<String> selectCHW() {
		SQLiteDatabase db=this.getReadableDatabase();
		
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.query(Households, new String[] { colCHW },
	        null, null, null, null, "HouseholdsID desc LIMIT 1");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	
	
	 
	 void InsertHousehold(SQLiteDatabase db)
	 {
		 ContentValues cv=new ContentValues();
			cv.put(colID, 1);
			cv.put(colHouseholdnumber, "1");
			cv.put(colVillage, 1);
			cv.put(colCHW, 1);
			db.insert(Households, colID, cv);
			
			
	 }
	
	 
	 public int UpdateEmp(Households emp)
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 ContentValues cv=new ContentValues();
		 cv.put(colHouseholdnumber, emp.getHouseholdnumber());
		 cv.put(colVillage, emp.getVillage());
		 cv.put(colCHW, emp.getCHW());
		 return db.update(Households, cv, colID+"=?", new String []{String.valueOf(emp.getID())});
		 
	 }
	 
	 public void DeleteEmp(Households emp)
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 db.delete(Households,colID+"=?", new String [] {String.valueOf(emp.getID())});
		 db.close();
		 
			
	 }
	 
	 public void deleteHouse(Houses emp){
		 SQLiteDatabase db=this.getWritableDatabase();
		 db.execSQL("DELETE FROM Houses WHERE village='"+emp.getVillage()+"' AND householdnumber='"+emp.getHouseholdnumber()+"'");
		 db.close();
	 }
	 public void deleteIndividual(Individuals emp){
		 SQLiteDatabase db=this.getWritableDatabase();
		 db.execSQL("DELETE FROM Individuals WHERE PID='"+emp.getPID()+"' AND village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"'");
		 db.close();
	 }
	 public void deleteIndividuals(Houses emp){
		 SQLiteDatabase db=this.getWritableDatabase();
		 db.execSQL("DELETE FROM Individuals WHERE Village='"+emp.getVillage()+"' AND House='"+emp.getHouseholdnumber()+"'");
		 db.close();
	 }
	 public void EditMember(Individuals emp) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			  values.put(colIndVillage, "'"+emp.getVillage()+"', ");
			  values.put(colIndHouse, "'"+emp.getHouseholdnumber()+"', ");
			  values.put(colIndPID, "'"+emp.getPID()+"', ");
			  
			  values.put(colIndName, "'"+emp.getpersonname()+"'");
			  values.put(colIndBd, "'"+emp.getbdate()+"', ");
			  values.put(colIndSex, "'"+emp.getsex()+"', ");
			  
			  
			  db.execSQL("UPDATE "+Individuals+" SET "+values+" WHERE "+colIndHouse+"='"+emp.getHouseholdnumber()+"' AND "+colIndVillage+"='"+emp.getVillage()+"' AND "+colIndPID+"='"+emp.getPID()+"'");
			 
		}
	 public void UpdateIndGen(Individualsgen gen) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			  values.put(colIndVillage, "'"+gen.getVillage()+"', ");
			  values.put(colIndHouse, "'"+gen.getHouseholdnumber()+"', ");
			  values.put(colIndPID, "'"+gen.getPID()+"', ");
			  values.put(colRel, "'"+gen.getRelationtohead()+"', ");
			  values.put(colBC, "'"+gen.getBc()+"'");
			  values.put(colKnowHIVstatus, "'"+gen.getKnowhivstatus()+"', ");
			  values.put(colBednet, "'"+gen.getBednet()+"', ");
			  values.put(colHowoften, "'"+gen.getHowoften()+"', ");
			  values.put(colChronic, "'"+gen.getChronic()+"', ");
			  values.put(colDisability, "'"+gen.getDisability()+"', ");
			  
			  db.execSQL("UPDATE "+Individuals+" SET "+values+" WHERE "+colIndHouse+"='"+gen.getHouseholdnumber()+"' AND "+colIndVillage+"='"+gen.getVillage()+"' AND "+colIndPID+"='"+gen.getPID()+"'");
			 
		}
	 public void UpdateIndo16(Individualso16 o16) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			  values.put(colIndVillage, "'"+o16.getVillage()+"', ");
			  values.put(colIndHouse, "'"+o16.getHouseholdnumber()+"', ");
			  values.put(colIndPID, "'"+o16.getPID()+"'");
			  
			  values.put(colIndPhone, "'"+o16.getPhonenumber()+"', ");
			  
			  
			  db.execSQL("UPDATE "+Individuals+" SET "+values+" WHERE "+colIndHouse+"='"+o16.getHouseholdnumber()+"' AND "+colIndVillage+"='"+o16.getVillage()+"' AND "+colIndPID+"='"+o16.getPID()+"'");
			 
		}
	 public void markDead(Individuals emp) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
				  
			  
			  db.execSQL("UPDATE "+Individuals+" SET "+sdate+"='"+emp.getsdate()+"', IndName='"+emp.getpersonname()+"' WHERE "+colIndHouse+"='"+emp.getHouseholdnumber()+"' AND "+colIndVillage+"='"+emp.getVillage()+"' AND "+colIndPID+"='"+emp.getPID()+"'");
			 
		}
	 public void EditHouseHead(Houses emp2) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
				  
			  
			  db.execSQL("UPDATE "+Houses+" SET "+personname+"='"+emp2.getPersonName()+"' WHERE "+householdnumber+"='"+emp2.getHouseholdnumber()+"' AND "+village+"='"+emp2.getVillage()+"'");
			 
		}
	 public void UpdateVillage(Houses emp) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
				  
			  
			  db.execSQL("UPDATE "+Houses+" SET "+village+"='"+emp.getVillage()+"' WHERE "+householdnumber+"='"+emp.getHouseholdnumber()+"' AND "+village+"='"+emp.getCHW()+"'");
			 
		}
	 public void UpdateVillageInds(Houses emp) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
				  
			  
			  db.execSQL("UPDATE "+Individuals+" SET "+colIndVillage+"='"+emp.getVillage()+"' WHERE "+colIndHouse+"='"+emp.getHouseholdnumber()+"' AND "+colIndVillage+"='"+emp.getCHW()+"'");
			 
		}
	 public void UpdateIndu16(Individualsu16 u16) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			  values.put(colIndVillage, "'"+u16.getVillage()+"', ");
			  values.put(colIndHouse, "'"+u16.getHouseholdnumber()+"', ");
			  values.put(colIndPID, "'"+u16.getPID()+"', ");
			  
			  values.put(colOrphan, "'"+u16.getOrphan()+"'");
			  values.put(colOVC, "'"+u16.getOVC()+"', ");
			  
			  db.execSQL("UPDATE "+Individuals+" SET "+values+" WHERE "+colIndHouse+"='"+u16.getHouseholdnumber()+"' AND "+colIndVillage+"='"+u16.getVillage()+"' AND "+colIndPID+"='"+u16.getPID()+"'");
			 
		}
	 public void UpdateIndai(Individualsai ai) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			  values.put(colIndVillage, "'"+ai.getVillage()+"', ");
			  values.put(colIndHouse, "'"+ai.getHouseholdnumber()+"', ");
			  values.put(colIndPID, "'"+ai.getPID()+"', ");
			  
			  values.put(colFlagged, "'"+ai.getPersonflagged()+"'");
			  values.put(colRemarks, "'"+ai.getRemarks()+"', ");
			  values.put(colFlaggedreason, "'"+ai.getFlaggedreason()+"', ");
			  
			  db.execSQL("UPDATE "+Individuals+" SET "+values+" WHERE "+colIndHouse+"='"+ai.getHouseholdnumber()+"' AND "+colIndVillage+"='"+ai.getVillage()+"' AND "+colIndPID+"='"+ai.getPID()+"'");
			 
		}
	 public void UpdateIndu5(Individualsu5 u5) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			  values.put(colIndVillage, "'"+u5.getVillage()+"', ");
			  values.put(colIndHouse, "'"+u5.getHouseholdnumber()+"', ");
			  values.put(colIndPID, "'"+u5.getPID()+"', ");
			  
			  values.put(colCliniccard, "'"+u5.getClinicard()+"', ");
			  values.put(colPenta1, "'"+u5.getPenta1given()+"', ");
			  values.put(colPenta1date, "'"+u5.getPenta1date()+"', ");
			  values.put(colPenta3, "'"+u5.getPenta3given()+"', ");
			  values.put(colPenta3date, "'"+u5.getPenta3date()+"', ");
			  values.put(colMeasles, "'"+u5.getMeaslesgiven()+"', ");
			  values.put(colMeaslesdate, "'"+u5.getMeaslesdate()+"', ");
			  values.put(colFullyimmunized, "'"+u5.getFullyimmunized()+"', ");
			  values.put(colVitamina, "'"+u5.getVitamina()+"'");
			  values.put(colVitaminadate, "'"+u5.getVitaminadate()+"', ");
			  values.put(colDeworming, "'"+u5.getDeworm()+"', ");
			  values.put(colDewormingdate, "'"+u5.getDewormdate()+"', ");
			  values.put(colMalnutrition, "'"+u5.getMalnutrition()+"', ");
			  
			  
			  db.execSQL("UPDATE "+Individuals+" SET "+values+" WHERE "+colIndHouse+"='"+u5.getHouseholdnumber()+"' AND "+colIndVillage+"='"+u5.getVillage()+"' AND "+colIndPID+"='"+u5.getPID()+"'");
			 
		}
	 public void UpdateIndmi(Individualsmi mi) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			  values.put(colIndVillage, "'"+mi.getVillage()+"', ");
			  values.put(colIndHouse, "'"+mi.getHouseholdnumber()+"', ");
			  values.put(colIndPID, "'"+mi.getPID()+"', ");
			  
			  values.put(colANC, "'"+mi.getANC()+"'");
			  values.put(colANC2, "'"+mi.getANC2()+"', ");
			  values.put(colBirthinlast12, "'"+mi.getBirthinlast12()+"', ");
			  values.put(colCurrentlypregnant, "'"+mi.getCurrentlypregnant()+"', ");
			  values.put(colLastperioddate, "'"+mi.getLastperioddate()+"', ");
			  values.put(colOutcome, "'"+mi.getOutcome()+"',");
			  values.put(colWhenbbd, "'"+mi.getWhenbbd()+"', ");
			  values.put(colWheredeliver, "'"+mi.getWheredeliver()+"', ");
		
			  
			  
			  db.execSQL("UPDATE "+Individuals+" SET "+values+" WHERE "+colIndHouse+"='"+mi.getHouseholdnumber()+"' AND "+colIndVillage+"='"+mi.getVillage()+"' AND "+colIndPID+"='"+mi.getPID()+"'");
			 
		}
	 public void UpdateHouse(Houses emp3) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			  values.put(haslatrine, "'"+emp3.getHaslatrine()+"', ");
			  values.put(treatswater, "'"+emp3.getTreatswater()+"', ");
			  values.put(method, "'"+emp3.getMethod()+"', ");
			  values.put(handwashing, "'"+emp3.getHandwashing()+"', ");
			  values.put(staplefood, "'"+emp3.getStaplefood()+"', ");
			  values.put(coordinates, "'"+emp3.getCoordinates()+"'");
			  values.put(iec, "'"+emp3.getIEC()+"', ");
			  
			  db.execSQL("UPDATE Houses SET "+values+" WHERE householdnumber='"+emp3.getHouseholdnumber()+"' AND village='"+emp3.getVillage()+"'");
			 
		}
	 public void UpdateHous(Houses emp3) {
			// TODO Auto-generated method stub
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			  values.put(haslatrine, "'"+emp3.getHaslatrine()+"', ");
			  values.put(treatswater, "'"+emp3.getTreatswater()+"', ");
			  values.put(method, "'"+emp3.getMethod()+"', ");
			  values.put(handwashing, "'"+emp3.getHandwashing()+"', ");
			  values.put(staplefood, "'"+emp3.getStaplefood()+"', ");
			  values.put(coordinates, "'"+emp3.getCoordinates()+"'");
			  values.put(personname, "'"+emp3.getPersonName()+"', ");
			  values.put(chw, "'"+emp3.getCHW()+"', ");
			  values.put(iec, "'"+emp3.getIEC()+"', ");
			  
			  db.execSQL("UPDATE Houses SET "+values+" WHERE householdnumber='"+emp3.getHouseholdnumber()+"' AND village='"+emp3.getVillage()+"'");
			 
		}
	public void update(Households emp) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values = new ContentValues();
		  values.put(colVillage, emp.getVillage());
		  //db.execSQL("UPDATE Households SET Village='Ywaya'");
		  //db.execSQL("UPDATE Households SET "+values+" WHERE HouseholdsID=1");
		  db.update(Households, values, null, null);
	}
	public void update1(Households emp) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values = new ContentValues();
		  values.put(colHouseholdnumber, emp.getHouseholdnumber());
		  //db.execSQL("UPDATE Households SET HouseholdNumber='"+);
		  db.update(Households, values, null, null);
	}
	 public List<String> selectHouses() {
		 SQLiteDatabase db=this.getReadableDatabase();
	      List<String> list = new ArrayList<String>();
	      Cursor cursor = db.query(Houses, new String[] { "personname" },
	        null, null, null, null, "personname desc");
	      if (cursor.moveToFirst()) {
	         do {
	            list.add(cursor.getString(0));
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
	
		public List<String> selectHouses1(Households emp) {
			SQLiteDatabase db=this.getReadableDatabase();
			
		      List<String> list = new ArrayList<String>();
		      Cursor cursor = db.rawQuery("SELECT personname FROM Houses WHERE Village='"+emp.getVillage()+"' ORDER BY personname desc LIMIT 1", null);
		      //Cursor cursor = db.query(Individuals, new String[] { colIndName },"WHERE Village="+emp.getVillage()+" AND House="+emp.getHouseholdnumber()+" AND PID=1", 
		      // null, null, null, null, "IndID desc LIMIT 1");
		      if (cursor.moveToFirst()) {
		         do {
		            list.add(cursor.getString(0));
		         } while (cursor.moveToNext());
		      }
		      if (cursor != null && !cursor.isClosed()) {
		         cursor.close();
		      }
		      return list;
		   }
		

	

}

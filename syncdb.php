<?php
//upload file
$target_path = "uploads/";

$target_path = $target_path . basename( $_FILES['uploadedfile']['name']);

if(move_uploaded_file($_FILES['uploadedfile']['tmp_name'], $target_path)) {
echo "Online data has been updated!";
} else{
echo "There was an error updating data, please try again!";
}
//mysql database connection information
$conn = mysql_connect("sql.segasiliconvalley.org", "admin11240", "SegA3829#*");
mysql_select_db("baza11240", $conn);

//connect to sqlite3 database
$filename = basename( $_FILES['uploadedfile']['name']);
$db = new PDO('sqlite:uploads/Chw29');

//find out chw
$result3 = $db->query('SELECT * FROM Households');
foreach($result3 as $row3)
{
$chw = $row3['CHW'];
}

//

$sql = mysql_query("SELECT * FROM chwapp_households WHERE chw='$chw'");
while($row = mysql_fetch_array($sql))
{
$householdnumber=$row['householdnumber'];
$village=$row['village'];
//delete all households and individuals of said chw
mysql_query("DELETE FROM chwapp_individuals WHERE House='$householdnumber' AND Village='$village'");
}
mysql_query("DELETE FROM chwapp_households WHERE chw='$chw'");



//create add households query
$resultstr = array();
$result2 = $db->query('SELECT * FROM Houses');
$query2_stmnt="INSERT INTO chwapp_households(householdnumber, village, haslatrine, iec, staplefood, treatswater, handwashing, coordinates, chw, personname)VALUES";
foreach($result2 as $row2)
{
$resultstr2[] = "('".$row2['householdnumber']."', '".$row2['village']."', '".$row2['haslatrine']."', '".$row2['iec']."', '".$row2['staplefood']."', '".$row2['treatswater']."', '".$row2['handwashing']."', '".str_replace('Coordinates: ', '', ''.$row2['coordinates'].'')."', '".$row2['chw']."', '".$row2['personname']."')";
}
$result4 = implode(",",$resultstr2).';';

$addhouseholds=$query2_stmnt.$result4;

$getlastno = mysql_query("SELECT id FROM chwapp_households ORDER BY id desc LIMIT 1");
$getlastnoarr=mysql_fetch_array($getlastno);
$lastno=$getlastnoarr['id'];

//create add individuals query
$resultstr = array();
$result = $db->query('SELECT * FROM Individuals');
$query1_stmnt="INSERT INTO chwapp_individuals(IndName, Sex, House, Village, Birthday, PID, PhoneNumber, sdate, death, Relationship, BirthCertificate, Bednet, KnowHIVstatus,
 Chronic, Disability, Orphan, OVC, flagged, remarks, flaggedreason,
cliniccard, penta1, penta1date, penta3, penta3date, measles, measlesdate, fullyimmunized, vitamina, vitamniadate, deworming, dewormingdate, malnutrition, 
anc, anc2, birthinlast12, currentlypregnant, whenbbd, wheredeliver, outcome, lastperddate)VALUES";

foreach($result as $row)
{
$resultstr[] = "('".$row['IndName']."', '".$row['Sex']."', '".$row['House']."', '".$row['Village']."', '".$row['Birthday']."', '".$row['PID']."', '".$row['PhoneNumber']."', '".$row['sdate']."', '".$row['Relationship']."', '".$row['BirthCertificate']."', '".$row['Bednet']."', '".$row['KnowHIVstatus']."', '".$row['Chronic']."', '".$row['Disability']."', '".$row['Orphan']."', '".$row['OVC']."', '".$row['flagged']."', '".$row['remarks']."', '".$row['flaggedreason']."', '".$row['cliniccard']."', '".$row['penta1']."', '".$row['penta1date']."', '".$row['penta3']."', '".$row['penta3date']."', '".$row['measles']."', '".$row['measlesdate']."', '".$row['fullyimmunized']."', '".$row['vitamina']."', '".$row['malnutrition']."', '".$row['anc']."', '".$row['birthinlast12']."', '".$row['currentlypregnant']."', '".$row['whenbbd']."', '".$row['wheredeliver']."', '".$row['outcome']."', '".$row['lastperddate']."')";
}
$result3 = implode(",",$resultstr).';';

$addindividuals=$query1_stmnt.$result3;


//perform created queries
mysql_query("$addhouseholds");
mysql_query("$addindividuals");
//echo mysql_error($conn);
?>

package database;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class DBTest {
	@Test
	public void givenQuery1_whenCreatedTable_thenInputtedCorrectly(){
	String arguments[] = {"CREATE","TABLE","chat","(","INTEGER","id","DOUBLE","people","STRING","data",")"};
	Database db = new Database();
	db.dbQuerry(arguments);
	int expectedSize = 1;
	String expectedName = "chat";
    Assert.assertEquals(db.tableName.size(), expectedSize); 
    Assert.assertEquals(db.tables.size(), expectedSize); 
    Assert.assertEquals(db.tableName.get(0), expectedName); 
	}
	
	@Test
	public void givenQuery1_whenCreatedTableAndInsert_thenCorrectlyAdded(){
		String arguments[] = {"CREATE","TABLE","chat","(","INTEGER","id","DOUBLE","people","STRING","data",")"};
		String arguments2 [] = {"INSERT","INTO","TABLE","chat","(","people","d","data","s",")","VALUES","(","100","TestingOut",")"};
		Database db = new Database();
		db.dbQuerry(arguments);
		db.dbQuerry(arguments2);
		int expectedSize = 1;
		Double expectedDouble = 100.0;
		String expectedString = "TestingOut";
		Double result=db.tables.get(0).doubleData.get(1).getArray().get(0);
		 
	    Assert.assertEquals(db.tableName.size(),expectedSize); 
	    Assert.assertEquals(db.tables.size(),expectedSize); 
	    Assert.assertEquals(result,expectedDouble); 
	    Assert.assertEquals(db.tables.get(0).stringData.get(1).getArray().get(0),expectedString); 

	}
	@Test
	public void givenQuery2_whenCreatedTableAndInsert_thenCorrectlyAdded(){
		String arguments[] = {"CREATE","TABLE","direction","(","INTEGER","id","STRING","up","STRING","down","CHARACTER","sign",")"};
		String arguments2 [] = {"INSERT","INTO","TABLE","direction","(","up","s","down","s","sign","c",")","VALUES","(","Yes","No","U",")"};
		Database db = new Database();
		db.dbQuerry(arguments);
		db.dbQuerry(arguments2);
		int expectedSize = 1;
		String expectedStringUp = "Yes";
		String expectedStringDown = "No";
		Character expectedSign ='U';
		
		 
	    Assert.assertEquals(db.tableName.size(),expectedSize); 
	    Assert.assertEquals(db.tables.size(),expectedSize); 
	    Assert.assertEquals(db.tables.get(0).stringData.get(1).getArray().get(0),expectedStringUp); 
	    Assert.assertEquals(db.tables.get(0).stringData.get(1).getArray().get(1),expectedStringDown); 
	    Assert.assertEquals(db.tables.get(0).charData.get(1).getArray().get(0),expectedSign); 
	}
	@Test
	public void givenQuery3_whenCreatedTableAndInsert_thenCorrectlyAdded(){
		String arguments[] = {"CREATE","TABLE","doctor","(","INTEGER","id","STRING","name","STRING","patient","CHARACTER","registered","CHARACTER","checkup",")"};
		String arguments2 [] = {"INSERT","INTO","TABLE","doctor","(","name","s","patient","s","registered","c","checkup","c",")","VALUES","(","Bob Turner","Jane","Y","N",")"};
		Database db = new Database();
		db.dbQuerry(arguments);
		db.dbQuerry(arguments2);
		int expectedSize = 1;
		String expectedStringName = "Bob Turner";
		String expectedStringPatient = "Jane";
		Character expectedReg ='Y';
		Character expectedCheckup ='N';
		
		 
	    Assert.assertEquals(db.tableName.size(),expectedSize); 
	    Assert.assertEquals(db.tables.size(),expectedSize); 
	    Assert.assertEquals(db.tables.get(0).stringData.get(1).getArray().get(0),expectedStringName); 
	    Assert.assertEquals(db.tables.get(0).stringData.get(1).getArray().get(1),expectedStringPatient); 
	 
	    Assert.assertEquals(db.tables.get(0).charData.get(1).getArray().get(0),expectedReg); 
	    Assert.assertEquals(db.tables.get(0).charData.get(1).getArray().get(1),expectedCheckup); 

	}
	
	@Test
	public void givenQuery4_whenCreatedTableAndInsert_thenCorrectlyAdded(){
		String arguments[] = {"CREATE","TABLE","doctor","(","INTEGER","id","STRING","name","STRING","patient","CHARACTER","registered","CHARACTER","checkup",")"};
		String arguments2 [] = {"INSERT","INTO","TABLE","doctor","(","name","s","patient","s","registered","c","checkup","c",")","VALUES","(","Bob Turner","Jane","Y","N",")"};
		String arguments3[] = {"CREATE","TABLE","direction","(","INTEGER","id","STRING","up","STRING","down","CHARACTER","sign",")"};
		String arguments4 [] = {"INSERT","INTO","TABLE","direction","(","up","s","down","s","sign","c",")","VALUES","(","Yes","No","U",")"};
		
		Database db = new Database();
		db.dbQuerry(arguments);
		db.dbQuerry(arguments2);
		db.dbQuerry(arguments3);
		db.dbQuerry(arguments4);
		
		int expectedSize = 1;
		String expectedStringName = "Bob Turner";
		String expectedStringPatient = "Jane";
		Character expectedReg ='Y';
		Character expectedCheckup ='N';
		
		 
	    Assert.assertEquals(db.tables.get(0).stringData.get(1).getArray().get(0),expectedStringName); 
	    Assert.assertEquals(db.tables.get(0).stringData.get(1).getArray().get(1),expectedStringPatient); 
	    Assert.assertEquals(db.tables.get(0).charData.get(1).getArray().get(0),expectedReg); 
	    Assert.assertEquals(db.tables.get(0).charData.get(1).getArray().get(1),expectedCheckup); 
	    
	    String expectedStringUp = "Yes";
		String expectedStringDown = "No";
		Character expectedSign ='U';
		
	    Assert.assertEquals(db.tables.get(1).stringData.get(1).getArray().get(0),expectedStringUp); 
	    Assert.assertEquals(db.tables.get(1).stringData.get(1).getArray().get(1),expectedStringDown); 
	    Assert.assertEquals(db.tables.get(1).charData.get(1).getArray().get(0),expectedSign); 

	}
}

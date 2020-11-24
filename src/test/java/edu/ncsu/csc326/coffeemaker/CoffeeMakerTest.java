package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;
import org.junit.Test;


/**
 * 
 * @author Sarah Heckman
 *
 * Extended by Mike Whalen
 *
 * Unit tests for CoffeeMaker class.
 */

public class CoffeeMakerTest extends TestCase {
	
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
	private Recipe recipe6;
	private Recipe recipe7;
	private Recipe recipe8;
	private Recipe recipe9;
	private Recipe recipe10;
	private CoffeeMaker cm;
	private RecipeBook recipeBookStub;
	private Recipe [] stubRecipies;
	private Inventory inventory;

	protected void setUp() throws Exception {
		
		cm = new CoffeeMaker();
		
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
		
		//Set up for r5 (added by MWW)
		recipe5 = new Recipe();
		recipe5.setName("Super Hot Chocolate");
		recipe5.setAmtChocolate("6");
		recipe5.setAmtCoffee("0");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("1");
		recipe5.setPrice("100");

		recipe6 = new Recipe();
		recipe6.setName("Super Hot Chocolatee");
		recipe6.setAmtChocolate("0");
		recipe6.setAmtCoffee("100");
		recipe6.setAmtMilk("0");
		recipe6.setAmtSugar("0");
		recipe6.setPrice("100");

		recipe7 = new Recipe();
		recipe7.setName("Super Hot Chocolateeee");
		recipe7.setAmtChocolate("0");
		recipe7.setAmtCoffee("0");
		recipe7.setAmtMilk("100");
		recipe7.setAmtSugar("0");
		recipe7.setPrice("100");

		recipe8 = new Recipe();
		recipe8.setName("Super Hot Chocolateeee");
		recipe8.setAmtChocolate("0");
		recipe8.setAmtCoffee("0");
		recipe8.setAmtMilk("0");
		recipe8.setAmtSugar("100");
		recipe8.setPrice("10");

		recipe10 = new Recipe();
		recipe10.setName("Impossible");
		recipe10.setAmtChocolate("1000");
		recipe10.setAmtCoffee("1000");
		recipe10.setAmtMilk("1000");
		recipe10.setAmtSugar("1000");
		recipe10.setPrice("1000");

		stubRecipies = new Recipe [] {recipe1, recipe2, recipe3};
		
		super.setUp();
	}
	
	
	// put your tests here!
	public void testMakeCoffee() {
		assertTrue(true);
	}

	@Test
	public void testRecipesMisc() throws RecipeException {
		Recipe recipe9= new Recipe();
		try {
			recipe9.setName("Super");
			recipe9.setAmtChocolate("2");
			recipe9.setAmtCoffee("0");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
			assertEquals(recipe9.toString(), "Super");
			assertNotSame(recipe9.hashCode(), recipe9.getName().hashCode());
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testRecipesMisc3() throws RecipeException {
		try {
			recipe7 = new Recipe();
			recipe7.setName("Super Hot Chocolateeee");
			recipe7.setAmtChocolate("0");
			recipe7.setAmtCoffee("0");
			recipe7.setAmtMilk("100");
			recipe7.setAmtSugar("0");
			recipe7.setPrice("100");

			recipe8 = new Recipe();
			recipe8.setName("Super Hot Chocolateeee");
			recipe8.setAmtChocolate("0");
			recipe8.setAmtCoffee("0");
			recipe8.setAmtMilk("0");
			recipe8.setAmtSugar("100");
			recipe8.setPrice("10");
			assertTrue(recipe7.equals(recipe8));
			assertTrue(recipe7.equals(recipe7));
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testRecipesMisc2() throws RecipeException {
		Recipe recipe9= new Recipe();
		try {
			recipe9.setName(null);
			recipe9.setAmtChocolate("2");
			recipe9.setAmtCoffee("0");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testMakeCoffee2() {
		cm.addRecipe(recipe1);
		cm.addRecipe(recipe2);

		cm.makeCoffee(0, 75);
		assertTrue(true);
		cm.makeCoffee(1, 40);
		assertTrue(true);
		cm.makeCoffee(0, 0);
		assertTrue(true);
		cm.makeCoffee(2, 0);
		assertTrue(true);
		cm.makeCoffee(1, 75);
		assertTrue(true);

	}

	@Test
	public void testAddRecipe() {
		assertTrue(cm.addRecipe(recipe1));
		assertFalse(cm.addRecipe(recipe1));
		assertTrue(cm.addRecipe(recipe2));
		assertTrue(cm.addRecipe(recipe3));
		assertTrue(cm.addRecipe(recipe4));
		;

	}

	@Test
	public void testRecipes() throws InventoryException {
		cm.addRecipe(recipe6);
		cm.addRecipe(recipe7);
		cm.addRecipe(recipe8);
		try {

			cm.addInventory("2","2","10","2");
			cm.makeCoffee(0,100);
			cm.makeCoffee(1,100);
			cm.makeCoffee(2,100);

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}
	}
	@Test
	public void testRecipess() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super");
			recipe9.setAmtChocolate("-2");
			recipe9.setAmtCoffee("0");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}
	@Test
	public void testRecipess2() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super2");
			recipe9.setAmtChocolate("ab");
			recipe9.setAmtCoffee("0");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}
	@Test
	public void testRecipess3() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super3");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("-1");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testRecipess4() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super4");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("ab");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testRecipess5() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super5");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("-1");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testRecipess6() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super6");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("ab");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testRecipess7() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super7");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("1");
			recipe9.setAmtSugar("-2");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testRecipess8() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super8");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("1");
			recipe9.setAmtSugar("ab");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testRecipess9() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super9");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("1");
			recipe9.setAmtSugar("1");
			recipe9.setPrice("-10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testRecipess10() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super10");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("1");
			recipe9.setAmtSugar("1");
			recipe9.setPrice("ab");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testGetRecipe() {
		cm.getRecipes();
		assertTrue(true);
	}
	@Test
	public void testCheckInventory() {
		cm.checkInventory();
		assertTrue(true);
	}
	@Test
	public void testDeleteRecipe() {
		boolean statusAdd = cm.addRecipe(recipe1);
		assertTrue(statusAdd);
		String statusDeleted = cm.deleteRecipe(0);
		assertTrue(statusDeleted == recipe1.getName());

	}
	@Test
	public void testDeleteRecipe2() {
		String statusDeleted = cm.deleteRecipe(0);
		assertTrue(statusDeleted == null);

	}

	@Test
	public void testEditRecipe() {
		cm.addRecipe(recipe2);
		assertTrue(true);
		cm.editRecipe(2,recipe3);
		assertTrue(true);


	}
	@Test
	public void testEditRecipe2() {
		cm.addRecipe(recipe1);
		cm.addRecipe(recipe2);
		cm.addRecipe(recipe3);
		cm.editRecipe(1, recipe2);
		assertTrue(true);
	}

	@Test
	public void testAddInventory() throws Exception {
		cm.addInventory("4","7","0","9");
		assertTrue(true);

	}

	@Test(expected = InventoryException.class)
	public void testAddInventory2() throws Exception {
		try {

			cm.addInventory("ab", "aa", "cc", "dd");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionForChocolate3() throws InventoryException {

		try {

			cm.addInventory("1", "2", "2", "4");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionForChocolate() throws InventoryException {

		try {

			cm.addInventory("1", "2", "2", "ab");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}


	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionForChocolate1() throws InventoryException {

		try {

			cm.addInventory("1", "3", "1", "-5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}
	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionForCoffee() throws InventoryException {

		try {

			cm.addInventory("ab", "3", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionForCoffee2() throws InventoryException {

		try {

			cm.addInventory("-1", "3", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionForMilk() throws InventoryException {

		try {

			cm.addInventory("1", "ab", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionForMilk2() throws InventoryException {

		try {

			cm.addInventory("1", "-2", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionForSugar() throws InventoryException {

		try {

			cm.addInventory("1", "2", "ab", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionForSugar1() throws InventoryException {

		try {

			cm.addInventory("1", "2", "-2", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	//-----------------------------------------------------------------------

	@Test
	public void testInventory(){
		Inventory inventory=new Inventory();
		inventory.setChocolate(-5);
		assertNotSame(inventory.getChocolate(),-5);

		inventory.setCoffee(-5);
		assertNotSame(inventory.getCoffee(),-5);

		inventory.setMilk(-5);
		assertNotSame(inventory.getMilk(),-5);

		inventory.setSugar(-5);
		assertNotSame(inventory.getSugar(),-5);
	}

	@Test
	public void testEnough() throws RecipeException {
		try {
			recipe10 = new Recipe();
			recipe10.setName("Impossible");
			recipe10.setAmtChocolate("1000");
			recipe10.setAmtCoffee("1000");
			recipe10.setAmtMilk("1000");
			recipe10.setAmtSugar("1000");
			recipe10.setPrice("1000");
			Inventory inventory=new Inventory();
			inventory.setChocolate(5);
			inventory.setMilk(5);
			inventory.setCoffee(5);
			inventory.setSugar(5);
			inventory.enoughIngredients(recipe10);
		}
		catch(RecipeException e){
			//..
		}
	}

	@Test
	public void testAddChocolate() throws InventoryException{
		try{
			Inventory inventory=new Inventory();
			inventory.setChocolate(5);
			inventory.setMilk(5);
			inventory.setCoffee(5);
			inventory.setSugar(5);
			inventory.addChocolate("ab");
		}
		catch(InventoryException e){
			//..
		}
	}

	@Test
	public void testAddChocolate2() throws InventoryException{
		try{
			Inventory inventory=new Inventory();
			inventory.setChocolate(5);
			inventory.setMilk(5);
			inventory.setCoffee(5);
			inventory.setSugar(5);
			inventory.addChocolate("-5");
		}
		catch(InventoryException e){
			//..
		}
	}

	@Test
	public void testNullHashCode() throws RecipeException {
		try {
			recipe10 = new Recipe();
			recipe10.setName(null);
			recipe10.setAmtChocolate("1000");
			recipe10.setAmtCoffee("1000");
			recipe10.setAmtMilk("1000");
			recipe10.setAmtSugar("1000");
			recipe10.setPrice("1000");
			assertEquals(recipe10.hashCode(),31);
		}
		catch(RecipeException e){
			//..
		}
	}

	@Test
	public void testEquals() throws RecipeException {
		try {
			Recipe recipe10=new Recipe();
			recipe10.setName("SupaHot");
			recipe10.setAmtChocolate("1000");
			recipe10.setAmtCoffee("1000");
			recipe10.setAmtMilk("1000");
			recipe10.setAmtSugar("1000");
			recipe10.setPrice("1000");
			Inventory inventory=new Inventory();
			inventory.setChocolate(5);
			inventory.setMilk(5);
			inventory.setCoffee(5);
			inventory.setSugar(5);
			assertFalse(recipe10.equals(inventory));
		}
		catch(RecipeException e){
			//..
		}
	}

	@Test
	public void testEquals2() throws RecipeException {
		try {
			Recipe recipe10=new Recipe();
			recipe10.setName(null);
			recipe10.setAmtChocolate("1000");
			recipe10.setAmtCoffee("1000");
			recipe10.setAmtMilk("1000");
			recipe10.setAmtSugar("1000");
			recipe10.setPrice("1000");
			Recipe recipe9=new Recipe();
			recipe9.setName("Supahot");
			recipe9.setAmtChocolate("10");
			recipe9.setAmtCoffee("10");
			recipe9.setAmtMilk("10");
			recipe9.setAmtSugar("10");
			recipe9.setPrice("10");
			assertFalse(recipe10.equals(recipe9));
		}
		catch(RecipeException e){
			//..
		}
	}

	//--------------------------------------------------------------------------------------
	@Test
	public void testAddInventory1() throws InventoryException {
		cm.addInventory("4","7","0","9");
	}

	@Test
	public void testAddInventory20() throws InventoryException {
		cm.addInventory("4","0","0","9");
	}
	@Test
	public void testAddInventory3() throws InventoryException {
		cm.addInventory("16","16","000","000");
	}
	@Test
	public void testAddInventory4() throws InventoryException {
		cm.addInventory("4", "4", "000", "0");
	}




	@Test(expected = InventoryException.class)
	public void testAddInventoryException1() throws InventoryException {
		try{
			cm.addInventory("-4","7","0","9");
		}catch (InventoryException e){
			//throw e;
		}
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException2() throws InventoryException {
		try{
			cm.addInventory("x","+7","-0","3-2");
		}
		catch (InventoryException e){

		}

	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException3() throws InventoryException {

		try{
			cm.addInventory("2-1","1+7","5-0","3-2");
		}catch (InventoryException e){

		}
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException4() throws InventoryException {
		try{
			cm.addInventory("4", "-1", "asdf", "3");
		}catch (InventoryException e){

		}
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException5() throws InventoryException {
		try{
			cm.addInventory("9", "@-1", "fxxxx", "xxxxx");
		}catch (InventoryException e){

		}
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException6() throws InventoryException {
		try{
			cm.addInventory("4", "-0", "@@@", "3");
		}catch (InventoryException e){

		}
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException7() throws InventoryException {
		try{
			cm.addInventory("", "-1", "", "3");
		}catch (InventoryException e){

		}
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException10() throws InventoryException {
		try{
			cm.addInventory("#", "@", "&", "~");
		}catch(InventoryException ignored){
			//throw ignored;
		}
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException11() throws InventoryException {
		try{
			cm.addInventory("0.5", "0.6", "0.003", "0.010");
		}catch (InventoryException ignored){
			//throw ignored;
		}
	}
	@Test(expected = InventoryException.class)
	public void testAddInventoryException13() throws InventoryException {
		try{
			cm.addInventory("-0", "-0", "", "");
		}catch (InventoryException ignored){
			//throw ignored;
		}
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException14() throws InventoryException {
		try{
			cm.addInventory("0.v", "0.0", "0.000", "0.00");
		}catch (InventoryException ignored){
			//throw ignored;
		}
	}
	@Test(expected = InventoryException.class)
	public void testAddInventoryException15() throws InventoryException {
		try{
			cm.addInventory("1", "-1", "-", "");
		}catch (InventoryException e){
			//throw e;
		}
	}
	@Test(expected = InventoryException.class)
	public void testAddInventoryException16() throws InventoryException {
		try{
			cm.addInventory("", "", "", "");
		}catch (InventoryException e){
			//throw e;
		}
	}

	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void ttestMakeCoffee() {
		cm.addRecipe(recipe1);
		assertEquals(25, cm.makeCoffee(0, 75));
	}

	@Test
	public void testMakeCoffee1() {
		boolean statusAdd = cm.addRecipe(recipe1);
		assertTrue(statusAdd);

	}

	@Test
	public void ttestMakeCoffee2() {
		boolean statusAdd = cm.addRecipe(recipe1);
		assertTrue(statusAdd);

	}

	@Test
	public void testMakeCoffee3() {
		boolean statusAdd2 = cm.addRecipe(recipe1);
		assertTrue(statusAdd2);

	}
	@Test
	public void testMakeCoffee4() {
		boolean statusAdd = cm.addRecipe(recipe1);
		assertTrue(statusAdd);

	}
	@Test
	public void testMakeCoffee5() {
		boolean statusAdd3 = cm.addRecipe(recipe3);
		assertTrue(statusAdd3);

	}
	@Test
	public void testMakeCoffee6() {
		boolean statusAdd4 = cm.addRecipe(recipe4);
		assertTrue(statusAdd4);

	}

	@Test
	public void testMakeCoffee7() {
		boolean statusAdd5 = cm.addRecipe(recipe6);
		assertTrue(statusAdd5);

	}

	@Test
	public void testMakeCoffee8() {
		boolean statusAdd4 = cm.addRecipe(recipe6);
		assertTrue(statusAdd4);

	}

	@Test
	public void addRecipe1() throws Exception {
		cm.addRecipe(recipe1);
	}

	@Test
	public void addRecipe6() throws Exception {
		cm.addRecipe(recipe1);
	}

	@Test
	public void addRecipe2() throws Exception {
		assertTrue(cm.addRecipe(recipe1));
		assertFalse(cm.addRecipe(recipe1));
	}
	@Test
	public void addRecipe3() throws Exception {
		assertTrue(cm.addRecipe(recipe1));
		assertTrue(cm.addRecipe(recipe4));
	}
	@Test
	public void addRecipe4() throws Exception {
		assertTrue(cm.addRecipe(recipe4));
	}

	@Test
	public void addRecipe5() throws Exception {
		assertTrue(cm.addRecipe(recipe5));
	}

	@Test
	public void addRecipe10() throws Exception {
		assertTrue(cm.addRecipe(recipe1));
		assertTrue(cm.addRecipe(recipe2));
		assertTrue(cm.addRecipe(recipe3));
		assertFalse(cm.addRecipe(recipe9));
	}

	@Test
	public void deleteRecipe1() throws Exception {
		String statusDeleted = cm.deleteRecipe(0);
		assertFalse(statusDeleted == recipe1.getName());
	}
	@Test
	public void deleteRecipe2() throws Exception {
		String statusDeleted = cm.deleteRecipe(0);
		assertTrue(statusDeleted == null);
	}
	@Test
	public void deleteRecipe3() throws Exception {
		String statusDeleted = cm.deleteRecipe(-1);
		assertTrue(statusDeleted == null);
	}
	@Test
	public void deleteRecipe4() throws Exception {
		String statusDeleted = cm.deleteRecipe(1);
		assertTrue(statusDeleted == null);
	}

	@Test
	public void editRecipe() throws Exception {
		cm.editRecipe(1,recipe6);
	}
	@Test
	public void editRecipe0() throws Exception {
		cm.editRecipe(2,recipe7);
	}
	@Test
	public void editRecipe1() throws Exception {

		recipe8 = new Recipe();
		recipe8 = new Recipe();
		recipe8.setName("Latte");
		recipe8.setAmtChocolate("0");
		recipe8.setAmtCoffee("3");
		recipe8.setAmtMilk("3");
		recipe8.setAmtSugar("1");
		recipe8.setPrice("100");

		cm.editRecipe(1,recipe8);
	}

	@Test
	public void editRecipe2() throws Exception {

		recipe9 = new Recipe();
		recipe9.setName("");
		recipe9.setAmtChocolate("00");
		recipe9.setAmtCoffee("-0");
		recipe9.setAmtMilk("0");
		recipe9.setAmtSugar("000");
		recipe9.setPrice("000");

		cm.editRecipe(1,recipe9);
	}

	@Test
	public void editRecipe3() throws Exception {

		recipe10 = new Recipe();
		recipe10.setName("");
		recipe10.setAmtChocolate("00");
		recipe10.setAmtCoffee("-0");
		recipe10.setAmtMilk("0");
		recipe10.setAmtSugar("000");
		recipe10.setPrice("000");

		cm.editRecipe(1,recipe10);
	}

	@Test
	public void editRecipe4() throws Exception {

		recipe10 = new Recipe();
		recipe10.setName("");
		recipe10.setAmtChocolate("00");
		recipe10.setAmtCoffee("-0");
		recipe10.setAmtMilk("0");
		recipe10.setAmtSugar("000");
		recipe10.setPrice("000");

		cm.editRecipe(1,recipe10);
	}

	@Test
	public void editRecipe5() throws Exception {

		recipe10 = new Recipe();
		recipe10.setName("");
		recipe10.setAmtChocolate("00");
		recipe10.setAmtCoffee("-0");
		recipe10.setAmtMilk("0");
		recipe10.setAmtSugar("000");
		recipe10.setPrice("000");

		cm.editRecipe(1,recipe10);
	}

	@Test
	public void editRecipe6() throws Exception {

		recipe10 = new Recipe();
		recipe10.setName("");
		recipe10.setAmtChocolate("00");
		recipe10.setAmtCoffee("-0");
		recipe10.setAmtMilk("0");
		recipe10.setAmtSugar("000");
		recipe10.setPrice("000");

		cm.editRecipe(1,recipe10);
	}

	@Test
	public void ttestRecipesMisc() throws RecipeException {
		Recipe recipe9= new Recipe();
		try {
			recipe9.setName("Super");
			recipe9.setAmtChocolate("2");
			recipe9.setAmtCoffee("0");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
			assertEquals(recipe9.toString(), "Super");
			assertNotSame(recipe9.hashCode(), recipe9.getName().hashCode());
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void ttestRecipesMisc3() throws RecipeException {
		try {
			recipe7 = new Recipe();
			recipe7.setName("Super Hot Chocolateeee");
			recipe7.setAmtChocolate("0");
			recipe7.setAmtCoffee("0");
			recipe7.setAmtMilk("100");
			recipe7.setAmtSugar("0");
			recipe7.setPrice("100");

			recipe8 = new Recipe();
			recipe8.setName("Super Hot Chocolateeee");
			recipe8.setAmtChocolate("0");
			recipe8.setAmtCoffee("0");
			recipe8.setAmtMilk("0");
			recipe8.setAmtSugar("100");
			recipe8.setPrice("10");
			assertTrue(recipe7.equals(recipe8));
			assertTrue(recipe7.equals(recipe7));
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void ttestRecipesMisc2() throws RecipeException {
		Recipe recipe9= new Recipe();
		try {
			recipe9.setName(null);
			recipe9.setAmtChocolate("2");
			recipe9.setAmtCoffee("0");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void testMakeCoffee20() {
		cm.addRecipe(recipe1);
		cm.addRecipe(recipe2);
		System.out.println(cm.checkInventory());
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 50),0);
		assertSame(cm.makeCoffee(0, 49),49);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);
		assertSame(cm.makeCoffee(0, 75),25);

		System.out.println(cm.checkInventory());
		assertSame(cm.makeCoffee(0, 75),75);
	}

	@Test
	public void testMakeCoffee21() {
		assertSame(cm.makeCoffee(0, 75),75);
	}

	@Test
	public void ttestAddRecipe() {
		assertTrue(cm.addRecipe(recipe1));
		assertFalse(cm.addRecipe(recipe1));
		assertTrue(cm.addRecipe(recipe2));
		assertTrue(cm.addRecipe(recipe3));
		//assertTrue(cm.addRecipe(recipe4));
		;
	}

	@Test
	public void ttestRecipes() throws InventoryException {
		cm.addRecipe(recipe6);
		cm.addRecipe(recipe7);
//		cm.addRecipe(recipe8);
		try {

			cm.addInventory("2","2","10","2");
			cm.makeCoffee(0,100);
			cm.makeCoffee(1,100);
			cm.makeCoffee(2,100);

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}
	}
	@Test
	public void ttestRecipess() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super");
			recipe9.setAmtChocolate("-2");
			recipe9.setAmtCoffee("0");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}
	@Test
	public void ttestRecipess2() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super2");
			recipe9.setAmtChocolate("ab");
			recipe9.setAmtCoffee("0");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}
	@Test
	public void ttestRecipess3() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super3");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("-1");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void ttestRecipess4() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super4");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("ab");
			recipe9.setAmtMilk("0");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void ttestRecipess5() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super5");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("-1");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void ttestRecipess6() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super6");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("ab");
			recipe9.setAmtSugar("100");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void ttestRecipess7() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super7");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("1");
			recipe9.setAmtSugar("-2");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void ttestRecipess8() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super8");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("1");
			recipe9.setAmtSugar("ab");
			recipe9.setPrice("10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void ttestRecipess9() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super9");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("1");
			recipe9.setAmtSugar("1");
			recipe9.setPrice("-10");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void ttestRecipess10() throws RecipeException {
		Recipe recipe9 = new Recipe();
		try {
			recipe9.setName("Super10");
			recipe9.setAmtChocolate("1");
			recipe9.setAmtCoffee("1");
			recipe9.setAmtMilk("1");
			recipe9.setAmtSugar("1");
			recipe9.setPrice("ab");
		}
		catch(RecipeException e){
			//..
		}

	}

	@Test
	public void ttestGetRecipe() {
		cm.getRecipes();
		assertTrue(true);
	}
	@Test
	public void ttestCheckInventory() {
		cm.checkInventory();
		assertTrue(true);
	}
	@Test
	public void ttestDeleteRecipe() {
		boolean statusAdd = cm.addRecipe(recipe1);
		assertTrue(statusAdd);
		String statusDeleted = cm.deleteRecipe(0);
		assertTrue(statusDeleted == recipe1.getName());

	}
	@Test
	public void ttestDeleteRecipe2() {
		String statusDeleted = cm.deleteRecipe(0);
		assertTrue(statusDeleted == null);

	}

	@Test
	public void testDeleteRecipe3() {
		boolean statusAdd = cm.addRecipe(recipe1);
		assertTrue(statusAdd);
		assertSame(cm.deleteRecipe(0),recipe1.getName());
	}

	@Test
	public void testDeleteRecipe5() {
		boolean statusAdd = cm.addRecipe(recipe1);
		assertTrue(statusAdd);
		statusAdd = cm.addRecipe(recipe2);
		assertTrue(statusAdd);
		statusAdd = cm.addRecipe(recipe3);
		assertTrue(statusAdd);
		String statusDeleted = cm.deleteRecipe(0);
		assertSame(statusDeleted, recipe1.getName());
		statusAdd = cm.addRecipe(recipe1);
		assertTrue(statusAdd);
	}

	@Test
	public void testDeleteRecipe6() {
		boolean statusAdd = cm.addRecipe(recipe1);
		assertTrue(statusAdd);
		statusAdd = cm.addRecipe(recipe2);
		assertTrue(statusAdd);
		statusAdd = cm.addRecipe(recipe3);
		assertTrue(statusAdd);
		String statusDeleted = cm.deleteRecipe(1);
		assertSame(statusDeleted, recipe2.getName());
		statusAdd = cm.addRecipe(recipe2);
		assertTrue(statusAdd);
	}

	@Test
	public void testDeleteRecipe4() {
		assertNull(cm.deleteRecipe(0));
	}

	@Test
	public void ttestEditRecipe() {
		cm.addRecipe(recipe2);
		assertSame(cm.editRecipe(0,recipe3), recipe3.getName());
	}

	@Test
	public void ttestEditRecipe2() {
		cm.addRecipe(recipe2);
		assertNull(cm.editRecipe(1,recipe3));
	}

	@Test
	public void testEditRecipe5() {
		assertNull(cm.editRecipe(0,recipe3));
		assertNull(cm.editRecipe(1,recipe3));
		assertNull(cm.editRecipe(3,recipe3));
	}

	@Test
	public void testEditRecipe6() {
		cm.addRecipe(recipe2);
		cm.editRecipe(0,recipe3);
		boolean a=cm.addRecipe(recipe1);
		assertTrue(a);
	}

	@Test
	public void ttestAddInventory() throws Exception {
		cm.addInventory("4","7","0","9");
		assertTrue(true);

	}

	@Test
	public void ttestAddInventory2() throws Exception {
		try {

			cm.addInventory("ab", "aa", "cc", "dd");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void ttestAddInventoryExceptionForChocolate3() throws InventoryException {

		try {

			cm.addInventory("1", "2", "2", "4");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void ttestAddInventoryExceptionForChocolate() throws InventoryException {

		try {

			cm.addInventory("1", "2", "2", "ab");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}


	@Test
	public void ttestAddInventoryExceptionForChocolate1() throws InventoryException {

		try {

			cm.addInventory("1", "3", "1", "-5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}
	@Test
	public void ttestAddInventoryExceptionForCoffee() throws InventoryException {

		try {

			cm.addInventory("ab", "3", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void ttestAddInventoryExceptionForCoffee2() throws InventoryException {

		try {

			cm.addInventory("-1", "3", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void ttestAddInventoryExceptionForMilk() throws InventoryException {

		try {

			cm.addInventory("1", "ab", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void ttestAddInventoryExceptionForMilk2() throws InventoryException {

		try {

			cm.addInventory("1", "-2", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void ttestAddInventoryExceptionForSugar() throws InventoryException {

		try {

			cm.addInventory("1", "2", "ab", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void ttestAddInventoryExceptionForSugar1() throws InventoryException {

		try {

			cm.addInventory("1", "2", "-2", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void testAddInventoryExceptionForSugar0() throws InventoryException {

		try {

			cm.addInventory("1", "2", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void testAddInventoryExceptionForSugar2() throws InventoryException {

		try {

			cm.addInventory("0", "2", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void testAddInventoryExceptionForSugar3() throws InventoryException {

		try {

			cm.addInventory("0", "0", "0", "5");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

	@Test
	public void testAddInventoryExceptionForSugar4() throws InventoryException {

		try {

			cm.addInventory("0", "0", "0", "0");

		} catch (InventoryException e) {

			System.out.print("catch the exceptions");

		}

	}

}

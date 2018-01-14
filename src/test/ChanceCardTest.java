package test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.MasterController;
import game.controllers.BoardController;
import game.controllers.PlayerController;
import game.model.Player;
import game.model.fields.ownable.ShippingField;

public class ChanceCardTest {
	ChanceCardControllerTest cC = new ChanceCardControllerTest();
	BoardController board = new BoardController();
	PlayerController pC = new PlayerController();
	String[] names = {"Trump","Obama","Bobs","Dick"};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void resolveChanceTest() {
		int ba = MasterController.PLAYER_STARTBALANCE;
		for (int j = 0 ; j < 1000000; j++){
			for (int i = 1; i<24; i++){
				pC.makePlayers(names);
				Player curPlayer = pC.getPlayer(1);
				cC.resolveChance(i, curPlayer,pC.getPlayers(),board.getFields());
				switch (i){
				case 1:
					assertTrue("not the right ammount", curPlayer.getBalance()==ba + 3000);
					break;
				case 2:
					assertTrue("not the right ammount", curPlayer.getBalance()==ba + (pC.getPlayers().length-1)*500 );
					break;
				case 3:
					assertTrue("not the right location", curPlayer.getLocation() == 0);
					break;
				case 4:
					assertTrue("not the right location", curPlayer.getLocation()==37);
					break;
				case 5:
					assertTrue("not the right ammount", curPlayer.getBalance()==ba + 1000);
					break;
				case 6:
					assertTrue("not the right ammount", curPlayer.getBalance()== ba + 200);
					break;
				case 7:
					assertTrue("not the right ammount", curPlayer.getBalance()== ba - 1000);
					break;
				case 8:
					assertTrue("not the right location", curPlayer.getLocation()== 3);
					break;
				case 9:
					assertTrue("not the right ammount", curPlayer.getBalance()== ba - 3000);
					break;
				case 10:
					assertTrue("not the right ammount", curPlayer.getBalance()== ba - 300);
					break;
				case 11:
					assertTrue("not the right ammount", curPlayer.getBalance()== ba - 2000);
					break;
				case 12:
					assertTrue("not the right ammount", curPlayer.getBalance()==ba + (pC.getPlayers().length-1)*200 );
					break;
				case 13:
					assertTrue("not in jail", curPlayer.isFree()== false);
					assertTrue("not the right location", curPlayer.getLocation()==10);
					break;
				case 14:
					assertTrue("not the right ammount", curPlayer.getBalance()== ba + 500);
					break;
				case 15:
					assertTrue("stopped at the wrong field", board.getField(curPlayer.getLocation())instanceof ShippingField);
					break;
				case 16:
					assertTrue("not the right field",curPlayer.getLocation()== 15);
					break;
				case 17:
					assertTrue("not the right field",curPlayer.getLocation()== 11);
					break;
				case 18:
					assertTrue("not the right field",curPlayer.getLocation()== 19);
					break;
				case 19:
					assertTrue("not the right field",curPlayer.getLocation()== 39);
					break;
				case 20:
					assertTrue("not the right field",curPlayer.getLocation()== 32);
					break;
				case 21:
					assertTrue("not the right field",curPlayer.getLocation()== 24);
					break;
				case 22:
					assertTrue("not the right ammount", curPlayer.getBalance()== ba - 200);
					break;
				case 23:
					assertTrue("not the right ammount", curPlayer.getJailCard() == 1);
					break;


				}
				

			}
			if (j % 500000 == 0)
				System.out.println(j+ " antal test kørt");
		}
	}

}

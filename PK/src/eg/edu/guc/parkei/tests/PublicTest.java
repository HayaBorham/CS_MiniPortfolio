package eg.edu.guc.parkei.tests;

import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;
import eg.edu.guc.parkei.amusers.Adult;
import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.amusers.Baby;
import eg.edu.guc.parkei.amusers.Kid;
import eg.edu.guc.parkei.amusers.Senior;
import eg.edu.guc.parkei.exceptions.AmuserException;
import eg.edu.guc.parkei.exceptions.CannotBoardException;
import eg.edu.guc.parkei.exceptions.CannotOperateException;
import eg.edu.guc.parkei.exceptions.FullRideException;
import eg.edu.guc.parkei.exceptions.OutOfOrderException;
import eg.edu.guc.parkei.exceptions.UnsuitableHeightException;
import eg.edu.guc.parkei.exceptions.WrongAgeException;
import eg.edu.guc.parkei.exceptions.WrongTicketException;
import eg.edu.guc.parkei.utilities.Ticket;
import eg.edu.guc.parkei.park.rides.BiDirectionalRide;
import eg.edu.guc.parkei.park.rides.CircularRide;
import eg.edu.guc.parkei.park.rides.FerrisWheel;
import eg.edu.guc.parkei.park.rides.FunRide;
import eg.edu.guc.parkei.park.rides.RollerCoaster;
import eg.edu.guc.parkei.park.rides.ScareRide;
import eg.edu.guc.parkei.park.rides.TransportRide;
import eg.edu.guc.parkei.park.rides.WaterRide;

public class PublicTest {
	private Amuser baby;
	private Amuser kid;
	private Amuser adult;
	private Amuser senior;
	private FunRide splash;
	private FunRide dark;
	private FunRide coaster;
	private FunRide ferris;
	private TransportRide parrade;
	private TransportRide paddleBoats;

	@Test(expected = WrongAgeException.class)
	public void testNotBornBaby() throws WrongAgeException {
		baby = new Baby("Zeen", -2, 30);
	}

	@Test(expected = AmuserException.class)
	public void testOldKid() throws WrongAgeException {
		kid = new Kid("Zeen", 17, 130);
	}

	@Test(expected = AmuserException.class)
	public void testVeryYoungAdult() throws WrongAgeException {
		adult = new Adult("Zeen", 3, 30);
	}

	@Test(expected = AmuserException.class)
	public void testOldAdult() throws WrongAgeException {
		adult = new Adult("Zeen", 67, 130);

	}

	@Test(expected = AmuserException.class)
	public void testVeryVeryYoungSenior() throws WrongAgeException {
		senior = new Senior("Zeen", 3, 30);
	}

	@Test(expected = AmuserException.class)
	public void testVeryYoungSenior() throws WrongAgeException {
		senior = new Senior("Zeen", 13, 130);
	}

	@Test
	public void testAdultNoExceptions() throws WrongAgeException {
		adult = new Adult("Eman", 22, 160);
		assertTrue("Adult should be constructed", !adult.equals(null));
	}

	@Test ()
	public void testSeniorNoExceptions() throws WrongAgeException {
		senior = new Senior("Karima", 65, 150);
		assertTrue("Senior should be constructed", !senior.equals(null));
	}

	@Test(expected = AmuserException.class)
	public void testBabyBuyMaxi() throws WrongAgeException,
			WrongTicketException {
		baby = new Baby("Zeen", 2, 50);
		baby.buyTicket(Ticket.Maxi);
	}

	@Test(expected = AmuserException.class)
	public void testKidBuyMaxi() throws AmuserException {
		kid = new Kid("Ahmed", 5, 90);
		kid.buyTicket(Ticket.Maxi);
	}

	@Test(expected = AmuserException.class)
	public void testAdultBuyMini() throws AmuserException {
		adult = new Adult("Eman", 22, 160);
		adult.buyTicket(Ticket.Mini);
	}

	@Test(expected = AmuserException.class)
	public void testSeniorBuyMaxi() throws AmuserException {
		senior = new Senior("Karima", 65, 150);
		senior.buyTicket(Ticket.Maxi);
	}

	@Test(expected = OutOfOrderException.class)
	public void testWaterOutOfOrderBoadring() throws WrongAgeException,
			OutOfOrderException, CannotBoardException {
		senior = new Senior("Karima", 65, 150);
		splash = new WaterRide("Splash", 15, 4);
		splash.setRidesToMaintain(0);
		senior.move(splash);
		splash.board(senior);
	}

	@Test(expected = CannotOperateException.class)
	public void testScareOutOfOrderBoadring() throws WrongAgeException,
			OutOfOrderException, CannotBoardException {
		adult = new Adult("Karima", 25, 150);
		dark = new ScareRide("Dark", 7, 10);
		dark.setRidesToMaintain(0);
		adult.move(dark);
		dark.board(adult);
	}

	@Test(expected = CannotOperateException.class)
	public void testRollerOutOfOrderBoadring() throws WrongAgeException,
			OutOfOrderException, CannotBoardException {
		adult = new Adult("Karima", 25, 150);
		coaster = new RollerCoaster("Fun Fire", 10, 2);
		coaster.setRidesToMaintain(0);
		adult.move(coaster);
		coaster.board(adult);
	}

	@Test(expected = CannotOperateException.class)
	public void testFerrisOutOfOrderBoadring() throws WrongAgeException,
			OutOfOrderException, CannotBoardException {
		senior = new Senior("Karima", 65, 150);
		ferris = new FerrisWheel("Big-O", 30, 30);
		ferris.setRidesToMaintain(0);
		senior.move(ferris);
		ferris.board(senior);
	}

	@Test(expected = CannotOperateException.class)
	public void testCirOutOfOrderBoadring() throws WrongAgeException,
			OutOfOrderException, CannotBoardException {
		senior = new Senior("Karima", 65, 150);
		splash = new WaterRide("Splash", 15, 4);
		dark = new ScareRide("Dark", 7, 10);
		coaster = new RollerCoaster("Fun Fire", 10, 2);
		ferris = new FerrisWheel("Big-O", 30, 30);
		ArrayList<FunRide> locs = new ArrayList<FunRide>();
		locs.add(coaster);
		locs.add(ferris);
		locs.add(splash);
		parrade = new CircularRide("Parrade", 30, 30, locs);
		parrade.setRidesToMaintain(0);
		senior.move(coaster);
		parrade.board(senior);
	}

	@Test(expected = CannotBoardException.class)
	public void testScareFull() throws AmuserException, CannotBoardException,
			CannotOperateException {
		baby = new Adult("Zeen", 17, 50);
		kid = new Adult("Ahmed", 35, 90);
		adult = new Adult("Eman", 22, 160);
		dark = new ScareRide("Dark", 7, 2);
		baby.move(dark);
		kid.move(dark);
		adult.move(dark);
		dark.board(baby);
		dark.board(kid);
		dark.board(adult);
	}

	@Test(expected = CannotBoardException.class)
	public void testRollerFull() throws AmuserException, CannotBoardException,
			CannotOperateException {
		baby = new Adult("Zeen", 17, 50);
		kid = new Kid("Ahmed", 13, 140);
		adult = new Adult("Eman", 22, 160);
		senior = new Kid("Karima", 13, 150);
		coaster = new RollerCoaster("Fun Fire", 10, 3);
		baby.move(coaster);
		kid.move(coaster);
		adult.move(coaster);
		senior.move(coaster);
		coaster.board(baby);
		coaster.board(kid);
		coaster.board(adult);
		coaster.board(senior);
	}

	@Test(expected = CannotBoardException.class)
	public void testFerrisFull() throws AmuserException, CannotBoardException,
			CannotOperateException {
		baby = new Baby("Zeen", 1, 50);
		kid = new Kid("Ahmed", 13, 140);
		ferris = new FerrisWheel("Big-O", 30, 1);
		baby.move(ferris);
		kid.move(ferris);
		ferris.board(baby);
		ferris.board(kid);
	}

	@Test(expected = FullRideException.class)
	public void testCirFull() throws AmuserException, CannotBoardException,
			CannotOperateException {
		baby = new Baby("Zeen", 1, 50);
		kid = new Kid("Ahmed", 13, 140);
		ferris = new FerrisWheel("Big-O", 30, 30);
		coaster = new RollerCoaster("Fun Fire", 10, 2);
		baby.move(ferris);
		kid.move(ferris);
		ArrayList<FunRide> locs = new ArrayList<FunRide>();
		locs.add(ferris);
		locs.add(coaster);
		parrade = new CircularRide("Parrade", 30, 1, locs);
		parrade.board(baby);
		parrade.board(kid);
	}

	@Test(expected = CannotBoardException.class)
	public void testBiFull() throws AmuserException, CannotBoardException,
			CannotOperateException {
		baby = new Baby("Zeen", 1, 50);
		kid = new Kid("Ahmed", 13, 140);
		ferris = new FerrisWheel("Big-O", 30, 30);
		coaster = new RollerCoaster("Fun Fire", 10, 2);
		baby.move(ferris);
		kid.move(ferris);
		ArrayList<FunRide> locs = new ArrayList<FunRide>();
		locs.add(ferris);
		locs.add(coaster);
		paddleBoats = new CircularRide("Paddle Boats", 30, 1, locs);
		paddleBoats.board(baby);
		paddleBoats.board(kid);
	}

	@Test(expected = CannotOperateException.class)
	public void testScareNoBoarder() throws AmuserException,
			CannotBoardException, CannotOperateException {
		dark = new ScareRide("Dark", 7, 10);
		dark.start();
	}

	@Test(expected = CannotOperateException.class)
	public void testRollerNoBoarderg() throws AmuserException,
			CannotBoardException, CannotOperateException {
		coaster = new RollerCoaster("Fun Fire", 10, 2);
		coaster.start();
	}

	@Test(expected = CannotOperateException.class)
	public void testFerrisNoBoarder() throws AmuserException,
			CannotBoardException, CannotOperateException {
		ferris = new FerrisWheel("Big-O", 30, 30);
		ferris.start();
	}

	@Test
	public void testCirNoBoarder() throws AmuserException,
			CannotBoardException, CannotOperateException {
		splash = new WaterRide("Splash", 15, 4);
		coaster = new RollerCoaster("Fun Fire", 10, 2);
		ferris = new FerrisWheel("Big-O", 30, 30);
		ArrayList<FunRide> locs = new ArrayList<FunRide>();
		locs.add(coaster);
		locs.add(ferris);
		locs.add(splash);
		parrade = new CircularRide("Parrade", 30, 30, locs);
		parrade.start();
		assertTrue("The ride started", parrade.getRidesToMaintain() == 9);
	}

	@Test(expected = CannotOperateException.class)
	public void testBiNoRoute() throws AmuserException, CannotBoardException,
			CannotOperateException {
		ArrayList<FunRide> locs = new ArrayList<FunRide>();
		paddleBoats = new BiDirectionalRide("Paddle Boats", 45, 50, locs);
		paddleBoats.start();
	}

	@Test(expected = CannotBoardException.class)
	public void testScareIneligibleBaby() throws AmuserException,
			CannotBoardException, CannotOperateException {
		baby = new Baby("Zeen", 1, 50);
		dark = new ScareRide("Dark", 7, 2);
		baby.move(dark);
		dark.board(baby);
	}

	@Test(expected = CannotBoardException.class)
	public void testScareIneligibleKid() throws AmuserException,
			CannotBoardException, CannotOperateException {
		kid = new Kid("Ahmed", 5, 90);
		dark = new ScareRide("Dark", 7, 2);
		kid.move(dark);
		dark.board(kid);
	}

	@Test(expected = CannotBoardException.class)
	public void testScareIneligibleSenior() throws AmuserException,
			CannotBoardException, CannotOperateException {
		senior = new Senior("Eman", 72, 160);
		dark = new ScareRide("Dark", 7, 2);
		senior.move(dark);
		dark.board(senior);
	}

	@Test(expected = CannotBoardException.class)
	public void testRollerIneligibleBaby() throws AmuserException,
			CannotBoardException, CannotOperateException {
		baby = new Baby("Zeen", 1, 50);
		coaster = new RollerCoaster("Fun Fire", 10, 3);
		baby.move(coaster);
		coaster.board(baby);
	}

	@Test(expected = CannotBoardException.class)
	public void testRollerIneligibleSenior() throws AmuserException,
			CannotBoardException, CannotOperateException {
		senior = new Senior("Zeen", 71, 50);
		coaster = new RollerCoaster("Fun Fire", 10, 3);
		senior.move(coaster);
		coaster.board(senior);
	}

	@Test
	public void testCirEligible() throws AmuserException, CannotBoardException,
			CannotOperateException {
		baby = new Baby("Zeen", 1, 50);
		kid = new Kid("Ahmed", 13, 140);
		adult = new Adult("Salma", 45, 155);
		senior = new Senior("Karim", 70, 140);
		ferris = new FerrisWheel("Big-O", 30, 30);
		coaster = new RollerCoaster("Fun Fire", 10, 2);
		baby.move(ferris);
		kid.move(ferris);
		adult.move(ferris);
		senior.move(ferris);
		ArrayList<FunRide> locs = new ArrayList<FunRide>();
		locs.add(ferris);
		locs.add(coaster);
		parrade = new CircularRide("Parrade", 30, 5, locs);
		parrade.board(baby);
		parrade.board(kid);
		parrade.board(adult);
		parrade.board(senior);
	}

	@Test(expected = UnsuitableHeightException.class)
	public void testRollerIneligibleShortKid() throws AmuserException,
			CannotBoardException, CannotOperateException {
		kid = new Kid("Zeen", 13, 110);
		coaster = new RollerCoaster("Fun Fire", 10, 3);
		kid.move(coaster);
		coaster.board(kid);
	}

}
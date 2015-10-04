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
import eg.edu.guc.parkei.exceptions.CannotUnboardException;
import eg.edu.guc.parkei.exceptions.FullRideException;
import eg.edu.guc.parkei.exceptions.LocationException;
import eg.edu.guc.parkei.exceptions.NoRidersException;
import eg.edu.guc.parkei.exceptions.NoRouteException;
import eg.edu.guc.parkei.exceptions.OutOfOrderException;
import eg.edu.guc.parkei.exceptions.UnsuitableAgeCategoryException;
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

public class PrivateTest {
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

	@Test(expected = AmuserException.class)
	public void testOldBaby() throws WrongAgeException {
		baby = new Baby("Zeen", 5, 30);
	}

	@Test(expected = AmuserException.class)
	public void testYoungKid() throws WrongAgeException {
		kid = new Kid("Zeen", 3, 30);
	}

	@Test(expected = AmuserException.class)
	public void testYoungAdult() throws WrongAgeException {
		adult = new Adult("Zeen", 13, 130);
	}

	@Test(expected = AmuserException.class)
	public void testYoungSenior() throws WrongAgeException {
		senior = new Senior("Zeen", 25, 130);
	}

	@Test
	public void testBabyNoExceptions() throws WrongAgeException {
		baby = new Baby("Zeen", 2, 50);
		assertTrue("Baby should be constructed", !baby.equals(null));
	}

	@Test
	public void testKidNoExceptions() throws WrongAgeException {
		kid = new Kid("Ahmed", 5, 90);
		assertTrue("Kid should be constructed", !kid.equals(null));
	}

	@Test
	public void testBabyBuyMicro() throws AmuserException {
		baby = new Baby("Zeen", 2, 50);
		baby.buyTicket(Ticket.Micro);
		assertEquals("Babies can buy Micro Tickets", baby.getTicket(),
				Ticket.Micro);
	}

	@Test(expected = WrongTicketException.class)
	public void testBabyBuyMini() throws AmuserException {
		baby = new Baby("Zeen", 2, 50);
		baby.buyTicket(Ticket.Mini);
	}

	@Test(expected = AmuserException.class)
	public void testKidBuyMicro() throws AmuserException {
		kid = new Kid("Ahmed", 5, 90);
		kid.buyTicket(Ticket.Micro);
	}

	@Test
	public void testKidBuyMini() throws AmuserException {
		kid = new Kid("Ahmed", 5, 90);
		kid.buyTicket(Ticket.Mini);
		assertEquals("Kids can buy Mini Tickets", kid.getTicket(), Ticket.Mini);
	}

	@Test(expected = AmuserException.class)
	public void testAdultBuyMicro() throws AmuserException {
		adult = new Adult("Eman", 22, 160);
		adult.buyTicket(Ticket.Micro);
	}

	@Test
	public void testAdultBuyMaxi() throws AmuserException {
		adult = new Adult("Eman", 22, 160);
		adult.buyTicket(Ticket.Maxi);
		assertEquals("Adults can buy Maxi Tickets", adult.getTicket(),
				Ticket.Maxi);
	}

	@Test(expected = AmuserException.class)
	public void testSeniorBuyMicro() throws AmuserException {
		senior = new Senior("Karima", 65, 150);
		senior.buyTicket(Ticket.Micro);
	}

	@Test
	public void testSeniorBuyMini() throws AmuserException {
		senior = new Senior("Karima", 65, 150);
		senior.buyTicket(Ticket.Mini);
		assertEquals("Seniors can buy Mini Tickets", senior.getTicket(),
				Ticket.Mini);
	}

	@Test(expected = CannotOperateException.class)
	public void testBiOutOfOrderBoadring() throws WrongAgeException,
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
		locs.add(dark);
		paddleBoats = new BiDirectionalRide("Paddle Boats", 45, 50, locs);
		paddleBoats.setRidesToMaintain(0);
		senior.move(coaster);
		paddleBoats.board(senior);
	}

	@Test(expected = FullRideException.class)
	public void testWaterFull() throws WrongAgeException, CannotBoardException,
			OutOfOrderException {
		baby = new Adult("Zeen", 17, 50);
		kid = new Kid("Ahmed", 5, 90);
		adult = new Adult("Eman", 22, 160);
		senior = new Senior("Karima", 65, 150);
		splash = new WaterRide("Splash", 15, 3);
		baby.move(splash);
		kid.move(splash);
		adult.move(splash);
		senior.move(splash);
		splash.board(baby);
		splash.board(kid);
		splash.board(adult);
		splash.board(senior);
	}

	@Test(expected = NoRidersException.class)
	public void testWaterNoBoarder() throws WrongAgeException,
			CannotOperateException {
		splash = new WaterRide("Splash", 15, 4);
		splash.start();
	}

	@Test
	public void testBiNoBoarder() throws AmuserException, CannotBoardException,
			CannotOperateException {
		splash = new WaterRide("Splash", 15, 4);
		dark = new ScareRide("Dark", 7, 10);
		coaster = new RollerCoaster("Fun Fire", 10, 2);
		ferris = new FerrisWheel("Big-O", 30, 30);
		ArrayList<FunRide> locs = new ArrayList<FunRide>();
		locs.add(coaster);
		locs.add(ferris);
		locs.add(splash);
		locs.add(dark);
		paddleBoats = new BiDirectionalRide("Paddle Boats", 45, 50, locs);
		paddleBoats.start();
		assertTrue("The ride started", paddleBoats.getRidesToMaintain() == 9);
	}

	@Test(expected = NoRouteException.class)
	public void testCirNoRoute() throws AmuserException, CannotBoardException,
			CannotOperateException {
		ArrayList<FunRide> locs = new ArrayList<FunRide>();
		parrade = new CircularRide("Parrade", 30, 30, locs);
		parrade.start();
	}

	@Test(expected = UnsuitableAgeCategoryException.class)
	public void testWaterIneligible() throws WrongAgeException,
			CannotBoardException, OutOfOrderException {
		baby = new Baby("Zeen", 1, 50);
		splash = new WaterRide("Splash", 15, 3);
		baby.move(splash);
		splash.board(baby);
	}

	@Test
	public void testFerrisEligible() throws AmuserException,
			CannotBoardException, CannotOperateException {
		baby = new Baby("Zeen", 1, 50);
		kid = new Kid("Ahmed", 13, 140);
		adult = new Adult("Salma", 45, 155);
		senior = new Senior("Karim", 70, 140);
		ferris = new FerrisWheel("Big-O", 30, 5);
		baby.move(ferris);
		kid.move(ferris);
		adult.move(ferris);
		senior.move(ferris);
		ferris.board(baby);
		ferris.board(kid);
		ferris.board(adult);
		ferris.board(senior);
	}

	@Test
	public void testBiEligible() throws AmuserException, CannotBoardException,
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
		paddleBoats = new CircularRide("Parrade", 30, 20, locs);
		paddleBoats.board(baby);
		paddleBoats.board(kid);
		paddleBoats.board(adult);
		paddleBoats.board(senior);
	}

	@Test(expected = UnsuitableAgeCategoryException.class)
	public void testRollerIneligibleTallBaby() throws WrongAgeException,
			CannotBoardException, OutOfOrderException {
		baby = new Baby("Zeen", 1, 150);
		coaster = new RollerCoaster("Fun Fire", 10, 3);
		baby.move(coaster);
		coaster.board(baby);
	}

	@Test
	public void testRollerEligibleTallKid() throws AmuserException,
			CannotBoardException, CannotOperateException {
		kid = new Kid("Ahmed", 5, 150);
		coaster = new RollerCoaster("Fun Fire", 10, 3);
		kid.move(coaster);
		coaster.board(kid);
	}

	@Test
	public void testRollerEligibleShortAdult() throws AmuserException,
			CannotBoardException, CannotOperateException {
		kid = new Adult("Ahmed", 25, 90);
		coaster = new RollerCoaster("Fun Fire", 10, 3);
		kid.move(coaster);
		coaster.board(kid);
	}

	@Test(expected = UnsuitableAgeCategoryException.class)
	public void testScareIneligibleTallSenior() throws AmuserException,
			CannotBoardException, CannotOperateException {
		senior = new Senior("Eman", 72, 160);
		coaster = new RollerCoaster("Fun Fire", 10, 3);
		senior.move(coaster);
		coaster.board(senior);
	}

	@Test(expected = CannotUnboardException.class)
	public void testunBoard() throws CannotUnboardException, WrongAgeException {
		adult = new Adult("Eman", 22, 160);
		coaster = new RollerCoaster("Fun Fire", 10, 3);
		adult.move(coaster);
		coaster.unBoard(adult);
	}

	@Test(expected = LocationException.class)
	public void testLocation() throws WrongAgeException, OutOfOrderException,
			CannotBoardException {
		adult = new Adult("Eman", 22, 160);
		coaster = new RollerCoaster("Fun Fire", 10, 3);
		coaster.board(adult);
	}
}

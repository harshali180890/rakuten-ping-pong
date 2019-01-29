package com.project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.project.exception.InvalidTimeSlotException;
import com.project.pojo.Matches;
import com.project.pojo.PlayerInfo;
import com.project.service.CalculateHours;
import com.project.service.CalculateHoursImpl;
import com.project.service.CalculateMatches;
import com.project.service.CalculateMatchesImpl;

public class PingPongGameTest {
	CalculateHours calculateHours;
	CalculateMatches calculateMatches;

	@Before
	public void setUp() {

		this.calculateHours = new CalculateHoursImpl();
		this.calculateMatches = new CalculateMatchesImpl();
	}

	@Test
	public void shouldCalculateMatches() throws InvalidTimeSlotException {

		HashMap<Integer, HashSet<PlayerInfo>> AvailablePlayerPerHour = this.calculateHours
				.calculateAvailablePlayersPerHours(9, 18, add2Players());
		Matches matches = this.calculateMatches.calculateMatches(AvailablePlayerPerHour);
		assertEquals(1, matches.getCountSingle());
		assertEquals(0, matches.getCountDouble());

		HashMap<Integer, HashSet<PlayerInfo>> Available4PlayerPerHour = this.calculateHours
				.calculateAvailablePlayersPerHours(9, 18, add4Players());
		Matches matches2 = this.calculateMatches.calculateMatches(Available4PlayerPerHour);
		assertEquals(5, matches2.getCountSingle());
		assertEquals(0, matches2.getCountDouble());

	}

	private List<PlayerInfo> add2Players() throws InvalidTimeSlotException {
		List<PlayerInfo> list = new ArrayList<>();

		PlayerInfo p1 = new PlayerInfo("p1", 9, 10);
		PlayerInfo p2 = new PlayerInfo("p2", 9, 12);

		list.add(p1);
		list.add(p2);

		return list;
	}

	private List<PlayerInfo> add4Players() throws InvalidTimeSlotException {
		List<PlayerInfo> list = new ArrayList<>();

		PlayerInfo p1 = new PlayerInfo("p1", 9, 10);
		PlayerInfo p2 = new PlayerInfo("p2", 9, 12);
		PlayerInfo p3 = new PlayerInfo("p3", 13, 15);
		PlayerInfo p4 = new PlayerInfo("p4", 10, 18);

		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);

		return list;
	}

}

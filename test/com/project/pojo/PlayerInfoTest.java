package com.project.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project.exception.InvalidTimeSlotException;

public class PlayerInfoTest {

	@Test(expected = InvalidTimeSlotException.class)
	public void shouldValidtePlayersInfo() throws InvalidTimeSlotException {
		new PlayerInfo("p1", 10, 9);
		new PlayerInfo("p2", 17, 17);
	}
}

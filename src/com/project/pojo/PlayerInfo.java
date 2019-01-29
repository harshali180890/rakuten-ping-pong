package com.project.pojo;

import com.project.exception.InvalidTimeSlotException;

public class PlayerInfo {

	private String playerName;
	private int inTime;
	private int outTime;

	public PlayerInfo(String playerName, int inTime, int outTime) throws InvalidTimeSlotException {
		this.playerName = playerName;
		if (outTime - inTime <= 0) {
			throw new InvalidTimeSlotException();
		}
		this.inTime = inTime;
		this.outTime = outTime;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

}

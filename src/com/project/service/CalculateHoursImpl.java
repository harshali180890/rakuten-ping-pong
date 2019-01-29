package com.project.service;

import java.util.HashMap;
import java.util.HashSet;

import java.util.List;

import com.project.pojo.PlayerInfo;

public class CalculateHoursImpl implements CalculateHours {

	HashMap<Integer, HashSet<PlayerInfo>> mapOfficeTimeSlot = new HashMap<>();

	@Override
	public HashMap<Integer, HashSet<PlayerInfo>> calculateAvailablePlayersPerHours(int inTime, int outTime,
			List<PlayerInfo> players) {

		for (int i = inTime; i < outTime; i++) {
			mapOfficeTimeSlot.put(i, new HashSet<>());
		}

		players.forEach(p -> {
			for (int j = p.getInTime(); j < p.getOutTime(); j++)
				mapOfficeTimeSlot.get(j).add(p);
		});
		/*
		 * for (PlayerInfo playerInfo : players) { // insert available players
		 * in office time slot for (int j = playerInfo.getInTime(); j <
		 * playerInfo.getOutTime(); j++) {
		 * 
		 * mapOfficeTimeSlot.get(j).add(playerInfo); } }
		 */
		return mapOfficeTimeSlot;
	}

}

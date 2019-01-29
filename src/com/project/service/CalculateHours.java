package com.project.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.project.pojo.PlayerInfo;

public interface CalculateHours {
	public HashMap<Integer, HashSet<PlayerInfo>> calculateAvailablePlayersPerHours(int inTime, int outTime,
			List<PlayerInfo> players);

}

package com.project.service;

import java.util.HashMap;
import java.util.HashSet;

import com.project.pojo.Matches;
import com.project.pojo.PlayerInfo;

public interface CalculateMatches {
	public Matches calculateMatches(HashMap<Integer, HashSet<PlayerInfo>> AvailablePlayerPerHour);
}

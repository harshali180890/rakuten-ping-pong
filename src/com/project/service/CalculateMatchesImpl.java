package com.project.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.project.pojo.Matches;
import com.project.pojo.PlayerInfo;

public class CalculateMatchesImpl implements CalculateMatches {

	@Override
	public Matches calculateMatches(HashMap<Integer, HashSet<PlayerInfo>> AvailablePlayerPerHour) {
		int countSingles = 0;
		int countDoubles = 0;
		Iterator<Integer> iterator = AvailablePlayerPerHour.keySet().iterator();
		while (iterator.hasNext()) {
			Integer timeslot = iterator.next();
			int size = AvailablePlayerPerHour.get(timeslot).size();
			if (size > 4) {
				countDoubles++;
			} else if (size > 1 && size < 4) {
				countSingles++;
			}
		}
		return new Matches(countSingles, countDoubles);
	}

}

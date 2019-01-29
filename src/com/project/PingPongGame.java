package com.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.project.exception.InvalidTimeSlotException;
import com.project.pojo.Matches;
import com.project.pojo.PlayerInfo;
import com.project.service.CalculateHours;
import com.project.service.CalculateHoursImpl;
import com.project.service.CalculateMatches;
import com.project.service.CalculateMatchesImpl;

public class PingPongGame {

	public static void main(String[] args) throws NumberFormatException, IOException {

		CalculateHours calculateHours = new CalculateHoursImpl();
		CalculateMatches calculateMatches = new CalculateMatchesImpl();
		HashMap<Integer, HashSet<PlayerInfo>> AvailablePlayerPerHour;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfPlayers = Integer.parseInt(br.readLine());
		final int officeInTime = 9;
		final int officeOutTime = 18;

		if (noOfPlayers >= 2) {
			List<PlayerInfo> players = new ArrayList<>();

			for (int i = 1; i <= noOfPlayers; i++) {
				String name = new String("p").concat(String.valueOf(i));

				String[] timeslot = br.readLine().split("\\s");
				PlayerInfo playerInfo;
				try {
					playerInfo = new PlayerInfo(name, Integer.parseInt(timeslot[0]), Integer.parseInt(timeslot[1]));
					players.add(playerInfo);
				} catch (InvalidTimeSlotException e) {
					System.out.println("InvalidTimeSlotException thrown: ");
				}

			}

			AvailablePlayerPerHour = calculateHours.calculateAvailablePlayersPerHours(officeInTime, officeOutTime,
					players);
			Matches match = calculateMatches.calculateMatches(AvailablePlayerPerHour);
			System.out.println(match.getCountSingle() + " " + match.getCountDouble());

		} else {
			System.out.println("No. of players are less to play even a single game");
		}

	}

}

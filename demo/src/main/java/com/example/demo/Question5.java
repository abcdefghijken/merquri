package com.example.demo;

public class Question5 {
    /**
     * SELECT p.Name, s.Sport, SUM(s.Score) AS Total_Score
     * FROM players p
     * JOIN scores s ON p.Player_no = s.Player_no
     * GROUP BY p.Name, s.Sport
     * ORDER BY p.Name, s.Sport;
     */
}

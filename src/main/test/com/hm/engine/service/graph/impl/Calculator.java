package com.hm.engine.service.graph.impl;

/**
 * Created by ant_shake_tree on 15/8/12.
 */
public class Calculator {
    public static MuscleScore  calc (String S,int Age,double Repetitions ) {
        MuscleScore muscleScore = new MuscleScore();
        double StandDev=0.0;
        double PE;
        double Zscore;
        double PercRegress;
        double PopulationAverage=0.0;
        String rating="";
        double score=0.0;
        if (S .equals( "Male")) {
            PopulationAverage =
                    Math.round(22.08-0.00142857*Age-0.00142857*Math.pow(Age,2));
        }
        if (S .equals("Female")) {
            PopulationAverage =
                    Math.round(113.48590476-3.76853968*Age+0.04895238*Math.pow(Age,2)-0.00022222*Math.pow(Age,3));
        }
        if (S .equals( "Male")) {
            StandDev =
                    (4.90714286-0.00714286*Age);
        }
        if (S == "Female" && Repetitions<=PopulationAverage) {
            StandDev =
                    43.00285714-1.02666667*Age+0.00666667*Math.pow(Age,2);
        }
        if (S == "Female" && Repetitions>PopulationAverage) {
            StandDev =
                    104.85161905-4.01758730*Age+0.05228571*Math.pow(Age,2)-0.00022222*Math.pow(Age,3);
        }
        Zscore = (Repetitions-PopulationAverage)/StandDev;

        PE= Math.exp(-1.8355027*(Math.abs(Zscore)-0.23073201));
        PercRegress= -0.41682992*(PE-1)/(PE+1)+0.58953708;
        if (Zscore > 0) {
            score =
                    Math.round(PercRegress*100);
        }
        if (Zscore <= 0) {
            score =
                    Math.round((1-PercRegress)*100);
        }
        if (Zscore >= 1) {
            rating ="Excellent";
        }
        if (Zscore < 1 && Zscore >= 0.5) {
            rating ="Good";
        }
        if (Zscore < 0.5 && Zscore >= -0.5) {
            rating="Average";
        }
        if (Zscore < -0.5 && Zscore >= -1) {
            rating ="Fair";
        }
        if (Zscore < -1) {
            rating ="Poor";
        }
        muscleScore.setScore(score);
        muscleScore.setLevel(rating);
        return muscleScore;
    }

    public static  class  MuscleScore{
        private String level;
        private double score;

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

    public static  void main(String[] args){
        System.out.print(calc("Male",31,20));
    }
}

package org.ssh.product.model;

public class RankingGoods {
    private String title;
    private double appearanceScore;
    private double performanceScore;
    private double photoScore;
    private double userScore;
    private double comprehensiveScore;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAppearanceScore() {
        return appearanceScore;
    }

    public void setAppearanceScore(double appearanceScore) {
        this.appearanceScore = appearanceScore;
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        this.performanceScore = performanceScore;
    }

    public double getPhotoScore() {
        return photoScore;
    }

    public void setPhotoScore(double photoScore) {
        this.photoScore = photoScore;
    }

    public double getUserScore() {
        return userScore;
    }

    public void setUserScore(double userScore) {
        this.userScore = userScore;
    }

    public double getComprehensiveScore() {
        return comprehensiveScore;
    }

    public void setComprehensiveScore(double comprehensiveScore) {
        this.comprehensiveScore = comprehensiveScore;
    }
}

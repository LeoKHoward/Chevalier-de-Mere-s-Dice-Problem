package Relax;

public class Statistics {

    private int totalNumberOfGamesPlayed;
    private double totalGameWinnings;
    private double totalGameWinningsSquared; // required to work out the variance


    /**
     * After the 1,000,000 games are completed, reset the first game variables to 0 before running the second game
     **/
    public synchronized void reset() {
        this.totalNumberOfGamesPlayed = 0;
        this.totalGameWinnings = 0.0;
        this.totalGameWinningsSquared = 0.0;
    }

    /**
     * Assign values to totalNumberOfGamesPlayed/totalGameWinnings and calculate totalGameWinningsSquared
     **/
    public synchronized void assignValues(double winningsPerSingleGame) { // cash output will either be $1.0 or $0.0
        ++totalNumberOfGamesPlayed;
        totalGameWinnings += winningsPerSingleGame;
        totalGameWinningsSquared += winningsPerSingleGame * winningsPerSingleGame;
    }

    /**
     * Calculate the mean value from totalGameWinnings/totalNumberOfGamesPlayed
     **/
    public synchronized double calculateMean() {
        double mean = 0.0;
        if (totalNumberOfGamesPlayed > 0) {
            mean = totalGameWinnings / totalNumberOfGamesPlayed;
        }
        return mean;
    }

    /**
     * Calculate the variance value
     **/
    public synchronized double calculateVariance() {
        double variance = 0.0;
        if (totalNumberOfGamesPlayed > 0) {
            variance = (totalGameWinningsSquared - (totalGameWinnings * totalGameWinnings) /
                    totalNumberOfGamesPlayed) / (totalNumberOfGamesPlayed - 1);
        }
        return variance;
    }

    /**
     * Calculate the standard deviation value from the square root of variance value
     **/
    public synchronized double calculateStandardDeviation() {
        return Math.sqrt(this.calculateVariance());
    }
}



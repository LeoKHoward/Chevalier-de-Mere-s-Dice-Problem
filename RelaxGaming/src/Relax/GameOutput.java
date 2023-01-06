package Relax;

import static Relax.DiceGame.*;


// put games into list so that could iterate through rather than duplicating methods for each game

// set both game number rules to variables for neatness

// chose to assign dollar value to winning game to then easily keep count of winnings

// reset used after each million games finish for each die game so that the output is accurate

public class GameOutput {

    public GameOutput() {

        // Constant variables to dictate rules of each game
        int ONE_DIE_GAME_NUMBER_OF_TIMES_THROWN = 4;
        int TWO_DICE_GAME_NUMBER_OF_TIMES_THROWN = 24;
        int ONE_DIE_GAME_NUMBER_OF_SIXES_REQUIRED = 1;
        int TWO_DICE_GAME_NUMBER_OF_SIXES_REQUIRED = 2;

        Statistics statistics = new Statistics();

        /*
          Both games put into one list to prevent repeated code
         */
        DiceGame[] diceGames = {
                new DiceGame(ONE_DIE_GAME_NUMBER_OF_TIMES_THROWN, ONE_DIE_GAME_NUMBER_OF_SIXES_REQUIRED),
                new DiceGame(TWO_DICE_GAME_NUMBER_OF_TIMES_THROWN, TWO_DICE_GAME_NUMBER_OF_SIXES_REQUIRED)
        };

        /*
          Title for the output
         */
        System.out.println("Given a payout of $1 when a win is hit...");

        /*
          If the player wins then $1 is credited otherwise 0 dollars are
         */
        for (DiceGame diceGame : diceGames) {
            for (int i = 0; i < NUMBER_OF_GAMES; i++) {
                if (diceGame.isPlayerWinner()) {
                    statistics.assignValues(1.0);
                } else {
                    statistics.assignValues(0.0);
                }
            }

        /*
          Statement to change the title of the output text blocks based on which game it is for
         */
            if (diceGame.getRollAttempts() == 4) {
                System.out.print("\nAt least one six when one six sided die is thrown 4 times in 1,000,000 games:");
            } else {
                System.out.print("\nAt least one double six when two six sided dice are thrown 24 times in 1,000,000 games:");
            }

        /*
          Run common code relevant to both games
         */
            commonCodeOutput(statistics);

        /*
          Reset the statistics each time otherwise will adversely reflect on output
         */
            statistics.reset();
        }
    }

    /**
     * Code relevant to both games
     **/
    private static void commonCodeOutput(Statistics statistics) {
        System.out.println("\n\tMean win chance: " + statistics.calculateMean());
        System.out.println("\tVariance: " + statistics.calculateVariance());
        System.out.println("\tStandard deviation: " + statistics.calculateStandardDeviation());
    }
}

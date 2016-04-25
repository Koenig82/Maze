/**
 * Created by Niklas Königsson on 2016-04-23.
 * cs: dv15nkn
 */

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Class RobotRace
 *
 * this class contains the main method to test the robots
 */
public class RobotRace {

    public static void main(String [] args) throws FileNotFoundException,
                                                   InvalidMazeException {

        int rightBotCount = 0;
        int memBotCount = 0;


        if(args.length == 0){
            System.out.println("Expected textfile as argument");
            return;
        }
        //open the textfile and send it to the mazeclass
        FileReader reader;
        reader = new FileReader(args[0]);
        Maze maze;
        maze = new Maze(reader);

        //create the two robots
        RightHandRuleRobot rightBot = new RightHandRuleRobot(maze);
        MemoryRobot memBot = new MemoryRobot(maze);

        boolean memGoal = false, rightGoal = false;
        //As long as either of the robots is still searching, continue to move
        //them and count the steps
        while(!memGoal || !rightGoal) {
            if(!rightBot.hasReachedGoal() && !rightGoal) {
                rightBot.move();
                rightBotCount++;
            }
            if(rightBot.hasReachedGoal() && !rightGoal) {
                System.out.println(String.format("RightHandRuleRobot reached" +
                                                 " the goal in %d moves",
                                                 rightBotCount));
                rightGoal = true;
            }
            if(!memBot.hasReachedGoal() && !memGoal) {
                memBot.move();
                memBotCount++;
            }
            if(memBot.hasReachedGoal() && !memGoal) {
                System.out.println(String.format("MemoryRobot reached the " +
                                                 "goal in %d moves",
                                                 memBotCount));
                memGoal = true;
            }
        }
        System.out.println(String.format("\nFinal placement: " +
                                         "RightHandRuleRobot    MemoryRobot"));
        System.out.println(String.format("                 %d            " +
                                         "        %d", rightBotCount,
                                         memBotCount));
    }
}

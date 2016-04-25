/**
 * Created by konig on 2016-04-24.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;

public class RobotRace {

    public static void main(String [] args) throws FileNotFoundException,
                                                   InvalidMazeException {

        int rightBotCount = 0;
        int memBotCount = 0;


        if(args.length == 0){
            System.out.println("Expected textfile as argument");
            return;
        }
        FileReader reader;
        reader = new FileReader(args[0]);
        Maze maze;
        maze = new Maze(reader);

        RightHandRuleRobot rightBot = new RightHandRuleRobot(maze);
        MemoryRobot memBot = new MemoryRobot(maze);

        boolean memGoal = false, rightGoal = false;

        while(!memGoal || !rightGoal) {
            //System.out.println("moving...");
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

/**
 * Created by konig on 2016-04-24.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;

public class RobotRace {

    public static void main(String [] args) throws FileNotFoundException, InvalidMazeException {

        int rightBotCount = 0;
        int memBotCount = 0;


        if(args.length == 0){
            System.out.println("Missing command line argument. Maze text file needed");
            return;
        }
        FileReader reader;
        reader = new FileReader(args[0]);
        Maze maze;
        maze = new Maze(reader);

        RightHandRuleRobot rightBot = new RightHandRuleRobot(maze);
        MemoryRobot memBot = new MemoryRobot(maze);
        int count = 0;
        while(!rightBot.hasReachedGoal() && !memBot.hasReachedGoal() && count < 100) {
            System.out.println("körde");
            if(!rightBot.hasReachedGoal()) {
                rightBot.move();
                rightBotCount++;
            }
            if(!memBot.hasReachedGoal()) {
                memBot.move();
                memBotCount++;
            }
            count++;
        }
        System.out.println(String.format("%d %d", memBotCount, rightBotCount));
    }
}

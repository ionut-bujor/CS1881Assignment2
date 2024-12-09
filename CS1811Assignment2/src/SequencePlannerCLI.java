import java.util.Scanner;
import java.util.ArrayList;


public class SequencePlannerCLI {
    public static void main(){
        SequencePlanner sequencePlannerInstance = new SequencePlanner();
        runSimulation(sequencePlannerInstance);

    }










    public static void runSimulation(SequencePlanner instanceSequencePlanner) {
        boolean condition = true;
        int numberOfAttempts = 0;
        while(condition) {
            String previousAttempts = instanceSequencePlanner.getPreviousSuggestions();
            System.out.println("Previous attempts:");

            if (previousAttempts == null) {
                System.out.println("No previous attempts");
            }

            else {
                System.out.println(previousAttempts);
            }

            LaunchSequence userSequence =initialiseUserSequence();
            numberOfAttempts++;


            if (instanceSequencePlanner.checkProposedSequence(userSequence)) {
                System.out.println("Sequence verified!");
                System.out.println("The final sequence is:");
                System.out.println(printingProcedures(userSequence));
                System.out.println("You needed "+numberOfAttempts+" attempts to find the sequence.");
                condition = false;


            }
        }

        }




    public static LaunchSequence initialiseUserSequence() {
        int lengthSequence = 5;
        ArrayList<Integer> userSequence = new ArrayList<>(lengthSequence);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new sequence:");
        while (userSequence.size() < lengthSequence) {
            if (scanner.hasNextInt()) {
                int userProcedure = scanner.nextInt();
                if (userProcedure == 0 || userProcedure > 9) {
                    System.out.println("Invalid sequence!");
                    initialiseUserSequence();
                }
                if (userSequence.contains(userProcedure)){
                    System.out.println("Invalid sequence!");
                    initialiseUserSequence();

                }

                 else {
                    userSequence.add(userProcedure);
                }

            }

        }
        return new LaunchSequence(SequencePlanner.listToArray(userSequence));
    }



   public static String printingProcedures(LaunchSequence sequence){
        StringBuilder userProcedures = new StringBuilder();
        String[] procedures = {
                "System Check",
                "Fuel Loading",
                "Navigation Setup",
                "Communication Test",
                "Engine Ignition",
                "Weather Verification",
                "Crew Boarding",
                "Safety Override",
                "Launch Pad Clear"
        };
        for (int index = 0;index < sequence.getLength();index++){
            int procedureNumber = sequence.getProcedure(index);
            String procedure = procedures[procedureNumber -1];
            userProcedures.append(procedure);
            if (index < sequence.getLength() - 1) {
                userProcedures.append("\n");
            }

        }
        return userProcedures.toString();


    }
}

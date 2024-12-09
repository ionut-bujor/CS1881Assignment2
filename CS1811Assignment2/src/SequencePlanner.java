import java.util.Random;
import java.util.ArrayList;
public class SequencePlanner{



    private static LinkedList previousSuggestions = new LinkedList();
    private  LaunchSequence solution;



    public SequencePlanner(LaunchSequence solution){
        this.solution = solution;
    }



    public SequencePlanner(){
        Random random = new Random();
        int lengthSolution = 5;
        ArrayList<Integer> solutionList = new ArrayList<>(lengthSolution);
        int randomNumber = random.nextInt(10);


        while ( solutionList.size()< lengthSolution) {
            if (randomNumber == 0) {
                randomNumber = random.nextInt(10);
            }
            if (contains(solutionList,randomNumber)) {
                randomNumber = random.nextInt(10);
            }
            else {
                solutionList.add(randomNumber);
            }

        }
        LaunchSequence solution = new LaunchSequence(listToArray(solutionList));
        this.solution = solution;
    }



    public  boolean checkProposedSequence(LaunchSequence sequence){
        ProposedSequence userSequence= new ProposedSequence(solution,sequence);
        previousSuggestions.addNode(userSequence);
        return userSequence.isCorrect();
    }



    public String getPreviousSuggestions(){
        LinkedList.Node head = previousSuggestions.getHead();
        if (head == null){
            return null;
        }
        else{
            return previousSuggestions.toString();

        }
    }



    public LaunchSequence getSolution(){
        return this.solution;
    }



    public boolean contains(ArrayList<Integer> solutionChecked, int target){
        for (int index = 0; index<solutionChecked.size();index ++){
            if (solutionChecked.get(index) == target){
                return true;
            }
            }
        return false;
        }
    public static int[] listToArray(ArrayList<Integer> arraylist){
        int lengthArray = 5;
        int[] array = new int[lengthArray];
        for(int index = 0; index<lengthArray;index++) {
            array[index] = arraylist.get(index);
        }
        return array;

    }

}

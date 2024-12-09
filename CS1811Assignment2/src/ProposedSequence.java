public class ProposedSequence {
    private LaunchSequence sequence;
    private LaunchSequence solution;
    public ProposedSequence(LaunchSequence solution, LaunchSequence sequence){
        this.solution = solution;
        this.sequence = sequence;

    }
    public LaunchSequence getSequence(){
        return this.solution;
    }
    public LaunchSequence getSequence2(){
        return this.sequence;
    }
    public int getNumCorrect(){
        int numCorrect = 0;
        int lengthArray = solution.getLength();
        for (int index = 0; index < lengthArray;index ++){
            if (solution.getProcedure(index) == sequence.getProcedure(index)){
                numCorrect ++;
            }
        }
        return numCorrect;
    }

    public int getNumWrongPosition() {
        int lengthArray = solution.getLength();
        int numWrongPosition = 0;
        boolean[] solutionUsed = new boolean[lengthArray];
        for (int index1 = 0; index1 < lengthArray; index1++) {
            int sequenceElement = sequence.getProcedure(index1);
            int solutionElement = solution.getProcedure(index1);
            if (sequenceElement != solutionElement) {
                boolean foundInSolution = false;
                for (int index2 = 0; index2 < lengthArray; index2++) {
                    if (!solutionUsed[index2] && solution.getProcedure(index2) == sequenceElement) {
                        foundInSolution = true;
                        solutionUsed[index2] = true;
                        break;
                    }
                }
                if (foundInSolution) {
                    numWrongPosition++;
                }
            }
        }

        return numWrongPosition;
    }


    public boolean isCorrect(){
        int numCorrect = 0;
        int lengthArray = solution.getLength();
        for (int index = 0; index < lengthArray;index ++){
            if (solution.getProcedure(index) == sequence.getProcedure(index)){
                numCorrect ++;
            }
        }
        return numCorrect == lengthArray;
    }
    @Override
    public String toString(){
        return getSequence() + " (" + "Correct "+ getNumCorrect()+", " + "Wrong position " + getNumWrongPosition()+")";
    }
}

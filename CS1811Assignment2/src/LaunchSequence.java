public class LaunchSequence {

    private int[] sequence;

    public LaunchSequence(int[] sequence) {
        this.sequence = sequence;
    }

    public int getProcedure(int i) {
        return sequence[i];

    }
    public int getLength(){
        int length = 0;
        for (int x: sequence) {
            length++;
        }
        return length;

    }

    @Override
    public String toString() {
        StringBuilder procedureString = new StringBuilder();
        for (int index = 0; index < sequence.length; index++) {
            procedureString.append(getProcedure(index));
            if (index < sequence.length - 1) {
                procedureString.append(" ");
            }
        }
        return procedureString.toString();
    }

}

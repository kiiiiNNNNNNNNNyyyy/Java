public class Main{
    public static void main(String args[]){

        // double[] leftVals ={100.0d, 25.0d, 224.3d, 11.0d};
        // double[] rightVals ={100.0d, 25.0d, 224.3d, 11.0d};
        // char[] opCodes = {'d', 'a', 's', 'm'};
        // double[] results = new double[opCodes.length];

        MathEquation[] equations = new MathEquation[4];
        equations[0] = create(100.0d, 50.0, 'd');
        equations[0] = create(100.0d, 50.0, 'a');
        equations[0] = create(100.0d, 50.0, 's');
        equations[0] = create(100.0d, 50.0, 'm');

        for(MathEquation equation: equations){
            equation.execute();
            System.out.println(equation.result);
        }
    }

    public static MathEquation create(double leftVal, double rightVal, char opCode){
        MathEquation equation = new MathEquation();
        equation.leftVal = leftVal;
        equation.rightVal = rightVal;
        equation.opCode = opCode;

        return equation;
    }
}

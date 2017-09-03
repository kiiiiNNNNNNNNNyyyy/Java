public class Main{
    public static void main(String args[]){

        double[] leftVals ={100.0d, 25.0d, 224.3d, 11.0d};
        double[] rightVals ={100.0d, 25.0d, 224.3d, 11.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        // double val1 = 100;
        // double val2 = 50.0;
        // double result;
        // char opCode = 'a';

        for(int i=0; i<opCodes.length; i++){
            switch(opCodes[i]){
                case 'a':
                    results[i] = leftVals[i] + rightVals[i];
                    break;
                case 's':
                    results[i] = leftVals[i] - rightVals[i];
                    break;
                case 'd':
                    results[i] = rightVals[i] != 0.0d ? leftVals[i] / rightVals[i] : 0.0d;
                    break;
                case 'm':
                    results[i] = leftVals[i] * rightVals[i];
                    break;
                default:
                    System.out.println("Invalid Code!!");
                    results[i] = 0.0;
                    break;
            }
        }

        for(double result: results){
            System.out.println(result);
        }
        
    }
}

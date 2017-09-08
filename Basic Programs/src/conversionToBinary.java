import java.util.ArrayList;
import java.util.List;;

public class conversionToBinary{
    
    public static int binary(int value){
        List<Integer> binaryNumber = new ArrayList<>();

        binaryNumber.add(1);

        if(value != 0){
            while(value != 1){
                if(value % 2 == 0){
                    binaryNumber.add(0);
                    value = value / 2;
                }else{
                    binaryNumber.add(1);
                    value = value / 2;
                }
                value = value / 2; 
            }    
        }

        String listOfBinartNotation = binaryNumber.toString();
        listOfBinartNotation = listOfBinartNotation.substring(1, listOfBinartNotation.length()-1);
        listOfBinartNotation.replaceAll("[^\\w\\s]", "");
        System.out.println(listOfBinartNotation);
        return 0;
        // return Integer.parseInt(listOfBinartNotation);
    }

    public static void main(String args[]){
        int x = 5;
        System.out.println(binary(x));
    }
}
import java.util.Scanner;

public class DrivewayDemo{
    public static void main(String[] args){
        Driveway testDriveway = new Driveway();
        Scanner scan = new Scanner(System.in);
        System.out.println("Positive integers add cars to the driveway");
        System.out.println("Negative license numbers remove cars.");
        System.out.println("0 stops the simulation.");

        while(scan.hasNextInt()){
            int plate = scan.nextInt();
            if(plate > 0){
                testDriveway.add(plate);
            } else if(plate < 0){
                testDriveway.remove(0 - plate);
            } else{
            	testDriveway.print();
                return;
            }
        }
    }
}

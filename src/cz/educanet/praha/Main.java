package cz.educanet.praha;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        final LanderControls controls = new LanderControls();
        final Scanner sc = new Scanner(System.in);
        System.out.println("So you wanna land huh ?");
        System.out.println("Enter your current autitude : ");
        final int autitude = Integer.parseInt(sc.nextLine());
        System.out.println("Enter your velocity : ");
        final int velocity = Integer.parseInt(sc.nextLine()); 


        try {
            final var lander = new LunarLanding(
                    controls,
                    autitude,
                    velocity
            );
            
            lander.land();
            sc.close();
            
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

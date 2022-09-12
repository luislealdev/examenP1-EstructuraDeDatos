import java.util.Scanner;

public class Exe {
    public static void main(String[] args) {
        // For inputs
        Scanner sc = new Scanner(System.in);
        // Create a binary file
        BinaryFile bf = new BinaryFile("./Flotantes.bin", "rw");
        // Write randomFloats on the file
        bf.m_writeRandomFloats(10);
        // Print all the floats
        bf.m_position(0);
        bf.m_printAllData();
        // Ask user what value to change
        System.out.println("¿Qué flotante desea cambiar?");
        float v_floatToChange = sc.nextFloat();
        System.out.println("¿Por qué valor lo quiere sustituir?");
        float v_newFloat = sc.nextFloat();
        // Change value
        bf.m_changeAValue(v_floatToChange, v_newFloat);
        // Print all the floats again
        bf.m_printAllData();
        // Close the door to the file
        bf.m_closeFile();
    }
}

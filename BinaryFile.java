import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinaryFile {
    // * Atributes */
    String a_location, a_mode;
    RandomAccessFile a_file;

    // * Constructor */
    BinaryFile(String p_location, String p_mode) {
        try {
            // Create the file with RandomAccessFile
            a_file = new RandomAccessFile(a_location, a_mode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // * Methods */
    // Method to change the position of the seek
    public void m_position(int p_position) {
        try {
            a_file.seek(p_position);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to write to the file the number of floats that the user wants
    public void m_writeRandomFloats(int p_numFloats) {
        int counter;
        for (counter = 0; counter < p_numFloats; counter++) {
            // Generate random floats
            float v_valor = (float) Math.random();
            try {
                // Write the floats
                a_file.writeFloat(v_valor);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to print all the file
    public void m_printAllData() {
        // Change position to the start
        m_position(0);
        int counter;
        // Like a title
        System.out.println("----------ARCHIVO FLOTANTES----------");
        // Read and print all the floats
        try {
            for (counter = 0; counter < a_file.length(); counter++) {
                float v_value;
                try {
                    v_value = a_file.readFloat();
                    System.out.println(v_value);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to change a value of the file for an other one
    public void m_changeAValue(float p_valueToChange, float p_newValue) {
        int counter;
        for (counter = 0; counter < 20; counter++) {
            try {
                if (a_file.readFloat() == p_valueToChange) {
                    a_file.seek(counter * 4);
                    a_file.writeFloat(p_newValue);
                    return;
                } else {
                    if (counter == 19) {
                        System.out.println("No se ha encontrado el float a cambiar");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to close the file
    public void m_closeFile() {
        try {
            a_file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

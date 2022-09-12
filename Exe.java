import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Exe {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);

        try (
                // CREAR ARCHIVO O LEERLO
                RandomAccessFile v_archivo = new RandomAccessFile("./flotantes.bin", "rw")) {
            
                    // Metemos 10 flotantes aleatorios al archivo

            v_archivo.seek(0);

            int contador;
            for (contador = 0; contador < 20; contador++) {
                // Generamos flotantes aleatorios
                float v_valor = (float) Math.random();
                try {
                    // Escribimos los flotantes
                    v_archivo.writeFloat(v_valor);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("----------ARCHIVO FLOTANTES----------");
            v_archivo.seek(0);
            int contador2;
            for (contador2 = 0; contador2 < 20; contador2++) {
                float v_valor = v_archivo.readFloat();
                // Mostrar los flotantes
                System.out.println(v_valor);
            }

            System.out.println("Ingrese el valor del flotante a cambiar.");
            float v_floatACambiar = sc.nextFloat();
            System.out.println("Ingrese el nuevo valor del flotante");
            float v_newFloat = sc.nextFloat();

            v_archivo.seek(0);
            for (contador = 0; contador < 20; contador++) {
                if (v_archivo.readFloat() == v_floatACambiar) {
                    v_archivo.seek(contador * 4);
                    v_archivo.writeFloat(v_newFloat);
                    return;
                } else {
                    if (contador == 19) {
                        System.out.println("No se ha encontrado el float a cambiar");
                    }
                }
            }
            System.out.println("----------ARCHIVO FLOTANTES----------");
            v_archivo.seek(0);
            for (contador2 = 0; contador2 < 20; contador2++) {
                float v_valor = v_archivo.readFloat();
                // Mostrar los flotantes
                System.out.println(v_valor);
            }

            try {
                // CERRAR ARCHIVO
                v_archivo.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

import java.io.*;

public class ManipuladorSerializaveis {
    public static void serializa (String nomeArquivo, Object objeto) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(nomeArquivo);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(objeto);

            oos.close();
            fos.close();
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Object desserializa (String nomeArquivo) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Object obj = null;

        try {
            fis = new FileInputStream(nomeArquivo);
            ois = new ObjectInputStream(fis);

            obj = ois.readObject();

            ois.close();
            fis.close();
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return obj;
    }
}

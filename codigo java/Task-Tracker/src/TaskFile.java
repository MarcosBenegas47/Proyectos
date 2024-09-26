
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskFile {

    static String pathArchivo = "archivo.json";

    public static void saveTask(  List<Task> listaTask)   {
       // System.out.println(task);
        //List<Task> listaTask = new ArrayList<Task>();
        String archivo = pathArchivo;
        try {
//            File file = new File(archivo);
//            if(file.exists()){
              //  listaTask = readTask();
            //}



            FileWriter fileWriter = new FileWriter(archivo);

            fileWriter.write(String.valueOf(listaTask).toString());
           fileWriter.flush();
           fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }





    public static List<Task> readTask ( )
    {
        List<Task> lista = new ArrayList<Task>();
        File file = new File(pathArchivo);
        if(!file.exists()){
            return lista;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathArchivo));
            StringBuilder contenido = new StringBuilder();
            String element;
            while (( element= reader.readLine()) != null){

               contenido.append(element);
            }
            String json = contenido.toString().trim();

            if(json.startsWith("[")&& json.endsWith("]")){
                json = json.substring(1,json.length()-1);
                if(json.isEmpty()) return lista;
                String[] objetoJson = json.split("},");

                for(String objeto: objetoJson){
                    if(!objeto.endsWith("}")){
                        objeto = objeto + "}";
                    }

                    Task task = Task.fromJson(objeto);
                    lista.add(task);
                }
            }

        }catch (IOException e){
            e.printStackTrace();

    }
        return lista;
    }
}

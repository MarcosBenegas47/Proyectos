import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TaskClass  {
    public static void IngresarTask(String descripcion){


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        List<Task> listTask = TaskFile.readTask();
        int id = generateId(listTask);

        //System.out.println(dateFormat.format(date));

        listTask.add(new Task(id, descripcion, "todo", dateFormat.format(date),""));

        TaskFile.saveTask( listTask );

        System.out.println("Task added successfully (ID: "+id+")");


    }

    private static int generateId(List<Task> lista) {
        if(lista.isEmpty()){
            return 1;
        }
        int index = lista.size()-1;
        Task ultimo = lista.get(index);
        //System.out.println("el uiltimo id es  "+ultimo.getId());
        return ultimo.getId()+1;


    }

    public static void updateTask(int id, String descripcion, String statusUpdate){
        List<Task> listTask = TaskFile.readTask();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        for(Task task:listTask){
            if(task.getId() == id){
                if(descripcion != ""){
                    task.setDescription(descripcion);
                    task.setUpdatedAt( dateFormat.format(date));
                }

                if(statusUpdate != ""){
                    task.setStatus(statusUpdate);
                    task.setUpdatedAt( dateFormat.format(date));

                }
            }
        }
        TaskFile.saveTask(listTask);
        System.out.println("Task updated successfully");

    }
    public static void listTask(String by){
        List<Task> lista = TaskFile.readTask();
        System.out.format("+----+--------------------------+-----------------+---------------------+---------------------+%n");
        System.out.format("| id |       description        |      status     |      createdAt      |      updatedAt      |%n");
        System.out.format("+----+--------------------------+-----------------+---------------------+---------------------+%n");

        List<Task> listFilter = by == null || by.trim().isEmpty() ? lista:
                lista.stream().filter(task -> task.getStatus().equals(by)).collect(Collectors.toList());

        String leftAlignment = "| %-2s | %-24s | %-15s | %-19s | %-19s |%n";
        for(Task task:listFilter){

            System.out.format(leftAlignment,task.getId(), task.getDescription(), task.getStatus(), task.getCreatedAt(), task.getUpdatedAt() );
            System.out.format("+----+--------------------------+-----------------+---------------------+---------------------+%n");

        }
    }
    public static void deleteTask(int id ){
        List<Task> lista = TaskFile.readTask();

        if(!lista.stream().anyMatch(task -> task.getId() ==id )){
            System.out.println("Error: Task with ID " + id + " does not exist.");
            return;
        } ;

        lista.removeIf(task -> task.getId() ==id);
        TaskFile.saveTask(lista);
        System.out.println("Task Deleted successfully");

    }


}

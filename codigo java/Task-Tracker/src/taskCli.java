import java.util.ArrayList;
import java.util.List;

public class taskCli {

    public static void main(String[] args){


        String comand = args[0];
        switch (comand){
            case "add":
                System.out.println("ingreso add " );
                TaskClass.IngresarTask(args[1]);
                break;
            case "update":
                System.out.println("ingreso Update");
                TaskClass.updateTask(Integer.parseInt(args[1]) , args[2],"");
                break;
            case "mark-in-progress":
                TaskClass.updateTask(Integer.parseInt(args[1]),"", "in-progress");
                break;
            case "list":
                String filter= "";
                if(args.length > 1){
                    filter = args[1];
                }
                TaskClass.listTask(filter);
                break;
            case "mark-done":
                TaskClass.updateTask(Integer.parseInt(args[1]),"", "done");
                break;
            case "delete":
                TaskClass.deleteTask(Integer.parseInt(args[1]));
                break;
        }

    }
}

import javax.annotation.processing.Generated;

public class Task {
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Task(int id, String description, String status, String createdAt, String updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"description\":\"" + description + '\"' +
                ", \"status\":\"" + status + '\"' +
                ", \"createdAt\":\"" + createdAt + '\"' +
                ", \"updatedAt\":\"" + updatedAt + '\"' +
                '}';
    }


    public static Task fromJson(String json){
        String[] element = json.replace("{","").replace("}","").split(",");
        int id = Integer.parseInt(element[0].split(":")[1].trim().replace("\"",""));
        String description=element[1].split(":")[1].trim().replace("\"","");
        String status = element[2].split(":")[1].trim().replace("\"","");

        int indexOfColon = element[3].indexOf(":");

        String createdAt = element[3].substring(indexOfColon + 1).trim().replace("\"", "");
        //String createdAt = element[3].split(":",2)[1].trim().replace("\"","");
        String updateAt = element[4].split(":",2)[1].trim().replace("\"","");

        Task task = new Task(id, description, status, createdAt,updateAt);

        return task;
    }

}

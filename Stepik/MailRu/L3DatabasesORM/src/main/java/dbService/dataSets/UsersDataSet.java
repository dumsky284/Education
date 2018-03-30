package dbService.dataSets;


import javax.persistence.*;

@Entity
@Table(name="users")
public class UsersDataSet {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="name", unique=true, updatable=false)
    private String name;

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(){

    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public UsersDataSet(String name) {
        this.setId(-1);
        this.setName(name);
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
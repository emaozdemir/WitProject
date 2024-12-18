package pojos;

import java.util.ArrayList;

public class PetPojo {

    private Integer id;

    private Category category;

    private String name;

    private ArrayList<String> photoUrls;

    private ArrayList<Tags> tags;

    private String status;

//    public PetPojo() {//de-serilization yaparken bu defaut const kullanır.
//    }   //obje mapper kullanacağız default bu olusuyor create etmicez gerek yok.

    //parametreli const neden yapmadık cunku; biz kendimiz elle değer girmeyeceğiz pli const manuel elle deger girilen yerlerde kullanılır
    //biz obje mapper kullanacağız ve stringi direkt olarak pojoya cevirecek

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetPojo{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}

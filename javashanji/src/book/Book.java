package book;

public class Book {
    private   String name;
    private String acthor;
    private  int price;
    private  String type;
    private  boolean statues;

    public Book(String name, String acthor, int price, String type) {
        this.name = name;
        this.acthor = acthor;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getActhor() {
        return acthor;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public boolean isStatues() {
        return statues;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActhor(String acthor) {
        this.acthor = acthor;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatues(boolean statues) {
        this.statues = statues;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", acthor='" + acthor + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", statues=" + ((statues==true)?" 借出 ":" 未借出 ")+
                '}';
    }
}

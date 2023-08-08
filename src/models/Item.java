package models;

public class Item {
    private Long id;
    private String name;
    private String description;
    private String price;
    private String specification;

    public Item() {
    }

    public Item(Long id, String name, String description, String price,String specification) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.specification=specification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}

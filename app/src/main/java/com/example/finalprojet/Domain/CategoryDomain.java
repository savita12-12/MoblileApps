package com.example.finalprojet.Domain;

public class CategoryDomain {
    String title;
    String pic;

    public CategoryDomain(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }
}

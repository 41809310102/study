package com.deyunjiaoyu.sportplay.bean;

public class SubMenu {
    private int id;
    private String path;
    private String title;

    public SubMenu() {

    }


    public SubMenu( String path, String title) {
        this.path = path;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SubMenu{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

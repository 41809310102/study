package com.deyunjiaoyu.sportplay.bean;


import javax.xml.crypto.Data;

public class Page {
    private  int id;
    private  String pagedesc;
    private  String  pagetime;
    private  String  pagename;
    private  String  pageactor;
    private  int readnum;

    public Page() {

    }

    public Page(String pagedesc, String   pagetime, String pagename, String pageactor, int pagenum) {
        this.id = id;
        this.pagedesc = pagedesc;
        this.pagetime = pagetime;
        this.pagename = pagename;
        this.pageactor = pageactor;
        this.readnum = pagenum;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPagedesc() {
        return pagedesc;
    }

    public void setPagedesc(String pagedesc) {
        this.pagedesc = pagedesc;
    }

    public String getPagetime() {
        return pagetime;
    }

    public void setPagetime(String  pagetime) {
        this.pagetime = pagetime;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }

    public String getPageactor() {
        return pageactor;
    }

    public void setPageactor(String pageactor) {
        this.pageactor = pageactor;
    }

    public int getPagenum() {
        return readnum;
    }

    public void setPagenum(int pagenum) {
        this.readnum = pagenum;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", pagedesc='" + pagedesc + '\'' +
                ", pagetime=" + pagetime +
                ", pagename='" + pagename + '\'' +
                ", pageactor='" + pageactor + '\'' +
                ", pagenum=" + readnum +
                '}';
    }
}

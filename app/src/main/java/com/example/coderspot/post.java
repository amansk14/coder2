package com.example.coderspot;

public class post {

    //todo recycle view creating constructor and returning them
    private String  postid;
    private String projectname;
    private String tvproject;
    private String tvdis;
    private String tvdate;
    private String tvassign;

    public post(String postid, String projectname, String tvproject, String tvdis, String tvdate, String tvassign) {
        this.postid = postid;
        this.projectname = projectname;
        this.tvproject = tvproject;
        this.tvdis = tvdis;
        this.tvdate = tvdate;
        this.tvassign = tvassign;
    }

    public post() {
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getTvproject() {
        return tvproject;
    }

    public void setTvproject(String tvproject) {
        this.tvproject = tvproject;
    }

    public String getTvdis() {
        return tvdis;
    }

    public void setTvdis(String tvdis) {
        this.tvdis = tvdis;
    }

    public String getTvdate() {
        return tvdate;
    }

    public void setTvdate(String tvdate) {
        this.tvdate = tvdate;
    }

    public String getTvassign() {
        return tvassign;
    }

    public void setTvassign(String tvassign) {
        this.tvassign = tvassign;
    }
}

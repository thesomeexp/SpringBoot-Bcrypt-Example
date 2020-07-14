package com.someexp.model;

import java.io.Serializable;

/**
 * sys_permission
 * @author 
 */
public class SysPermission implements Serializable {
    private Integer id;

    private String permname;

    private String permtag;

    /**
     * 请求url
     */
    private String url;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermname() {
        return permname;
    }

    public void setPermname(String permname) {
        this.permname = permname;
    }

    public String getPermtag() {
        return permtag;
    }

    public void setPermtag(String permtag) {
        this.permtag = permtag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
package com.ivan.datatables;

import java.util.List;

public class DatatablesResponse<T> {

    private int iTotalRecords;
    private int iTotalDisplayRecords;

    private String sEcho;

    private List<T> aaData;

    public DatatablesResponse(int iTotalRecords, int iTotalDisplayRecords, String sEcho, List<T> aaData) {
        this.iTotalRecords = iTotalRecords;
        this.iTotalDisplayRecords = iTotalDisplayRecords;
        this.sEcho = sEcho;
        this.aaData = aaData;
    }

    public int getiTotalRecords() {
        return iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public String getsEcho() {
        return sEcho;
    }

    public List<T> getAaData() {
        return aaData;
    }
}

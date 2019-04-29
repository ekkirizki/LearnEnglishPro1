package com.example.learnenglishpro;

import java.util.List;

public class ModelMateri {
    List<String> Cklm;

    public ModelMateri(List<String> Cklm){
        this.Cklm = Cklm;
    }

    public List<String> getCklm() {
        return Cklm;
    }

    public void setCklm(List<String> cklm) {
        Cklm = cklm;
    }
}

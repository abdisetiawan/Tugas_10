package com.example.proteintracker.Model;

public class DaftarTeman {



    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getNim() {
        return Nim;
    }

    public void setNim(String nim) {
        Nim = nim;
    }

    public String getHobby() {
        return Hobby;
    }

    public void setHobby(String hobby) {
        Hobby = hobby;
    }

    public String getCita2() {
        return Cita2;
    }

    public void setCita2(String cita2) {
        Cita2 = cita2;
    }

    public String getMotohidup() {
        return Motohidup;
    }

    public void setMotohidup(String motohidup) {
        Motohidup = motohidup;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public DaftarTeman(String nama, String nim, String hobby, String cita2, String motohidup, String gender, int img) {
        Nama = nama;
        Nim = nim;
        Hobby = hobby;
        Cita2 = cita2;
        Motohidup = motohidup;
        Gender = gender;
        this.img = img;
    }

    private String Nama;
    private String Nim;
    private String Hobby;
    private String Cita2;
    private String Motohidup;
    private String Gender;
    private  int img;

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }



}

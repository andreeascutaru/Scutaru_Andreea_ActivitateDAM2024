package com.example.exercitiustudent;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class Student implements Parcelable {
    private String nume;//editText
    private int varsta;//editText
    private String sex;//RadioButton
    private String specializare;//Spinner
    private boolean integralist;//CheckBox
    private boolean licenta;//Switch
    private float venit;//RatingBar
    private Date dataNasterii;//DatePicker

    public Student() {
    }

    public Student(String nume, int varsta, String sex, String specializare, boolean integralist, boolean licenta, float venit, Date dataNasterii) {
        this.nume = nume;
        this.varsta = varsta;
        this.sex = sex;
        this.specializare = specializare;
        this.integralist = integralist;
        this.licenta = licenta;
        this.venit = venit;
        this.dataNasterii = dataNasterii;
    }

    protected Student(Parcel in) {
        nume = in.readString();
        varsta = in.readInt();
        sex = in.readString();
        specializare = in.readString();
        integralist = in.readByte() != 0;
        licenta = in.readByte() != 0;
        venit = in.readFloat();
        dataNasterii = (java.util.Date)in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeInt(varsta);
        dest.writeString(sex);
        dest.writeString(specializare);
        dest.writeByte((byte) (integralist ? 1 : 0));
        dest.writeByte((byte) (licenta ? 1 : 0));
        dest.writeFloat(venit);
        dest.writeSerializable(dataNasterii);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public boolean isIntegralist() {
        return integralist;
    }

    public void setIntegralist(boolean integralist) {
        this.integralist = integralist;
    }

    public boolean isLicenta() {
        return licenta;
    }

    public void setLicenta(boolean licenta) {
        this.licenta = licenta;
    }

    public float getVenit() {
        return venit;
    }

    public void setVenit(float venit) {
        this.venit = venit;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("nume='").append(nume).append('\'');
        sb.append(", varsta=").append(varsta);
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", specializare='").append(specializare).append('\'');
        sb.append(", integralist=").append(integralist);
        sb.append(", licenta=").append(licenta);
        sb.append(", venit=").append(venit);
        sb.append(", dataNasterii=").append(dataNasterii);
        sb.append('}');
        return sb.toString();
    }

}

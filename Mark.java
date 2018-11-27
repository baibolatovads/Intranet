package com.company;

import java.io.Serializable;

public class Mark implements Serializable {
    private double fstAttestation;
    private double sndAttestation;
    private double finalExam;

    public Mark(){
        fstAttestation = 0;
        sndAttestation = 0;
        finalExam = 0;
    }

    public Mark(double att1, double att2, double finalExam){
        fstAttestation = att1;
        sndAttestation = att2;
        this.finalExam = finalExam;
    }

    public double getFstAttestation(){
        return fstAttestation;
    }

    public double getSndAttenstation(){
        return sndAttestation;
    }

    public double getFinalExam(){
        return finalExam;
    }

    public double getTotal(){
        return fstAttestation + sndAttestation + finalExam;
    }

    public void setFstAttestation(double fstAttestation) {
        this.fstAttestation = fstAttestation;
    }

    public void setSndAttestation(double sndAttestation) {
        this.sndAttestation = sndAttestation;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    private boolean retake(){
        return (fstAttestation + sndAttestation < 30 || (getFinalExam() < 20));
    }

    public String toLetter(){
        if(retake()) return "F";
        if(getTotal() > 95) return "A";
        if (getTotal() > 90 && getTotal() < 95) return "-A";
        if (getTotal() > 85 && getTotal() < 90) return "+B";
        if (getTotal() > 80 && getTotal() < 85) return "B";
        if (getTotal() > 75 && getTotal() < 80) return "-B";
        if (getTotal() > 70 && getTotal() < 75) return "+C";
        if (getTotal() > 65 && getTotal() < 70) return "C";
        if (getTotal() > 60 && getTotal() < 65) return "-C";
        if (getTotal() > 55 && getTotal() < 60) return "D";
        if (getTotal() > 50 && getTotal() < 55) return "-D";
        return "FAIL";
    }

    public double toNumber() {
        if (getFinalExam() < 20) return 0;
        if (getTotal() > 95) return 4.0;
        else if (getTotal() > 90 && getTotal() < 95) return 3.67;
        else if (getTotal() > 85 && getTotal() < 90) return 3.33;
        else if (getTotal() > 80 && getTotal() < 85) return 3.0;
        else if (getTotal() > 75 && getTotal() < 80) return 2.67;
        else if (getTotal() > 70 && getTotal() < 75) return 2.33;
        else if (getTotal() > 65 && getTotal() < 70) return 2.0;
        else if (getTotal() > 60 && getTotal() < 65) return 1.67;
        else if (getTotal() > 55 && getTotal() < 60) return 1.33;
        else if (getTotal() > 50 && getTotal() < 55) return 1.0;
        else return 0;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "firstAttestation=" + fstAttestation +
                ", secondAttestation=" + sndAttestation +
                ", finalExam=" + finalExam +
                ", total=" + getTotal() +
                '}';
    }

}

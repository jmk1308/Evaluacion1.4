package com.example.evaluacion14;

public class Item {

    private int imge;
    private String tittle;

    public Item(int imge, String tittle) {
        this.imge = imge;
        this.tittle = tittle;
    }

    public int getImge() {
        return imge;
    }

    public void setImge(int imge) {
        this.imge = imge;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

}
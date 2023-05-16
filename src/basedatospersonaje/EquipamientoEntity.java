/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basedatospersonaje;

/**
 *
 * @author ausias
 */
public class EquipamientoEntity extends ORMEntity {
    private String arma;
    private boolean equipado;
    private int id;
    
    private BDConnection c;

    public EquipamientoEntity(String arma, boolean equipado, int id) {
        this.arma = arma;
        this.equipado = equipado;
        this.id = id;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public boolean isEquipado() {
        return equipado;
    }

    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}


package es.unex.propuesta_proyecto.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {

    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("SubType")
    @Expose
    private String subType;
    @SerializedName("Weapon")
    @Expose
    private String weapon;
    @SerializedName("Accuracy")
    @Expose
    private String accuracy;
    @SerializedName("Damage")
    @Expose
    private String damage;
    @SerializedName("Range")
    @Expose
    private String range;
    @SerializedName("Fire Rate")
    @Expose
    private String fireRate;
    @SerializedName("Mobility")
    @Expose
    private String mobility;
    @SerializedName("Control")
    @Expose
    private String control;
    @SerializedName("Pros")
    @Expose
    private Object pros;
    @SerializedName("Cons")
    @Expose
    private Object cons;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getFireRate() {
        return fireRate;
    }

    public void setFireRate(String fireRate) {
        this.fireRate = fireRate;
    }

    public String getMobility() {
        return mobility;
    }

    public void setMobility(String mobility) {
        this.mobility = mobility;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public Object getPros() {
        return pros;
    }

    public void setPros(Object pros) {
        this.pros = pros;
    }

    public Object getCons() {
        return cons;
    }

    public void setCons(Object cons) {
        this.cons = cons;
    }

}

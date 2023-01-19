/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
/**
 *
 * @author Isaac Reyes
 */
public class TestObject implements Serializable {
    String val1;
    String val2;
    String val3;
    String val4;
    String val5;
    public TestObject(String val1, String val2, String val3, String val4 , String val5) {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
        this.val4 = val4;
        this.val5 = val5;

    }
    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    public String getVal3() {
        return val3;
    }

    public void setVal3(String val3) {
        this.val3 = val3;
    }
    public String getVal4() {
        return val4;
    }

    public void setVal4(String val4) {
        this.val4 = val4;
    }
    public String getVal5() {
        return val5;
    }

    public void setVal5(String val5) {
        this.val5 = val5;
    }
    @Override
    public String toString() {
        return "TestObject{" +"val1="+val1+'\"'+", val2" + val2+'\"'+", val3=" +val3+'\"'+", val4"+
                val4+'\"'+", val5"+val5+'\"' + "}";
    }
}

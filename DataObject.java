
public class DataObject {

    Object data, data1, data2, data3, data4, data5, data6, data7, data8, data9, data10, data11, data12, data13, data14;

    public DataObject(Object data, Object data1, Object data2, Object data3, Object data4, Object data5, Object data6,
            Object data7, Object data8, Object data9, Object data10, Object data11, Object data12, Object data13,
            Object data14, Object data15) {
        this.data = data;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
        this.data6 = data6;
        this.data7 = data7;
        this.data8 = data8;
        this.data9 = data9;
        this.data10 = data10;
        this.data11 = data11;
        this.data12 = data12;
        this.data13 = data13;
        this.data14 = data14;
    }

    // toString method to print the values of object
    @Override
    public String toString() {
        return "[" + data + "  " + data1 + data2 + "  " + data3 + "  "
                + data4 + " " + data5 + " " + data6 + " " + data7 + " " + data8 + " "
                + data9 + " " + data10 + " " + data11 + " " + data12 + " " + data13
                + " " + data14 + "]";
    }

    // getter here to get value

    public int getField() {
        return (int) data;
    }

    public String getField1() {
        return (String) data1;
    }

    public int getField2() {
        return (int) data2;
    }

    public Object getField3() {
        return data3;
    }

    public Object getField4() {
        return data4;
    }

    public Object getField5() {
        return data5;
    }

    public Object getField6() {
        return data6;
    }

    public String getField7() {
        return (String) data7;
    }

    public Object getField8() {
        return data8;
    }

    public String getField9() {
        return (String) data9;
    }

    public Object getField10() {
        return data10;
    }

    public Object getField11() {
        return data11;
    }

    public Object getField12() {
        return data12;
    }

    public Object getField13() {
        return data13;
    }

    public Object getField14() {
        return data14;
    }
}

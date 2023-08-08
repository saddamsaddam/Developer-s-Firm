/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registration;

public class TableClass {
    private String projectname;
    private String flatname;
    private String date;
    private String money;
    private String source;
    private String sellingprice;
    private String utilitybill;
    private String others;

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getFlatname() {
        return flatname;
    }

    public void setFlatname(String flatname) {
        this.flatname = flatname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    
    public String getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(String sellingprice) {
        this.sellingprice = sellingprice;
    }

    public String getUtilitybill() {
        return utilitybill;
    }

    public void setUtilitybill(String utilitybill) {
        this.utilitybill = utilitybill;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "TableClass{" +
                "projectname='" + projectname + '\'' +
                ", flatname='" + flatname + '\'' +
                ", date='" + date + '\'' +
                ", money='" + money + '\'' +
                ", source='" + source + '\'' +
                ", sellingprice='" + sellingprice + '\'' +
                ", utilitybill='" + utilitybill + '\'' +
                ", others='" + others + '\'' +
                '}';
    }
}

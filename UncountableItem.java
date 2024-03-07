public class UncountableItem extends Item {
    public String unit ;
    public float buyPrice,sellPrice ;
    public float quntity ;

    UncountableItem(String itemGroupCode,String itemName,String unit,int quntity,float buyPrice,float sellPrice)
    {
        super(itemGroupCode, itemName);
        this.quntity = quntity ;
        this.buyPrice= buyPrice ;
        this.sellPrice = sellPrice ;
        this.unit= unit ;
    }
    
    public String getUnit() {
        return unit;
    }

    public void setQuntity(float quntity) {
        this.quntity = quntity;
    }

    public float getQuntity() {
        return quntity;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setStock(int quntity) {
        this.quntity = quntity;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }
}

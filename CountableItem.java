public class CountableItem extends Item {
    public float quntity;
    public float buyPrice, sellPrice;

    CountableItem(String itemGroupCode,String itemName,int quntity,float buyPrice,float sellPrice)
    {
        super(itemGroupCode, itemName);
        this.quntity = quntity;
        this.buyPrice = buyPrice ;
        this.sellPrice = sellPrice ; 
    }

    public void setQuntity(float quntity) {
        this.quntity = quntity;
    }

    public float getQuntity() {
        return quntity;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    
}

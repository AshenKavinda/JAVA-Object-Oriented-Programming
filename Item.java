abstract public class Item {
    protected String itemGroupCode;
    protected String itemName ;

    Item(String itemGroupCode,String itemName)
    {
        this.itemGroupCode = itemGroupCode ;
        this.itemName = itemName ;
    }

    public String getItemGroupCode() {
        return itemGroupCode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getUnit() {
        return null;
    }
    
    abstract public float getBuyPrice();

    abstract public float getSellPrice() ;

    abstract public void setQuntity(float quntity) ;

    abstract public float getQuntity() ;

    
    
}

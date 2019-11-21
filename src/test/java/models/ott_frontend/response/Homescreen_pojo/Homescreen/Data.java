package models.ott_frontend.response.Homescreen_pojo.Homescreen;



public class Data
{
    private String limit;

    private String total;

    private Items[] items;

    private String offset;

    public String getLimit ()
    {
        return limit;
    }

    public void setLimit (String limit)
    {
        this.limit = limit;
    }

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [limit = "+limit+", total = "+total+", items = "+items+", offset = "+offset+"]";
    }
}

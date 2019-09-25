package onebyte.com.colortabs.model;

public class Menu {

    private int picture;
    private String dishName;
    private String cafeName;
    private String reviewAmount;

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getReviewAmount() {
        return reviewAmount;
    }

    public void setReviewAmount(String reviewAmount) {
        this.reviewAmount = reviewAmount;
    }

    public Menu(int picture, String dishName, String cafeName, String reviewAmount)
     {
         this.cafeName = cafeName;
         this.dishName = dishName;
         this.reviewAmount = reviewAmount;
         this.picture = picture;
     }

}

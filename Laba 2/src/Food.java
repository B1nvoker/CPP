class Food extends Item {

    private Taste taste;

    Food(String ItemName) {
        super(ItemName);
        this.taste = Taste.TASTELESS;
    }

    Food(Taste taste, String ItemName){
        super(ItemName);
        this.taste = taste;
    }

    Taste getTaste() {
        return taste;
    }

    String tasteToString() {
        switch (taste)
        {
            case SWEET: return "Сладкий";
            case SOUR: return "Кислый";
            case SALTY: return "Солёный";
            case BITTER: return "Горький";
        }
        return "Безвкусный";
    }
}
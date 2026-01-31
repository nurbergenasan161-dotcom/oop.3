package entities;

public class Membership {

    private String type;
    private int duration;
    private double price;

    private Membership(Builder builder) {
        this.type = builder.type;
        this.duration = builder.duration;
        this.price = builder.price;
    }

    public static class Builder {
        private String type;
        private int duration;
        private double price;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Membership build() {
            return new Membership(this);
        }
    }
}

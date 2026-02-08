package fitnessclub;

public class domain {
    public static class Booking {
        private int id;
        private int memberId;
        private int classId;
    }

    public static class FitnessClass {
        private int id;
        private String name;
        private String trainer;
    }

    public static class Member {
        private int id;
        private String name;
        private String email;

        public Member(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public Member(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public static class Membership {

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
}

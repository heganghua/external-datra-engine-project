package com.jxzj.external.data.designmode.buildmode;

public class MilkTea implements Cloneable {

    private String type;

    private String size;

    private Boolean pearl;

    private Boolean ice;

    private MilkTea(Builder builder) {
        this.type = builder.type;
        this.size = builder.size;
        this.pearl = builder.pearl;
        this.ice = builder.ice;
    }

    public static class Builder {
        private final String type;

        private String size = "中杯";

        private boolean pearl = true;

        private boolean ice = false;

        public Builder(String type) {
            this.type = type;
        }

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder pearl(boolean pearl) {
            this.pearl = pearl;
            return this;
        }

        public Builder ice(boolean cold) {
            this.ice = cold;
            return this;
        }

        public MilkTea build() {
            return new MilkTea(this);
        }

    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public boolean isPearl() {
        return pearl;
    }

    public boolean isIce() {
        return ice;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "MilkTea [type=" + type + ", size=" + size + ", pearl=" + pearl + ", ice=" + ice + "]";
    }

}

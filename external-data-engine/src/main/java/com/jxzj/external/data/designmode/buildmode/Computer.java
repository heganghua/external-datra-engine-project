package com.jxzj.external.data.designmode.buildmode;

public class Computer {

    private final String cpu;

    private final String ram;

    private final int usbCount;

    private final String keyboard;

    private final String display;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.usbCount = builder.usbCount;
        this.keyboard = builder.keyboard;
        this.display = builder.display;
    }

    public static class Builder {
        private String cpu;// 必须
        private String ram;// 必须
        private int usbCount;// 可选
        private String keyboard;// 可选
        private String display;// 可选

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder setUsbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }

        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public int getUsbCount() {
        return usbCount;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public String getDisplay() {
        return display;
    }

    @Override
    public String toString() {
        return "Computer [cpu=" + cpu + ", ram=" + ram + ", usbCount=" + usbCount + ", keyboard=" + keyboard
            + ", display=" + display + "]";
    }

}

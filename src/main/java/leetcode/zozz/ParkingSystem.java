package leetcode.zozz;

class ParkingSystem {

    private final int[] remain = new int[]{0, 0, 0, 0};
    private final int big = 1;
    private final int medium = 2;
    private final int small = 3;

    /**
     * ParkingSystem(int big, int medium, int small) 
     * 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
     */
    public ParkingSystem(int big, int medium, int small) {
        remain[this.big] = big;
        remain[this.medium] = medium;
        remain[this.small] = small;
    }

    /**
     * bool addCar(int carType) 
     * 检查是否有 carType 对应的停车位。 
     * carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。
     * 一辆车只能停在  carType 对应尺寸的停车位中。
     * 如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
     */
    public boolean addCar(int carType) {
        if (remain[carType] <= 0) {
            return false;
        }
        remain[carType] = remain[carType]--;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
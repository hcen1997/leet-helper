package leetcode.level.easy.rand5;

public class VersionControl {
    private final int badVersion;

    public VersionControl(int i) {
        this.badVersion = i;
    }

    public VersionControl(VersionControl versionControl) {
        this.badVersion = versionControl.badVersion;
    }

    boolean isBadVersion(int version){
        return version>=badVersion;
    }
}

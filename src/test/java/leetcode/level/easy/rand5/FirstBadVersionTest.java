package leetcode.level.easy.rand5;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstBadVersionTest {

    @Test
    public void firstBadVersion() {
        int badVersion = 1702766719;
        VersionControl versionControl = new VersionControl(badVersion);
        FirstBadVersion firstBadVersion = new FirstBadVersion(versionControl);
        int calBadVersion = firstBadVersion.firstBadVersion(2126753390);
        assertEquals(badVersion,calBadVersion);
    }
}
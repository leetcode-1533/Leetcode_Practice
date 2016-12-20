package first_bad_version;

/**
 * Created by y1275963 on 12/20/16.
 */

public class VersionControl {
    int firstBadVersion;
    boolean isBadVersion(int version) {
        if (version >= firstBadVersion) {
            return true;
        }
        return false;
    }
}
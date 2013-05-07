package mufg.batchapp.day2ItemSummary.jFItemSummary.stage0002;
import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparator;
/**
 * ステージ#2シャッフルで利用する順序比較器。
 */
@SuppressWarnings("rawtypes") public class ShuffleSortComparator implements RawComparator<ShuffleKey> {
    @Override public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
        int segmentId1 = WritableComparator.readInt(b1, s1);
        int segmentId2 = WritableComparator.readInt(b2, s2);
        int diff = this.compareInt(this.portIdToElementId(segmentId1), this.portIdToElementId(segmentId2));
        if(diff != 0) return diff;
        int o1 = 4;
        int o2 = 4;
        int lim1 = -1;
        int lim2 = -1;
        switch(segmentId1) {
            case 1:
                lim1 = com.asakusafw.runtime.value.LongOption.getBytesLength(b1, s1 + o1, l1 - o1);
                lim2 = com.asakusafw.runtime.value.LongOption.getBytesLength(b2, s2 + o2, l2 - o2);
                diff = com.asakusafw.runtime.value.LongOption.compareBytes(b1, s1 + o1, lim1, b2, s2 + o2, lim2);
                if(diff != 0) return diff;
                o1 += lim1;
                o2 += lim2;
                break;
            default:
                throw new AssertionError();
        }
        diff = this.compareInt(segmentId1, segmentId2);
        if(diff != 0) return diff;
        switch(segmentId1) {
            case 1:
                break;
            default:
                throw new AssertionError();
        }
        return 0;
    }
    @Override public int compare(ShuffleKey o1, ShuffleKey o2) {
        int segmentId1 = o1.getSegmentId();
        int segmentId2 = o2.getSegmentId();
        int diff = this.compareInt(this.portIdToElementId(segmentId1), this.portIdToElementId(segmentId2));
        if(diff != 0) return diff;
        switch(segmentId1) {
            case 1:
                diff = o1.groupElem0Term1.compareTo(o2.groupElem0Term1);
                if(diff != 0) return diff;
                break;
            default:
                throw new AssertionError();
        }
        diff = this.compareInt(segmentId1, segmentId2);
        if(diff != 0) return diff;
        switch(segmentId1) {
            case 1:
                break;
            default:
                throw new AssertionError();
        }
        return 0;
    }
    private int compareInt(int a, int b) {
        if(a == b) return 0;
        else if(a < b) return -1;
        else return 1;
    }
    private int portIdToElementId(int pid) {
        switch(pid) {
            case 1:
                return 0;
            default:
                return -1;
        }
    }
}
import java.util.*;
import soot.*;
import soot.baf.*;
import soot.jimple.toolkits.annotation.tags.NullCheckTag;
import soot.tagkit.*;

/** The aggregator for NullCheckAttribute. */
public class NullTagAggregator extends ImportantTagAggregator {
    public NullTagAggregator() {}

    public boolean wantTag(Tag t) {
        return (t instanceof NullCheckTag);
    }

    public String aggregatedName() {
        return "NullCheckAttribute";
    }
}

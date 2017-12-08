package tasks.helpers;

import java.util.ArrayList;
import java.util.List;

public class CollectionsHelper {
    public static boolean isTwoArrayListsWithSameValues(List<?> list1, List<?> list2) {
        if (list1 == null && list2 == null)
            return true;
        if ((list1 == null && list2 != null) || (list1 != null && list2 == null))
            return false;
        if (list1.size() != list2.size())
            return false;
        for (Object itemList1 : list1) {
            if (!list2.contains(itemList1))
                return false;
        }
        return true;
    }
}

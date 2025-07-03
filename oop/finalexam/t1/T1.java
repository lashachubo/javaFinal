package oop.finalexam.t1;

import java.util.*;

/**
 * This program creates a third list (`list3`) based on two given lists:
 * - `list1` contains integers.
 * - `list2` contains strings.
 *
 * For each number `n` in `list1`, the program accesses the element at index (list2.size - 1 - n)
 * in `list2`, then combines that string with `n` and adds it to `list3`.
 *
 * If `n` is out of bounds (negative or too large), it is ignored (error handling).
 *
 * After creating list3, the program removes from it any elements ending with a number from `list1`,
 * **except** the number 10, so `zpb10` remains after deletion.
 */
public class T1 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(10, 8, 4, 1, 6, 7, 2, 9, 5, 3);
        List<String> list2 = Arrays.asList(
            "jdp", "kpw", "zpk", "wnu", "gus", "whn",
            "cvw", "hpu", "efc", "uuq", "njd", "zpb"
        );

        List<String> list3 = new ArrayList<>();

        for (int val : list1) {
            int index = list2.size() - 1 - val;
            if (index >= 0 && index < list2.size()) {
                list3.add(list2.get(index) + val);
            } else {
                System.out.println("Ignored invalid index from list1 value: " + val);
            }
        }

        System.out.println("Initial list3:");
        System.out.println(list3);

        List<Integer> deletionList = new ArrayList<>(list1);
        deletionList.remove(Integer.valueOf(10));

        List<String> filteredList3 = new ArrayList<>(list3);
        for (int val : deletionList) {
            filteredList3.removeIf(s -> s.endsWith(String.valueOf(val)));
        }

        System.out.println("\nFinal list3 after deletion:");
        System.out.println(filteredList3);
    }
}

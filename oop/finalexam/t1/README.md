# Java Final Task 1

## Package

`oop.final.t1`

## Description

This program processes two input lists:

- `list1` contains integers
- `list2` contains strings

### Steps:

\

1. For each number `n` in `list1`, the program calculates:  
   `list2.size - 1 - n`,  
   and gets the string from `list2` at that index.

2. It appends `n` to the string and adds it to `list3`.

3. After building `list3`, it deletes any entry that ends with a number present in `list1`.

### Example Output:

Initial list3:
[zpb10, uuq8, whn4, zpk1, hpu6, efc7, wnu2, njd9, cvw5, gus3]

Final list3 after deletion:
[zpb10]

## Error Handling

If a value from `list1` causes an invalid index (e.g., too large or negative), the program skips that entry and prints a warning.
proof of this is shown in the error_handling.png

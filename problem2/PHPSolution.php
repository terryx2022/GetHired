<?php
    /**
     * This is the PHP version of my solution (which I learned on demand as you preferred).
     * There is also a Java version (which is my primary language).
     * Please see solution specifics in README.txt
     */
    function findDuplicate(&$words) {
        // Corner case
        if ($words == null || count($words) < 2) {
            return -1;
        }
        $slow = -1;
        $fast = 0;
        $duplicate = null; // Keep track of the duplicate pattern
        while ($fast < count($words)) {
            // Condition#1: the current word is the same as the next (if not reaching the end of array)
            $condition1 = ($fast < count($words) - 1) && (strcmp($words[$fast], $words[$fast+1]) == 0);
            // echo "1: ", $condition1, " ";
            // Condition#2: reaching the last word of a duplicate pattern
            $condition2 = strcmp($words[$fast], $duplicate) == 0;
            // echo "2: ", $condition2, " ";
            // target pattern: successive duplicate
            if ($condition1 || $condition2)  {
                $duplicate = $words[$fast];
                swap($words, ++$slow, $fast);
                // echo $duplicate; echo " ";
            } else {
                // Reset
                $duplicate = null;
            }
            $fast++; // drives the loop
        }
        return $slow; // result -> [0, slow)
    }

    function swap(&$array, $i, $j) {
        $temp = $array[$i];
        $array[$i] = $array[$j];
        $array[$j] = $temp;
        return $array;
    }

    // ====================================
    //             Unit Tests
    // ====================================

    // Store result in an array
    function getResult($idx, $words) {
        if ($idx <= 0) {
            return array();
        }
        $result = array();
        for ($i = 0; $i <= $idx; $i++) {
            array_push($result, $words[$i]);
        }
        return $result;
    }
    $passed = array();
    $failed = array();

    // Tests#1: The given test case as per the instruction
    $input1 = "one two two three go go go big small big how sample test text to do it default returns string string is is in seconds since what is the end end";
    $words1 = explode(" ", $input1);
    $endingIdx1 = findDuplicate($words1);
    $expected1 = array("two", "two", "go", "go", "go", "string", "string", "is", "is", "end", "end");
    $actual1 = getResult($endingIdx1, $words1);
    if ($endingIdx1 == 10 && $expected1 == $actual1) {
        array_push($passed, "Test case given by the instruction");
    } else {
        array_push($failed, "Test case given by the instruction");
    }

    // Test#2: No-duplicate
    $input2 = "one two three four five";
    $words2 = explode(" ", $input2);
    $endingIdx2 = findDuplicate($words2);
    if ($endingIdx2 == -1) {
        array_push($passed, "No-duplicate");
    } else {
        array_push($failed, "No-duplicate");
    }

    // Test#3: All-duplicate
    $input3 = "one one one one one";
    $words3 = explode(" ", $input3);
    $endingIdx3 = findDuplicate($words3);
    $expected3 = array("one", "one", "one", "one", "one");
    $actual3 = getResult($endingIdx3, $words3);
    if ($endingIdx3 == 4 && $expected3 == $actual3) {
        array_push($passed, "All-duplicate");
    } else {
        array_push($failed, "All-duplicate");
    }

    // Test#4: Null input array
    $words4 = null;
    $endingIdx4 = findDuplicate($words4);
    if ($endingIdx4 == -1) {
        array_push($passed, "Null input");
    } else {
        array_push($failed, "Null input");
    }

    // Test#5: Empty input array
    $words5 = array();
    $endingIdx5 = findDuplicate($words5);
    if ($endingIdx5 == -1) {
        array_push($passed, "Empty input");
    } else {
        array_push($failed, "Empty input");
    }

    // Summary
    echo "\n===========Test Results============\n";
    echo "Test cases passed: ", count($passed), "\n";
    for ($i = 0; $i < count($passed); $i++) {
        echo "    ", $passed[$i], "\n";
    }
    echo "Test cases failed: ", count($failed), "\n";
    for ($i = 0; $i < count($failed); $i++) {
        echo "    ", $failed[$i], "\n";
    }
    echo "======================================="

?>

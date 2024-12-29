# Uncommon Scala Error: Exception Handling with Try and toInt

This example demonstrates a subtle error that can occur when using Scala's `Try` monad with `toInt` for String conversion.  The code attempts to convert user names to integers, which can fail if a name is not a valid integer representation. The issue lies in the lack of robust exception handling, potentially causing unexpected crashes or incorrect results.

The solution demonstrates a more robust approach that uses pattern matching for better error handling and clarity.

## Bug
The original code uses `Try(user.name.toInt).toOption.getOrElse(0)`. This approach, while using `Try`, still doesn't provide explicit exception handling for the `NumberFormatException`. If a name cannot be converted to an integer, the `getOrElse(0)` silently replaces the exception with 0, which may mask errors and lead to unexpected behavior. 

## Solution
The solution employs pattern matching to handle the potential `NumberFormatException` gracefully.  It explicitly checks for successful conversions (`Success`) and handles failures (`Failure`) separately. This way, we can provide more controlled and informative error handling. 
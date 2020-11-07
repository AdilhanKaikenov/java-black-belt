**Regular expressions**  
Regular expressions are needed to create patterns with which to perform operations such as search, comparison, replacement.  
Regular expressions are a collection of characters, some of which are special metacharacters, i.e. have some kind of functionality.

Pattern and Matcher Classes:

```java
import java.util.regex.Pattern
import java.util.regex.Matcher

Pattern myPattern = Pattern.compile(«REGEX");
Matcher myMatcher = myPattern .matcher(myString);
```

**Frequently used symbols in REGEX**  
- abc – Matches sequential abc
- [abc] - Matches either a or b or c
- [d-j] - Matches one of the letters in the range d -j
- [3-8] - Matches one of the digits from the range 3-8
- [B-Fd-j3-8] - Matches one of the letters from both ranges or one of the numbers from the range 3-8
- a | b – Matches either a or b
---
- [^ d-j] - The given character at the beginning of these brackets means negation. Matches one of the letters NOT in the range d -j
- . expression – Matches any one character. Exception: newline character
- ^ expression - Matches an expression at the beginning of a line
- expression $ - Matches expression at the end of a line
---
- \d – Matches one digit
- \D – Matches one NOT digit
- \w – Matches a single letter, number, or "_"
- \W – Matches a single character that is NOT a letter, NOT a number, and NOT "_"
- \s – Matches a whitespace character
- \S – Matches NOT a whitespace character
---
- \A – Matches the expression at the beginning of the String
- \Z – Matches the expression at the end of the String
- \b – Matches word or number boundary
- \B – Matches NOT word and NOT number boundary
---
- expression? - Matches 0 or 1 repetition
- expression * - Matches 0 or more repetitions
- expression + - Matches 1 or more repetitions
- expression {n} - Matches the number of repetitions "n"
- expression {m, n} - Matches the number of repetitions from "m" to "n"
- expression {n,} - Matches n or more repetitions

**String Class Methods: matches and split**  
```java
public boolean matches (String regex) {...};
public String[] split (String regex) {...};
```

**Methods printf and format**  
```text
%[flags][width][.precision]datatype_specifier
```

Main flags:
- «-» alignment to the left
- «0» adding zeros before the number
- «,» Separator of digits in numbers

DT specifiers:
- «b» boolean
- «c» character
- «s» String
- «d» integer
- «f» decimal

